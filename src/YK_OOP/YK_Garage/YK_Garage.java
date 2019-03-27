package YK_OOP.YK_Garage;

import YK_Common.YK_Exception;

import java.util.ArrayList;

/*
Implementation of a parking garage

Assumptions:
- flat parking lot
- Can park small cars or large cars/trucks
- Companies (up to 2) can reserve small cars slots (specific slots)
- Cars can have year, color, license plate and make information
- Small cars can't park in large places

Didn't take into account (like in the book): levels, rows, more than 1 spot needed for a vehicle.
In the book, garage has only spots, not cars.  Car has a parking space, and parking space has a car.
Not sure it's the best way to implement, but it's probably not worse than what I have.

TODO write tests
 */

//TODO write tests

public class YK_Garage {

    YK_ParkingSpace[] slots;
    ArrayList<YK_AbstractCar> cars;

    public YK_Garage(int numSlotsSmall, int numSlotsBig) {
        privConstructor(numSlotsSmall, numSlotsBig, null, 0, null, 0);
    }

    //companies can reserve only small spots
    public YK_Garage(int numSlotsSmall, int numSlotsBig, String company1, int reserved1) {
        privConstructor(numSlotsSmall, numSlotsBig, company1, reserved1, null, 0);
    }

    public YK_Garage(int numSlotsSmall, int numSlotsBig, String company1, int reserved1, String company2, int reserved2) {
        privConstructor(numSlotsSmall, numSlotsBig, company1, reserved1, company2, reserved2);
    }

    //companies can reserve only small spots, up to 2 companies allowed
    public void privConstructor(int numSlotsSmall, int numSlotsBig, String company1, int reserved1, String company2, int reserved2) {
        if((reserved1 + reserved2) > numSlotsSmall) {
            throw new YK_Exception("Can't reserve " + (reserved1 + reserved2) + ", available: " + numSlotsSmall);
        }

        cars = new ArrayList<>();
        slots = new YK_ParkingSpace[numSlotsSmall + numSlotsBig];
        int toReserve1 = reserved1;
        int toReserve2 = reserved2;

        for(int i = 0; i < numSlotsSmall; i++) {
            if (toReserve1 > 0) {
                slots[i] = new YK_ParkingSpace(YK_ParkingSpace.YK_SIZE.SMALL, company1);
                toReserve1--;
            } else if(toReserve2 > 0) {
                slots[i] = new YK_ParkingSpace(YK_ParkingSpace.YK_SIZE.SMALL, company2);
                toReserve2--;
            } else {
                slots[i] = new YK_ParkingSpace(YK_ParkingSpace.YK_SIZE.SMALL);
            }
        }

        for(int j = numSlotsSmall; j < slots.length; j++) {
            slots[j] = new YK_ParkingSpace(YK_ParkingSpace.YK_SIZE.LARGE);
        }
    }

    private YK_ParkingSpace[] privGetSlots() {
        return slots;
    }

    public YK_ParkingSpace[] getSlots() {
        return privGetSlots();
    }

    public int getNumSlots() {
        return privGetSlots().length;
    }

    private YK_ParkingSpace[] privGetSlots(YK_ParkingSpace.YK_SIZE size, boolean emptyOnly) {
        ArrayList<YK_ParkingSpace> array = new ArrayList<>();

        for(YK_ParkingSpace slot : slots) {
            if((slot.getSize() == size) && (emptyOnly ? slot.isEmpty() : true)) {
                array.add(slot);
            }
        }

        return array.toArray(new YK_ParkingSpace[0]);
    }

    public int getNumSlots(YK_ParkingSpace.YK_SIZE size, boolean emptyOnly) {
        return privGetSlots(size, emptyOnly).length;
    }

    public YK_ParkingSpace[] getSlots(YK_ParkingSpace.YK_SIZE size, boolean emptyOnly) {
        return privGetSlots(size, emptyOnly);
    }

    private YK_ParkingSpace[] privGetSlots(String company, boolean emptyOnly) {
        ArrayList<YK_ParkingSpace> array = new ArrayList<>();

        for(YK_ParkingSpace slot : slots) {
            if((slot.getCompany().equals(company)) && (emptyOnly ? slot.isEmpty() : true)) {
                array.add(slot);
            }
        }

        return array.toArray(new YK_ParkingSpace[0]);
    }

    public int getNumSlots(String company, boolean emptyOnly) {
        return privGetSlots(company, emptyOnly).length;
    }

    public YK_ParkingSpace[] getSlots(String company, boolean emptyOnly) {
        return privGetSlots(company, emptyOnly);
    }

    private YK_ParkingSpace[] privGetReservedSlots(String company, boolean emptyOnly) {
        ArrayList<YK_ParkingSpace> array = new ArrayList<>();

        for(YK_ParkingSpace slot : slots) {
            if((slot.getCompany().equals(company)) && (emptyOnly ? slot.isEmpty() : true)) {
                array.add(slot);
            }
        }

        return array.toArray(new YK_ParkingSpace[0]);
    }

    public int getNumReservedSlots(String company, boolean emptyOnly) {
        return privGetReservedSlots(company, emptyOnly).length;
    }

    public YK_ParkingSpace[] getReservedSlots(String company, boolean emptyOnly) {
        return privGetReservedSlots(company, emptyOnly);
    }

    private YK_ParkingSpace[] privGetReservedSlots(boolean emptyOnly) {
        ArrayList<YK_ParkingSpace> array = new ArrayList<>();

        for(YK_ParkingSpace slot : slots) {
            if((slot.getCompany() != null) && (emptyOnly ? slot.isEmpty() : true)) {
                array.add(slot);
            }
        }

        return array.toArray(new YK_ParkingSpace[0]);
    }

    public int getNumReservedSlots(boolean emptyOnly) {
        return privGetReservedSlots(emptyOnly).length;
    }

    public YK_ParkingSpace[] getReservedSlots(boolean emptyOnly) {
        return privGetReservedSlots(emptyOnly);
    }

    private YK_ParkingSpace[] privGetSlots(boolean empty) {
        ArrayList<YK_ParkingSpace> array = new ArrayList<>();

        for(YK_ParkingSpace slot : slots) {
            if(slot.isEmpty() == empty) {
                array.add(slot);
            }
        }

        return array.toArray(new YK_ParkingSpace[0]);
    }

    public int getNumEmptySlots() {
        return privGetSlots(true).length;
    }

    public YK_ParkingSpace[] getEmptySlots() {
        return privGetSlots(true);
    }

    public int getNumFullSlots() {
        return privGetSlots(false).length;
    }

    public YK_ParkingSpace[] getFullSlots() {
        return privGetSlots(false);
    }

    private YK_AbstractCar[] privGetCars() {
        return cars.toArray(new YK_AbstractCar[0]);
    }

    public YK_AbstractCar[] getCars() {
        return privGetCars();
    }

    public int getNumCars() {
        return privGetCars().length;
    }

    private YK_AbstractCar[] privGetCars(Object ofType) {
        ArrayList<YK_AbstractCar> list = new ArrayList<>();

        for(YK_AbstractCar car : cars) {
            if(car.getClass() == ofType.getClass()) {
                list.add(car);
            }
        }

        return list.toArray(new YK_AbstractCar[0]);
    }

    public YK_AbstractCar[] getCars(Object ofType) {
        return privGetCars(ofType);
    }

    public int getNumCars(Object ofType) {
        return privGetCars(ofType).length;
    }


    private YK_AbstractCar[] privGetCars(String company) {
        ArrayList<YK_AbstractCar> list = new ArrayList<>();

        for(YK_AbstractCar car : cars) {
            if((car.getCompany() != null) && (car.getCompany().equals(company))) {
                list.add(car);
            }
        }

        return list.toArray(new YK_AbstractCar[0]);
    }

    public YK_AbstractCar[] getCars(String company) {
        return privGetCars(company);
    }

    public int getNumCars(String company) {
        return privGetCars(company).length;
    }

    public boolean isParked(YK_AbstractCar isParkedCar) {
        for (YK_AbstractCar singleCar : cars) {
            if (singleCar == isParkedCar) {
                return true;
            }
        }
        return false;
    }

    public boolean isFull() {
        return (privGetSlots(true).length == 0);
    }

    private YK_ParkingSpace getSpace(YK_AbstractCar car) {
        for(YK_ParkingSpace slot : slots) {
            if(slot.canPark(car)) {
                return slot;
            }
        }
        return null;
    }

    public boolean canPark(YK_AbstractCar car) {
        return (getSpace(car) != null);
    }

    public void park(YK_AbstractCar car) {
        YK_ParkingSpace slot = getSpace(car);

        if (slot == null) {
            throw new YK_Exception("No matching space for car: " + car);
        }

        slot.park(car);
        cars.add(car);
    }

    public void leave(YK_AbstractCar car) {
        for(YK_ParkingSpace slot : slots) {
            if((slot.isEmpty() == false) && (slot.getCar().equals(car))) {
                slot.makeEmpty();
                cars.remove(car);
                return;
            }
        }
        throw new YK_Exception("Didn't find car: " + car);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Garage. Statistics: ");

        sb.append("\nNum slots: ");
        sb.append(getNumSlots());
        sb.append(", out of them empty: ");
        sb.append(getNumEmptySlots());

        sb.append("\nNum small slots: ");
        sb.append(getNumSlots(YK_ParkingSpace.YK_SIZE.SMALL, false));
        sb.append(", out of them empty: ");
        sb.append(getNumSlots(YK_ParkingSpace.YK_SIZE.SMALL, true));

        sb.append("\nNum large slots: ");
        sb.append(getNumSlots(YK_ParkingSpace.YK_SIZE.LARGE, false));
        sb.append(", out of them empty: ");
        sb.append(getNumSlots(YK_ParkingSpace.YK_SIZE.LARGE, true));

        sb.append("\nNum reserved slots: ");
        sb.append(getNumReservedSlots(false));
        sb.append(", out of them empty: ");
        sb.append(getNumReservedSlots(false));

        sb.append("\nNum cars: ");
        sb.append(getNumCars());
        sb.append(", out of them small: ");
        sb.append(getNumCars(YK_ParkingSpace.YK_SIZE.SMALL));
        sb.append(", out of them big: ");
        sb.append(getNumCars(YK_ParkingSpace.YK_SIZE.LARGE));

        sb.append("-------------- Spaces with the cars if parked ------------------\n");

        for(YK_ParkingSpace slot : slots) {
            sb.append(slot.toString());
            sb.append('\n');
        }

        return sb.toString();
    }
}
