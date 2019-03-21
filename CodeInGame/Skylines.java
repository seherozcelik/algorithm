package CodeInGame;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Skylines {

    private TreeSet<Block> bSet         = new TreeSet<Block>();
    private HashSet<Block> addBlocks    = new HashSet<Block>();
    private HashSet<Block> removeBlocks = new HashSet<Skylines.Block>();

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Skylines sol = new Skylines();
        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            int x1 = in.nextInt();
            int x2 = in.nextInt();
            Block b = sol.new Block(h, x1, x2);
            sol.bSet.add(b);
        }

        while (sol.addBlocks.size() > 0) {
            HashSet<Block> cloneRemoveSet = (HashSet<Block>) sol.removeBlocks.clone();
            sol.removeBlocks.removeAll(sol.removeBlocks);
            for (Block block : cloneRemoveSet) {
                sol.bSet.remove(block);
            }

            HashSet<Block> cloneAddSet = (HashSet<Block>) sol.addBlocks.clone();
            sol.addBlocks.removeAll(sol.addBlocks);
            for (Block block : cloneAddSet) {
                sol.bSet.add(block);
            }
        }

        int linecount = 2;
        int rightWall = sol.bSet.first().x2;
        if (sol.bSet.pollFirst() == null) {
            linecount++;
        } else {
            for (Block block : sol.bSet) {
                if (block.x1 == rightWall) {
                    linecount = linecount + 2;
                } else {
                    linecount = linecount + 4;
                }
                rightWall = block.x2;
            }
            linecount++;
        }
        System.out.println(linecount);
    }

    public class Block implements Comparable<Block> {
        private int h;
        private int x1;
        private int x2;

        public void setH(int h) {
            this.h = h;
        }

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public void setX2(int x2) {
            this.x2 = x2;
        }

        private Block(int h, int x1, int x2) {
            this.h = h;
            this.x1 = x1;
            this.x2 = x2;
        }

        @Override
        public int compareTo(Block o) {
            if (x2 < o.x1 || (x2 == o.x1 && h != o.h)) {
                return -1;
            } else if (o.x2 < x1 || (o.x2 == x1 && h != o.h)) {
                return 1;
            } else if (x2 == o.x1 && h == o.h) {
                removeBlocks.add(o);
                Block nO = new Block(o.h, x1, o.x2);
                addBlocks.add(nO);
                return 0;
            } else if (o.x2 == x1 && h == o.h) {
                removeBlocks.add(o);
                Block nO = new Block(o.h, o.x1, x2);
                addBlocks.add(nO);
                return 0;
            } else if (x1 == o.x1 && x2 == o.x2 && h == o.h) {
                return 0;
            } else if (x1 <= o.x1 && x2 >= o.x2 && h >= o.h) {
                removeBlocks.add(o);
                Block nO = new Block(h, x1, x2);
                addBlocks.add(nO);
                return 0;
            } else if (x1 < o.x1 && x2 > o.x2 && h < o.h) {
                Block nO = new Block(h, o.x2, x2);
                addBlocks.add(nO);
                setX2(o.x1);
                return -1;
            } else if (x1 == o.x1 && x2 > o.x2 && h < o.h) {
                setX1(o.x2);
                return 1;
            } else if (x1 < o.x1 && x2 == o.x2 && h < o.h) {
                setX2(o.x1);
                return -1;
            } else if (x1 <= o.x1 && x2 < o.x2 && h == o.h) {
                removeBlocks.add(o);
                Block nO = new Block(o.h, x1, o.x2);
                addBlocks.add(nO);
                return 0;
            } else if (x1 <= o.x1 && x2 < o.x2 && h > o.h) {
                removeBlocks.add(o);
                Block nO = new Block(o.h, x2, o.x2);
                addBlocks.add(nO);
                return -1;
            } else if (x1 < o.x1 && x2 <= o.x2 && h < o.h) {
                setX2(o.x1);
                return -1;
            } else if (x1 >= o.x1 && x2 > o.x2 && h < o.h) {
                setX1(o.x2);
                return 1;
            } else if (x1 > o.x1 && x2 >= o.x2 && h > o.h) {
                removeBlocks.add(o);
                Block nO = new Block(o.h, o.x1, x1);
                addBlocks.add(nO);
                return 1;
            } else if (x1 >= o.x1 && x2 >= o.x2 && h == o.h) {
                removeBlocks.add(o);
                Block nO = new Block(o.h, o.x1, x2);
                addBlocks.add(nO);
                return 0;
            } else if (x1 >= o.x1 && x2 <= o.x2 && h <= o.h) {
                return 0;
            } else if (x1 > o.x1 && x2 < o.x2 && h > o.h) {
                Block nO = new Block(o.h, x2, o.x2);
                addBlocks.add(nO);
                removeBlocks.add(o);
                Block nO2 = new Block(o.h, o.x1, x1);
                addBlocks.add(nO2);
                return 1;
            }
            return 0;
        }

    }
}
