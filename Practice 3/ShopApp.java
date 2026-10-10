import java.util.Scanner;

class CurrencyConverter {
    // Курсы валют к рублю
    private static final double USD_RATE = 95.0;
    private static final double EUR_RATE = 102.0;

    // Универсальный метод: конвертирует сумму из одной валюты в другую
    public static double convert(double amount, String fromCurrency, String toCurrency) {
        // Шаг 1: Приводим сумму к рублям (базовая валюта)
        double amountInRubles;
        switch (fromCurrency.toUpperCase()) {
            case "USD": amountInRubles = amount * USD_RATE; break;
            case "EUR": amountInRubles = amount * EUR_RATE; break;
            case "RUB": amountInRubles = amount; break;
            default:
                System.out.println("Неизвестная валюта: " + fromCurrency);
                return amount;
        }

        // Шаг 2: Конвертируем из рублей в целевую валюту
        switch (toCurrency.toUpperCase()) {
            case "USD": return amountInRubles / USD_RATE;
            case "EUR": return amountInRubles / EUR_RATE;
            case "RUB": return amountInRubles;
            default:
                System.out.println("Неизвестная валюта: " + toCurrency);
                return amountInRubles;
        }
    }
}

public class ShopApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Добро пожаловать в интернет-магазин! ---");

        // Цена товара в долларах (базовая валюта магазина)
        double productPriceUSD = 100.0;
        System.out.println("Цена товара: " + productPriceUSD + " USD");

        // Пользователь выбирает валюту для оплаты
        System.out.println("Выберите валюту для оплаты (RUB, USD, EUR):");
        String currency = scanner.nextLine();

        // Расчет стоимости: конвертируем из USD в выбранную валюту
        double finalPrice = CurrencyConverter.convert(productPriceUSD, "USD", currency);

        // Вывод результата
        System.out.printf("Стоимость покупки в валюте %s: %.2f%n", currency.toUpperCase(), finalPrice);

        scanner.close();
    }
}