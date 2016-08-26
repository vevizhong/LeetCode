date: 4/15/2016 9:27:18 AM   
tags: HashTable, Two Pointers, String 

--- 
# Question: #
>Given a string, find the length of the longest substring without repeating characters.  
Examples:  
Given "**abcabcbb**", the answer is "**abc**", which the length is **3**.  
Given "**bbbbb**", the answer is "**b**", with the length of **1**.  
Given "**pwwkew**", the answer is "**wke**", with the length of **3**. Note that the answer must be a **substring**, "**pwke**" is a subsequence and not a substring.
  
# mySolution: #
    import java.util.Enumeration;
    import java.util.Hashtable;
    public class Solution {
    public int lengthOfLongestSubstring(String s) {
         char [] str = s.toCharArray();
	      int maxLength = 0;
	      int curLength = 0;
	      Hashtable <String, Integer> tableHashtable = new Hashtable<String,Integer>();
	      for (int j = 0; j < str.length; j++) {
			Integer n = tableHashtable.get(String.valueOf(str[j]));
			if(n == null){
				curLength ++;
				tableHashtable.put(String.valueOf(str[j]), j);
			}else {
				j--;
				maxLength = maxLength > curLength ? maxLength : curLength;
				Enumeration<Integer> en2 = tableHashtable.elements();
				while (en2.hasMoreElements()) {
					Integer integer = (Integer) en2.nextElement();
					if (integer <= n) {
						tableHashtable.remove(String.valueOf(str[integer]));
						curLength --;
					}
				}
			}
		}
	      return maxLength > curLength ? maxLength : curLength;
    }
    }
# Notes: #
　　This java file is written by myself. I use the HashTable to count the unique characters in the string and the look up speed is also O(c), where the parameter c is just a constant. We need two pointers, one(as A) is pointing to the start of the current longest substring while another(as B) is pointing to the current character when we are traveling the string. If the pointer B's value has appeared in the Hashtable, then we need record the current biggest length and remove all the elements in the Hashtable from the pointer A to the position where the pointer B's value appears in the Hashtable. Until the string is over. Unfortunately, the time consumed is not the least(156ms), which means my solution can be optimized.   
#  Sliding Window #
    public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    }
## Complexity Analysis  ##

-  Time complexity : O(2n)=O(n)O(2n) = O(n)O(2n)=O(n). In the worst case each character will be visited twice by iii and jjj.   
- Space complexity : O(min(m,n))O(min(m, n))O(min(m,n)). Same as the previous approach. We need O(k)O(k)O(k) space for the sliding window, where kkk is the size of the Set. The size of the Set is upper bounded by the size of the string nnn and the size of the charset/alphabet mmm.

# Sliding Window Optimized #
    public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    }
　　The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps. Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index. Then we can skip the characters immediately when we found a repeated character.

　　The reason is that if s[j]　have a duplicate in the range [i,j)with index j′, we don't need to increase i little by little. We can skip all the elements in the range [i,j′] and let iii to be j′+1　directly.　　

# Assuming ASCII 128 #
    public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; ++j) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
    }
　　The previous implements all have no assumption on the charset of the string s.

　　If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.

　　Commonly used tables are:

- int[26] for Letters 'a' - 'z' or 'A' - 'Z'
- int[128] for ASCII
- int[256] for Extended ASCII
## Complexity Analysis： ##

- Time complexity : O(n)O(n)O(n). Index jjj will iterate nnn times.
- Space complexity (HashMap) : O(min(m,n))O(min(m, n))O(min(m,n)). Same as the previous approach.
- Space complexity (Table): O(m)O(m)O(m). mmm is the size of the charset.
