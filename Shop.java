import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Computer {
    private String name;
    private double price;

    public Computer(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Computer{name='" + name + "', price=" + price + "}";
    }
}

public class Shop {
    private List<Computer> computers = new ArrayList<>();

    // Добавить компьютер
    public void add(Computer c) {
        computers.add(c);
    }

    // Удалить компьютер по имени
    public boolean remove(String name) {
        return computers.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    // Найти компьютер по имени
    public Computer find(String name) {
        for (Computer c : computers) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void printAll() {
        for (Computer c : computers) {
            System.out.println(c);
        }
    }

    // ==== main с интерфейсом ====
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shop shop = new Shop();

        while (true) {
            System.out.println("\n1. Добавить компьютер");
            System.out.println("2. Удалить компьютер");
            System.out.println("3. Найти компьютер");
            System.out.println("4. Показать все");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            int choice = sc.nextInt();
            sc.nextLine();  // съесть \n

            switch (choice) {
                case 1:
                    System.out.print("Название: ");
                    String name = sc.nextLine();
                    System.out.print("Цена: ");
                    double price = sc.nextDouble();
                    sc.nextLine();
                    shop.add(new Computer(name, price));
                    break;
                case 2:
                    System.out.print("Имя для удаления: ");
                    shop.remove(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Имя для поиска: ");
                    Computer found = shop.find(sc.nextLine());
                    System.out.println(found != null ? found : "Не найдено");
                    break;
                case 4:
                    shop.printAll();
                    break;
                case 0:
                    sc.close();
                    return;
            }
        }
    }
}