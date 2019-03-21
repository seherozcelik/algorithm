package CodeInGame;

import java.util.TreeSet;

public class treeSetDeneme {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        set.add(4);
        
        for (Integer sayi : set) {
            System.out.println(sayi);
        }
    }

}
