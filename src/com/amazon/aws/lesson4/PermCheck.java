package com.amazon.aws.lesson4;

import java.util.Arrays;

public class PermCheck {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,3,4,2,6,7,5}));
		System.out.println(solution(new int[] {1,3,4,2,7,5}));
	}
	
	public static int solution(int[] A) {
		Arrays.sort(A);
		for(int i=0;i<A.length;i++) {
			if((i+1)!=A[i]) {
				return 0;
			}
		}
		
		return 1;
	}
}
