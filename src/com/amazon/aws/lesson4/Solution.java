package com.amazon.aws.lesson4;

import java.util.Arrays;

/**
 * Write a function:
 * 
 * class Solution { public int solution(int[] A); }
 * 
 * that, given an array A of N integers, returns the smallest positive integer
 * (greater than 0) that does not occur in A.
 * 
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * 
 * Given A = [1, 2, 3], the function should return 4.
 * 
 * Given A = [−1, −3], the function should return 1.
 * 
 * Write an efficient algorithm for the following assumptions:
 * 
 * N is an integer within the range [1..100,000]; each element of array A is an
 * integer within the range [−1,000,000..1,000,000].
 * 
 * @author edoardo
 *
 */
public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int x = s.solution(new int[] { 1, 3, 6, 4, 1, 2 });
		System.out.println(x);
		x = s.solution(new int[] { 10, -3 });
		System.out.println(x);
		x = s.solution(new int[] { 1, 2, 3, 11, 5, 6, 7, 9, 2000 });
		System.out.println(x);
		x = s.solution(new int[] { -10, 5, 3, 9, 2, 6, 6, 3 });
		System.out.println(x);
		x = s.solution(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		System.out.println(x);
	}

	public int solution(int[] a) {
		Arrays.sort(a);
		int result = 1;
		int[] b = new int[a.length];
		boolean isEmpty = true;
		int idx = 0;
		for (int i = 0; i < a.length; i++, result++) {
			if (Arrays.binarySearch(a, result) < 0) {
				b[idx++] = result;
				isEmpty = false;
			}
		}
		// if the bucket is empty, the numbers inside the array are consecutive
		if (isEmpty) {
			b = new int[1];
			b[0] = a[a.length - 1] + 1;
		}
		return b[0];
	}
}
