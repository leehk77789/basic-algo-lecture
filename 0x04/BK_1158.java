import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int c = Integer.parseInt(s[1]);

        String answer = "<";

        LinkedList<Integer> ll = new LinkedList<>();
        int idx = 0;

        for(int i = 1; i <= n; i++){
            ll.add(i);
        }

        while(ll.size() != 0){
            idx += c-1;
            if(idx > ll.size()-1) idx = idx%ll.size();
            answer = answer + Integer.toString(ll.get(idx)) + ", ";
            ll.remove(idx);
        }
        answer = answer.substring(0, answer.length()-2) + ">";
        System.out.println(answer);
        br.close();
    }
}
