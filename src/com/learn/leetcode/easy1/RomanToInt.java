package com.learn.leetcode.easy1;

/**
 * 
 * Max roman number possible is 3999, because the number 4,000 would have to be written as MMMM, 
 * which goes against the principle of not having four consecutive letters of the same type together.
 *
 */
public class RomanToInt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int romanToInt(String s) {
        
        int result = 0;
        for (int i = 0; i < s.length(); i++) {

           char c = s.charAt(i);
           char n = 'A';
           if (i+1 < s.length()) {
               n = s.charAt(i+1);
           }
           if ((c == 'I' && (n == 'V' || n == 'X'))||(c == 'X' && (n == 'L' || n == 'C'))||(c == 'C' && (n == 'D' || n == 'M'))) {
                result+=(getValue(n)-getValue(c));
                i++;
            } else {
                result+=getValue(c);
            }
        }
        return result;
    }
	
	public int romanToInt1(String s) {
        
        int result = 0;
        s = s.replace("IV", "IIII");
        s = s.replace("IX", "VIIII");
        s = s.replace("XL", "XXXX");
        s = s.replace("XC", "LXXXX");
        s = s.replace("CD", "CCCC");
        s = s.replace("CM", "DCCCC");
        
        for (int i = 0; i < s.length(); i++) {

        	result+=getValue(s.charAt(i));
        }
        return result;
    }
	
	public int romanToInt2(String s) {
        
		int ans = 0, num = 0;
	    for (int i = s.length()-1; i >= 0; i--) {
	        switch(s.charAt(i)) {
	            case 'I': num = 1; break;
	            case 'V': num = 5; break;
	            case 'X': num = 10; break;
	            case 'L': num = 50; break;
	            case 'C': num = 100; break;
	            case 'D': num = 500; break;
	            case 'M': num = 1000; break;
	        }
	        if (4 * num < ans) ans -= num;
	        else ans += num;
	    }
    	return ans;
    }
	

    public static int getValue(char r) {

        switch(r) {
            case 'I':
            return 1;
            case 'V':
            return 5;
            case 'X':
            return 10;
            case 'L':
            return 50;
            case 'C':
            return 100;
            case 'D':
            return 500;
            case 'M':
            return 1000;
            default:
            return 0;
        }  
    }
}