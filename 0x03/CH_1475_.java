import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CH_1475_ {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int middle[] = new int[10];
        String a = br.readLine();
        a = a.replace("9","6");
        int max = 0;
        for (int i = 0; i < a.length(); i++) {
            int k = a.charAt(i) - '0';
            middle[k]++;
        }

        middle[6] = (middle[6]+1) / 2;

        for(int i=0; i<middle.length;i++) {
            if(middle[i] > max) {
                max = middle[i];
            }
        }

        System.out.println(max);




    }

}
