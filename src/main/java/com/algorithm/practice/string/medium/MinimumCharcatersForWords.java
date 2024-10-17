package com.algorithm.practice.string.medium;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumCharcatersForWords {
    public static char[] minimumCharactersForWords(String[] words) {
        Map<Character, Integer> first = new HashMap<>();

        for(Character ch: words[0].toCharArray()){
            first.put(ch, first.getOrDefault(ch, 0)+1);
        }
        for(int i=1;i<words.length;i++){
            Map<Character, Integer> current = new HashMap<>();
            for(Character ch: words[i].toCharArray()){
                current.put(ch, current.getOrDefault(ch, 0)+1);
            }
            for(Map.Entry<Character,Integer> entry: current.entrySet()){
                if(first.containsKey(entry.getKey())){
                    if(first.get(entry.getKey())<entry.getValue()){
                        first.put(entry.getKey(), entry.getValue());
                    }
                }else{
                    first.put(entry.getKey(), entry.getValue());
                }
            }
        }
        List<Character> list = new ArrayList<>();
        for(Map.Entry<Character,Integer> entry: first.entrySet()){
            for(int i=1;i<=entry.getValue();i++){
                list.add(entry.getKey());
            }
        }
        char[] res = new char[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i).charValue();
        }

        return res;
    }

    public static void main(String[] args) {
        minimumCharactersForWords(new String[]{"this","that"});
        Set<Integer> set = new HashSet<>();
        set.add(1);
    }

}
