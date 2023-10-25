import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class YJ_3986 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String input;
	static Stack<Character> arr;
	static int count;

	static void input() throws NumberFormatException, IOException {
		arr = new Stack<Character>();
		input = br.readLine();
	}

	static void find() {
		arr.push(input.charAt(0));
		for (int i = 1; i < input.length(); i++) {
			if (arr.isEmpty()) {
				arr.push(input.charAt(i));
			} else if (input.charAt(i) != arr.peek()) {
				arr.push(input.charAt(i));
			} else {
				arr.pop();
			}
		}
		if (arr.isEmpty()) {
			count++;
		}
	}

	static void solve() throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		count = 0;
		for (int i = 1; i <= tc; i++) {
			input();
			find();
		}
		System.out.println(count);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}
