package com.learn.leetcode.easy1;

public class MergeList {

	public static void main(String[] args) {

		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

		mergeTwoLists1(list1, list2);
	}

	public static ListNode mergeTwoLists(ListNode ls, ListNode ls1) {

		if(ls == null)
        {
			return ls1;
		}
		
		if(ls1 == null)
        {
			return ls;
		} 
		ListNode ls3 = new ListNode();
        ListNode ls2 = ls3;
		while (ls != null && ls1 != null) {
			if (ls.val < ls1.val) {
				ls2.val = ls.val;
				ls = ls.next;
			} else {
				ls2.val = ls1.val;
				ls1 = ls1.next;
			}
		
			ls2.next =  new ListNode();
			ls2 = ls2.next;
		}
		if (ls!=null) {
			ls2.val = ls.val;
			if (ls.next != null) {
				ls2.next = ls.next;
			}
			
		}
		if (ls1!=null) {
			if (ls1.next != null) {
				ls2.next = ls1.next;
			}
			ls2.val = ls1.val;
		}
		return ls3;

	}
	
	
	public static ListNode mergeTwoLists1(ListNode ls, ListNode ls1) {

		if(ls == null)
        {
			return ls1;
		}
		
		if(ls1 == null)
        {
			return ls;
		}
		ListNode ls3 = new ListNode(0);
        ListNode ls2 = ls3;
		while (ls != null && ls1 != null) {
			if (ls.val < ls1.val) {
				ls2.next = ls;
				ls = ls.next;
			} else {
				ls2.next = ls1;
				ls1 = ls1.next;
			}
		
			ls2 = ls2.next;
		}
		if (ls!=null) {
			ls2.next = ls;
			
		}
		if (ls1!=null) {
			ls2.next = ls1;
		}
		return ls3.next;

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}