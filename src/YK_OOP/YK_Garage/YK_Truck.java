package YK_OOP.YK_Garage;

public class YK_Truck extends YK_AbstractCar {
    enum YK_TRUCK_MAKE {VOLVO, NISSAN}

    YK_TRUCK_MAKE make;

    public YK_Truck(int licensePlate, YK_TRUCK_MAKE make, int year, YK_COLOR color) {
        super(licensePlate, year, color);
        this.make = make;
    }

    public YK_Truck(int licensePlate, YK_TRUCK_MAKE make, int year, YK_COLOR color, String company) {
        super(licensePlate, year, color, company);
        this.make = make;
    }

    @Override
    public String toString() {
        return "Truck " + make + ", " + super.abstractCarToString();
    }

    @Override
    public boolean equals(Object obj) {
        return ((super.abstractCarEquals(obj)) &&
                (obj.getClass() == this.getClass() &&
                        (this.make == ((YK_Truck)obj).make)));
    }

    @Override
    public String getMake() {
        return make.toString();
    }

    @Override
    public YK_ParkingSpace.YK_SIZE sizeRequired() {
        return YK_ParkingSpace.YK_SIZE.LARGE;
    }


}
