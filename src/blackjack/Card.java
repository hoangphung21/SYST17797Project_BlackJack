/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author phung
 */
public class Card {
    private Suit suit;
    private Value value;
    
    
    // constructors
    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
        
    }
    
    public Value getValue(){
        return this.value;
    }
    
    public String toString(){
        return this.suit.toString() + " " + this.value.toString();
    }
}
