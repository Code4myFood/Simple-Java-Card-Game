import java.util.ArrayList;

public class CheckResult{
	/**
	 * To judge the player or the dealer win the bet
	 * If the hand that player and dealer get is still remaining draw after rule1 and rule2, then 
	 * assign the dealer as the winner of the game
	 * 
	 * @param the cards that player in hand
	 * @param the cards that dealer in hand
	 * @see	CheckResult #rule1(ArrayList, ArrayList)
	 * @see CheckResult #rule2(ArrayList, ArrayList)
	 * @return true if the player win the game, otherwise return false
	 */
	static boolean playerWinTheGame(ArrayList<Cards> Player, ArrayList<Cards> Dealer){
		//1 player win, 2 player lose, 3 draw
		if(rule1(Player, Dealer) == 1){
			return true;
		}else if(rule1(Player, Dealer) == 2){
			return false;
		}else{
			if(rule2(Player, Dealer) == 1){
				return true;
			}else if(rule2(Player, Dealer) == 2){
				return false;
			}
			else{
				return false;
			}				
		}	
	}
	
	/**
	 * To check the cards in player's hand and dealer's hand. Then judge who has more special cards(Jack, Queen, King)
	 * 
	 * @param the cards that player in hand
	 * @param the cards that dealer in hand
	 * @return 1 if the player win the game, 2 if the player lose, 3 if draw
	 */
	
	static int rule1(ArrayList<Cards> Player, ArrayList<Cards> Dealer){
		int player = 0;
		int dealer = 0;
		for(int i = 0; i < 3; i++){
			if (Player.get(i).getNumber() == 0|| Player.get(i).getNumber() == 100 || Player.get(i).getNumber() == 1000){
				player++;
			}
			if (Dealer.get(i).getNumber() == 0|| Dealer.get(i).getNumber() == 100 || Dealer.get(i).getNumber() == 1000){
				dealer++;
			}
		}
		if ( player > dealer){
			return 1;
		}else if( player < dealer){
			return 2;
		}else{
			return 3;
		}
	}
	
	/**
	 * To check the cards in player's hand and dealer's hand. To check the sum of the cards then dividing by 10.
	 * If the player get a larger remainder then the player will win the game, otherwise lose.
	 * JACK, QUEEN, KING have assigned as multiple of ten, so the remainder will not be affected
	 * 
	 * @param the cards that player in hand
	 * @param the cards that dealer in hand
	 * @return 1 if the player win the game, 2 if the player lose, 3 if draw
	 */
	static int rule2(ArrayList<Cards> Player, ArrayList<Cards> Dealer){
		int player = 0;
		int dealer = 0;
		for(int i = 0; i < 3; i++){
			player += Player.get(i).getNumber();
			dealer += Dealer.get(i).getNumber();
		}
		if ( player % 10 > dealer % 10){
			return 1;
		}else if( player % 10 < dealer % 10){
			return 2;
		}else{
			return 3;
		}		
	}
}