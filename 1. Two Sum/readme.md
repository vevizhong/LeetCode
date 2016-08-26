date:3/30/2016 9:20:38 AM   
tags: Array,HashTable  

--- 
# Question: #
> Given an array of integers, return indices of the two numbers such that they add up to a specific target.  
> You may assume that each input would have exactly one solution.  
> Example:

    Given nums = [2, 7, 11, 15], target = 9,  
    Because nums[0] + nums[1] = 2 + 7 = 9,  
    return [0, 1].  
# mySolution: #
    import java.util.Hashtable;
    public class Solution {
    public int[] twoSum(int[] nums, int target) {
       int [] a = new int[2];
       Hashtable <Integer,Integer> number = new Hashtable<Integer,Integer>();
       for(int i = 0; i < nums.length; i++)
       {
          Integer n = number.get(nums[i]);
          if(n == null)
          {
              number.put(nums[i],i);
          }
          n = number.get(target - nums[i]);
          if(n != null && n < i)
          {
              a[0] = n;
              a[1] = i;
              return a;
          }
       }
      return a;
    }
    }
# Notes: #
　　Because we need to find two figures in an array & then calculate whether the sum of them is the given target, usually we need to do the traversal to the array for at least 2 times, which makes the time complexity of the algorithm become *O(n2)*. If so, the online judgment won't let it pass. This is the thought as soon as I read the question.  
　　After searching in the Internet & learning from others, I got an [answer](http://blog.csdn.net/jiadebin890724/article/details/23305449) by using the Hashtable. Obviously, the speed of looking up an element in the Hashtable is a constant. So we just need do the traversal to the array for one time & store it into the Hashtable at the same time. When we need to calculate, we just need to calculate:target minus the current figure and look up the result in the Hashtable. If we can find it, then we got the two number.