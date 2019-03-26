package YK_OOP.YK_CardDeck;

public class YK_Card extends YK_AbstractCard {

    enum SUIT {CLUBS, DIAMONDS, HEARTS, SPADES}
    enum RANK {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    private SUIT suit;
    private RANK rank;

    public YK_Card(SUIT suit, RANK rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Card - suit: " + suit + ", rank: " + rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        YK_Card gotCard = (YK_Card)obj;
        return ((this.suit == gotCard.suit) && (this.rank == gotCard.rank));
    }
}
