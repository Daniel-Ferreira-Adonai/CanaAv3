package Problem3;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Notebook", 3, 2000));
        items.add(new Item("Livro", 1, 100));
        items.add(new Item("Celular", 1, 1500));
        items.add(new Item("Câmera", 2, 1800));
        items.add(new Item("Fone", 1, 400));

        Collections.sort(items, (x,y) -> {
            Double xValue = x.price / x.weight;
            Double yValue = y.price / y.weight;
            return yValue.compareTo(xValue);
        });
        Backpack backpack = new Backpack(5);
        for (Item item : items) {
            backpack.addItem(item);
        }
        System.out.println("Itens na mochila:");
        for (Item item : backpack.itemList) {
            System.out.println("- " + item.name + " (R$" + item.price + ", " + item.weight + "kg)");
        }

        System.out.println("Peso total: " + backpack.backpackCurrentSpace + "kg");
    }
    }

