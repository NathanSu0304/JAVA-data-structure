package LinkedList;

import java.util.Stack;

public class Main {


    public static void reverseHead(HeroNode head){
        if(head.next == null || head.next.next == null){
            return;
        }
        HeroNode reverseHead = new HeroNode(0,"","");
        HeroNode temp = head.next;
        HeroNode next = null;
        while(temp != null){
            //HeroNode next = temp.next;
            next = temp.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            temp = next;
        }
        head.next = reverseHead.next;
    }
    public static void reversePrint(HeroNode head){
        Stack<HeroNode> stack = new Stack<>();
        HeroNode temp = head.next;
        if(temp == null){
            return;
        }
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        while(stack.size() > 0)
        {
            System.out.println(stack.pop());
        }

    }






    /**
     *
     * @param head 链表头节点
     * @return 有效节点数， 不包括头节点
     */
    public static int getLength(HeroNode head){
        HeroNode temp = head.next;
        if(temp == null){
            return 0;
        }
        int length = 0;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     *
     * @param head 头节点
     * @param index 要找的倒数第几个位置
     * @return 该节点HeroNode
     */
    public static HeroNode getIndexHero(HeroNode head, int index){
        HeroNode temp = head.next;
        if(temp == null){
            //System.out.println("empty Linklist.");
            return null;
        }
        int length = getLength(head);
        if(index <= 0 || index > length){
            //System.out.println("invalid index.");
            return null;
        }
        else{
            for(int i = 0; i < length - index; i++){
                temp = temp.next;
            }
            return temp;
        }

    }

    public static void main(String[] args) {
        HeroNode item1 = new HeroNode(1,"宋江","及时雨");
        HeroNode item2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode item3 = new HeroNode(3,"吴用","智多星");
        HeroNode item4 = new HeroNode(4,"林冲","豹子头");

        singleLinkedList singleLinkedListDemo = new singleLinkedList();
        /*singleLinkedListDemo.add(item1);
        singleLinkedListDemo.add(item4);
        singleLinkedListDemo.add(item3);
        singleLinkedListDemo.add(item2);*/
        singleLinkedListDemo.addByHeroOrder(item1);
        singleLinkedListDemo.addByHeroOrder(item4);
        singleLinkedListDemo.addByHeroOrder(item3);
        singleLinkedListDemo.addByHeroOrder(item2);

        singleLinkedListDemo.list();
        System.out.println(getLength(singleLinkedListDemo.getHead()));

        //reverseHead(singleLinkedListDemo.getHead());
        //singleLinkedListDemo.list();

        System.out.println("测试反向打印～");
        reversePrint(singleLinkedListDemo.getHead());

        //System.out.println("After update:");
        //HeroNode newItem = new HeroNode(6,"小卢","玉麒麟牛逼");
        //singleLinkedListDemo.update(newItem);
        //singleLinkedListDemo.del(4);
        //singleLinkedListDemo.del(3);
        //singleLinkedListDemo.del(2);
        //singleLinkedListDemo.del(1);
        /*singleLinkedListDemo.list();
        System.out.println(getLength(singleLinkedListDemo.getHead()));
        HeroNode testNode = getIndexHero(singleLinkedListDemo.getHead(),3);
        System.out.println(testNode);*/


    }

    //define single linklist to manipulate HeroNode
    static class singleLinkedList{
        //初始化头节点，头节点不能动，不存放具体数据
        private HeroNode head = new HeroNode(0,"","");

        public HeroNode getHead() {
            return head;
        }

        public void add(HeroNode item){
            HeroNode temp = head;
            while(true){
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = item;

        }
        //显示链表
        public void list(){
            if(head.next == null){
                System.out.println("链表空。");
                return;
            }
            HeroNode temp = head.next;
            while(true){
                if(temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }

        }

        //add by heroOrder
        public void addByHeroOrder(HeroNode item){
            HeroNode temp = head;
            boolean flag =false;//判断添加的编号是否存在
            while(true){
                if(temp.next == null){
                    break;
                }
                else if(temp.next.num > item.num){
                    break;
                }
                else if(temp.next.num == item.num){//位置找到temp后面
                    flag = true;
                    break;
                }
                temp = temp.next;

            }
            if(flag){
                System.out.printf("the number %d has been added. can't not be added again.\n",item.num);
            }
            else{
                item.next = temp.next;
                temp.next = item;
            }
        }

        //根据编号修改信息
        //根据new item 的编号来修改
        public void update(HeroNode newItem){
            HeroNode temp = head;
            boolean flag = false;//check whether find that order
            while(true){
                if(temp.next == null){
                    break;
                }
                if(temp.next.num == newItem.num){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.next.name = newItem.name;
                temp.next.nickname = newItem.nickname;
            }
            else{
                System.out.printf("the %d hero is not found.\n",newItem.num);
            }
        }

        //根据输入数字删除其中元素
        public void del(int index){
            HeroNode temp = head;
            boolean flag = false;//check whether find the element
            while(true){
                if(temp.next == null){
                    break;
                }
                if(temp.next.num == index){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.next = temp.next.next;
            }
            else{
                System.out.printf("Did not find #%d hero.\n",index);
            }
        }
    }



    static class HeroNode{
        public int num;
        public String name;
        public String nickname;
        public HeroNode next;

        //constructor
        public HeroNode(int hnum, String hname, String hnickname){
            num = hnum;
            name = hname;
            nickname = hnickname;
        }

        public String toString(){
            return "HeroNode num = " + num + ", name " + name + ", nickname " + nickname;
        }
    }
}

