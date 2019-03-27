package YK_OOP.YK_Garage;

public abstract class YK_AbstractCar {

    enum YK_COLOR {YK_COLOR_BLUE, YK_COLOR_RED, YK_COLOR_BLACK}

    String company;
    int year;
    YK_COLOR color;
    int licensePlate;

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);

    public abstract String getMake();

    public abstract YK_ParkingSpace.YK_SIZE sizeRequired();

    public YK_AbstractCar(int licensePlate, int year, YK_COLOR color) {
        this.licensePlate = licensePlate;
        this.year = year;
        this.color = color;
        company = null;
    }

    public YK_AbstractCar(int licensePlate, int year, YK_COLOR color, String company) {
        this.licensePlate = licensePlate;
        this.year = year;
        this.color = color;
        this.company = company;
    }

    public String abstractCarToString() {
        StringBuilder sb = new StringBuilder();

        sb.append("License plate: ");
        sb.append(licensePlate);
        sb.append(", year: ");
        sb.append(year);
        sb.append(", color: ");
        sb.append(color);

        return sb.toString();
    }

    public String getCompany() {
        return company;
    }

    public int getLicensePlate() {
        return licensePlate;
    }

    public int getYear() {
        return year;
    }

    public YK_COLOR getColor() {
        return color;
    }

    public boolean abstractCarEquals(Object obj) {
        if(obj.getClass().equals(this.getClass())) {
            YK_AbstractCar car = (YK_AbstractCar)obj;

            if((this.company == null) && (car.company != null)) {
                return false;
            }
            if((this.company != null) && (car.company == null)) {
                return false;
            }
            if((this.company != null) && (this.company.equals(car.company) == false)) {
                return false;
            }
            if(this.year != car.year) {
                return false;
            }
            if (this.color != car.color) {
                return false;
            }
            if (this.licensePlate != car.licensePlate) {
                return false;
            }
            return true;
        }
        return false;
    }
}
