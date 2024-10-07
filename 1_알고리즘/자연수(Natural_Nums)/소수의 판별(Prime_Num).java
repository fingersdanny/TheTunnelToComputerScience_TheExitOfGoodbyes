// 주어진 자연수가 소수인지 판별하는 방법. 

// 2부터 자기 자신까지 세는 방법. 시간 복잡도 O(X)
class Main {
    public static void main(String[] args) {
        int x = 11;
        boolean flag = true;
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                flag = false;
            }
        }
        System.out.println(flag);
    }
}

// 2부터 자기 자신의 제곱근까지 세는 법. 시간 복잡도 O(X^(1/2))
class Main {
    public static void main(String[] args) {
        int x = 15;
        boolean flag = true;
        for (int i = 2; i < (int) Math.sqrt(x) + 1; i++) {
            if (x % i == 0) {
                flag = false;
            }
        }
        System.out.println(flag);
    }
}