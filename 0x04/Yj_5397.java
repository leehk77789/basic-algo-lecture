import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Yj_5397 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[] input;
	static LinkedList<Character> pw;
	static ListIterator<Character> cursor;

	static void input() throws NumberFormatException, IOException {
		pw = new LinkedList<Character>();
		input = br.readLine().toCharArray();
		cursor = pw.listIterator();
	}

	static void find() {
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '<') {
				Left();
			} else if (input[i] == '>') {
				Right();
			} else if (input[i] == '-') {
				Remove();
			} else {
				addChar(input[i]);
			}
		}

		for (char ch : pw) {
			sb.append(ch);
		}
		sb.append("\n");
	}

	// 왼쪽으로 갈 수 있으면 왼쪽
	static void Left() {
		if (cursor.hasPrevious()) {
			cursor.previous();
		}
	}

	// 오른쪽으로 갈 수 있으면 오른쪽
	static void Right() {
		if (cursor.hasNext()) {
			cursor.next();
		}
	}

	// 왼쪽으로 이동할 수 있는지 살펴보고
	// 가능하면 이동 후 해당 커서 부분 요소 삭제
	static void Remove() {
		if (cursor.hasPrevious()) {
			cursor.previous();
			cursor.remove();
		}
	}

	// 입력된 Char 추가
	static void addChar(Character ch) {
		cursor.add(ch);
	}

	static void solve() throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		for (int i = 1; i <= tc; i++) {
			input();
			find();
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}
