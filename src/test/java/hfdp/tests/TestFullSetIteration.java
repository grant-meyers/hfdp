package hfdp.tests;

import static org.junit.Assert.fail;
import hfdp.ConcatenatedIteratorCollection;

import java.util.ArrayList;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class TestFullSetIteration {
	private ConcatenatedIteratorCollection<String> successfulInOrderTestCollection;
	

	@Before
	public void initialize() {
		successfulInOrderTestCollection = new ConcatenatedIteratorCollection<String>();
		
	}
	
	@Test
	public void testFullSetIteration() {
		ArrayList<String> iterableList1 = new ArrayList<String>(); 
		iterableList1.add(new String("asd")); 
		iterableList1.add(new String()); 
		iterableList1.add(new String("a string"));
		
		Vector<String> iterableVector = new Vector<String>();
		iterableVector.add(new String("zxc"));
		iterableVector.add(new String("bnm"));
		
		successfulInOrderTestCollection.addIterable(iterableList1);
		successfulInOrderTestCollection.addIterable(null);
		successfulInOrderTestCollection.addIterable(iterableVector);
		successfulInOrderTestCollection.addIterable(null);
		
		int stringsCompared = 0;
		
		while(successfulInOrderTestCollection.hasNext()) {
			String curString = successfulInOrderTestCollection.next();
						
			if(!curString.equalsIgnoreCase("") && !iterableList1.contains(curString) && !iterableVector.contains(curString)) {
				fail("TestFullSetIteration contained a String not added via provided iterable lists.");
			} else {
				stringsCompared += 1;
			}
		}
		
		if(stringsCompared < (iterableList1.size() + iterableVector.size())) {
			System.out.println("Provided size: " + (iterableList1.size() + iterableVector.size()) + " Tested size: " + stringsCompared);
			fail("TestFullSetIteration did not iterate over all provided values.");
		}
	}	
}
