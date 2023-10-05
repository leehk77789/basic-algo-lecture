import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class YJ_10773 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int input;
	static Stack<Integer> callNum;
	static int answer;

	static void input() throws NumberFormatException, IOException {
		callNum = new Stack<Integer>();
		answer = 0;
		int count = Integer.parseInt(br.readLine());

		// k만큼 정수를 받아서
		for (int i = 1; i <= count; i++) {
			input = Integer.parseInt(br.readLine());

			// 0이 아니면 스택에 넣고
			if (input != 0) {
				callNum.add(input);
				// 0이면 스택의 맨 윗값 제거
			} else {
				callNum.pop();
			}
		}
	}

	static void find() {
		// 남은 스택은 정확하게 부른 숫자이므로
		// 스택의 내용물이 존재할때까지 pop해서 총 숫자를 더해준다.
		while (!callNum.isEmpty()) {
			answer += callNum.pop();
		}
		sb.append(answer);
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
