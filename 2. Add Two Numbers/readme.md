date:3/31/2016 9:10:12 AM   
tags: LinkedList，Math 

--- 
# Question: #
> You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
> Example:

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8  
# mySolution: #
    /**
 	* Definition for singly-linked list.
 	* public class ListNode {
 	*     int val;
 	*     ListNode next;
 	*     ListNode(int x) { val = x; }
	* }
 	*/
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
# Notes: #
　　Here we use the class ListNode to replace the LinkedList. We are asked to add two LinkedList and merge them to one LinkedList. Obviously, it is just a common question in C. What the difference is that here each node's value should change between 0 and 9 & we should consider the carry at the same time.  
　　The situation here is complicated and we should consider every possible result. With your caution and patience, and your will get the correct answer.