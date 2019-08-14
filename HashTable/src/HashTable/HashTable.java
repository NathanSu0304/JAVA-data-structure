package HashTable;

//用于管理多条列表
public class HashTable {
    static int hashSize = 7;
    //创建一个数组，每个数组存放一个LL
    public static EmployeeLL[] hashEmployLL;

    public HashTable(){
        hashEmployLL = new EmployeeLL[hashSize];
        //编列array，每个位置都initialize 一个linklist
        for(int i = 0; i< hashSize;i++)
        {
            hashEmployLL[i] = new EmployeeLL();
        }
    }
    //需要一个散列函数将ID分散到不同的ll
    public static int hashfun(int id){
        return id % hashSize;
    }
    //add 函数加雇员信息
    public static void add(Employee emp){
        int index = hashfun(emp.id);
        hashEmployLL[index].add(emp);
    }
    //遍历
    public static void print(){
        for(int i = 0; i< hashSize;i++){
            hashEmployLL[i].print();
        }
    }
    public static void find(int id){
        int index = hashfun(id);
        hashEmployLL[index].find(id);
    }
    public static void delete(int id){
        int index = hashfun(id);
        hashEmployLL[index].delete(id);
    }




}
