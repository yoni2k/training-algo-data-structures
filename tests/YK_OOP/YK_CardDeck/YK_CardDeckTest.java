package YK_OOP.YK_CardDeck;

import YK_Common.YK_Exception;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class YK_CardDeckTest {

    @Test
    void defaultDeck() {
        YK_CardDeck deck = new YK_CardDeck();

        assertEquals(54, deck.size());
        System.out.println(deck.toString());
    }

    @Test
    void jokers0() {
        YK_CardDeck deck = new YK_CardDeck(0);

        assertEquals(52, deck.size());
        System.out.println(deck.toString());
    }

    @Test
    void jokers5() {
        YK_CardDeck deck = new YK_CardDeck(5);

        assertEquals(57, deck.size());
        System.out.println(deck.toString());
    }

    @Test
    void jokersInvalid() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> new YK_CardDeck(6));
    }

    @Test
    void smallerDeck() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.THREE, YK_Card.RANK.KING, 2);

        assertEquals(46, deck.size());
        System.out.println(deck.toString());
    }

    @Test
    void smallestDeck() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.KING, YK_Card.RANK.KING, 2);

        assertEquals(6, deck.size());
        System.out.println(deck.toString());
    }

    @Test
    void nonExistentDeck() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.KING, YK_Card.RANK.QUEEN, 2);

        assertEquals(2, deck.size());
        System.out.println(deck.toString());
    }

    @Test
    void removeCards() {
        YK_CardDeck deck = new YK_CardDeck();

        deck.removeCard(new YK_Card(YK_Card.SUIT.values()[0], YK_Card.RANK.values()[0]));
        deck.removeCard(new YK_Card(YK_Card.SUIT.CLUBS, YK_Card.RANK.THREE));
        deck.removeCard(new YK_Joker(YK_Joker.JOKER_TYPE.TWO));

        assertEquals(51, deck.size());
        assertEquals(new YK_Joker(YK_Joker.JOKER_TYPE.ONE), deck.peek());

        System.out.println(deck.toString());
    }

    @Test
    void removeCardsWhenEmptyNonExistent() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.THREE,YK_Card.RANK.TWO, 2);

        assertEquals(2, deck.size());

        //remove card
        deck.removeCard(new YK_Joker(YK_Joker.JOKER_TYPE.TWO));

        //nonexistent
        assertThrows(YK_Exception.class, () -> deck.removeCard(new YK_Joker(YK_Joker.JOKER_TYPE.THREE)));

        //removed
        assertThrows(YK_Exception.class, () -> deck.removeCard(new YK_Joker(YK_Joker.JOKER_TYPE.TWO)));

        //empty
        deck.removeCard(new YK_Joker(YK_Joker.JOKER_TYPE.ONE));
        assertEquals(0, deck.size());

        //nonexistent when empty
        assertThrows(YK_Exception.class, () -> deck.removeCard(new YK_Joker(YK_Joker.JOKER_TYPE.THREE)));

        //removed when empty
        assertThrows(YK_Exception.class, () -> deck.removeCard(new YK_Joker(YK_Joker.JOKER_TYPE.TWO)));
    }

    @Test
    void putFront_test() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.KING, YK_Card.RANK.QUEEN, 2);

        assertEquals(2, deck.size());

        YK_AbstractCard newCard = new YK_Card(YK_Card.SUIT.CLUBS, YK_Card.RANK.KING);

        deck.putFront(newCard);

        assertEquals(newCard, deck.peek());

        System.out.println(deck.toString());
    }

    @Test
    void putFront_empty() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.KING, YK_Card.RANK.QUEEN, 0);

        assertEquals(0, deck.size());

        YK_AbstractCard newCard = new YK_Card(YK_Card.SUIT.CLUBS, YK_Card.RANK.KING);

        deck.putFront(newCard);

        assertEquals(newCard, deck.peek());

        System.out.println(deck.toString());
    }

    @Test
    void putBack_test() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.KING, YK_Card.RANK.QUEEN, 2);

        assertEquals(2, deck.size());

        YK_AbstractCard newCard = new YK_Card(YK_Card.SUIT.CLUBS, YK_Card.RANK.KING);

        deck.putBack(newCard);

        assertEquals(3, deck.size());

        assertEquals(new YK_Joker(YK_Joker.JOKER_TYPE.TWO), deck.draw());
        assertEquals(new YK_Joker(YK_Joker.JOKER_TYPE.ONE), deck.draw());
        assertEquals(newCard, deck.draw());

        assertEquals(0, deck.size());

        System.out.println(deck.toString());
    }

    @Test
    void putBackEmpty_test() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.KING, YK_Card.RANK.QUEEN, 0);

        assertEquals(0, deck.size());

        YK_AbstractCard newCard = new YK_Card(YK_Card.SUIT.CLUBS, YK_Card.RANK.KING);

        deck.putBack(newCard);

        assertEquals(1, deck.size());

        assertEquals(newCard, deck.draw());

        assertEquals(0, deck.size());

        System.out.println(deck.toString());
    }

    @Test
    void draw_empty() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.KING, YK_Card.RANK.QUEEN, 1);

        assertEquals(1, deck.size());

        assertEquals(new YK_Joker(YK_Joker.JOKER_TYPE.ONE), deck.draw());

        assertEquals(0, deck.size());

        assertThrows(EmptyStackException.class, () -> deck.draw());

        System.out.println(deck.toString());
    }

    @Test
    void drawMany() {
        YK_CardDeck deck = new YK_CardDeck(YK_Card.RANK.KING, YK_Card.RANK.QUEEN, 5);

        assertEquals(5, deck.size());

        YK_AbstractCard[] exp1 = {new YK_Joker(YK_Joker.JOKER_TYPE.FIVE)};
        assertArrayEquals(exp1, deck.draw(1));

        assertEquals(4, deck.size());

        YK_AbstractCard[] exp2 = {  new YK_Joker(YK_Joker.JOKER_TYPE.FOUR),
                                    new YK_Joker(YK_Joker.JOKER_TYPE.THREE)};
        assertArrayEquals(exp2, deck.draw(2));

        assertEquals(2, deck.size());

        YK_AbstractCard[] exp3 = {  new YK_Joker(YK_Joker.JOKER_TYPE.TWO),
                                    new YK_Joker(YK_Joker.JOKER_TYPE.ONE)};
        assertArrayEquals(exp3, deck.draw(2));

        assertThrows(EmptyStackException.class, () -> deck.draw(1));

        System.out.println(deck.toString());
    }

    @Test
    void orders() {
        YK_CardDeck deck = new YK_CardDeck(0);

        assertEquals(52, deck.size());

        assertEquals(new YK_Card(YK_Card.SUIT.SPADES, YK_Card.RANK.ACE), deck.peek());

        deck.shuffle();

        assertEquals(52, deck.size());
        assertNotEquals(new YK_Card(YK_Card.SUIT.SPADES, YK_Card.RANK.ACE), deck.peek());

        System.out.println("Shuffled: ");
        System.out.println(deck.toString());

        deck.organizeBySuit();
        assertEquals(52, deck.size());
        System.out.println("Organized by suit: ");
        System.out.println(deck.toString());

        YK_AbstractCard[] exp1 = {  new YK_Card(YK_Card.SUIT.SPADES, YK_Card.RANK.ACE),
                                    new YK_Card(YK_Card.SUIT.SPADES, YK_Card.RANK.KING)};
        assertArrayEquals(exp1, deck.draw(2));

        deck.organizeByRank();
        assertEquals(50, deck.size());
        System.out.println("Organized by rank: ");
        System.out.println(deck.toString());

        YK_AbstractCard[] exp2 = {  new YK_Card(YK_Card.SUIT.HEARTS, YK_Card.RANK.ACE),
                                    new YK_Card(YK_Card.SUIT.DIAMONDS, YK_Card.RANK.ACE)};
        assertArrayEquals(exp2, deck.draw(2));
    }
}