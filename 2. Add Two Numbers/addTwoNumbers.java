package com.Test;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int temp = l1.val + l2.val;
        ListNode result;
        ListNode resTmp;
        if(temp > 9)
        {
            carry = temp / 10;
            result = new ListNode(temp % 10);
        }else{
        	result = new ListNode(temp);
        }
        l1 = l1.next;
        l2 = l2.next;
        resTmp = result;
        while(l1 != null || l2 != null)
        {
            if(l1 == null){
            	temp = l2.val + carry;
            	if(temp > 9){
            		carry = temp / 10;
            		resTmp.next = new ListNode(temp % 10);
            		resTmp = resTmp.next;
            		l2 = l2.next;
            	}else{
            		carry = 0;
            		resTmp.next = new ListNode(temp);
            		resTmp = resTmp.next;
            		l2 = l2.next;
            	}
            }else if(l2 == null){
            	temp = l1.val + carry;
            	if(temp > 9){
            		carry = temp / 10;
            		resTmp.next = new ListNode(temp % 10);
            		resTmp = resTmp.next;
            		l1 = l1.next;
            	}else{
            		carry = 0;
            		resTmp.next = new ListNode(temp);
            		resTmp = resTmp.next;
            		l1 = l1.next;
            	}
            }else{
            	temp = l1.val + l2.val + carry;
            	if(temp > 9){
            		carry = temp / 10;
            		resTmp.next = new ListNode(temp % 10);
            		resTmp = resTmp.next;
            		l1 = l1.next;
            		l2 = l2.next;
            	}else{
            		carry = 0;
            		resTmp.next = new ListNode(temp);
            		resTmp = resTmp.next;
            		l1 = l1.next;
            		l2 = l2.next;
            	}
            }
        }
        if(carry != 0)
        {
        	resTmp.next = new ListNode(carry);
    		resTmp = resTmp.next;
        }
        return result;
    }
    
}
