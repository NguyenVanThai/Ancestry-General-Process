/**
 * 
 */
package test;
import java.util.ArrayList;
import java.util.Arrays;
 
/**
 * @author lqnhu
 *
 */
public class TestApp {
	 
	  public static void main(String[] args) {
		  String s = "  %s = '{\"\",Herr}'::varchar[] or  %s = '{Frau,Herr}'::varchar[] or  %s = '{\"\",Herr}'::varchar[] )";
		  String r = String.format( s , "oooo");

	  }
	 //ssdfdsfsdf
	  private void process() {
	 
		Object[] obj = new Object[] { "a", "b", "c" };
	 
		System.out.println("Before Object [] ");
		for (Object temp : obj) {
			System.out.println(temp);
		}
	 
		System.out.println("\nAfter Object [] ");
		Object[] newObj = appendValue(obj, "new Value");
		for (Object temp : newObj) {
			System.out.println(temp);
		}
	 
	  }
	 
	  private Object[] appendValue(Object[] obj, Object newObj) {
	 
		ArrayList<Object> temp = new ArrayList<Object>(Arrays.asList(obj));
		temp.add(newObj);
		return temp.toArray();
	 
	  }
	 
	}
