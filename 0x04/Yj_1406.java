// cursor를 index로 문제를 푸니 시간 초과 발생

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Yj_1406 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static LinkedList<Character> editor = new LinkedList<>();
	static int count;
	static ListIterator<Character> cursor;

	static void input() throws IOException {
		String inputStr = br.readLine();

		// linkedlist에 받은 데이터 넣어주기
		for (char ch : inputStr.toCharArray()) {
			editor.add(ch);
		}

		// 명령어 횟수
		count = Integer.parseInt(br.readLine());

		// 해당 링크드 리스트에 대한 커서 지정
		cursor = editor.listIterator();

		// 링크드 리스트 끝까지 커서 이동
		while (cursor.hasNext()) {
			cursor.next();
		}
	}

	static void find() throws IOException {
		for (int i = 1; i <= count; i++) {
			String[] input = br.readLine().split(" ");
			// 입력받은 명령에 대한 처리
			if (input[0].equals("L")) {
				L();
			} else if (input[0].equals("D")) {
				D();
			} else if (input[0].equals("B")) {
				B();
			} else {
				P(input[1]);
			}
		}
		for (char ch : editor) {
			sb.append(ch);
		}
	}

	// L이면 맨 왼쪽인지 확인하고 왼쪽으로 이동
	static void L() {
		if (cursor.hasPrevious()) {
			cursor.previous();
		}
	}

	// D이면 맨 오른쪽인지 확인하고 오른쪽으로 이동
	static void D() {
		if (cursor.hasNext()) {
			cursor.next();
		}
	}

	// B이면 맨 왼쪽인지 확인하고 해당 커서 자리에 있는 문자 삭제
	static void B() {
		if (cursor.hasPrevious()) {
			cursor.previous();
			cursor.remove();
		}
	}

	// P이면 해당 커서에 문자 추가
	static void P(String str) {
		cursor.add(str.charAt(0));
	}

	static void solve() throws IOException {
		input();
		find();
		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		solve();
	}
}
