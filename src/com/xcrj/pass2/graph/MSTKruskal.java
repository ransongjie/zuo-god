package com.xcrj.pass2.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class MSTKruskal {
    public static void main(String[] args) {
        int[][] inss = {
                { 1, 2, 6 },
                { 1, 3, 1 },
                { 1, 4, 5 },
                { 2, 3, 5 },
                { 3, 4, 5 },
                { 2, 5, 3 },
                { 3, 5, 6 },
                { 3, 6, 4 },
                { 5, 6, 6 },
                { 4, 6, 2 },
                { 3, 4, 5 },
                { 2, 1, 6 },
                { 3, 1, 1 },
                { 4, 1, 5 },
                { 3, 2, 5 },
                { 4, 3, 5 },
                { 5, 2, 3 },
                { 5, 3, 6 },
                { 6, 3, 4 },
                { 6, 5, 6 },
                { 6, 4, 2 },
                { 4, 3, 5 },
        };

        Graph g = Convert.toGraph(inss);
        Set<Edge> set = kruskal(g);
        for (Edge e : set) {
            System.out.println(e.from.val + ", " + e.to.val + ", " + e.weight);
        }
    }

    static class MySet {
        Map<Node, List<Node>> nodeList;

        public MySet() {
            this.nodeList = new HashMap<>();
        }

        public boolean isSameSet(Node a, Node b) {
            return nodeList.get(a) == nodeList.get(b);
        }

        public void union(Node a, Node b) {
            if (isSameSet(a, b))
                return;
            List<Node> aList = nodeList.get(a);
            List<Node> bList = nodeList.get(b);
            for (Node node : aList) {
                bList.add(node);
                nodeList.put(node, bList);
            }
        }
    }

    public static Set<Edge> kruskal(Graph g) {
        Set<Edge> set=new HashSet<>();

        MySet mySet = new MySet();
        for (Node n : g.nodes.values()) {
            List<Node> list = new ArrayList<>();
            list.add(n);
            mySet.nodeList.put(n, list);
        }

        PriorityQueue<Edge> pque=new PriorityQueue<>((e1,e2)->e1.weight-e2.weight);
        for (Edge e : g.edges) {
            pque.offer(e);
        }

        while(!pque.isEmpty()){
            Edge e=pque.poll();
            Node a = e.from;
            Node b = e.to;
            if (mySet.isSameSet(a, b))continue;
            set.add(e);
            mySet.union(a, b);
        }

        return set;
    }
}
