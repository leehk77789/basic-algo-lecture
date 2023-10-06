import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class YJ_1874 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int input;
	static Stack<Integer> num;
	static int count;
	static int basic;
	static boolean success;

	static void input() throws NumberFormatException, IOException {
		num = new Stack<Integer>();
		success = true;
		basic = 0;
		input = 0;
		count = Integer.parseInt(br.readLine());
	}

	static void find() throws NumberFormatException, IOException {
		for (int i = 1; i <= count; i++) {
			input = Integer.parseInt(br.readLine());

			if (input > basic) {
				for (int idx = basic + 1; idx <= input; idx++) {
					num.push(idx);
					sb.append("+").append("\n");
				}
				basic = input;
			} else if (num.peek() != input) {
				success = false;
				return;
			}
			num.pop();
			sb.append("-").append("\n");
		}
	}

	static void solve() throws NumberFormatException, IOException {
		input();
		find();
		if (success) {
			System.out.println(sb);
		} else {
			System.out.print("NO");
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}
