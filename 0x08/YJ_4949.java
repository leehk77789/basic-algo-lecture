import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class YJ_4949 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String input;
	static Stack<Character> arr;

	static void input() throws NumberFormatException, IOException {
	}

	static void find() {
		for (int i = 0; i < input.length(); i++) {
			char nowIdx = input.charAt(i);
			if (nowIdx == '(' || nowIdx == '[') {
				arr.push(nowIdx);
			} else if (nowIdx == ')') {
				if (arr.isEmpty() || arr.peek() != '(') {
					arr.push(nowIdx);
					break;
				} else if (arr.peek() == '(') {
					arr.pop();
				}
			} else if (nowIdx == ']') {
				if (arr.isEmpty() || arr.peek() != '[') {
					arr.push(nowIdx);
					break;
				} else if (arr.peek() == '[') {
					arr.pop();
				}
			}
		}
		if (arr.isEmpty()) {
			sb.append("yes").append("\n");
		} else {
			sb.append("no").append("\n");
		}
	}

	static void solve() throws NumberFormatException, IOException {
		arr = new Stack<Character>();
		while (true) {
			arr.clear();
			input = br.readLine();
			if (input.equals(".")) {
				break;
			}
			find();
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}
