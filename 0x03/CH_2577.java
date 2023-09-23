import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CH_2577 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int irr[] = new int[10];

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int result = a*b*c;
        String str = Integer.toString(result);

        for (int i=0; i<str.length();i++) {
            int mid = str.charAt(i) - '0';
            irr[mid] +=1;
        }

        for(int num : irr) {
            System.out.println(num);
        }


    }
}
