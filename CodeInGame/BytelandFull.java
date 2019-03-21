package CodeInGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class BytelandFull {

    ArrayList<NodeSet>        land        = new ArrayList<BytelandFull.NodeSet>();
    HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
    HashSet<Integer>          rootList    = new HashSet<Integer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] landSizes = new int[n];
        ArrayList<BytelandFull> bls = new ArrayList<BytelandFull>();
        for (int i = 0; i < n; i++) {
            BytelandFull bl = new BytelandFull();
            int m = in.nextInt();
            landSizes[i] = m;
            for (int j = 1; j < m; j++) {
                int root = in.nextInt();
                bl.frequencies.put(j, 0);
                if (bl.rootList.contains(root)) {
                    NodeSet ns = bl.getNode(root);
                    ns.add(j);
                    bl.frequencies.put(root, bl.frequencies.get(root) + 1);
                } else {
                    NodeSet ns = bl.new NodeSet();
                    ns.add(j);
                    ns.root = root;
                    bl.rootList.add(root);
                    bl.land.add(ns);
                    bl.frequencies.put(root, 1);
                }
            }
            bls.add(bl);
        }

        for (BytelandFull byteland : bls) {
            Collections.sort(byteland.land);
            for (int i = 0; i < byteland.land.size(); i++) {
                System.out.println(byteland.land.get(i).root + " - " + byteland.land.get(i));
            }
            System.out.println(byteland.frequencies);
            System.out.println("---");
        }

        HashSet<Integer> unionedOnes = new HashSet<Integer>();
        HashSet<Integer> unionedInTurn = new HashSet<Integer>();
        int s = 0;
        for (BytelandFull byteland : bls) {
            int size = landSizes[s++] - 1;
            Collections.sort(byteland.land);
            HashMap<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
            for (int i = 0; i < byteland.land.size(); i++) {
                frequencies.put(byteland.land.get(i).root, byteland.land.get(i).size());
            }
            int numOfTurn = 0;
            while (unionedOnes.size() < size) {
                numOfTurn++;
                for (int i = 0; i < byteland.land.size(); i++) {
                    if (byteland.land.get(i).size() > 0) {
                        int nextItem = getNextItem(byteland.land.get(i), byteland.frequencies);
                        if (!unionedInTurn.contains(nextItem)) {
                            unionedOnes.add(nextItem);
                            unionedInTurn.add(nextItem);
                            unionedInTurn.add(byteland.land.get(i).root);
                            byteland.land.get(i).remove(nextItem);
                            bind(nextItem, byteland.land, byteland.rootList, byteland.land.get(i).root, byteland.frequencies);
                            byteland.rootList.remove(nextItem);
                        }
                    }
                }
                unionedInTurn.clear();
                System.out.println("tur bitti");
                System.out.println("******");
            }
            unionedOnes.clear();
            System.out.println(numOfTurn);
        }

        for (BytelandFull byteland : bls) {
            Collections.sort(byteland.land);
            for (int i = 0; i < byteland.land.size(); i++) {
                System.out.println(byteland.land.get(i).root + " - " + byteland.land.get(i));
            }
            System.out.println("---");
        }
    }

    private static int getNextItem(NodeSet nodeSet, HashMap<Integer, Integer> frq) {
        int nextItem = nodeSet.iterator().next();

        if (nodeSet.size() > 1)
            for (Integer node : nodeSet) {
                if (frq.get(nextItem) > frq.get(node))
                    nextItem = node;
            }
        return nextItem;
    }

    private static void bind(int nextItem, ArrayList<NodeSet> lnd, HashSet<Integer> roottLst, Integer rt, HashMap<Integer, Integer> frqn) {
        HashSet<Integer> freeItems = new HashSet<Integer>();
        if (roottLst.contains(nextItem)) {
            for (NodeSet node : lnd) {
                if (node.root.equals(nextItem)) {
                    freeItems.addAll(node);
                    node.clear();
                    frqn.put(node.root, 0);
                }
            }
            if (freeItems.size() > 0)
                for (NodeSet node : lnd) {
                    if (node.root.equals(rt)) {
                        node.addAll(freeItems);
                        frqn.put(node.root, node.size());
                    }
                }
            roottLst.remove(nextItem);
        }
        System.out.println("silinen root: " + nextItem);
        if (freeItems.size() > 0) {
            System.out.println("eklenen sayilar: " + freeItems);
            System.out.println("kendisine eklenen: " + rt);
        }
        System.out.println("rootlist: " + roottLst);
        System.out.println("---");
    }

    private class NodeSet extends HashSet<Integer> implements Comparable<NodeSet> {

        private static final long serialVersionUID = -6715546443228329148L;

        Integer                   root;

        @Override
        public int compareTo(NodeSet o) {
            if (this.size() < o.size())
                return 1;
            else if (this.size() > o.size())
                return -1;
            return 0;
        }
    }

    public NodeSet getNode(Integer root) {
        for (NodeSet nodeSet : land) {
            if (root.equals(nodeSet.root))
                return nodeSet;
        }
        return null;
    }

}
