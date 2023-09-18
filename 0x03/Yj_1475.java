import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yj_1475 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] input;
	static int[] count = new int[10];

	static void input() throws NumberFormatException, IOException {
		input = br.readLine().split("");
	}

	static void find() {
		// 최대 필요한 세트
		int max = 0;

		// 최대값의 인덱스
		int idx = 0;

		// 전체를 순회하며 해당 숫자의 인덱스 증가시키기
		for (int i = 0; i < input.length; i++) {
			count[Integer.parseInt(input[i])]++;
		}

		// 최대값의 인덱스 찾기
		for (int i = 0; i <= 9; i++) {
			if (count[i] >= max) {
				idx = i;
			}
		}

		// 인덱스가 6이나 9이면
		// 홀수, 짝수 구분해서 6이나 9를 최대한 사용할 수 있게 재분배
		// 6, 9 위치는 상관없음
		if (idx == 6 || idx == 9) {
			int avg = count[6] + count[9];
			if (avg % 2 == 0) {
				count[6] = avg / 2;
				count[9] = avg / 2;
			} else {
				count[6] = avg / 2 + 1;
				count[9] = avg / 2;
			}
		}

		max = 0;

		// 재 분배 후 다시 세트 필요 개수 세기
		for (int i = 0; i <= 9; i++) {
			if (count[i] >= max) {
				max = count[i];
			}
		}

		sb.append(max);
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
