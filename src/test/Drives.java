/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 * @author lqnhu
 * 
 */
public class Drives implements Runnable {

	private String username = "";
	private String password = "";
	public String terminal; // the terminal

	public boolean connected = false; // tells if the conection to this terminal
										// was possible or not

	public boolean finished = false; // tels if the thread has finished its work

	Hashtable drives = new Hashtable();

	public Drives(String username, String password) {
		this.username = username;
		this.password = password;
		scanDrives();
	}

	/**
	 * Scan the available drives with the "net use drive:" command
	 */
	public void scanDrives() {
		for (char ch = 'Z'; ch > 'F'; ch--) {
			String command = "net use " + ch + ":";
			String result = runCommand(command);

			// if found a free drive
			if (result.toUpperCase().indexOf(ch + ":") == -1) {
				// add it to the list
				// System.out.println(result.toUpperCase().indexOf(ch+":") ==
				// -1);
				drives.put("" + ch, new Boolean(true));
			}
		}
	}

	/**
	 * @return the first free drive found
	 */
	public synchronized String getFreeDrive() {
		for (char ch = 'Z'; ch > 'F'; ch--) {
			Boolean res = (Boolean) (drives.get("" + ch));
			if (res != null && res.booleanValue()) {
				// set the free drive found as busy

				setBusyDrive("" + ch);
				return "" + ch;
			}
		}

		return null;
	}

	/**
	 * Sets this drive as free and available to be used
	 */
	public synchronized void setFreeDrive(String drive) {
		drives.put(drive, new Boolean(true));
	}

	/**
	 * Sets the drive as busy and unavailable
	 */
	public synchronized void setBusyDrive(String drive) {
		drives.put(drive, new Boolean(false));
	}

	public void run() {
		System.out.println("Start thread ");

		String drive;

		while (true) {
			// get an available drive letter

			drive = getFreeDrive();
			if (drive != null) {
				break;
			}

			// if no drive letter found, sleep for 5 sec then try again
			try {
				Thread.sleep(5000);
				System.out.println("Waiting for a free drive");
			} catch (InterruptedException e1) {
			}
		}

		// connect with the given list of passwords
		boolean success = mapDrive(drive, terminal, username, password);

		// if connection is successful, break
		if (success) {
			connected = true;
		}

		// if no connection was possible, log and quit thread
		if (!connected) {
			System.out.println("Connection to " + terminal + " failed");
		} else // if connection possible
		{
			System.out.println("Connected to " + terminal);

		}

		// at the end disconnect the drive and free it
		disconnectDrive(drive);
		setFreeDrive(drive);

		// mark thread status as finished
		finished = true;
	}

	private void disconnectDrive(String drive) {
		String command = "net use " + drive + ": /delete";
		runCommand(command);
	}

	private boolean mapDrive(String drive, String terminal, String user,
			String pwd) {
		String command = null;

		if (user == null) {
			command = "net use " + drive + ": \\\\" + terminal + "\\C$ ";
		} else {
			command = "net use " + drive + ": \\\\" + terminal + "\\C$ " + pwd
					+ " /user:" + user;
		}
		return runCommandToBoolean(command);
	}

	public static String runCommand(String param) {
		try {
			StringBuffer sb = new StringBuffer();
			Process process = Runtime.getRuntime().exec(param);
			InputStream standardInput = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					standardInput));
			InputStream standardError = process.getErrorStream();
			BufferedReader brError = new BufferedReader(new InputStreamReader(
					standardError));
			// OutputStream standardOutput = process.getOutputStream();
			String s;

			while ((s = br.readLine()) != null) {
				sb.append(s + "\n");
			}

			while ((s = brError.readLine()) != null) {
				sb.append(s + "\n");
			}

			standardInput.close();
			standardError.close();
			return sb.toString();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static boolean runCommandToBoolean(String param) {
		try {
			boolean flag = false;
			System.out.println("Running: " + param);
			StringBuffer sb = new StringBuffer();
			Process process = Runtime.getRuntime().exec(param);
			InputStream standardInput = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(standardInput));
			InputStream standardError = process.getErrorStream();
			BufferedReader brError = new BufferedReader(new InputStreamReader(standardError));
			// OutputStream standardOutput = process.getOutputStream();
			String s;
			while ((s = br.readLine()) != null) {
				sb.append(s + "\n");
				flag = true;
			}
			while ((s = brError.readLine()) != null) {
				sb.append(s + "\n");
				flag = false;
			}
			standardInput.close();
			standardError.close();
			return flag;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
