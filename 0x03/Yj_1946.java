import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yj_1946 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] input;
	static int[] score;
	static int count;

	static void input() throws NumberFormatException, IOException {

		// count 초기화, 정렬 후, 첫번째 순서의 지원자는 무조건 합격
		count = 1;

		// 지원자의 숫자
		int N = Integer.parseInt(br.readLine());

		score = new int[N + 1];

		// 입력받은 값들을 넣어주자
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			score[Integer.parseInt(input[0])] = Integer.parseInt(input[1]);
		}
	}

	static void find() {

		// score 1번째의 지원자는 무조건 합격이기 때문에
		// 1번째 지원자를 기준으로 기준 생성
		int rank = score[1];

		// 0번째 인덱스가 비워져있고, 1번째는 count에 들어가 기준점으로 삼았으니
		// 2번째 부터 서치를 시작한다.
		// 만약 점수가 이전 지원자 보다 높다면, 기준 통과이므로 count를 증가시키고, 기준점을 재설정한다.
		for (int i = 2; i < score.length; i++) {
			if (score[i] < rank) {
				count++;
				rank = score[i];
			}
		}

		sb.append(count).append("\n");
	}

	static void solve() throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			input();
			find();
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}