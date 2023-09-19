import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class YJ_3273 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int N;
	static int X;
	static int count;

	static void input() throws NumberFormatException, IOException {
		// count 초기화
		count = 0;

		// N
		N = Integer.parseInt(br.readLine());

		// 숫자 배열
		input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// x
		X = Integer.parseInt(br.readLine());
	}

	static void find() {
		// input 크기순대로 정렬
		Arrays.sort(input);

		// i는 배열 첫번째부터 끝 - 2까지 순회
		// j는 i의 다음자리부터 끝까지 순회
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = i + 1; j < input.length; j++) {
				// 정렬시켜놨기 때문에 2개의 합이 X보다 커진순간 해당 i번째 자리는 더 볼 필요가 없다.
				if (input[i] + input[j] > X) {
					break;
					// 만약 X와 크기가 같다면 카운트.
				} else if (input[i] + input[j] == X) {
					count++;
				}
			}
		}

		sb.append(count);
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
