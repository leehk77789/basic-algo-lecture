import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class YJ_2164 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static Integer input;
	static Queue<Integer> q;

	static void input() throws NumberFormatException, IOException {
		q = new LinkedList<Integer>();

		input = Integer.parseInt(br.readLine());
	}

	static void find() {
		for (int i = 1; i <= input; i++) {
			q.add(i);
		}

		while (q.size() != 1) {
			q.poll();

			q.add(q.poll());
		}

		sb.append(q.poll());
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
