package BinaryTree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    String content = "i like like like java do you like a java";
	    //将字符以byte形式存放成一个数组
        //通过调用getBytes直接实现
        byte[] contentByte = content.getBytes();
//        //System.out.println(contentByte[0]);
//        System.out.println(contentByte.length);//40个字符
//        //创建Huffman所需要的Node
//        List<Node> nodes = getNodeList(contentByte);
//        System.out.println(nodes);
//
//        System.out.println("测试一下Huffman tree是否建立～");
//        Node root = createHuffmanTree(nodes);
//
//        root.preOrder();
//
//        //测试一下是否生成了对应的Huffman codes
//        getHuffmanCodes(root,"",stringBuilder);
//        System.out.println(Huffmancodes);
//        //得到Huffman 编码表
//        getHuffmanCodes(root);
//        System.out.println(Huffmancodes);
//
//        //根据Huffman编码表重写content数组
//        //每8bits 一位，形成一个新的byte 数组
//        System.out.println("HuffmanByteArray = "+ Arrays.toString(HuffmanByteArray(Huffmancodes,contentByte)));
        //为了调用方便，将获取Huffman编码数组的所有方法封装
        System.out.println(Arrays.toString(getHuffmanArray(contentByte)));

    }
    private static byte[] getHuffmanArray(byte[]contentByte){
        //创建Huffman所需要的Node
        List<Node> nodes = getNodeList(contentByte);
        //生成Huffman Tree
        Node root = createHuffmanTree(nodes);
        //得到Huffman 编码表
        Map<Byte,String>HFcode = getHuffmanCodes(root);
        //生成Huffman Array
        byte[] res = HuffmanByteArray(HFcode,contentByte);

        return res;
    }




//为了调用方便，重载getHuffmanCodes
    private static Map<Byte,String> getHuffmanCodes(Node root){
        if(root == null){
            System.out.println("传入的Huffman是空～");
        }
        else
        {
            getHuffmanCodes(root,"",stringBuilder);
        }
        return Huffmancodes;
    }
    //Huffman 编码表
    static Map<Byte,String>Huffmancodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

//编写一个方法，使准备构建Huffman tree的Node 存放到一个list中
//形如：[Node[date = 97,weight = 5], Node[date = 32, weight = 9]....]

    /**
     *
     * @param contentByte 字节数组
     * @return list
     */
    public static List<Node> getNodeList(byte[]contentByte){

        //建立一个list准备存放最后结果
        ArrayList<Node> nodes = new ArrayList<>();
        //遍历byte数组，统计每一个byte出现的次数，用map操作
        //键：字符 值：出现次数
        Map<Byte,Integer> map = new HashMap<>();
        for(byte b: contentByte){
            Integer value = map.get(b);
            if(value == null){//如果map里没有这个键
                map.put(b,1);
            }
            else {
                map.put(b,value+1);
            }
        }
        //将map中的键值对转换成Node 并存放到list中
        //遍历map
        for(Map.Entry<Byte,Integer> entry:map.entrySet())
        {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;

    }

    //通过已有的List来创建Huffman tree
    public static Node createHuffmanTree(List<Node> nodeList){
        while(nodeList.size() > 1){
            Collections.sort(nodeList);
            Node leftNode = nodeList.get(0);
            Node rightNode = nodeList.get(1);

            Node parent = new Node(null,leftNode.weight + rightNode.weight);
            parent.right = rightNode;
            parent.left = leftNode;

            nodeList.remove(0);
            nodeList.remove(0);
            nodeList.add(parent);
        }
        return nodeList.get(0);
    }

    //根据Huffman Tree 写一个方法生成 Huffman 编码表
    //以Map的形式存放Huffman编码表，键：Byte 值：String
    //形如：


    /**
     *
     * @param root Huffman Tree的根结点
     * @param code 规定：左路径code=0； 右路径code=1；
     * @param stringBuilder 积累code，成为路径
     */

    public static void getHuffmanCodes(Node root, String code, StringBuilder stringBuilder){
        //将传入的code 续到stringBuilder上
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(root != null){
            //判断root结点是叶子结点还是非叶子结点
            if(root.data == null){
                //说明是非叶子结点
                getHuffmanCodes(root.left,"0",stringBuilder1);
                getHuffmanCodes(root.right,"1",stringBuilder1);
            }
            else
            {
                Huffmancodes.put(root.data,stringBuilder1.toString());
            }
        }
    }

    /**
     *
     * @param HuffmanCodes Huffman 编码表，根据byte找到其对应的编码
     * @param contentByte 原始数组
     * @return 根据Huffman编码写成的新的数组
     */
    public static byte[] HuffmanByteArray(Map<Byte,String>HuffmanCodes, byte[]contentByte){
        //遍历原始数组，将得到的code写入到一个Stringbuilder中
        StringBuilder stringBuilder = new StringBuilder();
        for(byte b: contentByte){
            stringBuilder.append(HuffmanCodes.get(b));
        }
        //将stringBuilder每8位，换成一个byte，存放到结果数组中
        //该数组的长度为stringBuilder / 8(整除） 或者为stringBuilder / 8 + 1 (不能整除）
        int length = 0;
        if(stringBuilder.length() % 8 == 0){
            length = stringBuilder.length() / 8;
        }else {
            length = stringBuilder.length() / 8 + 1;
        }

        byte[]res = new byte[length];
        int index = 0;
        //8位 遍历stringbuilder，将每次遍历的结果（string)换成byte存放在结果数组中
        for(int i = 0; i < stringBuilder.length(); i=i+8){
            String temp = "";
            if(i + 8 < stringBuilder.length()){
                temp = stringBuilder.substring(i,i+8);
            }
            else{
                temp = stringBuilder.substring(i);
            }
            byte tempByte = (byte)Integer.parseInt(temp,2);
            res[index] = tempByte;
            index++;
        }
        return res;
    }




}


