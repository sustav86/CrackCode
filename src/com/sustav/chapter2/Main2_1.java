package com.sustav.chapter2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main2_1 {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedListA = new SingleLinkedList();
        singleLinkedListA.insert(1);
        singleLinkedListA.insert(5);
        singleLinkedListA.insert(50);
        singleLinkedListA.insert(1);
        singleLinkedListA.insert(289);
        singleLinkedListA.insert(50);
//        singleLinkedListA.insert(500);

        SingleLinkedList singleLinkedListB = new SingleLinkedList();
        singleLinkedListB.insert(1);
        singleLinkedListB.insert(5);
        singleLinkedListB.insert(50);
        singleLinkedListB.insert(1);
        singleLinkedListB.insert(289);
        singleLinkedListB.insert(50);
        singleLinkedListB.insert(500);

        SingleLinkedList result = new SingleLinkedList();

//        singleLinkedList.list();
//        singleLinkedList.deleteDuplicate();
//        singleLinkedList.list();

//        singleLinkedList.list();
//        singleLinkedList.deleteDuplicateInPlace();
//        singleLinkedList.list();

//        Map<String, String> buffer = new HashMap<>();
//        buffer.put("1", String.valueOf(1));
//        buffer.put("5", String.valueOf(5));
//        buffer.put("50", String.valueOf(50));
//        buffer.put("289", String.valueOf(289));
//        buffer.put("1", String.valueOf(11));

//        singleLinkedListA.list();
//        singleLinkedListA.nthToLast(5);

        SingleLinkedList merge = SingleLinkedList.merge(singleLinkedListA.getHead(), singleLinkedListB.getHead(), 0, result);
        System.out.println(merge);
    }
}

class SingleLinkedList {

    private Node head;

    public void insert(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node currentNode = head;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = new Node(value);
        }
    }

    public void list() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.nextNode;
        }
        System.out.println();
    }

    public void deleteDuplicate() {
        if (head == null) return;
        Map<Integer, Integer> buffer = new HashMap<>();
        Node current = head;
        Node beforeNode = null;

        while (current != null) {
            if (buffer.containsKey(current.value)) {
                beforeNode.nextNode = current.nextNode;
            }else {
                buffer.put(current.value, current.value);
            }
            beforeNode = current;
            current = current.nextNode;
        }
    }

    public void deleteDuplicateInPlace() {
        if (head == null) return;
        Node current = head;
        while (current != null) {
            Node next = current.nextNode;
            Node previous = current;
            while (next != null) {
                if (current.value == next.value) {
                    previous.nextNode = next.nextNode;
                }
                previous = next;
                next = next.nextNode;
            }
            current = current.nextNode;
        }
    }

    public void nthToLast(int n) {

        if (head == null || n < 1) {
            return;
        }
        Node p1 = head;
        Node p2 = head;
        for (int j = 0; j < n - 1; ++j) { // skip n-1 steps ahead
            if (p2 == null) {
                return; // not found since list size < n
            }
            p2 = p2.nextNode;
        }
        while (p2.nextNode != null) {
            p1 = p1.nextNode;
            p2 = p2.nextNode;
        }

        System.out.println(p1.value);

    }

    public static void apply(SingleLinkedList linkedListA, SingleLinkedList linkedListB) {


    }

    public static SingleLinkedList merge(Node linkedListA, Node linkedListB, int carry, SingleLinkedList result) {
        if (linkedListA == null || linkedListB == null) {
            return null;
        }

        int sum = linkedListA.value + linkedListB.value;
        result.insert(sum + carry);

        merge(linkedListA.nextNode, linkedListB.nextNode, sum >= 10 ? 1 : 0, result);

        return result;

    }

    public Node getHead() {
        return head;
    }
}

class Node {

    int value;
    Node nextNode;

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    }

    public int getValue() {
        return value;
    }
}
