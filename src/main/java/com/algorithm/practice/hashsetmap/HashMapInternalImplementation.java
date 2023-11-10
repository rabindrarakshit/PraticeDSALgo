package com.algorithm.practice.hashsetmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapInternalImplementation {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int bi = key.hashCode();
            return Math.abs(bi) % N;
        }

        // Time Complexity : O(lambda)
        public void put(K key, V value) {
            int bi = hashFunction(key); // bucket_index
            int di = searchInLL(key, bi); // data_index
            if (di == -1) {
                // key does not exist
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                // key exists
                Node data = buckets[bi].get(di);
                data.value = value;
            }
            double lambda = (double) n / N;
            if (lambda > 2.0) {
                //rehashing
                rehash();
            }
        }

        private void rehash() {
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N * 2];
            for (int i = 0; i < N * 2; i++) {
                buckets[i] = new LinkedList<>();
            }

            for (int i = 0; i < oldBucket.length; i++) {
                LinkedList<Node> ll = oldBucket[i];
                for (int j = 0; j < ll.size(); i++) {
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }
            }
            return -1;
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return null;
            } else {
                n--;
                return buckets[bi].remove(di).value;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di == -1) {
                return null;
            } else {
                return buckets[bi].get(di).value;
            }
        }

        public ArrayList<K> keySet(){
            ArrayList<K> list = new ArrayList<>();
            for(LinkedList<Node> ll: buckets){
                for(int i=0;i<ll.size();i++){
                    list.add(ll.get(i).key);
                }
            }
            return list;
        }

        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        Map<String, String> map1 = new java.util.HashMap<>();
        map.put("India", 100);
    }
}
