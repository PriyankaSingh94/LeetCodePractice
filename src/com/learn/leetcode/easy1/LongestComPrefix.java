package com.learn.leetcode.easy1;

public class LongestComPrefix {

	public static void main(String[] args) {
		
		String[] strs = {"flight", "flow", "flee", "flu"};
		
		longestCommonPrefix2(strs, 0 , strs.length - 1);
		
		longestCommonPrefix1(strs);

		
	}
	
	public static String longestCommonPrefix(String[] strs) {
        
        String res = "";
        if (strs.length == 1)
            return strs[0];
        for (int i = 0; i < strs.length-1; i++) {
            res = "";
            int j = 0;
            while ((j < strs[i].length()) && (j < strs[i+1].length())) {
                if (strs[i].charAt(j) == strs[i+1].charAt(j)) {
                res+=strs[i].charAt(j);       
                } else if (j == 0) {
                    return "";
                } else {
                    break;
                }
                j++;
            }
            strs[i+1] = res;
        }
        return res;
	}
	
	public static String longestCommonPrefix1(String[] strs) {
        
		if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++)
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }        
	    return prefix;
	}
	
	private static String longestCommonPrefix2(String[] strs, int l, int r) {
	    if (l == r) {
	        return strs[l];
	    }
	    else {
	        int mid = (l + r)/2;
	        String lcpLeft =   longestCommonPrefix2(strs, l , mid);
	        String lcpRight =  longestCommonPrefix2(strs, mid + 1,r);
	        return commonPrefix(lcpLeft, lcpRight);
	   }
	}

	static String commonPrefix(String left,String right) {
	    int min = Math.min(left.length(), right.length());       
	    for (int i = 0; i < min; i++) {
	        if ( left.charAt(i) != right.charAt(i) )
	            return left.substring(0, i);
	    }
	    return left.substring(0, min);
	}

}