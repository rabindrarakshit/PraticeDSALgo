package com.algorithm.practice.graph.striver.mst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ref: https://takeuforward.org/data-structure/accounts-merge-dsu-g-50/
/*
* Time Complexity: O(N+E) + O(E*4ɑ) + O(N*(ElogE + E)) where N = no. of indices or nodes and E = no. of emails. The first term is for visiting all the emails. The second term is for merging the accounts. And the third term is for sorting the emails and storing them in the answer array.
Space Complexity: O(N)+ O(N) +O(2N) ~ O(N) where N = no. of nodes/indices. The first and second space is for the ‘mergedMail’ and the ‘ans’ array. The last term is for the parent and size array used inside the Disjoint set data structure.
* */

public class MergeAccounts {
    static List<List<String>> mergeAccounts(List<List<String>> accounts) {

        Map<String, Integer> accountsMap = new HashMap<>();
        DisjointSetsUnionBySize ds = new DisjointSetsUnionBySize(accounts.size());

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 0; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if(accountsMap.containsKey(email)){
                    ds.unionBySize(accountsMap.get(email), i);
                }else{
                    accountsMap.put(email, i);
                }
            }
        }
        List<List<String>> mergedAccounts = new ArrayList<>();
        for(int i=0;i<accounts.size();i++){
            mergedAccounts.add(new ArrayList<>());
        }
        for(Map.Entry<String, Integer> entry : accountsMap.entrySet()){
            Integer parent = ds.findParent(entry.getValue());
            mergedAccounts.get(parent).add(entry.getKey());
        }

        List<List<String>> result = new ArrayList<>();
        for(int i=0;i<mergedAccounts.size();i++){
            if(mergedAccounts.get(i).size()==0){
                continue;
            }
            Collections.sort(mergedAccounts.get(i));
            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            for(String emails: mergedAccounts.get(i)){
                list.add(emails);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList() {
            {
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j2@com", "j3@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j4@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r1@com", "r2@com")));
                add(new ArrayList<String>(Arrays.asList("John", "j1@com", "j5@com")));
                add(new ArrayList<String>(Arrays.asList("Raj", "r2@com", "r3@com")));
                add(new ArrayList<String>(Arrays.asList("Mary", "m1@com")));

            }
        };


        List<List<String>> ans = mergeAccounts(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
        }

    }
}
