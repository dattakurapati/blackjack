//(c) A+ Computer Science
//www.apluscompsci.com

import java.util.*;
import java.util.Scanner;

public class Player
{
   private ArrayList<Card> hand;
   private int winCount;
   private static Scanner keyword;

   public Player ()
   {
      hand = new ArrayList<Card>();
      winCount = 0;
   }

   public Player (int score)
   {
      winCount = score;
   }

   public void addCardToHand(Card temp)
   {
      hand.add(temp);
   }

   public void resetHand( )
   {
      hand.clear();
   }

   public  void setWinCount( int numwins )
   {
      winCount = numwins;
   }

   public void addWinCount(int win) {
      winCount += win;
   }

   public int getWinCount() { return winCount; }

   public int getHandSize() { return hand.size(); }

   public int getHandValue()
   {
      int value = 0;
      for(int x = 0; x < hand.size(); x++) {
         value += hand.get(x).getValue();
      }
      return value;
   }

   public boolean hit( )
   {
      if(getHandValue() < 21) {
         return true;
      } else {
         System.out.println("Busted");
         return false;
      }
   }

   public boolean didBust() {
      if(getHandValue() > 21) {
         return true;
      } else {
         return false;
      }
   }

   public String toString()
   {
      return "hand = " + hand + " - " + getHandValue();
   }
}