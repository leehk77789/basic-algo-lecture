import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CH_3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int n = Integer.parseInt(br.readLine());
        String [] a = br.readLine().split(" ");
        int []irr = new int[n];
        for(int i=0; i<n; i++) {

            irr[i] = Integer.parseInt(a[i]);
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(irr);
        for (int i=0; i<irr.length-1; i++ ) {
             for (int j=i+1;j<irr.length;j++ ) {
               if (irr[i]+ irr[j] > x ) {
                   break;
               }
               else if (irr[i] + irr[j] == x) {
                   count +=1;
               }
            }
        }
        System.out.println(count);
    }
}
