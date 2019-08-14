package HashTable;


//生成一个LL用于存放每个Node
//需要一个头指针指向第一个Node
class EmployeeLL {
    private Employee head;//头指针默认为空

    //需要一个add来添加雇员
    //默认加入的雇员在LL最后一位
    public void add(Employee emp) {
        //此时加入第一个Node
        if(head == null)
        {
            head = emp;
            return;
        }
        //此时已有其他Node，需要遍历到最后一位并加入该Node
        //需要一个辅助指针
        Employee temp = head;
        while(true)
        {
            if(temp.next == null)
            {
                temp.next = emp;
                break;
            }
            temp = temp.next;
        }
    }

    //print 函数打印所有雇员信息
    public void print(){
        //如果是空，直接退出
        if(head == null)
        {
            System.out.println("当前链表为空～");
            return;
        }
        //需要辅助指针遍历
        Employee temp = head;
        while(true)
        {
            if(temp.next == null)
            {
                break;
            }
            System.out.printf("Name:%s ID: %d\t",temp.name,temp.id);
            temp = temp.next;
        }
        System.out.printf("Name:%s ID: %d\t ",temp.name,temp.id);
        System.out.println();
//        System.out.println("Name: " +temp.name+" ID: " + temp.id);

    }
    //查找一个雇员 根据ID
    public void find(int id){
        Employee temp = head;
        while(temp != null){
            if(temp.id == id){
                System.out.printf("该雇员ID：%d name: %s\n",temp.id,temp.name);
                break;
            }
            temp = temp.next;
        }
        if(temp == null)
        {
            System.out.println("没有找到该雇员～");
        }
    }
    //删除一个雇员
    public void delete(int id){
        Employee temp = head;
        Employee cur = head.next;
        while(cur != null){
            if(temp.id == id){
                head = cur;//
                break;
            }
            else if(cur.id == id){
                temp.next = cur.next;
                break;
            }
            temp = cur;
            cur = cur.next;
        }
        if(temp.id == id){
            temp.next = null;
        }
    }


}
