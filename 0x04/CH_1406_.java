import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CH_1406_ {

    public static void main(String[] args) throws IOException {

        List<Character> charList = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        String s = br.readLine();

        int N = Integer.parseInt(br.readLine());
        for (char ele : s.toCharArray()) {
            charList.add(ele);
        }
        ListIterator<Character> iterator = charList.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }


        for (int i = 0; i < N; i++) {
            String[] x = br.readLine().split(" ");
            char a;
            char b = '\0';  // null문자 초기화
            if (x.length > 1) {
                a = x[0].charAt(0);
                b = x[1].charAt(0);
            } else {
                a = x[0].charAt(0);
            }

            if (a == 'P') {
                iterator.add(b);
            }
            else if(a == 'L') {
                if(iterator.hasPrevious()) {
                    iterator.previous();
                }
            }
            else if(a == 'D') {
                if(iterator.hasNext()) {
                    iterator.next();
                }
            }
            else {
                if(iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }
            }
        }
        for (char c : charList) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
