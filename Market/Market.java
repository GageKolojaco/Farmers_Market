package Market;

import Stand.Stand;

public class Market {  //using a basic linked list to connect all the stands in the market

    private static class Node { //nested node class
        Stand stand;
        int standID;
        Node next;

        Node(Stand stand) {
            this.stand = stand;
            this.standID = stand.getStandID();
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public Market(){
        this.head = null;
        this.size = 0;
    }

    public int getSize(){return size;}

    public void addStand(Stand stand){
        Node newNode = new Node(stand);
        if (head == null){
            head = newNode;
        } else {
            Node currentNode = head;
            while (currentNode.next != null){currentNode = currentNode.next;}
            currentNode.next = newNode;

        }
        size++;
    }

    public void listStands(){
        Node currentNode = head;
        while (currentNode.next != null){
            System.out.println("Stand ID#: " + currentNode.standID + " Farmer: " + currentNode.stand.getFarmer());
            currentNode = currentNode.next;
        }
        System.out.println("Stand ID#: " + currentNode.standID + " Farmer: " + currentNode.stand.getFarmer());
    }
    
}