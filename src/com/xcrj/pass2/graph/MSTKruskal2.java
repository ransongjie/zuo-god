package com.xcrj.pass2.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class MSTKruskal2 {
    static class UnionFind {
        Map<Node, Node> nodeFather;
        Map<Node, Integer> rootNum;// 根结点所在集合结点数量

        public UnionFind() {
            this.nodeFather = new HashMap<>();
            this.rootNum = new HashMap<>();
        }

        public void initialize(Collection<Node> nodes) {
            for (Node node : nodes) {
                nodeFather.put(node, node);
                rootNum.put(node, 1);
            }
        }

        public boolean isSameSet(Node a, Node b) {
            return findRoot(a) == findRoot(b);
        }

        public void union(Node a, Node b) {
            if (isSameSet(a, b))
                return;
            Node aRoot = findRoot(a);
            Node bRoot = findRoot(b);
            int aRootNum = rootNum.get(aRoot);
            int bRootNum = rootNum.get(bRoot);
            // 少 到 多下
            if (aRootNum <= bRootNum) {
                nodeFather.put(aRoot, bRoot);
                rootNum.put(aRoot, aRootNum + bRootNum);
            } else {
                nodeFather.put(bRoot, aRoot);
                rootNum.put(bRoot, aRootNum + bRootNum);
            }
        }

        private Node findRoot(Node n) {
            Stack<Node> s = new Stack<>();
            s.push(n);
            //找父 找根
            Node father = nodeFather.get(n);
            while (father != n) {
                n = father;
                s.push(n);
                father = findRoot(n);
            }

            // 优化
            while (!s.isEmpty()) {
                nodeFather.put(s.pop(), n);
            }

            return n;
        }
    }

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

    public static Set<Edge> kruskal(Graph g) {
        Set<Edge> set = new HashSet<>();
        UnionFind uf = new UnionFind();
        uf.initialize(g.nodes.values());

        PriorityQueue<Edge> pque = new PriorityQueue<>((e1, e2) -> e1.weight - e2.weight);
        for(Edge e:g.edges){
            pque.offer(e);
        }

        while (!pque.isEmpty()) {
            Edge e = pque.poll();
            Node a = e.from;
            Node b = e.to;
            if (uf.isSameSet(a, b))continue;
            set.add(e);
            uf.union(a, b);
        }
        return set;
    }
}
