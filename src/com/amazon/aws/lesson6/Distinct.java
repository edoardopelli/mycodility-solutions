package com.amazon.aws.lesson6;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

	public static void main(String[] args) {
		solution(new int[] {2,1,1,2,3,1});
	}
	public static int solution(int[] A) {
		
		Set<Integer> s = new HashSet<>();
		int counter = 0;
		for (int i : A) {
			if(!s.contains(i)) {
				counter++;
				s.add(i);
			}
		}
		return counter;
		
		
	}
	
}
