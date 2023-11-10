package com.bestpratices.effectivejava;

public class TryClone implements Cloneable {
    public TryClone()  {

    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TryClone x = new TryClone();
        System.out.println(x.clone().getClass().getSimpleName());
        System.out.println();
        TryCloneChild y = new TryCloneChild();
        y.print();
    }
}
