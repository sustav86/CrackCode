package com.sustav.chapter2;

import java.util.HashMap;
import java.util.Map;

public class Main2_1 {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insert(1);
        singleLinkedList.insert(5);
        singleLinkedList.insert(50);
        singleLinkedList.insert(1);
        singleLinkedList.insert(289);
        singleLinkedList.insert(50);
        singleLinkedList.insert(500);

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

        singleLinkedList.list();
        singleLinkedList.nthToLast(5);
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

}

class Node {

    int value;
    Node nextNode;

    public Node(int value) {
        this.value = value;
        this.nextNode = null;
    }
}
