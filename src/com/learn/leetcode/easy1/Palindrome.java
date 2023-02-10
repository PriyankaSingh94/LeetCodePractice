package com.learn.leetcode.easy1;

public class Palindrome {

	public static void main(String[] args) {
		
		isPalindrome1(-121);
	}
	
	public boolean isPalindrome(int x) {
        
        String str = ((Integer) x).toString();
        String rev ="";
        for (int i =0; i < str.length(); i++) {
            rev+=str.charAt(str.length()-1-i);
        }

        if (str.equalsIgnoreCase(rev)) {
            return true;
        } 
        return false;
    }
	
	public static boolean isPalindrome1(int x) {
        
		int num = x;
		int n = 0;
		int r = 0;
		
        while (x > 0) {
        	r = x%10;
        	x = x/10;
        	n = 10*n+r;
        }
        if (num == n) {
            return true;
        } 
        return false;
    }
	
	/**
	 * This solution will help in reducing chances for 
	 * stack overflow errors as number is compared with half of it.
	 */
	
	public static boolean isPalindrome2(int x) {
        
		if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
		
		int revertedNumber = 0;
		
		while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
	    }
		
		return x == revertedNumber || x == revertedNumber/10;
    }
}