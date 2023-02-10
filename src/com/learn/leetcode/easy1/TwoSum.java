package com.learn.leetcode.easy1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		
	int[] arr = {-3, 0, 3, 20};	
    int Integer = 24;
    char String = 'a';
    System.out.println(Integer);
    System.out.println(String);
	}
	
	/**  
	 * Brute Force
	 * @param nums
	 * @param target
	 * @return
	 * Time Complexity O(n2)
	 * Space Complexity O(1)
	 */

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];

        for (int i = 0; i < nums.length-1; i++) {
                
            for (int j = i+1; j < nums.length; j++) {
                
                if (nums[i]+nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }   
            }
        }

        return result;
    }
	
	/**  
	 * Two Pass Hash Table
	 * @param nums
	 * @param target
	 * @return
	 * Time Complexity O(n)
	 * Space Complexity O(n)
	 */
	
	public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length-1; i++) {
        	map.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length-1; i++) {
        	int val = target - nums[i];
        	if (map.containsKey(val) && map.get(val) != i) {
        		System.out.println("First index: "+i+" Second index: "+map.get(val));
        		return new int[] {i, map.get(val)};
        	}
        }
        return null;
    }
	
	/**  
	 * One Pass Hash Table
	 * @param nums
	 * @param target
	 * @return
	 * Time Complexity O(n)
	 * Space Complexity O(n)
	 */
	
	public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length-1; i++) {
        	int complement = target - nums[i];
        	if (map.containsKey(complement) && map.get(complement)!=i) {
        		return new int[] {i, map.get(complement)};
        	}
        	map.put(nums[i], i);
        	}
        	return null;
       }
}