package stack;

//用LinkList 模拟栈
public class LLStack {
    public LLNode head = new LLNode(0);

    public void push(LLNode item){
        LLNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = item;
    }

    public int pop(){
        LLNode temp = head;
        LLNode helper = null;
        while(true){
            helper = temp.next;
            if(helper.next == null){
                temp.next = null;
                break;
            }
            temp = helper;
        }
        return temp.num;

    }


    public void print(){
        LLNode temp = head.next;
        int step = 1;
        while(temp != null){
            System.out.printf("Stack[%d] = %d\n",step,temp.num);
            step++;
            temp = temp.next;
        }
    }

}


