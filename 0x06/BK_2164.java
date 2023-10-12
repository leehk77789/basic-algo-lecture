import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		int n = Integer.parseInt(br.readLine());
		Queue queue = new Queue(n);

		while(queue.size() != 1){
            queue.pop();
			queue.push(queue.pop());
		}

		System.out.println(queue.front());
    br.close();
	}
}

class Queue{
	int[] arr;
	int head; 
	int tail;
	int MAX;
	
	Queue(int n){
		MAX = 1000000;
		this.arr = new int[MAX];
		for(int i = 0; i < n; i++){
			arr[i] = i+1;
		}
		this.head = 0;
		this.tail = n;
	}

	void push(int n){
		arr[tail++] = n;
	}

	int pop(){
		return arr[head++];
	}

	int size(){
		return tail - head;
	}
	
	int front(){
		return arr[head];
	}
}
