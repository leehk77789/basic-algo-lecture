import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>(); 
		
		int n = Integer.parseInt(br.readLine());
		String[] starr = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(starr[i]);
		}
		
		for(int i = 0; i < n ; i++){
			while(!st.empty()){
				if(arr[st.peek()] < arr[i]){
					st.pop();
				} 
				else if(arr[st.peek()] >= arr[i]) {
					sb.append(st.peek() + 1).append(" ");
					if(arr[st.peek()] == arr[i]) st.pop();
					break;
				}
			}
			if(st.empty()){
				sb.append(0).append(" ");
			}
			st.add(i);
		}
		System.out.println(sb.substring(0,sb.length()-1));
        br.close();
	}
}
