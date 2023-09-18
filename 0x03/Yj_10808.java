import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yj_10808 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String input;
	static int[] arr;

	static void input() throws NumberFormatException, IOException {
		// 알파벳 개수만큼 배열 선언
		arr = new int[26];
		input = br.readLine();
	}

	static void find() {
		// 아스키코드 사용하여 배열의 인덱스의 값 증가시키기
		for (int i = 0; i < input.length(); i++) {
			arr[input.charAt(i) - 97]++;
		}
	}

	static void solve() throws NumberFormatException, IOException {
		input();
		find();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}
