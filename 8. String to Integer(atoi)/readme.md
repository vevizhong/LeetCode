date: 4/16/2016 2:45:37 PM   
tags: Math, String 

---
# Question: #
> implement atoi to convert a string to an integer.  
> **Hint:** Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.  
> **Notes:** It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.  
# mySolution: #
    public class Solution {
        public int myAtoi(String str) {
		long result = 0;
		char [] strCon = str.toCharArray();
		int i;
		boolean overFlow = false;
		boolean isMinus = false;
		boolean isPositive = false;
		boolean figureAppear = false;
		boolean symbolAppear = false;
		for(i=0;i<str.length();i++){
			if (strCon[i] == ' ') {
				if (figureAppear || symbolAppear) {
					break;
				}
				continue;
			}else if (strCon[i] == '-') {
			    if(symbolAppear == true){
			        result = 0;
			        break;
			    }
			    symbolAppear = true;
				isMinus = true;
			}else if(strCon[i] == '+'){
			    if(symbolAppear == true){
			        result = 0;
			        break;
			    }
			    symbolAppear = true;
				isPositive = true;
			}else if (isFigure(strCon[i])) {
				figureAppear = true;
				result = result * 10;
				result = result + strCon[i] - '0';
				if((!isMinus && result >= Integer.MAX_VALUE)|| (isMinus && (0-result) <= Integer.MIN_VALUE))
					overFlow = true;
			}else {
				break;
			}
		}
		if (overFlow) {
			if (isPositive && isMinus) {
				result = 0;
			}else if (isMinus) {
				result = Integer.MIN_VALUE;
			}else if (!isMinus) {
				result = Integer.MAX_VALUE;
			}
		}else {
			if (isPositive && isMinus) {
				result = 0;
			}else if (isMinus) {
				result = 0 - result;
			}
		}
		return (int)result;
	}
	
	public static boolean isFigure(char ch) {
		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;
	}
    }

# Notes: #
　　It is easy to convert a string to an integer, but the difficulty is that the input may be many situation. Thus, we need list all of the situation. Such as minus, illegal, overflow and so on. So, if we can consider all of the input combination, we can solve this problem then.