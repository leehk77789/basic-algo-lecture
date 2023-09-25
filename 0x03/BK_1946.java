import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); //테케 수 입력
        
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine()); //지원자 수 입력
            int[] docs = new int[n];      //서류등수 저장
            int[] interview = new int[n]; //면접등수 저장
            int answer = n;               //총 지원자 수
            
            //데이터 저장
            for(int j = 0; j < n; j++){
                String[] s = br.readLine().split(" ");
                docs[j] = Integer.parseInt(s[0]);
                interview[j] = Integer.parseInt(s[1]);
            }
            
            //최대 합격자 수 구하기
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(j == k) continue;
                    //둘 다 낮은 등수면 탈락
                    if(docs[j] > docs[k] && interview[j] > interview[k]){
                        answer--;
                        break;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
