/**
 * 
 */
package com.digitexx.ancestry.util;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author lqnhu
 *
 */
public abstract class ReadTxtUtil {
	public static final int BFRSIZE = 4096;

	/**
	 * reads the given file into one big string
	 * 
	 * @param String
	 *            filename - the name of the file to read
	 * @return the contents filename
	 */
	public static String read(String filename) throws IOException,
			FileNotFoundException {
		FileReader in = null;
		StringBuffer out = new StringBuffer();
		try {
			in = new FileReader(filename);
			char[] cbuf = new char[BFRSIZE];
			int n = in.read(cbuf, 0, BFRSIZE);
			while (n > 0) {
				out.append(cbuf);
				n = in.read(cbuf, 0, BFRSIZE);
			}
		} finally {
			if (in != null)
				in.close();
		}
		return out.toString();
	}

	/**
	 * a pseudonym for read especially for perl programmers
	 */
	public static String slurp(String filename) throws IOException,
			FileNotFoundException {
		return (ReadTxtUtil.read(filename));
	}

	/**
	 * (re)writes the given content to the given filename
	 * 
	 * @param String
	 *            content - the new contents of the fil
	 * @param String
	 *            filename - the name of the file to write.
	 */
	public static void write(String content, String filename)
			throws IOException {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter(filename));
			out.write(content);
		} finally {
			if (out != null)
				out.close();
		}
	}

	/**
	 * a pseudonym for write especially for perl programmers
	 */
	public static void splooge(String content, String filename)
			throws IOException, FileNotFoundException {
		ReadTxtUtil.write(content, filename);
	}

	/**
	 * reads each line of the given file into an array of strings.
	 * 
	 * @param String
	 *            filename - the name of the file to read
	 * @return a fixed length array of strings containing file contents.
	 */
	public static String[] readArray(String filename) throws IOException,
			FileNotFoundException {
		return readList(filename).toArray(new String[0]);
	}

	/**
	 * reads each line of the given file into an ArrayList of strings.
	 * 
	 * @param String
	 *            filename - the name of the file to read
	 * @return an ArrayList of strings containing file contents.
	 */
	public static ArrayList<String> readArrayList(String filename)
			throws IOException, FileNotFoundException {
		return (ArrayList<String>) readList(filename);
	}

	/**
	 * reads each line of the given file into a List of strings.
	 * 
	 * @param String
	 *            filename - the name of the file to read
	 * @return an List handle ArrayList of strings containing file contents.
	 */
	public static List<String> readList(String filename) throws IOException,
			FileNotFoundException {
		BufferedReader in = null;
		List<String> out = new ArrayList<String>();
		try {
			FileInputStream fileStream = new FileInputStream(filename);
			byte[] arr = new byte[]{1,2,3};
			fileStream.read(arr);

			if(arr[0]==-1){
				in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-16"));
			}else if(arr[0]==-17){
				in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			}else{
				in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			} 
			String line = null;
			while ((line = in.readLine()) != null) {
				line = removeUTF8BOM(line);
				if(line.length()>0)
					out.add(line);
				
			}
		} finally {
			if (in != null)
				in.close();
		}
		return out;
	}
	
	public static final String UTF8_BOM = "\uFEFF";
    public static String removeUTF8BOM(String s) {
        if (s.startsWith(UTF8_BOM)) {
            s = s.substring(1);
        }
        return s;
    }

	/**
	 * reads the whole of the given file into an array of bytes.
	 * 
	 * @param String
	 *            filename - the name of the file to read
	 * @return an array of bytes containing the file contents.
	 */
	public static byte[] readBytes(String filename) throws IOException,
			FileNotFoundException {
		return (readBytes(new File(filename)));
	}

	/**
	 * reads the whole of the given file into an array of bytes.
	 * 
	 * @param File
	 *            file - the file to read
	 * @return an array of bytes containing the file contents.
	 */
	public static byte[] readBytes(File file) throws IOException,
			FileNotFoundException {
		byte[] out = null;
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			out = new byte[(int) file.length()];
			int size = in.read(out);
		} finally {
			if (in != null)
				in.close();
		}
		return out;
	}

	/**
	 * do files A & B have the same contents
	 * 
	 * @param String
	 *            filenameA - the first file to compare
	 * @param String
	 *            filenameA - the second file to compare
	 * @return boolean do-these-two-files-have-the-same-contents?
	 */
	public static boolean isSame(String filenameA, String filenameB)
			throws IOException, FileNotFoundException {
		File fileA = new File(filenameA);
		File fileB = new File(filenameB);
		// check for same physical file
		if (fileA.equals(fileB))
			return (true);
		// compare sizes
		if (fileA.length() != fileB.length())
			return (false);
		// compare contents (buffer by buffer)
		boolean same = true;
		InputStream inA = null;
		InputStream inB = null;
		try {
			inA = new FileInputStream(fileA);
			inB = new FileInputStream(fileB);
			byte[] bfrA = new byte[BFRSIZE];
			byte[] bfrB = new byte[BFRSIZE];
			int sizeA = 0, sizeB = 0;
			do {
				sizeA = inA.read(bfrA);
				sizeB = inA.read(bfrB);
				if (sizeA != sizeB) {
					same = false;
				} else if (sizeA == 0) {
					// do nothing
				} else if (!Arrays.equals(bfrA, bfrB)) {
					same = false;
				}
			} while (same && sizeA != -1);
		} finally {
			if (inA != null)
				inA.close();
			if (inB != null)
				inB.close();
		}
		return (same);
	}

	/**
	 * checks the given filename exists and is readable
	 * 
	 * @param String
	 *            filename = the name of the file to "open".
	 * @param OPTIONAl
	 *            String type = a short name for the file used to identify the
	 *            file in any exception messages. For example: "input",
	 *            "input data", "DTD", "XML", or whatever.
	 * @return a File object for the given filename.
	 * @throw FileNotFoundException if the given file does not exist.
	 * @throw IOException if the given file is unreadable (usually permits).
	 */
	public static File open(String filename) throws FileNotFoundException,
			IOException {
		return (open(filename, "input"));
	}

	public static File open(String filename, String type)
			throws FileNotFoundException, IOException {
		File file = new File(filename);
		String fullname = file.getCanonicalPath();
		if (!file.exists())
			throw new FileNotFoundException(type + " file does not exist: "
					+ fullname);
		if (!file.canRead())
			throw new IOException(type + " file is not readable: " + fullname);
		return (file);
	}

	/**
	 * gets the filename-only portion of a canonical-filename, with or without
	 * the extension.
	 * 
	 * @param String
	 *            path - the full name of the file. OPTIONAL @param boolean
	 *            cutExtension - if true then remove any .ext
	 * @return String the filename-only (with or without extension)
	 */
	public static String basename(String path) {
		return (basename(path, false));
	}

	public static String basename(String path, boolean cutExtension) {
		String fname = (new File(path)).getName();
		if (cutExtension) {
			int i = fname.lastIndexOf(".");
			if (i > 0)
				fname = fname.substring(0, i);
		}
		return (fname);
	}
	
	public static String getPathOfFile(String filename)
	{
		String pathFile = System.getProperty("java.class.path");
        
        pathFile = pathFile.split(";")[0].replace("\\", "/");
		
		if(pathFile.lastIndexOf("/") > -1) {
			pathFile = pathFile.substring(0, pathFile.lastIndexOf("/"));
		}else{
			pathFile = ".";
		}
        
        return pathFile + "/" + filename;
	}

	/**
	 * gets the directory portion of a canonical-filename
	 * 
	 * @param String
	 *            path - the full name of the file.
	 * @return String the parent directory of the given path.
	 */
	public static String dirname(String path) {
		return (new File(path).getParent());
	}

	/**
	 * close these "streams"
	 * 
	 * @param Closeable
	 *            ... "streams" to close.
	 */
	public static void close(Closeable... streams) {
		for (Closeable stream : streams) {
			if (stream == null)
				continue;
			try {
				stream.close();
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}
	
	public static Map<String,List<String>> readMap(String filename) throws IOException,
	FileNotFoundException {
		BufferedReader in = null;
		Map<String,List<String>> out = new HashMap<String,List<String>>();
		String[] str ;
		try {
			FileInputStream fileStream = new FileInputStream(filename);
			byte[] arr = new byte[]{1,2,3};
			fileStream.read(arr);
		
			if(arr[0]==-1){
				in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-16"));
			}else if(arr[0]==-17){
				in = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"));
			}else{
				in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			} 
			String line = null;
			while ((line = in.readLine()) != null) {
				line = removeUTF8BOM(line);
				if(line.length()>0){
					List<String> obj = new ArrayList<String>();
					str = line.split(",");
					
					obj.add(str[1]);
					obj.add(str[2]);
					obj.add(str[3]);
					obj.add(str[4]);
					out.put(str[0], obj);
				}
			}
		} finally {
			if (in != null)
				in.close();
		}
		return out;
	}


}
