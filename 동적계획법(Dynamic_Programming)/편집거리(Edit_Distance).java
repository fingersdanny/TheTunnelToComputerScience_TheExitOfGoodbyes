//두 개의 문자열이 주어졌을 때, 이를 세가지 연산 (삽입, 삭제, 교체)를 통해 편집할 때 최단거리
// 두 문자열을 2차원 배열로 만들어서 
// 1) 두 문자열이 같을 때 : dp[i][j] = dp[i - 1][j - 1]
// 2) 두 문자열이 다를 때 : dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])

// 각 문자열의 길이를 n, m 이라 한다면 두 문자열을 같게 만들 때까지 필요한 최소 편집 거리는 dp[n][m]이다.

import java.util.Scanner;

class Main {

    public static int editList(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        int[][] dp = new int[str1Length + 1][str2Length + 1];

        for (int i = 1; i < str1Length + 1; i++) {
            dp[i][0] = i;
        } 
        for (int j = 1; j < str2Length + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < str1Length + 1; i++) {
            for (int j = 1; j < str2Length + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }

        return dp[str1Length][str2Length];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        System.out.println(editList(str1, str2));
    }
}
