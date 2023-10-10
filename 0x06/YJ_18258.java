import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YJ_18258 {
	static int[] arr = new int[2000000];
	static int front = -1, rear = -1, size = 0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int num = Integer.parseInt(br.readLine());
		String[] input;

		for (int i = 1; i <= num; i++) {
			input = br.readLine().split(" ");
			if (input[0].equals("push")) {
				push(Integer.parseInt(input[1]));
			} else if (input[0].equals("pop")) {
				sb.append(pop() + "\n");
			} else if (input[0].equals("size")) {
				sb.append(size() + "\n");
			} else if (input[0].equals("empty")) {
				sb.append(isEmpty() + "\n");
			} else if (input[0].equals("front")) {
				sb.append(front() + "\n");
			} else {
				sb.append(back() + "\n");
			}
		}
		System.out.println(sb);
	}

	// enQueue(item) : 삽입
	static void push(int item) {
		arr[++rear] = item;
		size++;
	}

	// deQueue : 삭제
	static int pop() {
		if (front == rear) { // 큐가 비어있다면
			return -1;
		} else {
			int temp = arr[front + 1]; // 임시 변수에다가 현재 가장 앞에 있는 원소 저장
			size--;
			front++;
			// 삭제 원소를 반환
			return temp;
		}
	}

	// peek : 가장 첫번째 원소 확인(삭제 x, 반환 o)
	static int front() {
		if (front == rear) {
			return -1;
		} else {
			return arr[front + 1]; // 삭제하지 않고, 현재 첫번째 원소를 반환
			// front+1 : 현재 첫번째 원소의 idx
		}
	}

	static int back() {
		if (front == rear) {
			return -1;
		} else {
			return arr[rear]; // 삭제하지 않고, 현재 첫번째 원소를 반환
			// front+1 : 현재 첫번째 원소의 idx
		}
	}

	// isEmpty : 큐가 비어있는지
	public static int isEmpty() {
		if (front == rear) {
			return 1;
		}
		return 0;
	}

	// size : 현재 큐의 원소의 개수 ??
	public static int size() {
		return size;
	}
}
