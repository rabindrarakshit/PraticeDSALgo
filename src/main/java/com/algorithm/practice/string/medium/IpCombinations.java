package com.algorithm.practice.string.medium;

import java.util.ArrayList;

public class IpCombinations {
    public static ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ips = new ArrayList<>();

        for(int i=1; i<Math.min(string.length(), 4);i++){
            StringBuilder sb = new StringBuilder();
            if(isNotValid(string.substring(0,i)))
                continue;
            sb.append(string.substring(0,i));
            for(int j=i+1;j< i+Math.min(string.length()-i,4);j++){
                if(isNotValid(string.substring(i,j)))
                    continue;
                sb.append("."+ string.substring(i, j));
                for(int k=j+1;k<j+Math.min(string.length()-j, 4);k++){
                    String third = string.substring(j,k);
                    String fourth = string.substring(k);
                    if(isNotValid(third) || isNotValid(fourth))
                        continue;
                    sb.append("."+third+"."+fourth);
                    ips.add(sb.toString());
                }
            }
        }
        return ips;
    }

    static boolean isNotValid(String part){
        int intPart = Integer.parseInt(part);
        if(intPart>255 || part.length()>Integer.toString(intPart).length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        ArrayList<String> ips = validIPAddresses("1921680");
        Character ch = 'A';
    }
}
