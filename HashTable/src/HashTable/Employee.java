package HashTable;

//这个class用于生成LL中的Node
class Employee {
    public String name;
    public int id;
    public Employee next;

    //constructor
    public Employee(String name,int id){
        this.name = name;
        this.id = id;
        this.next = null;
    }
}
