import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = new int[10];
        Arrays.fill(nums, 0);
        int A = Integer.parseInt(br.readLine()); 
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        
        String s = Integer.toString(A*B*C);
        for(char c : s.toCharArray()){
            nums[(int)c - 48]++;
        }
        
        for(int i = 0; i < 10; i++){
            System.out.printf("%d ", nums[i]);
        }
    }
}
