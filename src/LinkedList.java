public class LinkedList <T> {

    //Nested Class Nodes
        private class Node<T> {
            private T content;
            private Node<T> nextNode;

            //Constructor
            public Node(T content, Node<T> nextNode) {
                this.content = content;
                this.nextNode = nextNode;
            }

            //Getter and Setters
            public T getContent() {
                return this.content;
            }
            public void setContent(T content) {
                this.content = content;
            }

            public Node<T> getNextNode() {
                return this.nextNode;
            }

            public void setNextNode(Node<T> nextNode) {
                this.nextNode = nextNode;
            }

        }

        private Node<T> head;
        private Node<T> tail;
        private int amountNodes;

        //Constructor der SinglyLinkedList
        public LinkedList() {
            this.head = null;
            this.tail = null;
            this.amountNodes = 0;
        }

        //GIbt zurück, wie viele Elemente in der Liste sind
        public int getSize() {
            return this.amountNodes;
        }

        //Gibt true zurück, falls keine Elemente in der Liste sind
        public boolean isEmpty() {
            return amountNodes == 0;
        }


        //Fügt eine Node am Anfang der Liste ein
        public void addAtFront(T content) {
            Node<T> newNode = new Node<T>(content, null);

            //Wenn die Liste leer ist, setzt nächste node auf null, head und tail auf newNode setzen
            if(isEmpty()) {
                head = newNode;
                tail = newNode;
                amountNodes++;
            } else {
                newNode.setNextNode(head);
                head = newNode;
                amountNodes++;
            }
        }

        //Fügt ein Element am Ende der Liste ein
        public void addAtEnd(T content) {
            Node<T> newNode = new Node<T>(content, null);

            if(isEmpty()) {
                addAtFront(content);
            } else {
                tail.setNextNode(newNode);
                tail = newNode;
            }
        }

        //Das erste Element (=erste Node) der Liste ausgeben
        public Node<T> getFirstElement() {
            if(isEmpty()) {
                return null;
            } else {
                return head;
            }
        }

        //Das letzte Element (=letzte Node) der Liste ausgeben
        public Node<T> getLastElement() {
            if(isEmpty()) {
                return null;
            } else {
                return tail;
            }
        }

        //Am Anfang der Liste
        public void removeAtFront() {
            if(isEmpty()) {
                System.out.println("Kein Element in der Liste");
            } else {
                head = head.getNextNode();
            }
        }



    }




