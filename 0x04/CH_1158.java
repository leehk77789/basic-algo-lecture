import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node {
        public Integer data;
        public Node next;
        public Node(Integer data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        List<Integer> result = new ArrayList<>();

        Node head = null;
        Node tail = null;

        for (int i = 1; i <= a; i++) {
            Node newNode = new Node(i);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        tail.next = head; // 마지막 노드와 첫 번째 노드 연결

        Node current = head;
        Node prev = tail; // 이전 노드를 리스트의 마지막 노드로 초기화

        while (result.size() < a) {
            for (int i = 1; i < b; i++) {
                prev = current;
                current = current.next;
            }
            result.add(current.data);

            // 현재 노드를 삭제하고 다음 노드로 이동
            prev.next = current.next;
            current = current.next;
        }


        System.out.print("<");
        for (int i = 0; i < a - 1; i++) {
            System.out.print(result.get(i) + ", ");
        }
        System.out.println(result.get(a - 1) + ">");
    }
}