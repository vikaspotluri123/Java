	


/**
 * This class encapsulates the basic behaviors and characteristics of a
 * standard deck of playing cards.
 */
public class Deck
{
	// FIELDS
	// ------------------------------------------------------------------
	private Card[] myCards;	// the array of the Card objects in this deck





	// CONSTRUCTORS
	// ----------------------------------------------------------------

	/**
	 * Creates a standard deck of 56 playing cards.
	 *
	 *  precondition: none
	 * postcondition: myCards is initialized to hold each of the 56 unique
	 *                cards in a standard deck of playing cards (i.e. 4
	 *                suits per deck, 14 values per suit, including Jokers).
	 *                Note:
	 *                     CardSuit.SUITS    <-- Array of all card suits
	 *                     CardValue.VALUES  <-- Array of all card values
	 */
	public Deck()
	{
		int i = 0;
		myCards = new Card[56];

		for (CardSuit s : CardSuit.SUITS)
		{
			for (CardValue v : CardValue.VALUES)
			{
				myCards[i] = new Card(v, s);	// instantiates the next Card
				i++;
			}
		}
	}


	/**
	 * Creates a custom deck from a specified set of pre-existing playing
	 * cards.
	 *
	 * @param c       The array of cards to be included in this Deck
	 *
	 *  precondition: c is an initialized array of 0 or more non-null
	 *                Card objects.
	 * postcondition: This Deck contains the same elements in the same
	 *                order as are stored in c.
	 */
	public Deck(Card[] c)
	{
		myCards = new Card[c.length];

		for (int i = 0; i < c.length; i++)
		{
			myCards[i] = c[i];		// copies each Card from c into myCards
		}
	}
	



	// ACCESSOR METHODS
	// ------------------------------------------------------------------
	/**
	 * Returns the number of cards currently in the deck.
	 *
	 * @return        The size of the deck.
	 *
	 *  precondition: This Deck contains 0 or more non-null Card objects.
	 * postcondition: Returns the number of cards currently in this Deck
	 *     algorithm: Return the length of the myCards array.
	 */
	public int size()
	{
		return myCards.length;
	}


	/**
	 * Reports whether or not the deck is currently empty.
	 *
	 * @return        <code>true</code> if there are no cards in the
	 *                deck and <code>false</code> if there is at least
	 *                one card in the deck.
	 *
	 *  precondition: This Deck contains 0 or more non-null Card objects.
	 * postcondition: Returns a boolean value indicating whether this
	 *                Deck is empty or not.
	 *     algorithm: Return the result of testing if this.size() == 0.
	 */
	public boolean isEmpty()
	{
		if (size() == 0)
			return true;
		return false;
	}


	/**
	 * Returns a String representing the contents of this deck of cards.
	 *
	 * @return        The card's value as a String.
	 *
	 *  precondition: This Deck contains 0 or more non-null Card objects.
	 * postcondition: Returns a String representing the contents of this
	 *                deck of cards
	 *     algorithm: Declare a String variable called s and initialize
	 *                  it to the empty string (i.e., "").
	 *                For each Card object, x, in this Deck... <-- HINT: "Enhanced" for() loop
	 *                  ...assign to s the result of concatenating x onto
	 *                       the end of s.
	 *                  ...assign to s the result of concatenating a space
	 *                       onto the end of s.
	 *                Return s.
	 */
	public String toString()
	{
		String s = "";
		for (Card x : myCards)
			s = s + x + " ";
		return s;	
	}


	/**
	 * Returns the specified Card object.
	 *
	 * @param n       The index position of the Card to be accessed.
	 * @return        The Card object at index position n.
	 *
	 *  precondition: 0 <= n < this.size()
	 * postcondition: Returns the Nth Card in this Deck
	 *     algorithm: Return the Card object at index position n in
	 *                  the myCards array.
	 */
	public Card getCard(int n)
	{
		return myCards[n];	// TODO: Implement this method correctly. DONE
	}


	/**
	 * Returns an array of the specified range of Card objects remaining in
	 * the deck (this does not include those cards that have already been
	 * dealt/removed from the deck).
	 *
	 * @param first   The index position of the first card to be returned.
	 * @param last    The index position of the last card to be returned.
	 * @return        The specified array of the cards in the deck.
	 *
	 *  precondition: 0 <= first <= last < this.size()
	 * postcondition: Returns an array containing the cards in this Deck
	 *                from index positions first through last in the
	 *                same order.
	 *     algorithm: Declare an array of Card objects called subsetOfCards
	 *                  and initialize it to hold (last - first + 1) Card
	 *                  objects.
	 *                For each index position, i, from first through (and
	 *                  including) last...
	 *                  ...get the Card at index position i of this Deck
	 *                       and copy it into index position (i - first) of
	 *                       subsetOfCards.
	 *                Return the subsetOfCards array.
	 */
	public Card[] getCards(int first, int last)
	{
		Card [] subset = new Card[last-first+1];
		for (int i = first ; i <= last ; i++)
			subset[i-first] = myCards[i];		// Can also do subset[i-first] = getCard[i]
		return subset;
	}


	/**
	 * Returns an array of all Card objects remaining in the deck (this
	 * does not include those cards that have already been dealt from the
	 * deck).
	 *
	 * @return        An array of the remaining cards in the deck.
	 *
	 *  precondition: This Deck contains 0 or more Card objects.
	 * postcondition: Returns an array containing all of the cards in
	 *                this Deck in the same order.
	 *     algorithm: Return the result of invoking the previous getCards()
	 *                  method starting with index position 0 and ending
	 *                  with index position this.size() - 1.
	 */
	public Card[] getCards()
	{
		return getCards(0, this.size()-1);
	}


	/**
	 * Indicates whether some other object is "equal to" this one (i.e.,
	 * both Deck objects contain the exact same sequence of cards in
	 * the same order.
	 *
	 * @param x       The other Deck object to be compared with.
	 * @return        <code>true</code> if both Deck objects contain
	 *                the same sequence of cards in the same order,
	 *                otherwise <code>false</code>.
	 *
	 *  precondition: This Deck contains 0 or more Card objects.
	 * postcondition: Returns true if x is an initialized Deck object
	 *                that contains the same sequence of cards as this
	 *                deck.
	 *     algorithm: If x is null...
	 *                  ...return false.
	 *                If x == this Deck...
	 *                  ...return true.
	 *                If x is not a Deck (i.e. !(x instanceof Deck) )...
	 *                  ...return false.
	 *                Declare a Deck variable called d and initialize
	 *                  it by typecasting x to be of type Deck.
	 *                If d.size() != this.size()...
	 *                  ...return false.
	 *                For each index position i in this Deck...
	 *                  ...if the card at index position i in this Deck
	 *                       does not equal (using the equals() method)
	 *                       the card at index position i in d...
	 *                       ...return false.
	 *                Return true.
	 */
	public boolean equals(Object x)
	{
		if (x == null)
			return false;
			if (x == myCards)
				return true;
			Deck d = (Deck)x;
			if(d.size() != size())
				return false;
			for (int i = 0 ; i<size(); i++)
				if (!(d.getCard(i).equals(myCards[i])))
					return false;
				return true;
	}




	// MODIFIER METHODS
	// ------------------------------------------------------------------
	/**
	 * Removes the "Nth" card from the deck and returns this Card object.
	 * If the deck is currently empty, the method should return null.
	 *
	 * @param n       The index position of the Card to be removed.
	 * @return        The Nth card in the deck.
	 *
	 *  precondition: 0 <= n < this.size()
	 * postcondition: Removes and returns the Card object at index
	 *                position n in this Deck.  Otherwise, returns null.
	 *     algorithm: If this.size() == 0...
	 *                  ...return null.
	 *                Declare an array of Card objects called temp
	 *                  and initialize it with a new array that can hold
	 *                  this.size()-1 Card objects.
	 *                Declare a Card variable called c and
	 *                  assign it the Card object in index position n of
	 *                  this Deck.
	 *                For each index position, i, in this Deck from 0 through n
	 *                  (exclusive)...
	 *                  ...get the Card from index position i in this Deck
	 *                       and copy it into index position i of temp.
	 *                For each index position, i, in this Deck from n+1
	 *                  through this.size() (exclusive)...
	 *                  ...get the Card from index position i in this Deck
	 *                       and copy it into index position i-1 of temp.
	 *                Reassign myCards to be a reference to array temp.
	 *                Return the value of c.
	 */
	private Card removeCard(int n)
	{
		if (this.size() == 0)
			return null;
		Card[] temp = new Card [this.size()-1];
		Card c = getCard(n) ;
		for (int i = 0 ; i<n ; i++)
			temp[i] = getCard(i);
		for (int i = n +1  ; i < size() ; i++)
			temp[i - 1] = getCard(i);
		myCards = temp;
		return c;
		
			
	}



	/**
	 * Removes the "top" card from the deck and returns this Card object.
	 * If the deck is currently empty, the method should return null.
	 *
	 * @return        The top card in the deck.
	 *
	 *  precondition: This Deck contains 0 or more non-null Card objects.
	 * postcondition: If this.size() > 0, removes and returns the first
	 *                Card object this Deck.  Otherwise, returns null.
	 *     algorithm: Return the result of invoking the removeCard()
	 *                method when n is 0.
	 */
	public Card deal()
	{
		if (this.size()  > 0)
		{
			Card c = removeCard(0);
			return c;
			
		}
		else return null;
	}


	/**
	 * Removes the "top" n cards from the deck and returns an array of
	 * these Card objects.
	 *
	 * @param n       The number of cards to be dealt from the deck.
	 * @return        The top n cards in the deck.
	 *
	 *  precondition: This Deck contains 0 or more non-null Card objects.
	 * postcondition: If this.size() > n, removes and returns an array of
	 *                the first n Card object in this Deck.  Otherwise,
	 *                returns null.
	 *     algorithm: If this.size() < n...
	 *                  ...return null.
	 *                Declare an array of Card objects of length n and
	 *                call it dealtCards.
	 *                For each index position i in dealtCards...
	 *                  ...Deal a single card from this Deck and assign
	 *                     the card to index position i of dealtCards.
	 *                Return the value of dealtCards.
	 */
	public Card[] deal(int n)
	{
		if (this.size() < n)
			return null;
		else 
		{
			Card [] dealtCards = new Card[n];
		for (int i = 0 ; i < n; i ++)
			dealtCards[i]=deal();
		return dealtCards;
		}
	}


	/**
	 * Randomly selects and removes a card from the deck and returns this
	 * Card object.
	 *
	 * @return        The randomly selected card in the deck.
	 *
	 *  precondition: This Deck contains 0 or more non-null Card objects.
	 * postcondition: If this.size() > 0, removes and returns a randomly
	 *                selected Card object this Deck.  Otherwise, returns
	 *                null.
	 *     algorithm: Declare and integer called rand and initialize it with
	 *                  a random (but valid) index position from this Deck
	 *                  (i.e., 0 through this.size(), exclusive).
	 *                Return the result of invoking the removeCard()
	 *                method when n is rand.
	 */
	public Card pickACardAnyCard()
	{
		return removeCard((int)(Math.random() * this.size()));
	}



	/**
	 * Inserts a card into the deck at the specified index position.  The
	 * index positions for all subsequent cards already in the deck should
	 * shift down in the array to make room for the new card.  If the
	 * index position is not valid for the current deck (i.e. index < 0 or
	 * index > size()), the card should be added to the "bottom" of the
	 * deck.
	 *
	 * @param n       The index position where the Card object should be
	 *                inserted.
	 * @param c       The Card object being added to the deck.
	 *
	 *  precondition: c is a non-null Card object.  0 <= n <= this.size()
	 * postcondition: Inserts c into this Deck at index position n.  The
	 *                length of myCards will be increased to allow
	 *                for the added card.
	 *     algorithm: If n is less than 0 or n is greater than the size
	 *                  of this Deck...
	 *                  ...Assign to n the size of this Deck.
	 *                Declare an array of Card objects called temp and
	 *                  initialize it with new array that can hold
	 *                  this.size()+1 Card objects.
	 *                For each index position i from 0 through n
	 *                  (exclusive)...
	 *                  ...copy the card from index position i of this Deck
	 *                       into index position i of temp.
	 *                For each index position i from n through this.size()
	 *                  (exclusive)...
	 *                  ...copy the card from index position i of this Deck
	 *                     into index position i+1 of temp.
	 *                Assign c into index position n of temp.
	 *                Reassign myCards to be a reference to array temp.
	 */
		public void insertCard(int n, Card c)
		{
			if ((n < 0) || (n > this.size()))
	            n = this.size();
			Card [] temp = new Card [this.size()+1];
			for (int i = 0; i < n; i++)
	            	temp[i] = myCards[i];
			for (int i = 0; i < this.size(); i++)
	            	temp[i + 1] = myCards[i];
			temp[n] = c;
			myCards = temp ;
		}


	/**
	 * Inserts an array of Card objects into the deck starting at the
	 * specified index position.  The index positions for all subsequent
	 * cards already in the deck should shift down in the array to make
	 * room for the new cards.
	 *
	 * @param n       The index position where the Card objects should
	 *                be inserted.
	 * @param c       The array of Card objects being added to the deck.
	 *
	 *  precondition: c contains 0 or more non-null Card objects.
	 *                0 <= n <= this.size()
	 * postcondition: Appends all of the Card objects in c to the end of
	 *                this Deck.
	 *     algorithm: For each Card object x in array c...
	 *                  ...insert the card at position n
	 *                  ...increment the value of n
	 */
	public void insertCards(int n, Card[] c)
	{
		for (Card x : c)
		{
			insertCard(n,x);
			n ++;
		}
	}


	/**
	 * Adds a card to the "bottom" of the deck.
	 *
	 * @param c       The Card object being added to the deck.
	 *
	 *  precondition: c is a non-null Card object.
	 * postcondition: Appends c to the end of this Deck.
	 *     algorithm: Insert the card at the end of this Deck (i.e., at
	 *                index position this.size().
	 */
	public void addCard(Card c)
	{
		int t = this.size();
		insertCard(t, c);
	}


	/**
	 * Adds an array of Card objects to the "bottom" of the deck.
	 *
	 * @param c       The Card objects being added to the deck.
	 *
	 *  precondition: c contains 0 or more non-null Card objects.
	 * postcondition: Appends all of the Card objects in c to the end of
	 *                this Deck.
	 *     algorithm: For each Card object x in array c...
	 *                  ...insert the card at the end of the Deck (i.e.,
	 *                     at index position this.size().
	 */
	public void addCards(Card[] c)
	{
		for (Card x : c)
			addCard(x);// TODO: Implement this method correctly
	}




	// HELPER METHODS
	// ------------------------------------------------------------------
	/**
	 * Swaps the position of the 2 specified cards in the deck.
	 *
	 * @param i      The index position of the first card to be swapped.
	 * @param j      The index position of the second card to be swapped.
	 *
	 *  precondition: 0 <= i, j < this.size()
	 * postcondition: Exchanges the positions of the Card objects at
	 *                index positions i and j in this Deck.
	 *     algorithm: Declare a temporary Card variable and assign it
	 *                the Card object at index position i of this Deck.
	 *                Copy the Card object in index position j of this
	 *                Deck into index position i of this Deck.
	 *                Copy the value of the temporary variable into
	 *                index position j of this Deck.
	 */
	public void swap(int i, int j)
	{
		Card temp =  getCard(i) ;
		temp  = getCard(j);
	//	j = temp ;
		
		// TODO: Implement this method correctly
	}




	// ADVANCED ACCESSOR/MODIFIER METHODS
	// ------------------------------------------------------------------
	/**
	 * Reports whether or not the deck contains the specified card.
	 *
	 * @return        <code>true</code> if the deck currently contains
	 *                the specified Card object, <code>false</code> if
	 *                it does not.
	 *
	 *  precondition: c != null.  A Card object is considered to be a
	 *                match with another Card object if their equals()
	 *                method returns true.
	 * postcondition: Returns true if c currently exists in this Deck
	 *                and returns false if it does not exist in this Deck.
	 *     algorithm: For each Card object x in the myCards array...
	 *                  ...if x matches c (using the equals() method)...
	 *                       ...return true.
	 *                Return false.
	 */
	public boolean contains(Card c)
	{
		return false;	// TODO: Implement this method correctly
	}


	/**
	 * Reports whether or not the deck contains at least one pair of
	 * matching cards (i.e. same card value and suit).
	 *
	 * @return        <code>true</code> if the deck currently contains
	 *                the a pair of matching card objects,
	 *                <code>false</code> if it does not.
	 *
	 *  precondition: This Deck contains 0 or more non-null Card objects.
	 *                A Card object is considered to be a match with
	 *                another Card object if their equals() method
	 *                returns true.
	 * postcondition: Returns true if this Deck contains at least 1
	 *                matching pair of Card objects.
	 *     algorithm: For each index position i in this Deck...
	 *                  ...For each index position j from 0 through i-1...
	 *                       ...If the Card objects at index positions
	 *                          i and j match...
	 *                            ...return true.
	 *                Return false.
	 */
	public boolean hasDuplicates()
	{
		return false;	// TODO: Implement this method correctly
	}


	/**
	 * Randomly shuffles the contents of the deck.
	 *
	 *  precondition: This Deck contains 0 or more non-null Card objects.
	 * postcondition:
	 *     algorithm: For each index position i in this Deck...
	 *                  ...Declare and initialize a random (but valid)
	 *                     index position n from this Deck (i.e., 0
	 *                     through this.size() - 1, inclusive).
	 *                  ...Swap the Card objects at index positions i
	 *                       and n.
	 */
	public void shuffle()
	{
		// TODO: Implement this method correctly
	}


	/**
	 * Sorts the contents of the deck into ascending order based on the
	 * relative values of each Card object.
	 *
	 *  precondition: This Deck contains 0 or more non-null Card objects.
	 * postcondition: All of the Card objects in this Deck are arranged
	 *                in ascending order based on their relative values.
	 *     algorithm: ???
	 */
	public void sort()
	{
		// TODO: Implement this method correctly
	}





}
