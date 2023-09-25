import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int answer = 0;
     
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        
        Arrays.sort(nums);
        
        int i = n-1;
        int j = 0;
        while(i > j){
            if(nums[j] + nums[i] == x){
                i--;
                j++;
                answer++;
            }else if(nums[j] + nums[i] < x){
                j++;
            }else{
                i--;
            }
        }
        System.out.println(answer);
        
    }
}
