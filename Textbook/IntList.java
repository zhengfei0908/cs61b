public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        r = rest;
    }

    public void addAdjacent(){
        IntList p = this;
        while (true) {
            while (p.rest != null && p.first == p.rest.first) {
                p.first *= 2;
                p.rest = p.rest.rest;
            }
            if (p.rest == null) {
                break;
            } else {
                p = p.rest;
            }
        }
    }

    public static void main(String[] args) {
        IntList L = new IntList(1,null);
        L.rest = new IntList(2, null);
        L.rest.rest = new IntList(2, null);
        L.rest.rest.rest = new IntList(4, null);
        L.addAdjacent();
        System.out.println(L.first);
    }
}