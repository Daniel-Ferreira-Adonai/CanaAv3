package Problem4;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("preTreino", 1, 220));
        items.add(new Item("Creatina", 1, 140));
        items.add(new Item("whey", 2, 190));
        items.add(new Item("halter", 5, 35));
        Backpack backpack = new Backpack(5);
        int n = 4;
        int[][] dp = new int[n + 1][backpack.backpackLimit + 1];

        for (int i = 1; i <= n; i++) {
            Item item = items.get(i - 1);
            for (int j = 0; j <= backpack.backpackLimit; j++) {
                if (item.weight > j) {
                    dp[i][j] = dp[i - 1][j]; // não cabe
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - item.weight] + item.price);
                }
            }
        }
        System.out.println("Valor máximo que pode ser carregado: R$" + dp[n][backpack.backpackLimit]);

        int w = backpack.backpackLimit;
        System.out.println("Itens escolhidos:");
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                Item item = items.get(i - 1);
                System.out.println("- " + item.name + " (peso: " + item.weight + ", valor: R$" + item.price + ")");
                w -= item.weight;
            }
        }
    }
    }

