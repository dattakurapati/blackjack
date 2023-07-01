import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack
{
	//add in Dealer instance variable
	private Dealer dealer;
	private static Scanner keyword;

	private static ArrayList<Player> players;

	public BlackJack()
	{
		keyword = new Scanner(System.in);
		players = new ArrayList<Player>();
		dealer = new Dealer();

	}

	public void playGame()
	{
		System.out.println();

		for(Player p : players) {
			p.resetHand();
		}

		dealer.resetHand();
		dealer.shuffle();

		for(Player p : players) {
			p.addCardToHand(dealer.deal());
			p.addCardToHand(dealer.deal());
		}

		dealer.addCardToHand(dealer.deal());
		dealer.addCardToHand(dealer.deal());

		int count = 1;
		
		for(Player p : players) {
			System.out.println();
			System.out.println("PLAYER " + count);
			System.out.println("Hand Value :: " + p.getHandValue());
			System.out.println("Hand Size :: " + p.getHandSize());
			System.out.println("Cards in Hand :: " + p);
			System.out.println("Busted: " + p.didBust());
			count++;
		}

		System.out.println("Dealer");
		System.out.println("Hand Value :: " + dealer.getHandValue());
		System.out.println("Hand Size :: " + dealer.getHandSize());
		System.out.println("Cards in Hand :: " + dealer);
		System.out.println("Busted: " + dealer.didBust());
		System.out.println();

		count = 1;
		for(Player p : players) {
			String save = "";
			if(p.getHandValue() < 21) {
				System.out.println("Does player " + count + " want to hit? [Y/N]");
				save = keyword.next();
				System.out.println();
			}
	
			while(save.equals("Y") || save.equals("y") && p.hit()) {
				p.addCardToHand(dealer.deal());
				System.out.println("Current player " + p);
				System.out.println();
				if(p.getHandValue() < 21) {
					System.out.println("Does player " + count + " want to hit? [Y/N]");
					save = keyword.next();
					System.out.println();
				} else {
					save = "N";
				}
			}
			count++;
		}

		while(dealer.hit()) {
			dealer.addCardToHand(dealer.deal());
		}

		System.out.println();
		System.out.println("Dealer");
		System.out.println("Hand Value :: " + dealer.getHandValue());
		System.out.println("Hand Size :: " + dealer.getHandSize());
		System.out.println("Cards in Hand :: " + dealer);
		System.out.println("Busted: " + dealer.didBust());
		System.out.println();

		System.out.println("Each player's and dealer's cards and hand values:");
		System.out.println();

		count = 1;

		for(Player p : players) {
			System.out.println("PLAYER " + count);
			System.out.println("Hand Value :: " + p.getHandValue());
			System.out.println("Hand Size :: " + p.getHandSize());
			System.out.println("Cards in Hand :: " + p);
			System.out.println("Busted: " + p.didBust());
			System.out.println();
			count++;
		}

		System.out.println("Dealer");
		System.out.println("Hand Value :: " + dealer.getHandValue());
		System.out.println("Hand Size :: " + dealer.getHandSize());
		System.out.println("Cards in Hand :: " + dealer);
		System.out.println("Busted: " + dealer.didBust());
		System.out.println();



		if(dealer.didBust() != true) 
		{
			count = 1;
			for(Player p : players) {
				if(dealer.getHandValue() < p.getHandValue()) {
					p.setWinCount(1);
				} else if (dealer.getHandValue() == p.getHandValue()) {
					System.out.println("The dealer and player " + count + " have tied. Neither win.");
				}
				count++;
			}
		} else if(dealer.didBust() == true) {
		   out.println("Dealer busted!");
		   for(Player p : players) {
			   if(p.didBust() != true) {
				p.setWinCount(1);
			   }
		   }
		}

		System.out.println();

		System.out.println("Dealer has won " + dealer.getWinCount() + ".");
		
		count = 1;
		for(Player p : players) {
			System.out.println("Player " + count + " has won " + p.getWinCount() + ".");
			count++;
		}

	}
	
	public static void main(String[] args)
	{
		BlackJack game = new BlackJack();
		boolean check = true;
		int numPlayers = 0;
		String save = "";
		System.out.println("How many people are playing?");
		numPlayers = keyword.nextInt();
		System.out.println();
		for(int x = 0; x < numPlayers; x++) {
			players.add(new Player());
		}
		while(check) {
			game.playGame();
			System.out.println("Do you want to play again? [Y,y,N,n] :: ");
			save = keyword.next();
			if(save.equals("N") || save.equals("n")) {
				check = false;
			}
		}
	}
}