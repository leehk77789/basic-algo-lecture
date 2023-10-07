import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CH_10828 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();  // 스택선언
        while (N > 0) {

            String[] s = br.readLine().split(" ");
            String a;
            int b = 0;
            if (s.length > 1) {
                a = s[0];
                b = Integer.parseInt(s[1]);
            } else {
                a = s[0];
            }

            if(a.equals("push") ) {
                stack.push(b);
            }
            else if (a.equals("top")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.peek());
                }
            }
            else if(a.equals("pop")) {
                if (stack.isEmpty()){
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.pop());
                }
            }
            else if(a.equals("size")) {
                System.out.println(stack.size());
            }
            else {
                if (stack.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }

            }
            N--;
        }
    }
}
