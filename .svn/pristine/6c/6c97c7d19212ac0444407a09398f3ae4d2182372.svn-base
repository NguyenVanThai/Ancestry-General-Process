/**
 * 
 */
package com.digitexx.ancestry.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lqnhu
 * 
 */
public class SystemUtil {

	public static String getOsArchitecture() {
		return System.getProperty("os.arch");
	}

	public static String getOsName() {
		return System.getProperty("os.name");
	}

	public static String getOsVersion() {
		return System.getProperty("os.version");
	}

	public static String getUserDir() {
		return System.getProperty("user.dir");
	}

	public static String getUserHome() {
		return System.getProperty("user.home");
	}

	public static String getUserTemp() {
		return System.getProperty("java.io.tmpdir");
	}

	public static String getUserName() {
		return System.getProperty("user.name");
	}
	
	
	/**
	 * get user mount in Linux
	 */
	public static String getUserMountLinux()throws Exception {
		String username = "";
		try {
			Process mountProcess = Runtime.getRuntime().exec("mount");
			BufferedReader mountOutput = new BufferedReader(new InputStreamReader(mountProcess.getInputStream()));
			List<File> roots = new ArrayList<File>();
			while (true) {
				// fetch the next line of output from the "mount" command
				String line = mountOutput.readLine();
				if (line == null)
					break;
				line = line.substring(line.lastIndexOf("username"));
				line = line.substring(0, line.indexOf(","));
				line = line.substring(line.indexOf("=") + 1);
				username = line;
			}
			mountOutput.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("getUserMountLinux : "  + e.toString());
		}
		return username;
	}
}
