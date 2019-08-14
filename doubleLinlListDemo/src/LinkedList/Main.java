package LinkedList;

public class Main {

    public static void main(String[] args) {
        System.out.println("双向列表的测试～");
        HeroNode2 item1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 item2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 item3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 item4 = new HeroNode2(4,"林冲","豹子头");
        doubleLinkListDemo testdoubleLL = new doubleLinkListDemo();
        /*testdoubleLL.add(item1);
        testdoubleLL.add(item2);
        testdoubleLL.add(item3);
        testdoubleLL.add(item4);
        testdoubleLL.list();

        HeroNode2 item5 = new HeroNode2(4,"公孙胜","入云龙");
        testdoubleLL.update(item5);
        System.out.println("修改后的列表～");
        testdoubleLL.list();
        System.out.println("删除后的列表～");
        testdoubleLL.del(3);
        testdoubleLL.list();*/
        System.out.println("按顺序添加～");
        testdoubleLL.addByHeroOrder(item4);
        testdoubleLL.addByHeroOrder(item2);
        testdoubleLL.addByHeroOrder(item1);
        testdoubleLL.addByHeroOrder(item3);
        testdoubleLL.list();


    }




    static class doubleLinkListDemo {
        //初始化头节点，头节点不能动，不存放具体数据
        private HeroNode2 head = new HeroNode2(0,"","");

        public HeroNode2 getHead() {
            return head;
        }

        public void list(){
            if(head.next == null){
                System.out.println("链表空。");
                return;
            }
            HeroNode2 temp = head.next;
            while(true){
                if(temp == null) {
                    break;
                }
                System.out.println(temp);
                temp = temp.next;
            }
        }

        public void add(HeroNode2 item){
            HeroNode2 temp = head;
            while(true){
                if(temp.next == null){
                    break;
                }
                temp = temp.next;
            }
            temp.next = item;
            item.pre = temp;

        }

        public void update(HeroNode2 newItem){
            HeroNode2 temp = head;
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

        public void del(int index){
            if(head.next == null){
                System.out.println("链表为空，不能删除。");
                return;
            }
            HeroNode2 temp = head.next;
            boolean flag = false;//check whether find the element
            while(true){
                if(temp == null){
                    break;
                }
                if(temp.num == index){
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(flag){
                temp.pre.next = temp.next;
                if(temp.next != null){
                    temp.next.pre = temp.pre;
                }

            }
            else{
                System.out.printf("Did not find #%d hero.\n",index);
            }
        }

        public void addByHeroOrder(HeroNode2 item){
            HeroNode2 temp = head;
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
                    if(temp.next == null){
                        item.next = temp.next;
                        item.pre = temp;
                        temp.next = item;
                    }
                    else{
                        temp.next.pre = item;
                        item.next = temp.next;
                        item.pre = temp;
                        temp.next = item;
                    }



            }
        }

    }

    static class HeroNode2{
        public int num;
        public String name;
        public String nickname;
        public HeroNode2 next;
        public HeroNode2 pre;



        //constructor
        public HeroNode2(int hnum, String hname, String hnickname){
            num = hnum;
            name = hname;
            nickname = hnickname;
        }

        public String toString(){
            return "HeroNode num = " + num + ", name " + name + ", nickname " + nickname;
        }
    }
}


