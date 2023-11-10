package com.bestpratices.effectivejava;

public class TryCloneChild extends TryClone {
    public TryCloneChild(){
    }

    public void print() throws CloneNotSupportedException {
        TryCloneChild x = new TryCloneChild();
        System.out.println(x.clone().getClass().getSimpleName());
    }
}
