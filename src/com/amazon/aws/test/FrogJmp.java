package com.amazon.aws.test;

public class FrogJmp {

	public static void main(String[] args) {
		System.out.println(new FrogJmp().solution(10, 85, 30));
		System.out.println(new FrogJmp().solution(3, 999111321, 7));

	}

	public int solution(int X, int Y, int D) {
		int distanceToJump = Y - X;
		int jumpsRequired = distanceToJump / D;
		if (distanceToJump % D != 0) {
			jumpsRequired++; // only add extra jump if remainder exists
		}
		return jumpsRequired;
	}

}
