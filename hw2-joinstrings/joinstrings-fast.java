/**
  * Name: Goh Zheng Teck
  * NUSNET ID: E0544321
  * Lab Class: Lab 03
*/

import java.util.Arrays;

class joinstrings {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        class sLinkedList {
            class Node {
                String data;
                Node next;

                Node(String d) {
                    data = d;
                    next = null;
                }
            }

            Node head;
            Node tail;

            sLinkedList(String d) {
                this.head = new Node(d);
                this.tail = this.head;
            }

            public void append(sLinkedList list) {
                this.tail.next = list.head;
                this.tail = list.tail;
            }

            public void print(int wordsCount) {
                for (int i = 0; i < wordsCount; i++) {
                    io.print(head.data);
                    this.head = head.next;
                }
            }
        }
        
        final int wordsCount = io.getInt();
        if (wordsCount == 1) {
            io.print(io.getWord());
            io.close();
            return;
        }
        sLinkedList[] arr = new sLinkedList[wordsCount + 1];
        for (int i = 1; i <= wordsCount; i++) {
            arr[i] = new sLinkedList(io.getWord());
        }
        for (int i = 0; i < wordsCount-2; i++) {
            arr[io.getInt()].append(arr[io.getInt()]);
        }
        int last = io.getInt();
        arr[last].append(arr[io.getInt()]);
        arr[last].print(wordsCount);
        io.close();
    }
}