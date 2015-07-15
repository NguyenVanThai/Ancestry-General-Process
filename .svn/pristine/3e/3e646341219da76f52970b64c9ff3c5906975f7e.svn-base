/**
 * 
 */
package test;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;

/**
 * @author lqnhu
 *
 */
public class ListMountedVolumesWithNio {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
	     for (FileStore store : FileSystems.getDefault().getFileStores()) {
	         long total = store.getTotalSpace() / 1024;
	         long used = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024;
	         long avail = store.getUsableSpace() / 1024;
	         System.out.format("%-20s %12d %12d %12d%n", store, total, used, avail);
	      }

	}

}
