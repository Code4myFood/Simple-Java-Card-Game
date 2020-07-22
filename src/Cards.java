public class Cards{
	private Suit suit;
	private Value number;
	
	/**
	 * Constructor for the Cards class
	 * @param suit of the card
	 * @param number of the number 
	 */
	public Cards(Suit suit, Value number) {
		this.suit = suit;
		this.number = number;
	}
	/**
	 * @return the string suit
	 * @see Suit#getSuit()
	 */
	public String getSuit() {
		return suit.getSuit();
	}
	
	/**
	 * 
	 * @return the card value
	 * @see Value#getNumber()
	 */
	public int getNumber() {
		return number.getNumber();
	}
}