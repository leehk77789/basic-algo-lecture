import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] answer = new int[26];
        Arrays.fill(answer, 0);
        
        for(char c : s.toCharArray()){
            answer[(int)c - 97]++;
        }
        
        for(int i = 0; i < 26; i++){
            System.out.printf("%d ", answer[i]);
        }
    }
}
