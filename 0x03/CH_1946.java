import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CH_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> rlist = new ArrayList<Integer>();
        while(n > 0) {
            int k = Integer.parseInt(br.readLine());
            int result = k;
            int irr[][] = new int[k][2];
            for (int i=0; i<k;i++) {
               String[] input = br.readLine().split(" ");
               irr[i][0] = Integer.parseInt(input[0]);
               irr[i][1] = Integer.parseInt(input[1]);
            }
            //Arrays.sort(irr,Comparator.comparingInt(a -> a[0]));
            Arrays.sort(irr, (a, b) -> a[0] - b[0]); // 서류심사 성적을 기준으로 오름차순 정렬

            int minInterviewRank = Integer.MAX_VALUE;

            for (int i = 0; i < k; i++) {
                if (irr[i][1] < minInterviewRank) {
                    minInterviewRank = irr[i][1];
                } else {
                    // 면접 성적이 떨어지면 선발되지 않음
                    result--;
                }
            }
            rlist.add(result);
            n = n-1;
        }

        for (int num : rlist) {
            System.out.println(num);
        }

    }
}
