import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import sign.signlink;


/**
 * Handles downloadiong our cache files from the webserver
 *
 * @author Arithium
 *
 */
public class CacheDownloader {

	/**
	 * The size of our buffer
	 */
	private static final int BUFFER_SIZE = 1024;

	/**
	 * The path to save our config files in, we assume the user is still using
	 * an older version of java so no need to use path
	 */
	private static final File CONFIG_SAVE_PATH = new File(signlink.findcachedir() + "/config/");

	/**
	 * If our directory doesn't exist, make it
	 */
	static {
		if (!CONFIG_SAVE_PATH.exists()) {
			CONFIG_SAVE_PATH.mkdir();
		}
	}
public static client Client;
	/**
	 * Different file types to download archives from
	 *
	 * @author Mobster
	 *
	 */
	public enum FileType {
		//CACHE(signlink.findcachedir(), "https://godzhell.net/cache/cache.zip", 8),
		FILEDATA(signlink.findcachedir(), "http://" + Client.server + ":" + (29435 + Client.ondemand_offset)+"/fileData.zip", 13);
		/**
		 * The link to the file on the webserver
		 */
		private String url;

		/**
		 * The current version of the file
		 */
		private int version;

		/**
		 * The directory to extract the file after downloaded
		 */
		private String directory;

		/**
		 * Constructs a new {@link FileType} for a downloadable file
		 *
		 * @param directory
		 *            The directory to extract the file
		 * @param url
		 *            The url to the file on the web server
		 * @param version
		 *            The current version of the file
		 */
		FileType(String directory, String url, int version) {
			this.directory = directory;
			this.url = url;
			this.version = version;
		}

		/**
		 * Gets the current version of the file
		 *
		 * @return The current version of the file
		 */
		public int getVersion() {
			return version;
		}

		/**
		 * Gets the url of the file on the webserver
		 *
		 * @return The url of the file on the webserver
		 */
		public String getURL() {
			return url;
		}

		/**
		 * Gets the directory to extract the file too
		 *
		 * @return The directory to extract the file too
		 */
		public String getDirectory() {
			return directory;
		}

		@Override
		public String toString() {
			return name().toLowerCase();
		}
	}

	/**
	 * Deletes the zip file from the directory
	 *
	 * @param fileName
	 *            The name of the file to delete
	 */
	private static void deleteZIP(String fileName, FileType type) {
		// A File object to represent the filename
		File f = new File(type.getDirectory(), fileName);

		// Make sure the file or directory exists and isn't write protected
		if (!f.exists()) {
			throw new IllegalArgumentException("Delete: no such file or directory: " + fileName);
		}

		if (!f.canWrite()) {
			throw new IllegalArgumentException("Delete: write protected: " + fileName);
		}

		// If it is a directory, make sure it is empty
		if (f.isDirectory()) {
			String[] files = f.list();

			if (files.length > 0) {
				throw new IllegalArgumentException("Delete: directory not empty: " + fileName);
			}
		}

		// Attempt to delete it
		boolean success = f.delete();

		if (!success) {
			throw new IllegalArgumentException("Delete: deletion failed");
		}
	}

	/**
	 * Starts our cache downloader
	 *
	 * @param Client
	 *            The {@link client} instance
	 * @param type
	 *            The {@link FileType} we are downloading
	 */
	public static void start(client Client, FileType type) {
		try {
			File location = new File(type.getDirectory());
			int version = readVersion(type);
			if (!location.exists()) {
				downloadFile(Client, type, getArchivedName(type));
				unZip(type);
				deleteZIP(getArchivedName(type), type);
				writeVersion(type);
			} else {
				if (version != type.getVersion()) {
					downloadFile(Client, type, getArchivedName(type));
					unZip(type);
					deleteZIP(getArchivedName(type), type);
					writeVersion(type);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Starts the downloading process
	 *
	 * @param Client
	 *            The {@link client} instance
	 * @param type
	 *            The address of the file to download
	 * @param localFileName
	 *            The name of our file to store in our cache directory
	 */
	private static void downloadFile(client Client, FileType type, String localFileName) {
		try {
			URL url = new URL(type.getURL());
			URLConnection conn = url.openConnection();
			try (OutputStream out = new BufferedOutputStream(new FileOutputStream(type.getDirectory() + "/" + localFileName)); InputStream in = conn.getInputStream()) {
				byte[] data = new byte[BUFFER_SIZE];
				int numRead;
				long numWritten = 0;
				long start = System.nanoTime();
				final double NANOS_PER_SECOND = 1000000000.0;
				final double BYTES_PER_MIB = 1024;
				int length = conn.getContentLength();
				while ((numRead = in.read(data)) != -1) {
					out.write(data, 0, numRead);
					numWritten += numRead;
					double speed = Math.round(((NANOS_PER_SECOND / BYTES_PER_MIB) * numWritten) / ((System.nanoTime() - start) + 1));
					int percentage = (int) (((double) numWritten / (double) length) * 100D);
					int totalLength = length / 1024;
					int totalReceived = (int) (numWritten / 1024);
					Client.method13(percentage == 100 ? 101 : percentage,
							 (byte)4,"Downloading " + type.toString() + " @ " + Math.round(speed) + " kb/s" + " " + totalReceived + "/" + totalLength + "kb");
				}

				Client.method13(101, (byte)4, "Downloaded " + type.toString() + ", unzipping.");
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Gets the archive name
	 *
	 * @param type
	 * @return
	 */
	private static String getArchivedName(FileType type) {
		int lastSlashIndex = type.getURL().lastIndexOf('/');

		if ((lastSlashIndex >= 0) && (lastSlashIndex < (type.getURL().length() - 1))) {
			String u = type.getURL().substring(lastSlashIndex + 1, type.getURL().length() - 5);
			String Name = u.replace("?dl=1", "");
			return Name;
		} else {
			System.err.println("error retrieving archived name.");
		}

		return "";
	}

	/**
	 * Starts the unzipping process
	 *
	 * @param zin
	 * @param s
	 * @throws IOException
	 */
	private static void unzip(ZipInputStream zin, String s) throws IOException {
		try (FileOutputStream out = new FileOutputStream(s)) {
			byte[] buf = new byte[BUFFER_SIZE];
			int len = 0;

			while ((len = zin.read(buf)) != -1) {
				out.write(buf, 0, len);
			}
		}
	}

	/**
	 * Attempts to unzip the archive
	 *
	 * @param type
	 */
	private static void unZip(FileType type) {
		String archive = type.getDirectory() + File.separator + getArchivedName(type);
		try (ZipInputStream zin = new ZipInputStream(new BufferedInputStream(new FileInputStream(archive)))) {
			ZipEntry e;
			while ((e = zin.getNextEntry()) != null) {
				if (e.isDirectory()) {
					(new File(type.getDirectory() + File.separator + e.getName())).mkdir();
				} else {
					if (e.getName().equals(archive)) {
						unzip(zin, archive);
						break;
					}

					unzip(zin, type.getDirectory() + File.separator + e.getName());
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	/**
	 * Gets the current Client version
	 *
	 * @return
	 */
	private static int readVersion(FileType type) {
		try (DataInputStream in = new DataInputStream(new FileInputStream(new File(CONFIG_SAVE_PATH, type.toString() + "_version.dat")))) {
			int version = in.readInt();
			return version;
		} catch (IOException ignored) {
		}

		return -1;
	}

	/**
	 * Writes the current version
	 */
	private static void writeVersion(FileType type) {
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(new File(CONFIG_SAVE_PATH, type.toString() + "_version.dat")))) {
			out.writeInt(type.getVersion());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}