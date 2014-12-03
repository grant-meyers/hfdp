package hfdp.tests;

import hfdp.ConcatenatedIteratorCollection;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class ConcatenatedIteratorCollectionTests {
	private ConcatenatedIteratorCollection<AbstractCollection> successfulInOrderTestCollection;
	private ConcatenatedIteratorCollection successfulSingleIteratorTestCollection;
	private ConcatenatedIteratorCollection successfulMultiIteratorTestCollection;
	private ConcatenatedIteratorCollection successfulHomongenousIteratorTestCollection;
	private ConcatenatedIteratorCollection successfulHeterogenousIteratorTestCollection;
	
	private ConcatenatedIteratorCollection failureNoIteratorsTestCollection;
	private ConcatenatedIteratorCollection failureNotInitializedTestCollection;
	private ConcatenatedIteratorCollection failureResetTestCollection;

	@Before
	public void initialize() {
		successfulInOrderTestCollection = new ConcatenatedIteratorCollection<AbstractCollection>();
		successfulSingleIteratorTestCollection = new ConcatenatedIteratorCollection();
		successfulMultiIteratorTestCollection = new ConcatenatedIteratorCollection();
		successfulHomongenousIteratorTestCollection = new ConcatenatedIteratorCollection();
		successfulHeterogenousIteratorTestCollection = new ConcatenatedIteratorCollection();
		
		failureNoIteratorsTestCollection = new ConcatenatedIteratorCollection();
		failureNotInitializedTestCollection = new ConcatenatedIteratorCollection();
		failureResetTestCollection = new ConcatenatedIteratorCollection();	
	}
	    
	public ConcatenatedIteratorCollectionTests() {
		
	}
	
	@SuppressWarnings({ "serial", "rawtypes" })
	@Test
	public void testFullSetIteration() {
		AbstractList iterableList1 = new ArrayList<String>() {{ new String("asd"); new String(); }};
		Vector iterableVector = new Vector<String>() {{ new String("zxc"); new String("bnm"); }};
		
		successfulInOrderTestCollection.addIterable(iterableList1);
		successfulInOrderTestCollection.addIterable(null);
		successfulInOrderTestCollection.addIterable(iterableVector);
		successfulInOrderTestCollection.addIterable(null);
	}

	public void testSingleIteratorIteration() {
		
	}
	
	public void testMultipleIteratorIteration() {
		
	}
	
	public void testHomongenousIteratorsIteration() {
		
	}
	
	public void testHeterogenousIteratorsIteration() {
		
	}

	public void testZeroIteratorIteration() {
		
	}
	
	public void testNoInitializationIteration() {
		
	}
	
	public void testResetCollectionIteration() {
		
	}
	
}
