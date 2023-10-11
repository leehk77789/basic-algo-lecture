import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		StringBuilder sb = new StringBuilder();

		Queue queue = new Queue();

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n ; i++){
			String[] arr = br.readLine().split(" ");
			switch(arr[0]){
				case "push":queue.push(Integer.parseInt(arr[1])); 
							break;
				case "pop" :sb.append(queue.pop()).append("\n"); 
							break;
				case "size":sb.append(queue.size()).append("\n"); 
							break;
				case "empty":sb.append(queue.empty() ? 1 : 0).append("\n"); 
							break;
				case "front":sb.append(queue.front()).append("\n"); 
							break;
				case "back":sb.append(queue.back()).append("\n");
							break;
			}
		}
		System.out.println(sb.length() > 0 ? sb.substring(0,sb.length()-1) : "");
        br.close();
	}
}

class Queue{
	int[] arr;
	int head; 
	int tail;
	int MAX;
	
	Queue(){
		MAX = 2000000;
		this.arr = new int[MAX];
		this.head = 0;
		this.tail = 0;
	}

	void push(int n){
		arr[tail++] = n;
	}

	int pop(){
		int popValue = empty() ? -1 : arr[head++];
		return popValue;
	}

	int size(){
		return tail - head;
	}

	boolean empty(){
		return head == tail ? true : false;
	}

	int front(){
		return empty() ? -1 : arr[head];
	}

	int back(){
		return empty() ? -1 : arr[tail-1];
	}
}
