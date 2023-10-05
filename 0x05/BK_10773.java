import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        int answer = 0;

        for(int i = 0; i < n; i++){
            int p = Integer.parseInt(br.readLine());
            if(p == 0 && !st.empty()){
                st.pop();
            }else{
                st.push(p);
            }
        }
        while(!st.empty()){
            answer += st.pop();
        }
        System.out.println(answer);
        br.close();
    }
}
