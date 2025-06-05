package Problem3;

import java.util.ArrayList;

public class Backpack {

    public ArrayList<Item> itemList = new ArrayList<>();
    public int backpackLimit;
    public int backpackCurrentSpace;

    public Backpack(int backpackLimit) {
        this.backpackLimit = backpackLimit;
        this.backpackCurrentSpace = 0;
    }

    public void addItem(Item item) {
        if (backpackCurrentSpace + item.weight <= backpackLimit) {
            itemList.add(item);
            backpackCurrentSpace += item.weight;

            System.out.println("Escolhido: " + item.name + " (R$" + item.price + ", " + item.weight + "kg)");
        } else {
            System.out.println("Ignorado (excede limite): " + item.name + " (" + item.weight + "kg)");
        }
    }
}
