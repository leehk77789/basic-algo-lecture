import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class YJ_5430 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String input;
	static Deque<Integer> deq;

	static String[] s;

	// p
	static String hamsu;

	// n
	static int size;

	static boolean isR;

	static void input() throws NumberFormatException, IOException {
		deq = new LinkedList<Integer>();
		hamsu = br.readLine();

		try {
			size = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			size = 0;
		}

		isR = false;

		if (size != 0) {

			input = br.readLine();

			String tmp = input.substring(1, input.length() - 1);

			s = tmp.split(",");

			for (int i = 0; i < s.length; i++) {
				deq.add(Integer.parseInt(s[i]));
			}
		}
	}

	static void find() {
		for (int i = 0; i < hamsu.length(); i++) {
			if (hamsu.charAt(i) == 'R') {
				R();
			} else {
				if (deq.size() == 0) {
					sb.append("error").append("\n");
					return;
				} else {
					D();
				}
			}
		}
		if (deq.size() > 0) {
			sb.append('[');
			if (!isR) {
				sb.append(deq.pollFirst());
				while (!deq.isEmpty()) {
					sb.append(',').append(deq.pollFirst());
				}
			} else {
				sb.append(deq.pollLast());
				while (!deq.isEmpty()) {
					sb.append(',').append(deq.pollLast());
				}
			}
			sb.append(']').append("\n");
		} else {
			sb.append("[]\n");
		}
	}

	static void R() {
		if (!isR) {
			isR = true;
		} else {
			isR = false;
		}
	}

	static void D() {
		if (!isR) {
			deq.pollFirst();
		} else {
			deq.pollLast();
		}
	}

	static void solve() throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			input();
			find();
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}
