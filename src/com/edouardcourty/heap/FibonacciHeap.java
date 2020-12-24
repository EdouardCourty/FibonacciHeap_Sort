package com.edouardcourty.heap;

import java.util.ArrayList;
import java.util.List;

public class FibonacciHeap {

    private final List<Node> nodes;
    private Node minNode;

    public static class Node {
        private final int value;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public FibonacciHeap() {
        this.nodes = new ArrayList<>();
        this.minNode = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        this.nodes.add(newNode);
        if (this.minNode == null || this.minNode.value > value) {
            this.minNode = newNode;
        }
    }

    public Node deleteMinNode() {
        for (Node node : this.nodes) {
            if (node.value == this.minNode.value) {
                this.nodes.remove(node);
                this.minNode = findMinNode(this.nodes);
                return node;
            }
        }
        return null;
    }

    private Node findMinNode(List<Node> nodeList) {
        int minimalValue = 0;
        for (Node node : nodeList) {
            if (nodeList.indexOf(node) == 0) {
                minimalValue = node.value;
            }
            minimalValue = Math.min(minimalValue, node.value);
        }
        for (Node node : nodeList) {
            if (node.value == minimalValue) {
                return node;
            }
        }
        return null;
    }

    public static List<Integer> sort(List<Integer> numbers) {
        FibonacciHeap heap = new FibonacciHeap();
        List<Integer> sorted = new ArrayList<>();
        for (int number: numbers) {
            heap.insert(number);
        }
        while (sorted.size() != numbers.size()) {
            sorted.add(heap.deleteMinNode().getValue());
        }
        return sorted;
    }
}
