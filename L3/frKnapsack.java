import java.util.*;

class Item {
    int weight, profit;
    double ratio;

    Item(int w, int p) {
        weight = w;
        profit = p;
        ratio = (double)p / w;
    }
}

public class FractionalKnapsack {

    public static void main(String[] args) {

        int W = 17;

        Item items[] = {
            new Item(7,49),
            new Item(5,55),
            new Item(2,38),
            new Item(9,27),
            new Item(3,28)
        };

        Arrays.sort(items, (a,b) -> Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;

        for(Item i : items) {
            if(W >= i.weight) {
                W -= i.weight;
                totalProfit += i.profit;
            } else {
                totalProfit += i.ratio * W;
                break;
            }
        }

        System.out.println("Maximum Profit = " + totalProfit);
    }
}