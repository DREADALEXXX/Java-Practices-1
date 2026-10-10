// Абстрактный класс Транспортное средство
abstract class Vehicle {
    protected String name;
    protected double speed; // км/ч
    protected double costPerKm; // стоимость за км

    public Vehicle(String name, double speed, double costPerKm) {
        this.name = name;
        this.speed = speed;
        this.costPerKm = costPerKm;
    }

    // Абстрактные методы, которые обязаны реализовать наследники
    public abstract double calculateTime(double distance);
    public abstract double calculateCost(double distance, double weight);

    @Override
    public String toString() {
        return name + " (скорость: " + speed + " км/ч, базовая ставка: " + costPerKm + " руб/км)";
    }
}

class Car extends Vehicle {
    public Car() {
        super("Автомобиль", 90, 15);
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public double calculateCost(double distance, double weight) {
        // Автомобиль: базовая ставка * расстояние + надбавка за вес
        return costPerKm * distance + weight * 5;
    }
}

class Airplane extends Vehicle {
    public Airplane() {
        super("Самолет", 800, 100);
    }

    @Override
    public double calculateTime(double distance) {
        // Добавляем 1 час на взлет/посадку
        return distance / speed + 1;
    }

    @Override
    public double calculateCost(double distance, double weight) {
        return costPerKm * distance + weight * 20;
    }
}

class Train extends Vehicle {
    public Train() {
        super("Поезд", 60, 8);
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public double calculateCost(double distance, double weight) {
        return costPerKm * distance + weight * 2;
    }
}

class Ship extends Vehicle {
    public Ship() {
        super("Корабль", 30, 5);
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public double calculateCost(double distance, double weight) {
        return costPerKm * distance + weight * 1;
    }
}

public class TransportTask {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car(),
                new Airplane(),
                new Train(),
                new Ship()
        };

        double distance = 1000; // км
        double weight = 500;    // кг

        System.out.println("--- Расчет перевозки на расстояние " + distance + " км, вес " + weight + " кг ---");
        for (Vehicle v : vehicles) {
            System.out.printf("%s%n", v);
            System.out.printf("  Время в пути: %.2f ч%n", v.calculateTime(distance));
            System.out.printf("  Стоимость: %.2f руб.%n%n", v.calculateCost(distance, weight));
        }
    }
}