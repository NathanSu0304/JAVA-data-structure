package LLprac;

public class SLList {
    private class inNode{
        public int num;
        public inNode next;
        public inNode(int num, inNode next){
            this.num = num;
            this.next = next;
        }
    }

    inNode next;
    private inNode first = new inNode(0 ,next);


    public void addFirst(int i){
        first = new inNode(i,first);
    }
    public void add(int i){
        inNode temp = first;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.num = i;
        temp.next = new inNode(-1,next);


    }

    public void insert(int item, int position){
        //VersionII
        if(first == null || position == 0){
            addFirst(item);
            return;
        }
        inNode temp = first;
        while(position > 1 && temp.next != null){
            position--;
            temp = temp.next;
        }
        inNode newItem = new inNode(item,temp.next);
        temp.next = newItem;


        /*Version I
        inNode temp = first;
        for(int i = 0; i < position; i++){
            temp = temp.next;
        }
        inNode cur = temp;
        temp.next = new inNode(cur.num, cur.next);
        temp.num = item;*/

    }

    //reverse
    public void revese(){
        inNode temp = first;
        int step = 1;
        while(temp.next.num != -1){
            temp = temp.next;
            step++;
        }
        while(true){
            inNode cur = first;
            if(step == 1){
                System.out.printf("%d",cur.num);
                break;
            }
            for(int i = 0; i < step - 1; i++){
                cur = cur.next;
            }
            System.out.printf("%d -> ",cur.num);
            step--;
        }




    }


    public void print(){
        inNode temp = first;
        while(temp.next != null){
            System.out.printf("%d -> ",temp.num);
            temp = temp.next;
        }
        System.out.printf("%d\n",temp.num);
        System.out.println("程序结束～");

    }


}
