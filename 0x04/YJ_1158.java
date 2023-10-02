import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class YJ_1158 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] input;
	static int count;
	static LinkedList<Integer> arr;
	static ListIterator<Integer> cursor;

	static void input() throws NumberFormatException, IOException {
		input = br.readLine().split(" ");
		arr = new LinkedList<Integer>();
		for (int i = 1; i <= Integer.parseInt(input[0]); i++) {
			arr.add(i);
		}
		cursor = arr.listIterator();
		count = 0;
	}

	static void find() {

		// 요소가 없을 때 까지 계속 뽑는다.
		while (arr.size() > 0) {
			// cursor가 끝까지 갔는지 아닌지 판단
			while (cursor.hasNext()) {

				// 해당 인덱스를 미리 지정해두고
				int idx = cursor.next();

				// 카운트 증가
				count++;

				// 카운트가 k번째 숫자라면
				if (count == Integer.parseInt(input[1])) {

					// 출력 양식을 위해 마지막 요소는 그냥 붙이고
					if (arr.size() == 1) {
						sb.append(idx);
					} else {
						// 마지막이 아닌 요소는 ", "를 붙이고, 카운트를 초기화해준다.
						sb.append(idx).append(", ");
						count = 0;
					}

					// 추가된 요소는 리스트에서 제거
					cursor.remove();
				}
			}

			// while문이 풀렸다는 것은, cursor가 끝까지 왔다는 것.
			// cursor를 처음으로 되돌린다.
			if (arr.size() > 0) {
				cursor = arr.listIterator();
			}
		}
	}

	static void solve() throws NumberFormatException, IOException {
		input();
		sb.append("<");
		find();
		sb.append(">");
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}
