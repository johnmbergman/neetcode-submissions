class LinkedList {

    private static class Node {
        private Node next;
        private int val;
    }

    final Node root;

    public LinkedList() {
        root = new Node();
    }

    public int get(int index) {
        Node curr = root;
        int i = 0;
        while (curr.next != null) {
            curr = curr.next;
            if (i == index) {
                return curr.val;
            }
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        final Node newNode = new Node();
        newNode.next = root.next;
        newNode.val = val;
        root.next = newNode;
    }

    public void insertTail(int val) {
        Node curr = root;
        while (curr.next != null) {
            curr = curr.next;
        }
        final Node newNode = new Node();
        newNode.val = val;
        curr.next = newNode;
    }

    public boolean remove(int index) {
        Node curr = root;
        int i = 0;
        while (curr.next != null) {
            if (i == index) {
                curr.next = curr.next.next;
                return true;
            }
            curr = curr.next;
            i++;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        final ArrayList<Integer> vals = new ArrayList<>();
        Node curr = root;
        while (curr.next != null) {
            curr = curr.next;
            vals.add(curr.val);
        }
        return vals;
    }
}
