package hfdp.tests;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hfdp.ConcatenatedIteratorCollection;

public class TestNoInitializationIteration {
	private ConcatenatedIteratorCollection failureNotInitializedTestCollection;

	@Before
	@Ignore("Not implemented yet.")
	public void initialize() {
		failureNotInitializedTestCollection = new ConcatenatedIteratorCollection();
	}
	
	@Test
	public void testNoInitializationIteration() {
	}
	
}
