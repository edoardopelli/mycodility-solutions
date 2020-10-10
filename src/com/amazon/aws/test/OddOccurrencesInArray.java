package com.amazon.aws.test;

public class OddOccurrencesInArray {

	public static void main(String[] args) {
		/*System.out.println(*/new OddOccurrencesInArray().solution(new int[] { 7, 1, 7,6,5,4,6,5,1});//, 3, 4, 5, 7, 6, 6, 4, 3, 2, 1 })/*)*/;

	}

	public int solution(int[] A) {
		int elem = 0;

		for (int i = 0; i < A.length; i++) {
			System.out.println(A[i]+">>>>"+Integer.toBinaryString(A[i])+" - "+Integer.toBinaryString(elem));
			elem ^= A[i];
			System.out.println();
		}
		System.out.println(elem+" --> "+Integer.toBinaryString(elem));
		return elem;
	}

}
