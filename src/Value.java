public enum Value {
	/**
     * value of the cards
     * the value of jack, queen, king is assigned by 0, 100, 1000 respectively because it can help to identify
     * the special cards and in rule2 it is using the remainder of the value sum of cards by dividing by 10.
     * 
     *  @see CheckResult#playerWinTheGame(java.util.ArrayList, java.util.ArrayList) 
     */
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(0), QUEEN(100), KING(1000);
	
	private int number;
	
	/**
	 * @param the value of the card
	 */
	Value(int number){
		this.number = number;
	}
	/**
	 * 
	 * @return the value of the card
	 */
	public int getNumber() {
		return number;
	}

}
