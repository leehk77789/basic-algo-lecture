import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CH_1021 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Deque<Integer> queue = new LinkedList<>();
    static int result;
    static int[] irr;

    public static void main(String[] args) throws IOException {
        String s[] = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        irr = new int[M];

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        String input[] = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            irr[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < M; i++) {
            findElement(irr[i]);
        }

        System.out.println(result);
    }

    static void findElement(int target) {
        int left = 0;
        int right = 0;
        Deque<Integer> firstCopyQueue = new LinkedList<>(queue);
        Deque<Integer> secondCopyQueue = new LinkedList<>(queue);

        while (queue.peekFirst() != target) {

            while (firstCopyQueue.peekFirst() != target) {
                left++;
                firstCopyQueue.offerLast(firstCopyQueue.pollFirst());
            }
            while (secondCopyQueue.peekFirst() != target) {
                right++;
                secondCopyQueue.offerFirst(secondCopyQueue.pollLast());
            }

            if (left > right) {
                queue = new LinkedList<>(firstCopyQueue);
                result += right;
            } else {
                queue = new LinkedList<>(secondCopyQueue);
                result += left;
            }
        }
        queue.pollFirst();

    }
}
