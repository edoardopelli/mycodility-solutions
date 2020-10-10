package com.amazon.aws.lesson4;

public class MaxCounters {

	public static void main(String[] args) {
		int[] c = solution(5, new int[] { 3, 4, 4, 6, 1, 4, 4 });
//		print(c);
	}

	private static void print(int[] c) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]).append(",");
		}
		System.out.println(sb.toString());
	}

	public static int[] solution(int N, int[] A) {

		int[] counterArray = new int[N];
		final int[] zeroedArray = new int[N];
		int biggestCounter = 0;
		int maxCounter = 0;

		for (int i = 0; i < A.length; i++) {

			if (A[i] <= N) {

				counterArray[A[i] - 1]++;
				if (counterArray[A[i] - 1] + maxCounter > biggestCounter)
					biggestCounter = counterArray[A[i] - 1] + maxCounter;

			} else if (A[i] == N + 1) {
				maxCounter = biggestCounter;
				System.arraycopy(zeroedArray, 0, counterArray, 0, zeroedArray.length);
			}

			print(counterArray);
		}

		for (int j = 0; j < counterArray.length; j++)
			counterArray[j] += maxCounter;
		return counterArray;
	}
}
