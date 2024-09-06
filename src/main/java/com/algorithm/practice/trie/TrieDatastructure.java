package com.algorithm.practice.trie;

public class TrieDatastructure {

    Node root;

    static class Node{
        Node[] links = new Node[26];
        boolean end;

        void put(char ch, Node node){
            links[ch-'a']=node;
        }

        boolean isEnd(){
            return end;
        }

        void setEnd(){
            end = true;
        }

        Node get(char ch){
            return links[ch-'a'];
        }

        boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
    }

    TrieDatastructure(){
        root = new Node();
    }

    void insert(String word){

    }

   // boolean search(String word){}

   // boolean startsWith(String prefix){}
}
