package com.amazon.aws.lesson4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {

	
	public static void main(String[] args) {
		System.out.println(solution(9,new int[] {1,3,1,4,2,3,5,4}));
	}
	
	
	public static int solution (int X ,int[] A) {
 		Set positions = new HashSet<>();
 		
 		for(int i = 1; i<=X;i++) {
 			positions.add(i);
 		}
 		
 		Set leaves = new HashSet<>();
 		for(int i = 0;i<A.length;i++) {
 			leaves.add(A[i]);
 			if(leaves.size()<positions.size()) continue;
 			
 			if(leaves.containsAll(positions)) {
 				return i;
 			}
 		}
		return -1;
		
	}
}
