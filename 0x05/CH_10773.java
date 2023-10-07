import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class CH_10773 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<N;i++) {
            int K = Integer.parseInt(br.readLine());

            if (K!=0) {
                stack.push(K);
            }
            else {
                stack.pop();
            }
        }
        for(int num : stack){
            result +=num;
        }
        System.out.println(result);

    }
}
