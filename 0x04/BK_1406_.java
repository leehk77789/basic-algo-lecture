import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        
        Stack<String> front = new Stack<>();
        Stack<String> back = new Stack<>();
        
        for(char c : s.toCharArray()){
            front.push(Character.toString(c));
        }
        
        for(int i = 0; i < n; i++){
            String command = br.readLine();
            switch(command.charAt(0)){
                case 'L': if(!front.empty()) back.push(front.pop()); break;
                case 'D': if(!back.empty()) front.push(back.pop()); break;
                case 'B': if(!front.empty()) front.pop(); break;
                case 'P': front.push(Character.toString(command.charAt(2))); break;
            }
        }
        StringBuilder sb = new StringBuilder();
        
        while(!front.empty()){
            back.push(front.pop());
        }
        
        while (!back.empty()){
            sb.append(back.pop());
        }
        System.out.println(sb.toString());
    }
}
