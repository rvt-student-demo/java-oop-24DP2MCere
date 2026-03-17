package rvt.Jmooc92;

import java.util.ArrayList;

public class Box implements Packable {
    private int max_element;
    private ArrayList<Packable> items;

    public Box(int max_element) {
        this.max_element = max_element;
        this.items = new ArrayList<>();
    }

    public void add(Packable item) {
        this.items.add(item);

    }
    // weigth = 0
    // for-each pa items
    // +=

    public double weight() {
        double weight = 0;
        for (Packable item : items) {
            item.weight();
            weight += item.weight();
        }

        return weight;
    }

    public String toString() {
        return "Box: " + items.size() + " items " + "total weight: " + this.weight() + "kg";
    }
}
