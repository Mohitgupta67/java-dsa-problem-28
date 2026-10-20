class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;

    }
}

public class LL {
    Node head = null;

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void reverseTill(int k) {
        if (head == null || k <= 1) {
            return;
        }

        Node current = head;
        Node previousGroupEnd = null;
        Node newHead = null;

        while (current != null) {
            Node groupStart = current;
            Node temp = current;

            int count = 0;

            while (temp != null && count < k) {
                temp = temp.next;
                count++;
            }

            if (count < k) {
                if (previousGroupEnd != null) {
                    previousGroupEnd.next = current;
                }
                break;
            }

            Node previous = null;
            count = 0;

            while (current != null && count < k) {
                Node nextNode = current.next;
                current.next = previous;
                previous = current;
                current = nextNode;
                count++;
            }

            if (newHead == null) {
                newHead = previous;
            }

            if (previousGroupEnd != null) {
                previousGroupEnd.next = previous;
            }

            previousGroupEnd = groupStart;
        }

        head = newHead;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String args[]) {
        LL list = new LL();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);

        System.out.println("list before operation");
        list.printList();

        System.out.println("list after operation");
        list.reverseTill(4);
        list.printList();
    }

}