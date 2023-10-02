import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class YJ_10828 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] input;
	static int order;
	static List<Integer> arr;

	static void input() throws NumberFormatException, IOException {
		order = Integer.parseInt(br.readLine());
		arr = new ArrayList<Integer>();
	}

	static void find() throws IOException {
		for (int i = 1; i <= order; i++) {
			input = br.readLine().split(" ");
			if (input[0].equals("push")) {
				push(Integer.parseInt(input[1]));
			} else if (input[0].equals("pop")) {
				pop();
			} else if (input[0].equals("size")) {
				size();
			} else if (input[0].equals("empty")) {
				empty();
			} else {
				top();
			}
		}
	}

	static void push(int x) {
		arr.add(x);
	}

	static void pop() {
		if (arr.size() == 0) {
			sb.append(-1).append("\n");
		} else {
			sb.append(arr.get(arr.size() - 1)).append("\n");
			arr.remove(arr.size() - 1);
		}
	}

	static void size() {
		sb.append(arr.size()).append("\n");
	}

	static void empty() {
		if (arr.size() == 0) {
			sb.append(1).append("\n");
		} else {
			sb.append(0).append("\n");
		}
	}

	static void top() {
		if (arr.size() == 0) {
			sb.append(-1).append("\n");
		} else {
			sb.append(arr.get(arr.size() - 1)).append("\n");
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
