package test;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(100000000, 100000000));
	}

	public int solution(int A, int B) {
		
		int result = 0;
		if(A<0 || B < 0) {
			return result;
		}
		if(A>100000000 || B>100000000) {
			return 0;
		}
		int m = A*B;
		String bit = Integer.toBinaryString(m);
		char[] c = bit.toCharArray();
		for (char d : c) {
			if(d=='1') {
				result++;
			}
		}
		
		
		return result;
	}
}
