/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author phung
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        //create new Deck
        Deck playingDeck = new Deck();
        playingDeck.createDeck();
        playingDeck.shuffle();
        
        
        //create deck for player and dealer
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();
        boolean endRound = false;
        
        double playerMoney = 100.00;
        
        
        // Game Loop
        while(playerMoney > 0){
            System.out.println("You have" + playerMoney + " , how much you want to bet?");
            double playerBet = sc.nextDouble();
            if(playerBet > playerMoney){
                System.out.println("Cant bet more than you have.");
                break;
            }
            
            //Dealing, player get 2 cards first
            playerDeck.draw(playingDeck);
            playerDeck.draw(playingDeck);
            
            //Dealing, dealer get 2 cards
            
            dealerDeck.draw(playingDeck);
            dealerDeck.draw(playingDeck);
            
            while(true){
                System.out.println("you have ");
                System.out.println(playerDeck.toString());
                System.out.println("Your value: " + playerDeck.cardsValue());
                
                System.out.println("Dealer has: ");
                System.out.println(dealerDeck.toString());
                System.out.println("Dealer value: " + dealerDeck.getCard(0).toString());
                
                //ask player what to do next
                System.out.println("You want to Hit(1) or Stay(2)");
                int answer = sc.nextInt();
                
                if(answer==1){
                    playerDeck.draw(playingDeck);
                    System.out.println("You draw a: "+ playerDeck.getCard(playerDeck.deckSize()-1).toString());
                    
                    
                    if(playerDeck.cardsValue() > 21){
                        System.out.println("Lose. Your value is: "+ playerDeck.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                        
                    }
                }
                
                if(answer == 2 ){
                    break;
                }
            }
            //show dealer hand
            System.out.println("Dealer's cards: " + dealerDeck.toString());
            if(dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound == false){
                System.out.println("You lost to dealer");
                playerMoney -= playerBet;
                endRound = true;
            }
            
            //dealer draws at 16 and stay at 17.
            while((dealerDeck.cardsValue() < 17) && endRound == false){
                dealerDeck.draw(playingDeck);
                System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize() -1 ).toString());
            }
            
            //display total value of dealer
            System.out.println("Dealer's value: " + dealerDeck.cardsValue());
            
            //dealer is lost if the value is greater than 21
            if((dealerDeck.cardsValue() > 21) && endRound == false){
                System.out.println("Dealer lose. You win!!");
                playerMoney += playerBet;
                endRound = true;
            } 
            
            //when player and dealer draw
            if((playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false){
                System.out.println("Push");
                endRound = true;
            }
            
            
            if((playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false){
                System.out.println("You win");
                playerMoney += playerBet;
                endRound = true;
            }
            else if(endRound == false){
                    System.out.println("Your lost the game");
                    playerMoney -= playerBet;
                    endRound = true;
            }
            
            playerDeck.moveCardstoDeck(playingDeck);
            dealerDeck.moveCardstoDeck(playingDeck);
            System.out.println("End of game");
            
            
        }
        
        
        System.out.println("Game over!!");
    }
    
}
