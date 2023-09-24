import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] nums = new int[10];
        Arrays.fill(nums, 0);
        int answer = 0;
        
        for(char c : s.toCharArray()){
            int n = (int)c-48;
            nums[n]++;
        }
        for(int i = 0; i < 9; i++){
            answer = i != 6 ? Math.max(answer, nums[i]) : 
            (nums[6]+nums[9])%2 == 0 ? Math.max(answer, (nums[6]+nums[9])/2) : Math.max(answer, ((nums[6]+nums[9])/2)+1);
        }
        System.out.println(answer);
    }
}
