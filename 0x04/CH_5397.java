import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class CH_5397 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N>0) {

            String s = br.readLine();

            List<Character> keyList = new LinkedList<>();
            ListIterator<Character> iterator = keyList.listIterator();
            for (char ele : s.toCharArray()) {
                if (ele == '<') {
                    if(iterator.hasPrevious()){
                        iterator.previous();
                    }
                } else if(ele == '>') {
                    if (iterator.hasNext()){
                        iterator.next();
                    }
                } else if(ele == '-') {
                    if(iterator.hasPrevious()){
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    iterator.add(ele);
                }
            }


            for(char c: keyList) {
                sb.append(c);
            }

            sb.append("\n");
            N--;
        }


        System.out.print(sb);
    }
}
