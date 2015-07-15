/**
 * 
 */
package com.digitexx.ancestry.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author lqnhu
 * 
 */
public class CopyFileUtil 
{
	  public static boolean copyDirectory(File source, File destination, FileFilter filter)throws IOException
	  {
		boolean flag = false;
		try {
			File nextDirectory = new File(destination, source.getName());
			if (!nextDirectory.exists() && !nextDirectory.mkdirs()) {
				Object[] filler = { nextDirectory.getAbsolutePath() };
				String message = "DirCopyFailed";
				throw new IOException(message);
			}
			File[] files = source.listFiles();
			for (int n = 0; n < files.length; ++n) {
				if (filter == null || filter.accept(files[n])) {
					if (files[n].isDirectory())
						copyDirectory(files[n], nextDirectory, filter);
					else
						copy(files[n], nextDirectory);
				}
			}
		} catch (Exception e) {
			flag = false;
			throw new IOException("copyDirectory : "  + e.toString());
		}
		return flag;
	  }
	
	/**
	 * Copies file contents from source to destination. Makes up for the lack of
	 * file copying utilities in Java
	 */
	public static boolean copy(File source, File destination) {
		BufferedInputStream fin = null;
		BufferedOutputStream fout = null;
		try {
			int bufSize = 8 * 1024;
			fin = new BufferedInputStream(new FileInputStream(source), bufSize);
			fout = new BufferedOutputStream(new FileOutputStream(destination),bufSize);
			copyPipe(fin, fout, bufSize);
		} catch (IOException ioex) {
			return false;
		} catch (SecurityException sx) {
			return false;
		} finally {
			if (fin != null) {
				try {
					fin.close();
				} catch (IOException cioex) {
				}
			}
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException cioex) {
				}
			}
		}
		return true;
	}

	/**
	 * Save URL contents to a file.
	 */
	public static boolean copy(URL from, File to) {
		BufferedInputStream urlin = null;
		BufferedOutputStream fout = null;
		try {
			int bufSize = 8 * 1024;
			urlin = new BufferedInputStream(from.openConnection().getInputStream(), bufSize);
			fout = new BufferedOutputStream(new FileOutputStream(to), bufSize);
			copyPipe(urlin, fout, bufSize);
		} catch (IOException ioex) {
			return false;
		} catch (SecurityException sx) {
			return false;
		} finally {
			if (urlin != null) {
				try {
					urlin.close();
				} catch (IOException cioex) {
				}
			}
			if (fout != null) {
				try {
					fout.close();
				} catch (IOException cioex) {
				}
			}
		}
		return true;
	}

	/**
	 * Reads data from the input and writes it to the output, until the end of
	 * the input stream.
	 * 
	 * @param in
	 * @param out
	 * @param bufSizeHint
	 * @throws IOException
	 */
	public static void copyPipe(InputStream in, OutputStream out,int bufSizeHint) throws IOException {
		int read = -1;
		byte[] buf = new byte[bufSizeHint];
		while ((read = in.read(buf, 0, bufSizeHint)) >= 0) {
			out.write(buf, 0, read);
		}
		out.flush();
	}
}
