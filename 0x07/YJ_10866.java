import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YJ_10866 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] input;
	static int front;
	static int back;
	static int size;
	static int count;
	static int[] deque;

	static void input() throws NumberFormatException, IOException {
		count = Integer.parseInt(br.readLine());
		deque = new int[10000];
	}

	static void find() throws IOException {
		for (int i = 1; i <= count; i++) {
			input = br.readLine().split(" ");
			switch (input[0]) {
			case "push_front":
				pushFront(Integer.parseInt(input[1]));
				break;
			case "push_back":
				pushBack(Integer.parseInt(input[1]));
				break;
			case "pop_front":
				popFront();
				break;
			case "pop_back":
				popBack();
				break;
			case "size":
				size();
				break;
			case "empty":
				empty();
				break;
			case "front":
				front();
				break;
			case "back":
				back();
				break;
			}
		}
	}

	static void pushFront(int x) {
		// 원소를 먼저 넣은 뒤 front을 감소시킨다.
		deque[front] = x;
		// 음수가 되지 않도록 배열 크기만큼 더해준다.
		front = (front - 1 + 10000) % 10000;
		size++;
	}

	static void pushBack(int x) {
		/*
		 * deque[9999] 까지 꽉 찼을 경우 0으로 가리키기 위해 배열 크기만큼 나눠 나머지를 구한다.
		 */
		back = (back + 1) % 10000;
		size++;
		deque[back] = x;
	}

	static void popFront() {
		if (size == 0) {
			sb.append("-1").append("\n");
		} else {
			int ret = deque[(front + 1) % 10000];
			front = (front + 1) % 10000;
			size--;
			sb.append(ret).append("\n");
		}
	}

	static void popBack() {
		if (size == 0) {
			sb.append("-1").append("\n");
		} else {
			int ret = deque[back];
			back = (back - 1 + 10000) % 10000;
			size--;
			sb.append(ret).append("\n");
		}
	}

	static void size() {
		sb.append(size).append("\n");
	}

	static void empty() {
		if (size == 0) {
			sb.append("1").append("\n");
		} else {
			sb.append("0").append("\n");
		}
	}

	static void front() {
		if (size == 0) {
			sb.append("-1").append("\n");
		} else {
			sb.append(deque[(front + 1) % 10000]).append("\n");
		}
	}

	static void back() {
		if (size == 0) {
			sb.append("-1").append("\n");
		} else {
			sb.append(deque[back]).append("\n");
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
