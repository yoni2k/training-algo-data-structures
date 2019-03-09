import java.util.Arrays;

@SuppressWarnings({"ALL", "WeakerAccess"})
public class YK_IntArrayList {

    private final int init_size = 10;
    private int[] array;
    private int used_size = 0;

    public YK_IntArrayList() {
        array = new int[init_size];
    }

    public YK_IntArrayList(int initial_capacity) throws YK_Exception {
        if (initial_capacity < 0)
            throw new YK_Exception("Negative");

        System.out.println("New YK_IntArrayList created with capacity " + initial_capacity);

        array = new int[initial_capacity];
    }

    public void add(int new_int) {

        System.out.println("Adding member " + new_int + " at implicit index " + used_size);

        if(used_size == array.length) {
            enlarge();
        }

        array[used_size++] = new_int;
    }

    public void add(int index, int new_int) {

        checkIndex(index, true);

        System.out.println("Adding member " + new_int + " at explicit index " + index);

        if (index == used_size) {
            add(new_int);
            return;
        }

        int new_size = array.length;

        if(used_size == array.length) {
            new_size *= 2;
        }

        int[] temp_array = array;
        array = new int[new_size];

        System.out.println("In Adding member, old size: " + temp_array.length + ", new size: " + new_size + ", old used_size: " + used_size);

        int i_old = 0, i_new = 0;

        for (; i_old < used_size; i_old++, i_new++) {
            if (i_new == index) {
                array[i_new] = new_int;
                i_old--; //will be incremented for no reason
            }
            else {
                array[i_new] = temp_array[i_old];
            }
        }

        used_size++;

    }

    public int size() {
        System.out.println("In size(), size: " + used_size);
        return used_size;
    }

    public String toString() {

        System.out.println("In toString(), size: " + used_size);

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < used_size; i++) {
            str.append(array[i]);
            str.append(' ');
        }

        return str.toString();
    }

    private void enlarge() {
        System.out.println("Enlarging capacity by 2");
        changeSize(array.length * 2);
    }

    private void changeSize(int new_size) {

        System.out.println("Enlarging capacity from " + array.length + " to: " + new_size + ", used_size: " + used_size);

        /*
        int[] temp_array = array;
        array = new int[new_size];

        for (int i = 0; i < used_size; i++) {
            array[i] = temp_array[i];
        }*/

        array = Arrays.copyOf(array, new_size);
    }


    public void clear() {
        System.out.println("Clearing array of size: " + used_size);

        for(int i = 0; i < used_size; i++) {
            array[i] = 0;
        }

        used_size = 0;
    }

    public boolean contains(int int_to_find) {

        System.out.println("In contains() looking for " + int_to_find);

        for(int i = 0; i < used_size; i++) {
            if (array[i] == int_to_find) {
                System.out.println("Found " + int_to_find + " at index " + i);
                return true;
            }
        }
        System.out.println("In contains() didn't find" + int_to_find);
        return false;
    }

    public int getCapacity() {
        System.out.println("In getCapacity(), capacity: " + array.length);
        return array.length;
    }

    public void ensureCapacity(int minCapacity) {
        System.out.println("In ensureCapacity(), minCapacity: " + minCapacity + ", current capacity: " + array.length);

        if (minCapacity > array.length) {
            changeSize(minCapacity);
        }
    }

    public int get(int index) {
        checkIndex(index, false);

        System.out.println("In get(), returning value: " + array[index] + ", from index: " + index);

        return array[index];
    }

    public void remove(int index) {

        checkIndex(index, false);

        System.out.println("In remove(), removing value: " + array[index] + ", from index: " + index + ", used_size before removal: " + used_size);

        int[] temp_array = array;
        array = new int[temp_array.length];

        int i_old = 0, i_new = 0;

        for (; i_old < used_size; i_old++, i_new++) {
            if (i_old == index) {
                i_new--;//will be incremented for no reason
            }
            else {
                array[i_new] = temp_array[i_old];
            }
        }

        used_size--;
    }

    private void checkIndex(int index, boolean bFollowingIndexOK) throws YK_Exception {
        if (index < 0)
            throw new YK_Exception("Negative");

        //noinspection PointlessBooleanExpression
        if  (   (index > used_size) ||
                ( (index == used_size) && (bFollowingIndexOK == false))
            )
            throw new YK_Exception("Invalid");
    }

    public void set(int index, int newValue) {

        checkIndex(index, false);

        System.out.println("Setting value: " + newValue + ", instead of: " + array[index] + ", index: " + index);

        array[index] = newValue;
    }

    public void trimToSize() {

        System.out.println("In trimToSize(), used_size: " + used_size + ", current capacity: " + array.length);

        if(used_size < init_size)
        {
            if(array.length > init_size)
                changeSize(init_size);
            return;
        }

        changeSize(used_size);
    }
}
