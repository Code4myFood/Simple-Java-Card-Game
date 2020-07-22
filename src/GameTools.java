
import java.util.ArrayList;
import java.util.Random;

public class GameTools {
	/**
	 * Inserting 52 cards into the desk 
	 * 
	 * @param an empty ArrayList that for storing cards
	 * @see Cards#Cards(Suit, Value)
	 */
	
	static void createDesk(ArrayList<Cards> desk) {
		for(Suit cardSuit : Suit.values()) {
			for(Value cardValue : Value.values()) {
				desk.add(new Cards(cardSuit, cardValue));
			}
		}		
	}

	/**
	 * Creating a temporal desk to store the cards then assign the desk to the temporal desk
	 * 
	 * @param the change the order of cards inside the desk
	 * @return a ordered changed desk
	 */
	static ArrayList<Cards> shuffle(ArrayList<Cards> desk) {
		ArrayList<Cards> temp = new ArrayList<Cards>();
		Random random = new Random();
		int randomCardIndex = 0;
		for(int i = 0; i < 52; i++) {
			//Picking a cards from the original card slot to new card slot
			randomCardIndex = random.nextInt(desk.size());
			temp.add(desk.get(randomCardIndex));
			desk.remove(randomCardIndex);
		}
		return temp;
	}
	/**
	 * Giving player three cards for the game from the top of the desk
	 * 
	 * @param desk that for the game after shuffling 
	 * @param an ArrayList of player hand
	 */
	static void givePlayerCards(ArrayList<Cards> desk, ArrayList<Cards> player) {
		for(int i = 0; i < 3; i++) {
			player.add(desk.get(0));
			desk.remove(0);
		}
	}
	
	/**
	 * Giving dealer three cards for the game from the top of the desk
	 * 
	 * @param desk that for the game after shuffling
	 * @param an ArrayList of dealer hand
	 */
	static void giveDealerCards(ArrayList<Cards> desk, ArrayList<Cards> dealer) {
		for(int i = 0; i < 3; i++) {
			dealer.add(desk.get(0));
			desk.remove(0);
		}
	}
	/**
	 * Let the player change his cards in hand, the cards that will draw from the top of the desk
	 * 
	 * @param the desk that for the game after shuffling
	 * @param cards in player hand
	 * @param which cards need to make changes 
	 */
	static void playerDrawCard(ArrayList<Cards> desk, ArrayList<Cards> player, int index){
		player.set(index, desk.get(0));
		desk.remove(0);
	}

}
