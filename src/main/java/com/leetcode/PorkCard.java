package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PorkCard {
    public enum Suit {
        Club,
        Spade,
        Heart,
        Diamond
    }

    public interface ICard {
        Suit getSuit();
        int getNumber();
    }

    public static class Card implements ICard {
        private Suit Suit;
        private int Number;

        public Card(Suit suit, int number) {
            this.Suit = suit;
            this.Number = number;
        }

        public Suit getSuit() {
            return this.Suit;
        }

        public int getNumber() {
            return this.Number;
        }
    }

    public static class CardDeck {
        public List<Card> cards;
        public CardDeck cardDeck;

        public CardDeck() {
            cards = new ArrayList<>();
            var suits = Suit.values();
            for (Suit suit : suits) {
                for (int i = 1; i <= 13; i++)
                    cards.add(new Card(suit, i));
            }
        }

        public void ShuffleCard() {
            Random random = new Random();
            for (int i = 0; i < 52; i++) {
                int j = random.nextInt(cards.size() - 1);
                Card cardAtI = cards.get(i);
                cards.set(i, cards.get(j));
                cards.set(j, cardAtI);
            }
        }

        public Card DrawCard() {
            Card firstCard = cards.get(0);
            cards.remove(0);
            return firstCard;
        }

        public Card DrawCardRandomly() {
            Random random = new Random();
            int i = random.nextInt(cards.size());
            return cards.remove(i);
        }
    }

    public static void main(String[] args) {
        CardDeck cardDeck = new CardDeck();
        // shuffle card deck
        cardDeck.ShuffleCard();

        // draw a card randomly
        Card card1 = cardDeck.DrawCardRandomly();
    }
}