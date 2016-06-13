public class ListNode<E>
{
	// FIELDS
	// ------------------------------------------------------------------
	private E value;
	private ListNode<E> next;
	private ListNode<E> prev;

	// CONSTRUCTORS
	// ------------------------------------------------------------------
	public ListNode(E initValue, ListNode<E> initNext, ListNode<E> initPrev)
	{
		value = initValue;
		next = initNext;
		prev = initPrev;
	}

	// METHODS
	// ------------------------------------------------------------------
	public E getValue() { return value; }
	public void setValue(E theNewValue) { value = theNewValue; }

	public ListNode<E> getNext() { return next; }
	public ListNode<E> getPrev() { return prev; }

	public void setNext(ListNode<E> theNewNext) { next = theNewNext; }
	public void setPrev(ListNode<E> theNewPrev) { prev = theNewPrev; }

	public String toString() { return "[" + value + "]"; }

}
