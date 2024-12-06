public class runner{
    public static void main(String[] args) {
        StringLL linked = new StringLL();
        linked.setup();
        linked.print();
        System.out.println("");
        linked.removeFirst5();
        linked.print();
    }
}