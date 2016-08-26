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