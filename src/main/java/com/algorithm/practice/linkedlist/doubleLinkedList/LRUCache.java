package com.algorithm.practice.linkedlist.doubleLinkedList;

import java.util.HashMap;
import java.util.Map;

class Node {
    Node prev, next;
    int key, data;

    public Node(){}
    public Node(int key, int data) {
        this.key = key;
        this.data = data;
    }
}

public class LRUCache {
    Map<Integer, Node> map = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    int capacity;
    LRUCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    int get(int key) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            remove(node);
            insert(node);
            return node.data;
        }
        return -1;
    }

    void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        if(map.size()==capacity){
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    void remove(Node node) {
        map.remove(node.key);
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev=node;
    }

}

class Test{
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.get(2);
        lruCache.put(5,5);
        System.out.println();
    }
}