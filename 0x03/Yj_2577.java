import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yj_2577 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int num;
	static String input;
	static int[] arr;

	static void input() throws NumberFormatException, IOException {
		// 1부터 9까지의 숫자를 셀 배열 생성
		arr = new int[10];

		// 1을 시작으로 3개의 입력받은 숫자 곱하기
		num = 1;
		for (int i = 1; i <= 3; i++) {
			num *= Integer.parseInt(br.readLine());
		}

		// 숫자 -> 문자열
		input = Integer.toString(num);
	}

	static void find() {
		// 아스키코드 사용하여 배열 인덱스 증가
		for (int i = 0; i < input.length(); i++) {
			arr[input.charAt(i) - '0']++;
		}

		// 1~9까지 개수 카운트
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
	}

	static void solve() throws NumberFormatException, IOException {
		input();
		find();
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}
