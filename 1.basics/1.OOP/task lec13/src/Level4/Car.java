package Level4;

import java.util.Objects;

public class Car {
    private int plateNumber;
    private String color;

    public Car(int plateNumber, String color) {
        this.plateNumber = plateNumber;
        this.color = color;
    }

    public int getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(int plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return plateNumber == car.plateNumber && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, color);
    }
}
