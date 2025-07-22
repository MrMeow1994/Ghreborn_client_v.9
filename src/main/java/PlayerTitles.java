
import sign.signlink;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class PlayerTitles {
	
	public static void unpack() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(signlink.findcachedir() + "title.dat"));
		LineNumberReader lnr = new LineNumberReader(new FileReader(signlink.findcachedir() + "title.dat"));
		try {
			String line;
			lnr.skip(Long.MAX_VALUE);
			archived = lnr.getLineNumber() + 1;
			titleM = new String[lnr.getLineNumber() + 1];
			titleF = new String[lnr.getLineNumber() + 1];
			color = new String[lnr.getLineNumber() + 1];
			int index = 0;
			while((line = br.readLine()) != null) {
				String[] data = line.split("#");
				titleM[index] = data[0].trim();
				titleF[index] = data[1].trim();
				color[index] = data[2].trim();
				index++;
			}
			System.out.println("Loaded: " + titleM.length + " Titles");
		} finally {
			br.close();
			lnr.close();
		}
		br.close();
		lnr.close();
	}
	
	public boolean getGender(Player player) {
		if(player.gender == 0)
			return true;
		
		return false;
	}

	public String format(String title) {
		for(int index = 0; index < suffixChar.length; index++) {
			if(title.startsWith("<col="))
				title = title.substring(12);
			
			if(title.startsWith(suffixChar[index])) {
				suffix = true;
				if(index < 4) {
					return " @";
				} else 
					return " #";
			}
		}
		if(title.contains("</col>"))
			return " $";
		else 
			return "";
		
	}

	public String tag() {
		String[] tag = {"str", "trans", "shad", "u"};
		for(int id = 0; id < tag.length; id++)
			if(title.contains("<" + tag[id]) && !title.contains("</"+ tag[id]))
				return ("</" + tag[id] + ">");
		
		return "";
	}

	public String placement(String name, String title) {
		if(name != null || title != null) {
			if(suffix && format(title) == " @") 
				name += "" + title + tag();
			else
			if(suffix && format(title) == " #")
				name += " " + title + tag();
			else {
				String character = name;
				name = title + (format(title) == " $" ? " " : "") + character + tag();
			}
			return name;
		}
		return "";
	}
	
	public String title(int id, Player player) {
		title = getGender(player) ? titleM[id] : titleF[id];
		if(title.contains("null"))
			title = titleM[id];
		
		return (color[id] + title + (id != 0 ? "</col>" : ""));
	}
	
	public String get(int index) {
		return color[index] + titleM[index] + "</col>";
	}
	
	PlayerTitles() {
		title = "";
		suffix = false;
	}
	
	String[] suffixChar = {
		".", "?", ",", " ",
		"to", "the", "was", "lost", "ate", "of", "<col", "<s", "Zil", "Scourge", 
		"Master of", "Scion", "BlackB", "Runeb", "Ruler of", "Chronicl", "Slapsa", "le "
	};
	
	public static int archived;
	String title;
	static String[] titleM;
	static String[] titleF;
	static String[] color;
	boolean suffix;
	
}
