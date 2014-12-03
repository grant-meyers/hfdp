package hfdp.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerAll {

	public static void main(String[] args) {
		
		
		Result results[] = {
	    		  JUnitCore.runClasses(ConcatenatedIteratorCollectionTests.class)
	      };
	      
	      String classes[] = {
	    	"ConcatenatedIteratorCollectionTests"
	      };
	      
	      int i=0;
	      
	      for (Result cur : results) {
		      for (Failure failure : cur.getFailures()) {
		         System.out.println(failure.toString());
		      }

		      String ret = (cur.wasSuccessful()) ? "a success." : "a failure.";
		      
		      System.out.println("Testing " + classes[i++] + " was " + ret);
	      }  
	}
}
