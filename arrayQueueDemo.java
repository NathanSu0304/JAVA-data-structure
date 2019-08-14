import java.util.Scanner;

public class arrayQueueDemo{
	public static void main(String[] args){
		ArrayQueue testArray = new ArrayQueue(3);
		Scanner Scanner = new Scanner(System.in);
		while(true){
			System.out.println("s(show): 打印数组.");
			System.out.println("e(exit): exit the loop.");
			System.out.println("a(add): add an element.");
			System.out.println("g(get): get the element.");
			System.out.println("h(head): get the head element.");
			char key = Scanner.next().charAt(0);	//只接受用人字符
			switch(key){
				case 's':
					testArray.print();
					break;
				case 'a':
					System.out.println("Enter a number: ");
					int value = Scanner.nextInt();
					testArray.add(value);
					break;
				case 'g':
					try{
						int result = testArray.get();
						System.out.printf("the number obtained is %d\n",result);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'h':
					try{
						int result = testArray.headQueue();
						System.out.printf("the head element is %d\n", result);
					}catch(Exception e){
						System.out.println(e.getMessage());
					}
					break;
				case 'e':
					Scanner.close();
					break;
				default:
					break;
			}
		}


	}
}

// 使用数组模拟队列
class ArrayQueue{
	private int maxSize;
	private int front;
	private int rear;
	int [] in_array;// 	用来存数据
	public ArrayQueue(int size){
		maxSize = size;
		front = -1;//指向队列前一个位置
		rear = -1;//指向队列尾
		in_array = new int [maxSize];
	}
	public boolean isFull(){
		return rear == maxSize - 1;
	}
	public boolean isEmpty(){
		return rear == front;
	}
	public void add(int num){
		if(isFull()){
			System.out.println("array is full already.");
			return;
		}
		rear++;
		in_array[rear] = num;
	}
	public int get(){
		if(isEmpty()){
			throw new RuntimeException("array is empty, can't get element.");
		}
		front++;
		return in_array[front];
	}
	public void print(){
		if(isEmpty()){
			System.out.println("array is empty, can't get element.");
			return;
		}
		for(int i = 0; i < maxSize; i++){
			System.out.printf("arr[%d] = %d\n", i, in_array[i]);
		}
	}

	public int headQueue(){
		if(isEmpty()){
			throw new RuntimeException("array empty， can't get element!");
		}
		front++;
		return in_array[front];

	}
}