import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class YJ_1021 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] input;
	static LinkedList<Integer> deq;
	static int count;
	static int size;
	static int[] target;
	static int targetIdx;
	static int halfIdx;

	static void input() throws NumberFormatException, IOException {
		deq = new LinkedList<Integer>();
		count = 0;
		targetIdx = 0;
		halfIdx = 0;
		input = br.readLine().split(" ");
		size = Integer.parseInt(input[0]);
		target = new int[Integer.parseInt(input[1])];
		for (int i = 1; i <= size; i++) {
			deq.add(i);
		}

		input = br.readLine().split(" ");

		for (int i = 0; i < target.length; i++) {
			target[i] = Integer.parseInt(input[i]);
		}
	}

	static void find() {
		for (int i = 0; i < target.length; i++) {
			targetIdx = deq.indexOf(target[i]);
			if (deq.size() % 2 == 0) {
				halfIdx = deq.size() / 2 - 1;
			} else {
				halfIdx = deq.size() / 2;
			}

			if (targetIdx <= halfIdx) {
				for (int j = 0; j < targetIdx; j++) {
					moveLeft();
				}
			} else {
				for (int j = 0; j < deq.size() - targetIdx; j++) {
					moveRight();
				}
			}
			deq.pollFirst();
		}
		sb.append(count);
	}

	static void moveLeft() {
		deq.addLast(deq.pollFirst());
		count++;
	}

	static void moveRight() {
		deq.addFirst(deq.pollLast());
		count++;
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
