class 피보나치수열 {
    /*
    * f1 = 1, f2 = 1 f(n + 2) = f(n + 1) + f(n)을 만족하는 수열을 피보나치 수열을 한다.
    * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144..... 과 같은 진행을 가지고 있고
    * 위 등식에서 f(n)을 구할 때는 다음과 같은 재귀를 통해서 구할 수 있다
    */

    long fibo(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    /*
    * 당연하게도 n이 커지면 커질 수록 재귀를 하는 횟수가 많아지기 때문에 속도는 더 느려질 수 밖에 없다. 
    * 따라서 위 식을 해결하기 위해서는 메모이제이션을 통해서 연산 속도를 줄일 수 있다.
    */

    long fiboWithMemoization(int n) {
        if (n == 1 || n == 2) {
            return 1;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    } 

    /*
    * n이 훨씬 더 커진다면 어떨까? n의 범위가 10 ^ 16라면 이미 long의 범위 (2 ^ 32 - 1)을 아득히 넘어버린다 ((2 * 5) ^ 16 > 2 ^ 32 - 1)
    * 더 이상 배열을 통한 메모이제이션은 사용할 수 없다.. 물론 원시형 자료 타입도 사용할 수 없기 때문에 Java에서는 BigInteger의 연산을 통해서 계산해야 한다.
    * 또한 n까지 1번 방법을 통해서 재귀를 한다면 얼마나 오래 걸릴지 모른다.
    * 이 때는 피보나치의 행렬 곱을 통한 연산을 통해서 더 빠른 연산을 할 수 있다.
    * 
    * https://en.wikipedia.org/wiki/Fibonacci_sequence
    * 
    * 피보나치 행렬 곱의 일반 식에서 다음과 같은 식을 유추할 수 있다.
    * f(m) * f(n) + f(m - 1) * f(n - 1) = f(m + n - 1)
    * f(m) * f(n + 1) + f(m - 1) * f(n) = f(m + n)
    * 
    * m 과 n 이 같다고 할 때 행렬의 곱에서는 A ^ m * A ^ n = A ^ (m + n)이므로
    * 
    * f(2n - 1) = f(n) ^ 2 + f (n - 1) ^ 2
    * f(2n) = f(n) * f(n + 1) + f(n - 1) * f(n)
    * 
    * 따라서 홀수 일때 f(n) ^ 2 + f (n - 1) ^ 2
    * 짝수 일때 f(n) * f(n + 1) + f(n - 1) * f(n)라는 일반식이 나온다. 
    * 
    * 또한 메모이제이션을 더 이상 배열로 할 수 없으므로 HashMap을 통한 메모이제이션을 통해서 필요한 수만 저장하고 그 수가 있는지만 체크할 수 있다.
    */
   HashMap<BigInteger, BigInteger> map = new HashMap<>();

   BigInteger fiboWithBigInteger(BigInteger n) {
        if (map.containsKey(n)) {
			return map.get(n);
		}
		BigInteger result;
		if ((n.mod(BigInteger.TWO)).equals(BigInteger.ZERO)) {
			BigInteger half = n.divide(BigInteger.TWO);
			BigInteger fibonacci = fibonacci(half);
			BigInteger fibonacciSubtractOne = fibonacci(half.subtract(BigInteger.ONE));
			result = fibonacciSubtractOne.multiply(BigInteger.TWO)
				.add(fibonacci)
				.multiply(fibonacci)
				.mod(modular);
		} else {
			BigInteger half = n.add(BigInteger.ONE).divide(BigInteger.TWO);
			BigInteger fibonacci = fibonacci(half);
			BigInteger fibonacciSubtractOne = fibonacci(half.subtract(BigInteger.ONE));
			result = fibonacci.pow(2).add(fibonacciSubtractOne.pow(2)).mod(modular);
		}

		map.put(n, result);  // Memoization
		return result;
   }
}