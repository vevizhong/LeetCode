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