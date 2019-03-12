package YK_Cracking3_StacksQueues;

import java.util.Arrays;
import java.util.LinkedList;

/*
Source: Cracking, p.99, Ch. 3, 3.6

Animal Shelter - can get a dog or a cat, can be requested for oldest dog / cat / animal.
*/


public class YK_AnimalShelter {

    LinkedList<Integer> cats;
    LinkedList<Integer> dogs;
    public enum YK_Animal {cat, dog}

    public YK_AnimalShelter() {
        cats = new LinkedList<>();
        dogs = new LinkedList<>();
    }

    public void enqueue(YK_Animal animal, int serialNum) {

        LinkedList<Integer> listToAdd = ((animal == YK_Animal.cat) ? cats : dogs);
        listToAdd.add(serialNum);
    }

    public int dequeueDog() {
        return dogs.remove();
    }

    public int dequeueCat() {
        return cats.remove();
    }

    public int dequeue() {
        if((dogs.size() > 0) && (cats.size() > 0)) {
            int serialNumDog = dogs.element();
            int serialNumCat = cats.element();

            if (serialNumDog < serialNumCat) {
                return dogs.remove();
            }
            else {
                return cats.remove();
            }
        }
        else if (dogs.size() > 0) {
            return dogs.remove();
        }
        else { //(cats.size() > 0)
            return cats.remove();
        }
    }

    public String toString() {
        return "Dogs: " + Arrays.toString(dogs.toArray()) + ", cats: " + Arrays.toString(cats.toArray());
    }
}
