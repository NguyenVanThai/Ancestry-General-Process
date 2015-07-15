/**
 * 
 */
package test;

import java.io.File;
import java.io.IOException;


/**
 * @author lqnhu
 *
 */
public class RecursiveDelete {

    public static void main(String[] args) throws IOException {
    	
//    	String str = "ss@CLE32"; 
//    	char[] charArray = str.toCharArray();
//    	RemoteSession remoteSession = new RemoteSession("file://10.10.5.206", "ancestry", charArray);
//    	RemoteFile remoteFile = new RemoteFile(remoteSession, "Dexter/ExternalBatches/Test/test.txt");

    	
       // String dirPath = "C:" + File.separator + "dev_tools" + File.separator + "dir_to_delete";
       // System.out.println("Delete folder path=" + dirPath);
       // execute(dirPath);
    }

    public static void execute(String folderToDelete) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        File emptyFolder = createEmptyDirectory();
        if (isWindows(os)) {
            Runtime.getRuntime().exec("cmd /c robocopy " + emptyFolder + " " + folderToDelete + " /purge & rmdir " + folderToDelete);
        } else if (isUnix(os) || isMac(os) || isSolaris(os)) {
            Runtime.getRuntime().exec("rm -r -f  " + folderToDelete);
        }
    }

    private static File createEmptyDirectory() {
        File emptyFolder = new File("EmptyFolder");
        if (!emptyFolder.exists()) {
            boolean isCreated = emptyFolder.mkdir();
            System.out.println("Is empty folder created ?" + isCreated);
            System.out.println("EmptyFolder path" + emptyFolder.getAbsolutePath());
        }
        return emptyFolder;
    }

    public static boolean isWindows(String os) {
        return (os.contains("win"));
    }

    public static boolean isUnix(String os) {
        return (os.contains("nix") || os.contains("aix") || os.contains("nux"));
    }

    public static boolean isSolaris(String os) {
        return (os.contains("sunos"));
    }

    public static boolean isMac(String os) {
        return (os.contains("mac"));
    }
}
