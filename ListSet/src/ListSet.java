import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;

/** Combined implementation of both the List and Set interfaces.
 *  Represents an ordered collection that contains no duplicate values.
 */
public class ListSet<E> implements List<E>, Set<E>
{
	// FIELDS
	// ------------------------------------------------------------------
	private ListNode<E> myHead;	// Reference to a "dummy" node
	private int mySize;			// Number of items in this list-set

	private ListSet<E> parent;	// Used when accessing ListSet methods
	                            // from the inner ListSetIterator class.


	// CONSTRUCTORS
	// ------------------------------------------------------------------
	/** postcondition: Initializes an empty list-set.
	 *      algorithm: Assign to myHead a new ListNode<E> object whose
	 *                   "value" is null and whose "next" and "previous"
	 *                   pointers are null.
	 *                 Set the "next" pointer of myHead to be myHead.
	 *                 Set the "previous" pointer of myHead to be myHead.
	 *                 Assign mySize a value of 0.
	 *                 Assign to parent a reference to this list-set.
	 */
	public ListSet()
	{
		myHead = new ListNode<E>(null,null,null);
		myHead.setNext(myHead);
		myHead.setPrev(myHead);
		mySize = 0;
		parent = this;
	}


	// METHODS
	// ------------------------------------------------------------------
	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: Returns the number of elements in this list-set.
	 *     algorithm: Return the value of mySize.
	 */
	public int size()
	{
		return mySize;
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: Returns false if the number of elements currently in
	 *                this list-set is greater than 0.  Returns true if
	 *                this list-set currently contains no elements.
	 *     algorithm: Return the result of comparing this.size() with 0.
	 */
	public boolean isEmpty()
	{
		return !(mySize > 0);
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: If i is a valid index position in this list-set,
	 *                returns the ListNode<E> representing index position i.
	 *                Otherwise, throws an IndexOutOfBoundsException.
	 *     algorithm: If i is less than -1 or i is greater than the size of
	 *                  this list-set...
	 *                  ...throw a new IndexOutOfBoundsException.
	 *                Declare a ListNode<E> variable called n and initialize
	 *                  it to the value of myHead.
	 *                While i is greater than or equal to 0...
	 *                  ...assign to n the ListNode<E> reference by the
	 *                       "next" field of n.
	 *                  ...decrement the value of i.
	 *                Return the ListNode<E> referenced by n.
	 */
	private ListNode<E> getNode(int i)
	{
		if(i < -1 || i > mySize)
			throw new IndexOutOfBoundsException();
		ListNode<E> n = myHead;
		while(i >= 0)
		{
			n = n.getNext();
			i--;
		}
		return n;
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: If i is a valid index position in this list-set,
	 *                returns the object stored at index position i.
	 *                Otherwise, throws an IndexOutOfBoundsException.
	 *     algorithm: If i is less than 0 or i is greater than or equal
	 *                  too the size of this list-set...
	 *                  ...throw a new IndexOutOfBoundsException.
	 *                Declare a ListNode<E> variable called n.
	 *                Get the node at position i and assign it to n.
	 *                Return the value stored in node n.
	 */
	public E get(int i)
	{
		if(i < 0 || i >= mySize)
			throw new IndexOutOfBoundsException();
		ListNode<E> n = parent.getNode(i);
		return n.getValue();
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: Returns a string containing a concatenation of
	 *                the string representations of all elements in
	 *                this list-set in order of their index positions.
	 *     algorithm: Declare a String variable called s and initialize it
	 *                  with a value of the empty string ("").
	 *                For each index position, i, in this list-set...
	 *                  ...assign to s the string that results from
	 *                       concatenating the object at position i onto
	 *                       the end of s.
	 *                Return the value of s.
	 */
	public String toString()
	{
		String s = "";
		for(int i = 0 ; i < mySize; i++)
		{
			s += parent.getNode(i).toString();
		}
		return s;	// TODO: Implement this method correctly
	}


	/** precondition: This list-set may or may not already contain x.
	 *                Object x may be null.
	 * postcondition: Returns the index position of x in this list-set or -1
	 *                if this list-set does not contain a reference to x.
	 *     algorithm: For each index position, i, in this list-set...
	 *                  ...if the object at position i is equivalent to x...
	 *                       ...return the value of i.
	 *                Return a value of -1.
	 */
	public int indexOf(Object x)
	{
		for(int i = 0 ; i < mySize; i ++)
		{
			if(getNode(i).getValue() == x)
				return i;
		}
		return -1;
	}


	/** precondition: This list-set may or may not already contain x.
	 *                Object x may be null.
	 * postcondition: Returns the index position of x in this list-set or -1
	 *                if this list-set does not contain a reference to x.
	 *     algorithm: Return the result of invoking indexOf(x).
	 */
	public int lastIndexOf(Object x)
	{
		return indexOf(x);
	}


	/** precondition: This list-set may or may not already contain x.
	 *                Object x may be null.
	 * postcondition: Returns true if this list-set contains x and false
	 *                if it does not.
	 *     algorithm: Return the result of comparing to see if the index
	 *                  position of x is greater than -1.
	 */
	public boolean contains(Object x)
	{
		return indexOf(x) > -1;
	}


	/** precondition: This list-set may or may not contain the elements
	 *                of collection c.  The elements of c may be null.
	 * postcondition: Returns true if this list-set contains all elements
	 *                of collection c and false if it does not.
	 *     algorithm: For each Object x in Collection c...
	 *                  ...if this list-set does not contain x...
	 *                       ...return false.
	 *                Return true.
	 */
	public boolean containsAll(Collection<?> c)
	{
		for(Object x : c)
		{
			if(contains(x))
				return false;
		}
		return true;
	}


	/** precondition: This list-set may or may not already contain x.
	 *                Object x may be null.
	 * postcondition: If this list-set does not already contain x and i is
	 *                a valid index position within this list-set, x will be
	 *                inserted at the specified position and the size will
	 *                increase by 1.  If this list-set already contains x,
	 *                the list-set will remain unchanged.  If i is not a
	 *                valid index position (i.e., i < 0 or i > this.size()),
	 *                an IndexOutOfBoundsException will be thrown.
	 *     algorithm: If i is less than 0 or i is greater than the size of
	 *                  this list-set...
	 *                  ...throw a new IndexOutOfBoundsException.
	 *                If this list-set does not contain x...
	 *                  ...declare a ListNode<E> called p and assign to it a
	 *                       reference to node i-1 of this list-set.
	 *                  ...declare a ListNode<E> called n and assign to it a
	 *                       reference to node i of this list-set.
	 *                  ...declare a ListNode<E> called addedNode and assign to
	 *                       it a new ListNode<E> object whose "value" is x,
	 *                       whose "next" pointer is n, and whose "previous"
	 *                       pointer is p.
	 *                  ...set the "next" pointer of p to be addedNode.
	 *                  ...set the "previous" pointer of n to be addedNode.
	 *                  ...increment the value of mySize.
	 */
	public void add(int i, E x)
	{
		if(i < 0 || i > mySize)
			throw new IndexOutOfBoundsException();
		if(!(contains(x)))
		{
			ListNode<E> p = getNode(i-1);
			ListNode<E> n = getNode(i);
			ListNode<E> addNode = new ListNode<E>(x,n,p);
			p.setNext(addNode);
			n.setPrev(addNode);
			mySize++;
			
		}
	}


	/** precondition: This list-set may or may not already contain x. Object
	 *                x may be null.
	 * postcondition: If this list-set does not already contain x, it will
	 *                be appended to the end of the list-set and the size
	 *                will increase by 1.  Otherwise, this list-set will
	 *                remain unchanged.  Returns true if this list-set is
	 *                changed as a result of the method call and false if it
	 *                is not.
	 *     algorithm: Declare a boolean variable called wasModified and
	 *                  initialize it with the result of invoking contains(x)
	 *                  on this list-set.
	 *                Declare an integer variable i and initialize it with
	 *                  the size of this list-set.
	 *                Add x to index position i of this list-set.
	 *                Return the value of wasModified.
	 */
	public boolean add(E x)
	{
		boolean wasModified = contains(x);
		int i = mySize;
		add(i,x);
		return wasModified;
		
	}


	/** precondition: c contains items to be added to this list-set.  This
	 *                list-set may already contain some of the elements of
	 *                Collection c.  The elements of c may be null.
	 * postcondition: Attempts to insert each element of c into this
	 *                list-set at position i in the order that the items
	 *                are returned by the specified collection's iterator.
	 *                Returns true if this list-set is changed as a result
	 *                of the method call and false if it is not.  If i is
	 *                not a valid index position (i.e., i < 0 or
	 *                i > this.size()), an IndexOutOfBoundsException will
	 *                be thrown.
	 *     algorithm: Declare a boolean variable called wasModified and
	 *                  initialize it with a value of false.
	 *                For each E x in Collection c...
	 *                  ...if this list-set does not contain x...
	 *                       ...add x to this list-set at position i.
	 *                       ...increment the value of i.
	 *                       ...assign to wasModified the value of true.
	 *                Return the value of wasModified.
	 */
	public boolean addAll(int i, Collection<? extends E> c)
	{
		boolean wasModified = false;
		for(E x : c)
		{
			if(!(this.contains(x)))
			{
				add(i,x);
				i++;
				wasModified = true;
			}
		}
		return wasModified;
	}


	/** precondition: c contains items to be added to this list-set.  This
	 *                list-set may already contain some of the elements of
	 *                Collection c.  The elements of c may be null.
	 * postcondition: Attempts to append each element of c to the end of
	 *                this list-set in the order that the items are
	 *                returned by the specified collection's iterator.
	 *                Returns true if this list-set is changed as a result
	 *                of the method call and false if it is not.
	 *     algorithm: Declare an integer variable i and initialize it with
	 *                  the size of this list-set.
	 *                Return the result of adding all elements of c to index
	 *                  position i of this list-set.
	 */
	public boolean addAll(Collection<? extends E> c)
	{
		int i = mySize;
		return addAll(i,c);
	}


	/** precondition: This list-set contains 0 or more elements.  This
	 *                list-set may or may not already contain x.  Object
	 *                x may be null.
	 * postcondition: If this list-set already contains object x, throws an
	 *                IllegalArgumentException.  If this list-set does not
	 *                already contain object x, replaces the element at
	 *                index position i with object x and returns the object
	 *                originally stored in that position.  If i is not a
	 *                valid index position (i.e., i < 0 or i >= this.size()),
	 *                an IndexOutOfBoundsException will be thrown.
	 *     algorithm: If i is less than 0 or i is greater than or equal
	 *                  too the size of this list-set...
	 *                  ...throw a new IndexOutOfBoundsException.
	 *                Declare a ListNode<E> called n and assign to it a
	 *                  reference to node i of this list-set.
	 *                Declare an E variable called val and assign it the
	 *                  "value" stored in node n.
	 *                Set the "value" stored in node n to be x.
	 *                Return the value of val.
	 */
	public E set(int i, E x)
	{
		if(i <= 0 || i >= mySize)
			throw new IndexOutOfBoundsException();
		ListNode<E> n = getNode(i);
		E val = n.getValue();
		n.setValue(x);
		return val;
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: Removes and returns the element currently stored at
	 *                index position i.  If i is not a valid index position
	 *                (i.e., i < 0 or i >= this.size()), an
	 *                IndexOutOfBoundsException will be thrown.
	 *     algorithm: If i is less than 0 or i is greater than or equal
	 *                  too the size of this list-set...
	 *                  ...throw a new IndexOutOfBoundsException.
	 *                Declare a ListNode<E> called r and assign to it a
	 *                  reference to node i of this list-set.
	 *                Declare a ListNode<E> called p and assign to it a
	 *                  reference to the "previous" node of r.
	 *                Declare a ListNode<E> called n and assign to it a
	 *                  reference to the "next" node of r.
	 *                Set the "next" pointer of p to be n.
	 *                Set the "previous" pointer of n to be p.
	 *                Set the "next" pointer of r to be null.
	 *                Set the "previous" pointer of r to be null.
	 *                Decrement the value of mySize.
	 *                Return the "value" of r;
	 */
	public E remove(int i)
	{
		if(i<0 || i >= mySize)
			throw new IndexOutOfBoundsException();
		ListNode<E> r = this.getNode(i);
		ListNode<E> p = r.getPrev();
		ListNode<E> n = r.getNext();
		p.setNext(n);
		n.setPrev(p);
		r.setPrev(null);
		mySize--;
		return r.getValue();
	}


	/** precondition: This list-set may or may not already contain x. Object
	 *                x may be null.
	 * postcondition: Removes the first occurrence of x in the list-set.
	 *                Returns true if this list-set is changed as a result
	 *                of the method call and false if it is not.
	 *     algorithm: Declare an integer variable called i and assign to it
	 *                  the result of invoking indexOf(x).
	 *                If the value of i is equal to -1...
	 *                  ...return false.
	 *                Otherwise...
	 *                  ...remove the element at position i from this list-set.
	 *                  ...return true.
	 */
	public boolean remove(Object x)
	{
		int i = indexOf(x);
		if(i == -1)
			return false;
		remove(i);
		return true;
	}


	/** precondition: c contains items to be removed from this list-set.
	 *                This list-set may or may not contain each element of
	 *                Collection c.  The elements of c may be null.
	 * postcondition: Removes all occurrences of each element of c from this
	 *                list-set.  Returns true if this list-set is changed as
	 *                a result of the method call and false if it is not.
	 *     algorithm: Declare a boolean variable called wasModified and
	 *                  initialize it with a value of false.
	 *                For each Object x in Collection c...
	 *                  ...if removing x from this list-set returns true...
	 *                       ...assign wasModified a value of true.
	 *                Return the value of wasModified.
	 */
	public boolean removeAll(Collection<?> c)
	{
		if(this == c)
			clear();
		
		boolean wasModified = false;
		for(Object x : c)
		{
			if(remove(x))
				wasModified = true;
		}
		return wasModified;
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: Removes all of the elements from this list-set. This
	 *                list-set will be empty after this call returns.
	 *     algorithm: While this list-set is not empty...
	 *                  ...remove the element at index position 0.
	 */
	public void clear()
	{
		while(!(isEmpty()))
		{
			remove(0);
		}
	}


	/** precondition: c contains items to be retained in this list-set.
	 *                This list-set may or may not contain each element of
	 *                Collection c.  The elements of c may be null.
	 * postcondition: Removes all elements of this list-set except for those
	 *                in c.  Returns true if this list-set is changed as a
	 *                result of the method call and false if it is not.
	 *     algorithm: Declare a boolean variable called wasModified and
	 *                  initialize it with a value of false.
	 *                For each index position, i, in this list-set...
	 *                  ...if c does not contain the element stored at
	 *                     position i in this list-set...
	 *                       ...remove the element stored at position i
	 *                          from this list-set.
	 *                       ...assign wasModified a value of true.
	 *                Return the value of wasModified.
	 */
	public boolean retainAll(Collection<?> c)
	{
		boolean wasModified = false;
		for(int i = 0; i < mySize; i++)
		{
			if(!c.contains(parent.getNode(i)))
			{
				remove(i);
				wasModified = true;
			}
		}
		return wasModified;
	}


	/** precondition: Object x may or not be a List or a Set.  Object x may
	 *                be null.
	 * postcondition: Returns true if and only if the specified object is
	 *                also a List and a Set, both list-sets have the same
	 *                size, and all corresponding pairs of elements in the
	 *                two list-sets are equal (that is, for each element
	 *                e1.equals(e2)).  In other words, two list-sets are
	 *                defined to be equal if they contain the same elements
	 *                in the same order.
	 *     algorithm: If x references this list-set...
	 *                  ...return true.
	 *                If x is not an instance of List or x is not an
	 *                  instance of Set...
	 *                  ...return false.
	 *                Declare a List<E> variable called c and assign it
	 *                  the (properly type-casted) value of x.
	 *                If the size of this list-set does not equal the size
	 *                  of c...
	 *                  ...return false.
	 *                Declare an integer variable named i and initialize it
	 *                  to a value a 0.
	 *                For each index position of c...
	 *                  ...if the element at position i of c does not equal 
	 *                     the element stored at position i of this list-set...
	 *                       ...return false.
	 *                  ...increment the value of i.
	 *                Return true.
	 */
	public boolean equals(Object x)
	{
		if(x == this)
			return true;
		if(!(x instanceof List) || !(x instanceof Set))
			return false;
		List<E> c = (List<E>)x;
		if(c.size() != this.size())
			return false;
		for(int i = 0 ; i < c.size(); i++)
		{
			if(c.get(i) != get(i))
				return false;
		}
		return true;
	}
	/** precondition: firstIndex is the lower end-point (inclusive) of the
	 *                sublist and lastIndex is the upper end-point
	 *                (exclusive) of the sublist.
	 * postcondition: Returns a new List that contains all of the elements
	 *                of this list-set within the range of firstIndex
	 *                inclusive) through lastIndex (exclusive) in the same
	 *                order that they occur in this list-set.  Throws an
	 *                IndexOutOfBoundsException if from and to specify an
	 *                an invalid range (firstIndex < 0 or lastIndex > size
	 *                or firstIndex > lastIndex).
	 *     algorithm: If firstIndex is less than 0 or lastIndex is greater
	 *                  than the size of this list-set or if firstIndex is
	 *                  greater than lastIndex...
	 *                  ...throw a new IndexOutOfBoundsException.
	 *                Declare a new List<E> called sub and assign to it a
	 *                  new ListSet<E>.
	 *                For each index position of this list-set from
	 *                  firstIndex through lastIndex (exclusive)...
	 *                  ...add the element to sub.
	 *                Return the sub list-set.
	 */
	public List<E> subList(int firstIndex, int lastIndex)
	{
		if(firstIndex < 0 || lastIndex > mySize)
				throw new IndexOutOfBoundsException();
		List<E> sub = new ListSet<E>();
		for(int i = firstIndex++; i < lastIndex; i++)
		{
			sub.add(this.getNode(i).getValue());
		}
		return sub;
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: Returns a primitive array containing all of the
	 *                elements of this list-set in the same order that they
	 *                are currently stored.  The length of the returned
	 *                array is equal to the number of elements in this
	 *                list-set.
	 *     algorithm: Declare a new Object array called arr and initialize
	 *                  it to have a length equal to the size of this
	 *                  list-set.
	 *                For each index position, i, of this list-set...
	 *                  ...assign into position i of arr the value stored
	 *                     in the node at position i of this list-set.
	 *                Return arr.
	 */
	public Object[] toArray()
	{
		Object [] arr = new Object [mySize];
		for(int i = 0 ; i < mySize; i++)
		{
			arr[i] = getNode(i);
		}
		return arr;
	}


	/** precondition: dest is a properly initialized of some typed, T.
	 * postcondition: If dest.length is greater than the size of this
	 *                list-set, copies all of the elements of this
	 *                list-set into dest, assigns null to the first
	 *                index position beyond the last element copied,
	 *                and then returns dest. Otherwise, returns a new
	 *                array of T of the appropriate length containing
	 *                all of the elements of this list-set.
	 */
	public <T> T[] toArray(T[] dest)
	{
		Object[] src = this.toArray();

		if (dest.length < this.size())
		{
			return (T[])(Arrays.copyOf(src, this.size(), dest.getClass()));
		}
		else
		{
			System.arraycopy(src, 0, dest, 0, this.size());
		   	if (dest.length > this.size()) { dest[this.size()] = null; }
		   	return dest;
		}
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: Returns a new ListSetIterator for this list-set.
	 *     algorithm: Return a new ListSetIterator (see private inner class).
	 */
	public Iterator<E> iterator()
	{
		return new ListSetIterator();
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: Returns a new ListSetIterator for this list-set.
	 *     algorithm: Return a new ListSetIterator (see private inner class).
	 */
	public ListIterator<E> listIterator()
	{
		return new ListSetIterator();
	}


	/** precondition: This list-set contains 0 or more elements.
	 * postcondition: Returns a new ListSetIterator for this list-set
	 *                that is initialized to start at index position i.
	 *                If i is not a valid index position
	 *                (i.e., i < 0 or i >= this.size()), an
	 *                IndexOutOfBoundsException will be thrown.
	 *     algorithm: If i is less than 0 or i is greater than or equal
	 *                  too the size of this list-set...
	 *                  ...throw a new IndexOutOfBoundsException.
	 *                Declare an ListIterator<E> object called iter and
	 *                  assign to it a new ListSetIterator (see private
	 *                  inner class).
	 *                While i is greater than or equal to 0...
	 *                  ...use next() to increment iter to the next
	 *                     element in this list-set.
	 *                  ...decrement the value of i.
	 *                Return the iter iterator.
	 */
	public ListIterator<E> listIterator(int i)
	{
		if(i < 0 || i >= mySize)
			throw new IndexOutOfBoundsException();
		ListIterator<E> iter = new ListSetIterator();
		while(i >= 0)
		{
			iter.next();
			i--;
		}
		return iter;
	}


	/** Private, inner class representing an object that can iterate
	 *  over the elements of a ListSet.
	 */
	private class ListSetIterator implements ListIterator<E>
	{
		// FIELDS
		//---------------------------------------------------------------
		private int myLatestIndex;	// Index position of the last element
									// referenced by this iterator

		private boolean myEditableState;	// true if set() or remove()
		                                    // may be invoked, otherwise
		                                    // false if they cannot


		// CONSTRUCTORS
		//---------------------------------------------------------------
		/** postcondition: Initializes a ListSetIterator for this
		 *                 list-set such that the first invocation of
		 *                 next() will return the element at index
		 *                 position 0 of this list-set.
		 *      algorithm: Initialize myLatestIndex to a value of -1.
		 *                 Initialize myEditableState to false.
		 */
		public ListSetIterator()
		{
			myLatestIndex = -1;
			myEditableState = false;
		}


		// METHODS
		//---------------------------------------------------------------
		/** precondition: 0 <= i < this.size()
		 * postcondition: Sets the value of myLatestIndex such that the
		 *                next element to be returned by an invocation of
		 *                next() will be at index position i.
		 *     algorithm: Assign myLatestIndex with the value of i-1.
		 */
		private void setLatestIndex(int i)
		{
			myLatestIndex = i-1;
		}


		/** precondition: This list-set contains 0 or more elements.
		 * postcondition: Returns true if this list iterator has more
		 *                elements when traversing the list in the
		 *                forward direction.
		 *     algorithm: Return the result of comparing to see if
		 *                  myLatestIndex is less than the size of the
		 *                  parent list-set - 1.
		 *
		 */
		public boolean hasNext()
		{
			return myLatestIndex < parent.size()-1;
		}


		/** precondition: This list-set contains 0 or more elements.
		 * postcondition: Returns true if this list iterator has more
		 *                elements when traversing the list in the
		 *                backward direction.
		 *     algorithm: Return the result of comparing to see if
		 *                  myLatestIndex is greater than 0.
		 */
		public boolean hasPrevious()
		{
			return myLatestIndex > 0;
		}


		/** precondition: This list-set contains 0 or more elements.
		 * postcondition: Returns the index of the element that would be
		 *                returned by a subsequent call to next().
		 *     algorithm: Return the value of myLatestIndex + 1.
		 */
		public int nextIndex()
		{
			return myLatestIndex+1;
		}


		/** precondition: This list-set contains 0 or more elements.
		 * postcondition: Returns the index of the element that would be
		 *                returned by a subsequent call to previous().
		 *     algorithm: Return the value of myLatestIndex - 1.
		 */
		public int previousIndex()
		{
			return myLatestIndex-1;
		}


		/** precondition: This list-set contains 0 or more elements.
		 * postcondition: Returns the next element in this list-set or
		 *                throws a NoSuchElementException if there is no
		 *                next element.
		 *     algorithm: If myLatestIndex is equal to the size of this
		 *                  list-set - 1...
		 *                  ...throw a new NoSuchElementException.
		 *                Increment the value of myLatestIndex.
		 *                Declare a ListNode<E> variable called n.
		 *                Assign to n the node at position myLatestIndex
		 *                  of the parent list-set.
		 *                Assign to myEditableState the value of true.
		 *                Return the value stored in node n.
		 */
		public E next()
		{
			if(myLatestIndex == parent.size()-1)
			{
				throw new NoSuchElementException();
			}
			myLatestIndex++;
			ListNode<E> n = getNode(myLatestIndex);
			myEditableState = true;
			return n.getValue();
			
		}


		/** precondition: This list-set contains 0 or more elements.
		 * postcondition: Returns the previous element in this list-set or
		 *                throws a NoSuchElementException if there is no
		 *                previous element.
		 *     algorithm: If myLatestIndex is equal to 0...
		 *                  ...throw a new NoSuchElementException.
		 *                Decrement the value of myLatestIndex.
		 *                Declare a ListNode<E> variable called n.
		 *                Assign to n the node at position myLatestIndex
		 *                  of the parent list-set.
		 *                Assign to myEditableState the value of true.
		 *                Return the value stored in node n.
		 */
		public E previous()
		{
			if(myLatestIndex == 0)
			{
				throw new NoSuchElementException();
			}
			myLatestIndex --;
			ListNode<E> n = getNode(myLatestIndex);
			myEditableState = true;
			return n.getValue();
		}


		/** precondition: This list-set contains 0 or more elements.
		 * postcondition: Removes from this list-set the last element
		 *                returned by either the next() or previous()
		 *                methods. Throws an IllegalStateException if neither
		 *                next() nor previous() have been called, or remove()
		 *                or add() have been called after the last call to
		 *                next() or previous().
		 *     algorithm: If myEditableState is false...
		 *                  ...throw a new IllegalStateException.
		 *                Remove the element from position myLatestIndex
		 *                  of the parent list-set.
		 *                Assign to myEditableState the value of false.
		 */
		public void remove()
		{
			if(!myEditableState)
				throw new IllegalStateException();
			parent.remove(myLatestIndex);
			myEditableState = false;
		}


		/** precondition: This list-set may or may not already contain x.
		 *                Object x may be null.
		 * postcondition: If this list-set does not already contain x, x will be
		 *                inserted at the position of the element that will be
		 *                returned by the next invocation of next() and the size
		 *                will increase by 1.  If this list-set already contains
		 *                x, the list-set will remain unchanged.
		 *     algorithm: If this list-set does not contain x...
		 *                  ...add x into the parent list-set at position
		 *                       myLatestIndex + 1.
		 *                Assign to myEditableState the value of false.
		 */
		public void add(E x)
		{
			if(!(parent.contains(x)))
				parent.add(myLatestIndex+1,x);
			myEditableState = false;
		}

		/** precondition: This list-set contains 0 or more elements.  This
		 *                list-set may or may not already contain x.  Object
		 *                x may be null.
		 * postcondition: If this list-set already contains object x, throws
		 *                an IllegalArgumentException.  If this list-set does
		 *                not already contain object x, replaces the last
		 *                element by an invocation of next() or previous()
		 *                with object x. Throws an IllegalStateException if
		 *                neither next() nor previous() have been called, or
		 *                remove() or add() have been called after the last
		 *                call to next() or previous().
		 *     algorithm: If myEditableState is false...
		 *                  ...throw a new IllegalStateException.
		 *                If this list-set does not contain x...
		 *                  ...declare a ListNode<E> variable called n.
		 *                  ...assign to n the node at position myLatestIndex
		 *                       of the parent list-set.
		 *                  ...set the value stored in node n to x.
		 */
		public void set(E x)
		{
			if(!myEditableState)
				throw new IllegalStateException();
			if(!(parent.contains(x)))
			{
				ListNode<E> n = getNode(myLatestIndex);
				n.setValue(x);
			}
		}
	}

}