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