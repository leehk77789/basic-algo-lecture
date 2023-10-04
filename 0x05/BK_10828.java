import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<String> st = new Stack<>();

        for(int i = 0; i < n; i++){
            String[] s = br.readLine().split(" ");
            switch(s[0]){
                case "push": st.push(s[1]); 
                             break;
                case "top": if(!st.empty()) System.out.println(st.peek());
                            else System.out.println(-1);
                            break;
                case "size": System.out.println(st.size()); break;
                case "empty": if(st.empty()) System.out.println(1);
                              else System.out.println(0);
                              break;
                case "pop": if(!st.empty()) System.out.println(st.pop());
                            else System.out.println(-1);
                            break;
            }
        }
        br.close();
    }
}
