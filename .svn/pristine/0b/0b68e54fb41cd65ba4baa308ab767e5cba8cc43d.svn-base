/**
 * 
 */
package com.digitexx.ancestry.util;

import java.io.File;
import java.io.FileFilter;

/**
 * @author lqnhu
 * 
 */
public class DB3FileFilter implements FileFilter {
	private final String[] okFileExtensions = new String[] { "db3", "DB3" };

	public boolean accept(File file) {
		for (String extension : okFileExtensions) {
			if (file.getName().toLowerCase().endsWith(extension)) {
				return true;
			}
		}
		return false;
	}
}