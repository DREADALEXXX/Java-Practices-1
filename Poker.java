import java.util.Random;
import java.util.Scanner;

public class Poker {
    public static void main(String[] args) {
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8",
                "9", "10", "J", "Q", "K", "A"};

        // Создаём колоду 52 карты
        String[] deck = new String[52];
        int k = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[k++] = rank + suit;
            }
        }

        // Перетасовка (Fisher-Yates)
        Random rnd = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = rnd.nextInt(i + 1);
            String tmp = deck[i];
            deck[i] = deck[j];
            deck[j] = tmp;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Сколько игроков? ");
        int n = sc.nextInt();

        if (n * 5 > 52) {
            System.out.println("Слишком много игроков (макс. 10)");
            return;
        }

        int card = 0;
        for (int p = 1; p <= n; p++) {
            System.out.println("Игрок " + p + ":");
            for (int c = 0; c < 5; c++) {
                System.out.print(deck[card++] + " ");
            }
            System.out.println("\n");  // пустая строка между игроками
        }

        sc.close();
    }
}