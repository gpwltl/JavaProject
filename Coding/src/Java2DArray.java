import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.Array;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Java2DArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        bufferedReader.close();

        // 모든 값이 마이너스일 때 max_value 예외처리 필요 ... => line38 추가 완료
        int max_value = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = sumValue(arr, i, j);
                if (i == 0 && j == 0) {
                    max_value = sum;
                    continue;
                }
                max_value = Math.max(max_value, sum);
            }
        }
        System.out.println(max_value);
    }

    public static int sumValue(List<List<Integer>> arr, int start_x, int start_y) {
        int sum = 0;
        int dx[] = new int[]{0, 0, 0, 1, 2, 2, 2};
        int dy[] = new int[]{0, 1, 2, 1, 0, 1, 2};

        for (int i = 0; i < 7; i++) {
            int val = arr.get(start_x + dx[i]).get(start_y + dy[i]);
            sum += val;
        }

        return sum;
    }
}
