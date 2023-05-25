// 조합 : n개의 숫자 중에서 r개의 수를 순서 없이 뽑는 경우
// 2개를 뽑는다 하면 아래와 같다
// [1, 2, 3] -> [1, 2], [2, 3], [1, 3]

class 조합론 { 
    // 1. 백트래킹을 이용한 조합 구현
    static void comb1(int[] arr, boolean[] visited, int start, int r) {
        if (r == 0) {
            print(arr, visited);
            return; 
        } else {
            for (int i = start; i < arr.length; i++) {
                visited[i] = true;
                comb1(arr, visited, i + 1, r - 1);
                visited[i] = false;
            }
        }
    }

    // 2. 재귀를 이용한 조합 구현
    static void comb2(int[] arr, boolean[] visited, int depth, int r) {
        if (r == 0) {
            print(arr, visited);
            return; 
        } 
        if (depth == arr.length) {
            return;
        }
        else {
            visited[depth] = true;
            comb2(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            comb2(arr, visited, depth + 1, r);
        }
    }

    // 3. 중복 조합 (자기 자신을 중복하여 뽑을 수 있다.) [1, 2, 3] -> 

    static void print(int[] arr, boolean[] visited) {
        for(int i = 0; i < arr.length; i++) {
            if(visited[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        boolean[] visited = new boolean[arr.length];

        System.out.println("1. 백트래킹을 이용한 구현");

        for (int r = 1; r <= arr.length; r++) {
            System.out.println("\n" + arr.length + "개 중에 " + r + "개 뽑음");
            comb1(arr, visited, 0, r);
        }

        System.out.println("2. 재귀를 이용한 구현");

        for (int r = 1; r <= arr.length; r++) {
            System.out.println("\n" + arr.length + "개 중에 " + r + "개 뽑음");
            comb2(arr, visited, 0, r);
        }
    }
}