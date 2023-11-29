package com.algorithm.practice.linkedlist.util;

public class LinkedListNodeCTCI {
	public LinkedListNodeCTCI next;
	public LinkedListNodeCTCI prev;
	public LinkedListNodeCTCI last;
	public int data;
	public LinkedListNodeCTCI(int d, LinkedListNodeCTCI n, LinkedListNodeCTCI p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}
	
	public LinkedListNodeCTCI(int d) {
		data = d;
	}	
	
	public LinkedListNodeCTCI() { }

	public void setNext(LinkedListNodeCTCI n) {
		next = n;
		if (this == last) {
			last = n;
		}
		if (n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNodeCTCI p) {
		prev = p;
		if (p != null && p.next != this) {
			p.setNext(this);
		}
	}	
	
	public String printForward() {
		if (next != null) {
			return data + "->" + next.printForward();
		} else {
			return ((Integer) data).toString();
		}
	}
	
	public LinkedListNodeCTCI clone() {
		LinkedListNodeCTCI next2 = null;
		if (next != null) {
			next2 = next.clone();
		}
		LinkedListNodeCTCI head2 = new LinkedListNodeCTCI(data, next2, null);
		return head2;
	}
}