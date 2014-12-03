package hfdp.tests;

import java.util.ArrayList;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestFullSetIteration.class,
	TestHeterogenousIteratorsIteration.class,
	TestHomongenousIteratorsIteration.class,
	TestMultipleIteratorIteration.class,
	TestNoInitializationIteration.class,
	TestResetCollectionIteration.class,
	TestSingleIteratorIteration.class,
	TestZeroIteratorIteration.class})
public class TestRunnerAll {

	public TestRunnerAll() {}
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
	      
		Class testClasses[] = {
				TestFullSetIteration.class,
				TestHeterogenousIteratorsIteration.class,
				TestHomongenousIteratorsIteration.class,
				TestMultipleIteratorIteration.class,
				TestNoInitializationIteration.class,
				TestResetCollectionIteration.class,
				TestSingleIteratorIteration.class,
				TestZeroIteratorIteration.class
		};
		
		ArrayList<Result> results = new ArrayList<Result>();
		
		for(Class curTestClass : testClasses) {
			results.add(JUnitCore.runClasses(curTestClass));
		}
		
		int i=0;
		
		for (Result curResult : results) {
		    for (Failure failure : curResult.getFailures()) {
		       System.out.println(failure.toString());
		    }
		
		    String returnString = (curResult.wasSuccessful()) ? "a success." : "a failure.";
		    
		    System.out.println("Testing " + testClasses[i++].toGenericString() + " was " + returnString);
		} 
	}
}
