date:3/31/2016 9:04:15 PM   
tags: Bit Manipulation  

---
# Question: #
> Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).  
> For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.  
# mySolution: #
    public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
         while(0 != n)
        {
           n = n & (n-1);
           count ++;
        }
        return count;
       }
    }

# Notes: #
　　We need to count the number of 1 bit when we change the integer figure into binary figure. Obviously, we need the bit manipulation to accelerate the speed of calculation.  
　　At the begin, my way is to shift the target figure left and use the & manipulation to see if the current bit is 1 to determine whether we need to add the count. But the question is that when the given figure is 0x8000, the count should be 1 but we need to repeat for 32 times. At last, the calculation time is out. Then I found a way by n=n&(n-1) and the binary figure will decrease a 1 bit. In this case, the situation above becomes 1 time in total, which increase the calculation speed.