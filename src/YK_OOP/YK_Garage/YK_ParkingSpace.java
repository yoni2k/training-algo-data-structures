package YK_OOP.YK_Garage;

import YK_Common.YK_Exception;

public class YK_ParkingSpace {

    enum YK_SIZE {LARGE, SMALL}

    YK_SIZE size;
    YK_AbstractCar car;
    String company;

    public YK_ParkingSpace(YK_SIZE size) {
        this.size = size;
        String company = null;
        YK_AbstractCar car = null;
    }

    public YK_ParkingSpace(YK_SIZE size, String company) {
        this.size = size;
        this.company = company;
        YK_AbstractCar car = null;
    }

    public void addCompany(String company) {
        if(this.company != null) {
            throw new YK_Exception("Can't set company: " + company + ", already has company: " + this.company);
        }
        this.company = company;
    }

    public void overrideCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public boolean isEmpty() {
        return (car == null);
    }

    public YK_AbstractCar getCar() {
        return car;
    }

    public YK_SIZE getSize() {
        return size;
    }

    public boolean canPark(YK_AbstractCar car) {
        if (this.car != null) {
            return false;
        }
        if (car.sizeRequired() != size) {
            return false;
        }
        if ((company != null) && (car.getCompany() == null)) {
            return false;
        }
        if ((company != null) && (car.getCompany().equals(company) == false)) {
            return false;
        }
        return true;
    }

    public void park(YK_AbstractCar car) {
        if (this.car != null) {
            throw new YK_Exception("Can't park in this space new car: " + car + ", already has: " + this.car);
        }
        if (car.sizeRequired() != size) {
            throw new YK_Exception("Size is not matching, car's: " + car.sizeRequired() + ", this space: " + size);
        }
        if ((company != null) && (car.getCompany() == null)) {
            throw new YK_Exception("Trying to park car that's not assigned to company in space reserved to: " + company);
        }
        if ((company != null) && (car.getCompany().equals(company) == false)) {
            throw new YK_Exception("Trying to park car that's of company: " + car.getCompany() + ", in space reserved to: " + company);
        }

        this.car = car;
    }

    public void makeEmpty() {
        car = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Parking space, size: ");
        sb.append(size);
        sb.append(", ");

        if(company != null) {
            sb.append("reserved to company: ");
            sb.append(company);

        } else {
            sb.append("not reserved");
        }
        sb.append(", ");

        if(car != null) {
            sb.append("Car parked: ");
            sb.append(car);
        } else {
            sb.append("Empty");
        }

        return sb.toString();
    }
}
