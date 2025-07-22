# === Keep your client entry ===
-keep public class client {
    public static void main(java.lang.String[]);
}

# === Reflection + Swing compatibility ===
-keepclassmembers class * {
    public <init>(...);
    public static void main(java.lang.String[]);
    public void *(...);
}
-keepattributes Signature, InnerClasses, EnclosingMethod, RuntimeVisibleAnnotations, *Annotation*

# === General safety flags ===
-ignorewarnings
-dontnote
-dontwarn **
-dontoptimize
-dontshrink

# === Radiance UI Libraries ===
-keep class org.pushingpixels.** { *; }

# === JLayer (MP3 Playback) ===
-keep class javazoom.jl.** { *; }

# === Apache Commons Lang3 ===
-keep class org.apache.commons.lang3.** { *; }
-keep class com.sun.jna.** { *; }
# === Google-Collect / Guava precursor ===
-keep class com.google.common.collect.** { *; }
-keep class com.google.common.base.** { *; }
# === Discord RPC – confirm this path matches your jar’s actual packages ===
-keep class net.arikia.dev.drpc.** { *; }

# === Resources (optional but safe) ===
-keepattributes SourceFile, LineNumberTable

# === Optional: Save mapping file ===
-printmapping build/proguard-map.txt
