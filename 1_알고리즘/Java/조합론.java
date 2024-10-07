import java.util.ArrayList;

public class 조합론 {
    static int[] arr; // 뽑을 배열
    static int n; // 기준 배열 길이
    static int perCount; // 순열 갯수
    static int dupPerCount; // 중복 순열 갯수
    static int comCount; // 조합 갯수
    static int dupComCount; // 중복 조합 갯수
    static int num; // 뽑을 갯수
    static ArrayList<Integer> perList;

    public static void main(String[] args) {
        arr = new int[] {1,2,3,4};
        perList = Arrays.stream(ints).boxed().collect(Collectors.toList());
		n = arr.length;
		num = 2;
		
		permutation(new ArrayList<Integer>(), num);
		System.out.println("[순열 갯수] " + perCount);
		System.out.println("-------------------");
		
		permutationWithR(new ArrayList<Integer>(), num);
		System.out.println("[중복순열 갯수] " + dupPerCount);
		System.out.println("-------------------");
		
		combination(new ArrayList<Integer>(), 0, num);
		System.out.println("[조합 갯수] " + comCount);
		System.out.println("-------------------");
		
		combinationWithR(new ArrayList<Integer>(), 0, num);
		System.out.println("[중복조합 갯수] " + dupComCount);
    }

    // 1. 순열 : 서로 다른 n 개 중에 r개를 선택하는 경우의 수
    // 순서가 존재한다.
    // 경우의 수 : n! / (n - r)!
    public static void permutation(ArrayList<Integer> list, int count) {
        //다 뽑았을때
        if (count == 0) {
            System.out.println(list);
            perCount++;
            return;
        } 

        for (int i = 0; i < n; i++) {
            int temp = perList.remove(i);
            list.add(temp);
            permutation(list, count - 1); // 뽑을 때 마다 count - 1;
            list.remove(list.size() - 1); // 재귀 위해서 마지막에 넣은 원소 제거;
            perList.add(i, temp);
        }
    }

    // 2. 중복 순열 : n개 중에 r개를 선택하는 경우의 수 
    // 순서가 존재한다
    // 경우의 수 : n ^ r
    public static void permutationWithR(ArrayList<Integer> list, int count) {
        //다 뽑았을때
        if (count == 0) {
            System.out.println(list);
            dupPerCount++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 순열과 달리 리스트에 포함되어 있는지 확인하지 않아도 된다.
            list.add(arr[i]);
            permutationWithR(list, count - 1); // 뽑을 때 마다 count - 1;
            list.remove(list.size() - 1); // 재귀 위해서 마지막에 넣은 원소 제거;
        }
    }

    // 3. 조합 : 서로 다른 n개 중에 r개를 선택하는 경우의 수
    // 순서가 존재하지 않는다.
    // 경우의 수 : n! / r! * (n - r)!
    public static void combination(ArrayList<Integer> list, int index, int count) {
        //다 뽑았을때
        if (count == 0) {
            System.out.println(list);
            comCount++;
            return;
        }

        for (int i = index; i < n; i++) {
            list.add(arr[i]);
            combination(list, i + 1, count - 1); // 뽑을 때 마다 count - 1;
            list.remove(list.size() - 1); //재귀 위해 마지막에 넣은 원소 제거
        }
    }


    // 4. 중복 조합 : n개 중에 r개를 선택하는 경우의 수 
    // 순서가 존재하지 않는다.
    // 경우의 수 : (r + (n - 1))! / r! * (n - 1)!
    public static void combinationWithR(ArrayList<Integer> list, int index, int count) {
        // 다 뽑았을 때
        if (count == 0) {
            System.out.println(list);
            dupComCount++;
            return;
        }

        for (int i = index; i < n; i++) {
            list.add(arr[i]);
            // 자기 자신부터 다시 재귀
            combinationWithR(list, i, count - 1); // 뽑을 때 마다 count - 1;
            list.remove(list.size() - 1); //재귀 위해 마지막에 넣은 원소 제거
        }
    }
}