package YK_OOP.YK_CardDeck;

import YK_Common.YK_Exception;

import java.util.Random;
import java.util.Stack;

public class YK_CardDeck {

    enum ORDER_TYPE {ORDER_SHUFFLED, ORDER_RANK, ORDER_SUIT }

    private Stack<YK_AbstractCard> cards;
    private ORDER_TYPE order_type;

    private void buildDeck(YK_Card.RANK smallestRank, YK_Card.RANK largestRank, int numJokers) {
        cards = new Stack<>();

        for(YK_Card.SUIT suit : YK_Card.SUIT.values()) {
            for (YK_Card.RANK rank : YK_Card.RANK.values()) {
                if ((rank.compareTo(smallestRank)) < 0 || (rank.compareTo(largestRank) > 0)) {
                    continue;
                }
                cards.push(new YK_Card(suit, rank));
            }
        }

        for (int i = 0; i < numJokers; i++) {
            cards.push(new YK_Joker(YK_Joker.JOKER_TYPE.values()[i]));
        }

        order_type = ORDER_TYPE.ORDER_SUIT;
    }

    public YK_CardDeck() {
        buildDeck(YK_Card.RANK.TWO, YK_Card.RANK.ACE, 2);
    }

    public YK_CardDeck(int numJokers) {
        buildDeck(YK_Card.RANK.TWO, YK_Card.RANK.ACE, numJokers);
    }

    public YK_CardDeck(YK_Card.RANK smallestRank, YK_Card.RANK largestRank, int numJokers) {
        buildDeck(smallestRank, largestRank, numJokers);
    }

    public void removeCard(YK_AbstractCard card) {
        if (cards.contains(card) == false) {
            throw new YK_Exception("Card doesn't exist: " + card);
        }

        cards.remove(card);
    }

    public void putFront(YK_AbstractCard card) {
        cards.push(card);
    }

    public void putBack(YK_AbstractCard card) {
        cards.add(0, card);
    }

    public YK_AbstractCard draw() {
        return cards.pop();
    }

    public YK_AbstractCard[] draw(int num) {
        YK_AbstractCard[] res = new YK_AbstractCard[num];

        for(int i = 0 ; i < num ; i++) {
            res[i] = cards.pop();
        }

        return res;
    }

    public YK_AbstractCard peek() {
        return cards.peek();
    }

    public void shuffle() {
        Stack<YK_AbstractCard> newStack = new Stack<>();
        Random rand = new Random();
        YK_AbstractCard card;

        int oldStackSize = cards.size();
        while(oldStackSize > 0) {
            card = cards.remove(rand.nextInt(oldStackSize));
            newStack.push(card);
            oldStackSize = cards.size();
        }

        cards = newStack;
    }

    public void organizeByRank() {
        Stack<YK_AbstractCard> newStack = new Stack<>();

        for (YK_Card.RANK rank : YK_Card.RANK.values()) {
            for(YK_Card.SUIT suit : YK_Card.SUIT.values()) {
                organizeCard(newStack, new YK_Card(suit, rank));
            }
        }

        organizeJokers(newStack);

        cards = newStack;
    }

    public void organizeBySuit() {
        Stack<YK_AbstractCard> newStack = new Stack<>();

        for(YK_Card.SUIT suit : YK_Card.SUIT.values()) {
            for (YK_Card.RANK rank : YK_Card.RANK.values()) {
                organizeCard(newStack, new YK_Card(suit, rank));
            }
        }

        organizeJokers(newStack);

        cards = newStack;
    }

    private void organizeCard(Stack<YK_AbstractCard> newStack, YK_AbstractCard card) {
        if (cards.contains(card)) {
            cards.remove(card);
            newStack.push(card);
        }
    }

    private void organizeJokers(Stack<YK_AbstractCard> newStack) {
        for (YK_Joker.JOKER_TYPE type : YK_Joker.JOKER_TYPE.values()) {
            YK_Joker card = new YK_Joker(type);
            if (cards.contains(card)) {
                cards.remove(card);
                newStack.push(card);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Deck of cards with ");
        sb.append(cards.size());
        sb.append(" cards: \n");

        for(YK_AbstractCard card : cards) {
            sb.append(card);
            sb.append("\n");
        }

        return sb.toString();
    }

    public int size() {
        return cards.size();
    }
}
