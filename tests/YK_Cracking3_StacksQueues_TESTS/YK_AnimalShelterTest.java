package YK_Cracking3_StacksQueues_TESTS;

import YK_Cracking3_StacksQueues.YK_AnimalShelter;
import YK_Cracking3_StacksQueues.YK_AnimalShelter.YK_Animal;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_AnimalShelterTest {

    private void P(YK_AnimalShelter shelter) { System.out.println(shelter.toString()); }

    @Test
    void shelter() {

        int i = 1;

        YK_AnimalShelter shelter = new YK_AnimalShelter();

        P(shelter);shelter.enqueue(YK_Animal.dog,i++);//1
        P(shelter);shelter.enqueue(YK_Animal.dog,i++);//2
        P(shelter);shelter.enqueue(YK_Animal.cat,i++);//3
        P(shelter);shelter.enqueue(YK_Animal.cat,i++);//4
        P(shelter);shelter.enqueue(YK_Animal.dog,i++);//5
        P(shelter);shelter.enqueue(YK_Animal.cat,i++);//6

        P(shelter);assertEquals(1, shelter.dequeue());
        P(shelter);assertEquals(2, shelter.dequeueDog());
        P(shelter);assertEquals(3, shelter.dequeueCat());

        P(shelter);shelter.enqueue(YK_Animal.cat,i++);//7
        P(shelter);shelter.enqueue(YK_Animal.dog,i++);//8

        P(shelter);assertEquals(4, shelter.dequeueCat());
        P(shelter);assertEquals(5, shelter.dequeueDog());
        P(shelter);assertEquals(6, shelter.dequeue());

        P(shelter);assertEquals(8, shelter.dequeueDog());
        P(shelter);assertEquals(7, shelter.dequeueCat());
    }
}