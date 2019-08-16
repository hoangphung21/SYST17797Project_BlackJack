/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author phung
 */
public class Deck {
    
    // create variablies
    
    private ArrayList<Card> cards;
    
    //contructor
    public Deck(){
        this.cards = new ArrayList<Card>();
    }
    
    public void createDeck(){
        //generating cards
        for(Suit cardSuit: Suit.values()){
            for(Value cardValue: Value.values()){
                //add new card to the deck
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }
    
    //shuffling the deck
    public void shuffle(){
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCard = 0;
        int cardSize = this.cards.size();
        for(int i = 0; i < cardSize; i++){
            randomCard = random.nextInt(this.cards.size());
            tempDeck.add(this.cards.get(randomCard));
            
            // then remove all the deck
            
            this.cards.remove(randomCard);
        }
        this.cards = tempDeck;
        
        
    }
    
    // remove the used cards from the deck
    public void removeCard(int i){
        this.cards.remove(i);
    }
    
    public Card getCard(int i){
        return this.cards.get(i);
    }
    
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }
    
    //Drawing cards from deck
    public void draw(Deck fromDeck){
        this.cards.add(fromDeck.getCard(0));
        fromDeck.removeCard(0);
    }
    
    
    public int deckSize(){
        return this.cards.size();
    }
    
    //put the cards back to the deck
    public void moveCardstoDeck(Deck moveCards){
        int thisDeckSize = this.cards.size();
        for(int i = 0; i < thisDeckSize; i++){
            moveCards.addCard(this.getCard(i));
        }
        
        for(int i =0; i < thisDeckSize; i++){
            this.removeCard(0);
        }
    }
    
    //calculate all cards value
    public int cardsValue(){
        int totalValue = 0;
        int aces = 0;
        
        for (Card _card: this.cards){
            switch(_card.getValue()){
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE: totalValue += 9; break;
                case TEN: totalValue += 10; break;
                case JACK: totalValue += 10; break;
                case QUEEN: totalValue += 10; break;
                case KING: totalValue += 10; break;
                case ACE: totalValue += 1; break;
                
            }
        }
        
        for(int i = 0; i < aces; i++){
            if(totalValue > 10){
                totalValue += 1;
            }
            else{
                totalValue +=11;
            }
        }
        
        return totalValue;
    }
    
    //print out all the cards by String
    public String toString(){
        String cardOutPut = " ";
        
        for(Card _card : this.cards)
        {
            cardOutPut += "\n" + _card.toString();
            
        }
        return cardOutPut;
    }
    
    
}
