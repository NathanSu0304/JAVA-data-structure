import java.util.Scanner;
public class circleArrayDemo{
    public static void main(String[] args){
    circleArray testArray = new circleArray(4);
    Scanner Scanner = new Scanner(System.in);
    while(true){
        System.out.println("s(show): 打印数组.");
        System.out.println("e(exit): exit the loop.");
        System.out.println("a(add): add an element.");
        System.out.println("g(get): get the element.");
        System.out.println("h(head): get the head element.");
        char key = Scanner.next().charAt(0);    //只接受用人字符
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


class circleArray{
        private int maxSize;
        private int front;
        private int rear;
        int [] in_array;//  用来存数据
        public circleArray(int size){
            maxSize = size;
            //front = 0;
            //rear = 0;
            in_array = new int[maxSize];
        }

        public boolean isFull(){
            return (rear + 1) % maxSize == front;
        }
        public boolean isEmpty(){
            return rear == front;
        }
        public void add(int number){
            if(isFull()){
                System.out.println("队列满。不能加入");
                return;
            }
            //rear 指向最后一位的下一位，所以可以将数字直接写入
            in_array[rear] = number;
            // rear 后移一位，必须通过module.
            rear = (rear + 1) % maxSize;
        }
        public int get(){
            if(isEmpty()){
                throw new RuntimeException("队列空，无法读出。");
            }
            //通过front读出
            int temp = in_array[front];
            front = (front + 1) % maxSize;
            return temp;
        }
        public int size(){
            return (rear - front + maxSize) % maxSize;
        }
        public void print(){
            if(isEmpty()){
                System.out.println("队列空，无法读出。");
                return;
            }
            for(int i = front; i < front + size(); i++){
                System.out.printf("arr[%d] = %d \n",i % maxSize,in_array[i % maxSize]);
            }
        }
        public int headQueue(){
            if(isEmpty()){
                throw new RuntimeException("队列空，无法读出。");
            }
            return in_array[front];

        }

    }



