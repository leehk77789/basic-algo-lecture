import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CH_10866 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        String[] input;

        for(int i=0; i<N; i++) {

            input = br.readLine().split(" ");

            if (input[0].equals("push_front")) {
                pushFront(Integer.parseInt(input[1]));
            }else if (input[0].equals("push_back")) {
                pushBack(Integer.parseInt(input[1]));
            }else if (input[0].equals("pop_front")) {
                sb.append(popFront()).append("\n");
            }else if (input[0].equals("pop_back")) {
                sb.append(popBack()).append("\n");
            }else if (input[0].equals("size")) {
                sb.append(size()).append("\n");
            }else if (input[0].equals("empty")) {
                sb.append(isEmpty()).append("\n");
            }else if (input[0].equals("front")) {
                sb.append(front()).append("\n");
            }else {
                sb.append(back()).append("\n");
            }


        }

        System.out.println(sb);

    }

    static void pushFront(int item) {
        deque.offerFirst(item);
    }

    static void pushBack(int item){
        deque.offerLast(item);
    }
    static int popFront() {
        if (deque.isEmpty()) {
            return -1;
        }
        else {
            return deque.pollFirst();
        }
    }
    static int popBack() {
        if (deque.isEmpty()) {
            return -1;
        }
        else{
            return deque.pollLast();
        }
    }
    static int size() {
        return deque.size();
    }

    static int isEmpty() {
        if (deque.isEmpty()) {
            return 1;
        }
        else{
            return 0;
        }
    }

    static int front() {
        if(deque.isEmpty()) {
            return -1;
        }
        else {
            return deque.peekFirst();
        }
    }

    static int back() {
        if(deque.isEmpty()) {
            return -1;
        }
        else {
            return deque.peekLast();
        }
    }
}
