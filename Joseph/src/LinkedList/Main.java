package LinkedList;

public class Main {


    public static void main(String[] args) {
	    //构建环形列表
        //显示环形列表
        CircleSingleLL circleSingleLLDemo = new CircleSingleLL();
        circleSingleLLDemo.addBoy(125);
        circleSingleLLDemo.showCircleLL();

        circleSingleLLDemo.outCircle(10,20,125);//2->4->1->5->3




    }
    //创建一个环形单向列表
    static class CircleSingleLL{
        //创建first节点，当前没有编号
        private Boy first = null;
        //添加小孩节点，构建成环形列表
        //传入数字确定这个环形列表有几个小孩
        public void addBoy(int nums){
            //nums 的数据校验
            if(nums < 1){
                System.out.println("nums 值不正确～");
                return;
            }
            //使用for循环来创建环形列表
            Boy curBoy = first;
            for(int i = 1; i <= nums; i++){
                Boy boy = new Boy(i);
                //如果是第一个小孩，需要先闭合成环
                if(i == 1){
                    first = boy;
                    curBoy = first;
                    curBoy.setNext(first);
                }
                else
                {
                    curBoy.setNext(boy);
                    curBoy = boy;
                    curBoy.setNext(first);
                }

            }

        }

        //遍历当前所有元素
        public void showCircleLL() {
            //判断是否为空
            if (first == null) {
                System.out.println("链表为空～");
                return;
            }
            //因为first不能动，仍然需要辅助指针完成遍历
            Boy curBoy = first;
            while(curBoy.getNext() != first){
                System.out.printf("小孩的编号：%d\n",curBoy.getNum());
                curBoy = curBoy.getNext();//curBoy 后移一位
            }
            System.out.printf("小孩的编号：%d\n",curBoy.getNum());

        }
        //出圈函数

        /**
         *
         * @param startNum 开始的位置
         * @param countNum 查几次
         * @param total 一共几个小孩
         */
        public void outCircle(int startNum, int countNum, int total){
            //check validation of para
            if(first == null || startNum > total || countNum < 0){
                System.out.println("invalid parameters~");
                return;
            }
            //set up helper which points to the former node of first
            //删除元素，辅助指针位于带删除元素的前一个位置
            //and helper moves with first
            Boy helper = first;
            while(helper.getNext() != first){//循环结束代表此时helper在first的前一位
                helper = helper.getNext();
            }
            //移动helper和first 到开始的位置，需要移动（starNum - 1）次
            for(int i = 0; i < startNum - 1; i++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //开始出圈
            while(true){
                if(helper == first){//此时圈中只剩一个小孩
                    break;
                }
                for(int i = 0; i < countNum - 1; i++){
                    first = first.getNext();
                    helper = helper.getNext();
                }
                System.out.printf("出圈小孩%d\n",first.getNum());
                first = first.getNext();
                helper.setNext(first);
            }
            System.out.printf("最后出圈小孩%d\n",helper.getNum());

        }


    }

    //表示一个节点
    static class Boy{
        private int num;//编号
        private Boy next;//指向下一个节点

        public Boy(int num){
            this.num = num;
        }

        public Boy getNext() {
            return next;
        }
        public Boy setNext(Boy next){
            return this.next = next;
        }
        public int getNum(){
            return this.num;
        }
        public int setNum(int num){
            return this.num = num;
        }
    }
}
