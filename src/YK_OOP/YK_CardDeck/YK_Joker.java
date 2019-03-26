package YK_OOP.YK_CardDeck;

public class YK_Joker extends YK_AbstractCard {
    enum JOKER_TYPE {ONE, TWO, THREE, FOUR, FIVE}

    private JOKER_TYPE type;

    public YK_Joker(JOKER_TYPE type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Joker - type: " + type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        YK_Joker gotCard = (YK_Joker)obj;
        return (this.type == gotCard.type);
    }
}
