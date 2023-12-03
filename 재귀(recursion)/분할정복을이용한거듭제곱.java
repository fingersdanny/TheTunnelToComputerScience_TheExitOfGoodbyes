class 분할정복을이용한거듭제곱 {
    /*
    * 매우 큰 수의 거듭 제곱을 for 문으로 구하게 되면 O(N)에 달하는 시간이 걸린다.
    따라서 이를 O(logN)으로 줄이기 위해서는 그 전의 상태 (number) ^ (times / 2) 값을 미리 구해놓고
    이의 제곱을 구하는 분할정복 방식으로 구할 수 있다.

    짝수의 경우 제곱을 구하면 되고
    홀수 일 경우 
    - 자바에서는 나누면 바로 소수점 내림을 하므로 해당 (number)를 한번 더 곱해주고
    - 파이썬에서는 // 연산으로 몫만 구할 수 있다.
    */
    private static long fPow(long number, long times, long c) {
		if (times == 1) {
			return number % c;
		} else {
			long next = fPow(number, times / 2, c) % c;
			if (times % 2 == 0) {
				return next * next % c;
			} else {
				return (next * next) % c * number % c;
			}
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		long a = fr.nextLong(), b = fr.nextLong(), c = fr.nextLong();
		System.out.println(fPow(a, b, c));
	}
}