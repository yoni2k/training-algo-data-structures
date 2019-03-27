package YK_OOP.YK_Garage;

public class YK_SmallCar extends YK_AbstractCar {

    enum YK_CAR_MAKE {VOLVO, MAZDA, TOYOTA}

    YK_CAR_MAKE make;

    public YK_SmallCar(int licensePlate, YK_CAR_MAKE make, int year, YK_COLOR color) {
        super(licensePlate, year, color);
        this.make = make;
    }

    public YK_SmallCar(int licensePlate, YK_CAR_MAKE make, int year, YK_COLOR color, String company) {
        super(licensePlate, year, color, company);
        this.make = make;
    }

    @Override
    public String toString() {
        return "Car " + make + ", " + super.abstractCarToString();
    }

    @Override
    public boolean equals(Object obj) {
        return ((super.abstractCarEquals(obj)) && (obj.getClass() == this.getClass() && (this.make == ((YK_SmallCar)obj).make)));
    }

    @Override
    public String getMake() {
        return make.toString();
    }

    @Override
    public YK_ParkingSpace.YK_SIZE sizeRequired() {
        return YK_ParkingSpace.YK_SIZE.SMALL;
    }
}
