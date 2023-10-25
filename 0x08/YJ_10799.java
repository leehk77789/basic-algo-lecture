import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class YJ_10799 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String input;
	static Stack<Character> arr;
	static int count;

	static void input() throws NumberFormatException, IOException {
		arr = new Stack<Character>();
		input = br.readLine();
		count = 0;
	}

	static void find() {
		for (int i = 0; i < input.length(); i++) {
			Character nowChar = input.charAt(i);
			if (nowChar == '(') {
				arr.push(nowChar);
			} else if (input.charAt(i - 1) == '(' && nowChar == ')') {
				arr.pop();
				count += arr.size();
			} else if (arr.peek() == '(' && nowChar == ')') {
				arr.pop();
				count++;
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
