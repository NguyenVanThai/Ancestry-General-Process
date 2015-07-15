/**
 * 
 */
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lqnhu
 *
 */
public class TestMount {

	/**
	 * @param args
	 * @throws IOException 
	 */
	
	
	
	public static void main(String[] args) throws IOException {
		
		   Process mountProcess = Runtime.getRuntime ().exec ( "mount" );
		    BufferedReader mountOutput = new BufferedReader ( new InputStreamReader ( mountProcess.getInputStream () ) );
		    List<File> roots = new ArrayList<File> ();
		    
		    
		    while ( true ) {

		        // fetch the next line of output from the "mount" command
		        String line = mountOutput.readLine ();
		        
		        System.out.println(line);
		        
		        if ( line == null )
		            break;

		        // the line will be formatted as "... on <filesystem> (...)"; get the substring we need
		        int indexStart = line.indexOf ( " on /" );
		        int indexEnd = line.indexOf ( " ", indexStart );
		        //roots.add ( new File ( line.substring ( indexStart + 4, indexEnd - 1 ) ) );
		    }
		    mountOutput.close ();
		    
		    String line = "(rw,relatime,vers=1.0,cache=strict,username=lqnhu,domain=DIGI";
		    line = line.substring(line.lastIndexOf("username"));
		    line = line.substring(0 ,line.indexOf(","));
		    line = line.substring(line.indexOf("=")+1);
		    System.out.println(line);

	}

}
