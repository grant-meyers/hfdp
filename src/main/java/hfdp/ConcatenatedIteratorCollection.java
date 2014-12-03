package hfdp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

//Created as an alternate implementation for exposing a single iterator for a disparate set of source classes.
//	Specifically in reference to Ch. 9 - Well-Managed Collections chapter of Head First Design Patterns
//
// TODO: Modify to make concurrent capable.

public class ConcatenatedIteratorCollection<E> implements Iterator<E> {
	private Iterator<E> currentIterator = null;
	private ArrayList<Iterable<E>> iterables = null;
	private int iteratorsIndex = 0;
	
	public ConcatenatedIteratorCollection() {
		iterables = new ArrayList<Iterable<E>>();
	}

/**
 * Function to set currentIterator variable to the next Iterator with a hasNext() element
 * 
 * @return boolean value for currentIterator being set to an Iterator with a hasNext() element.
 */
	private boolean findNextFullIterator() {
		iteratorsIndex = iteratorsIndex + 1;
		
		while(iteratorsIndex < iterables.size()) {
			Iterable<E> currentIterable = iterables.get(iteratorsIndex);
			
			//Skip null Iterable<E>'s
			if(currentIterable == null) { iteratorsIndex = iteratorsIndex + 1; continue; }
			
			//Check next iterator for one with entries in it
			currentIterator = currentIterable.iterator();
			
			if(currentIterator != null && currentIterator.hasNext()) {
				return true;
			}
			
			iteratorsIndex = iteratorsIndex + 1;
		}
		return false;
	}
	
/**
 * Add an Iterable from the parameter to the iterator collection.
 * 
 * @param iterable class to retrieve and add an iterator to the iterator collection.
 */
	public void addIterable(Iterable<E> iterable) {
		iterables.add(iterable);
	}
	
/**
 * Restart this ConcatenatedIteratorCollection to the beginning of the collection of Iterables.
 */
	public void restart() {
		iteratorsIndex = 0;
		currentIterator = null;
	}

/**
 * Reset this ConcatenatedIteratorCollection to it's initial state of an empty collection of Iterables, index of 0, and a null current iterator reference.
 */
	public void reset() {
		restart();
		iterables = new ArrayList<Iterable<E>>();
	}

/**
 * Function to check if one of the Iterators, from the current onwards, in the Iterable collection has a next element.
 * 
 * @return boolean value of whether or not there is another element in one of the iterators.
 */
	@Override
	public boolean hasNext() {
		//Check if there are still Iterators left to check hasNext against.
		if(iterables.size() <= 0 || iteratorsIndex >= iterables.size()) {
			return false;
		}
		
		//Starting at the currentIterator scan the rest of the Iterators in the collection for hasNext().
		if(currentIterator == null || currentIterator.hasNext() == false) { 
			//Loop over remainder of the collection of Iterables
			while(findNextFullIterator()) {
				if(currentIterator.hasNext() == true) {
					return true;
				}
			}
		} else {
			return true;
		}
		
		//Searched the collection from currentIterator forward and there are no more entries to retrieve.
		return false;
	}

/**
 * Function to get the next element from one of the Iterators, from the current onwards, in the iterators collection.
 * 
 * @return Generic reference E from the current iterator onwards from the collection of iterators.
 */
	@Override
	public E next() {
		//Nothing in the set of Iterables
		if(iterables.size() == 0) {
			throw new NoSuchElementException("ConcatenatedIteratorCollection has no Iterators to retrieve elements from.");
		}
		
		//Should only happen if the user does not use a hasNext() before this call.
		//Need to find the next Iterator with an entry and return that or throw a NoSuchElementException.
		if(currentIterator == null || currentIterator.hasNext() == false) { 
			//Loop over remainder of the collection of Iterables
			while(findNextFullIterator()) {
				if(currentIterator.hasNext() == true) {
					return currentIterator.next();
				}
			}
			throw new NoSuchElementException("ConcatenatedIteratorCollection has no more elements in it's Iterators to retrieve elements from.");
		} else {
			return currentIterator.next();
		}
	}

	
	
}
