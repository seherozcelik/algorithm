package CodeInGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Solution2 {
    private TreeSet<Block> bSet         = new TreeSet<Solution2.Block>();
    private HashSet<Block> addBlocks    = new HashSet<Solution2.Block>();
    private HashSet<Block> removeBlocks = new HashSet<Solution2.Block>();
    private HashSet<Block> addBlocksD   = new HashSet<Solution2.Block>();
    JFrame                 frame        = new JFrame();
    JFrame                 frame2       = new JFrame();
    MyDrawP                drawP        = new MyDrawP();
    MyDrawP2               drawP2       = new MyDrawP2();

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Solution2 sol = new Solution2();
        sol.prepareFrames();
        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            int x1 = in.nextInt();
            int x2 = in.nextInt();
            Block b = sol.new Block(h, x1, x2);
            sol.bSet.add(b);
            sol.addBlocksD.add(b);
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

        for (Block b : sol.bSet) {
            System.out.println(b.h + " " + b.x1 + " " + b.x2);
        }
        sol.drawRect();

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

    public void prepareFrames() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(drawP);
        frame.setTitle("ilk");
        frame.setSize(1600, 500);
        frame.setVisible(true);
        frame2.getContentPane().add(drawP2);
        frame2.setTitle("son");
        frame2.setSize(1600, 500);
        frame2.setVisible(true);
    }

    public void drawRect() {
        drawP.repaint();
        drawP2.repaint();
    }

    class MyDrawP extends JPanel {

        private static final long serialVersionUID = -4152917783045991270L;

        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, 1600, 500);
            g.setColor(Color.blue);
            for (Block b : addBlocksD) {
                g.drawRect((b.x1 - 480) / 3, (400 - b.h) / 3, (b.x2 - b.x1) / 3, b.h / 3);
            }

        }
    }

    class MyDrawP2 extends JPanel {

        private static final long serialVersionUID = -4152917783045991270L;

        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, 1600, 500);
            g.setColor(Color.blue);
            for (Block b : bSet) {
                g.drawRect((b.x1 - 480) / 3, (400 - b.h) / 3, (b.x2 - b.x1) / 3, b.h / 3);
            }

        }
    }
}
