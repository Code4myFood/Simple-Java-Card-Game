/**
 *  Colors that can be used
 */
public enum Suit {
	/**
     * spades suit
     */
	SPADES("Spade"),
	/**
     * heart suit
     */
	HEARTS("Heart"),
	/**
     * club suit
     */
	CLUBS("Club"),
	/**
     * club suit
     */
	DIAMONDS("Diamond");
	
	private String suit;
	
	/**
	 * @param suit of the cards
	 */

	Suit(String suit){
		this.suit = suit;
	}
	
	/**
	 * @return the string of the suit
	 */
	
	public String getSuit() {
		return suit;
	}
	
}
