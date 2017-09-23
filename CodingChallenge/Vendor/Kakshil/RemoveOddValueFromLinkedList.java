static LinkedListNode deleteOdd(LinkedListNode list) {

           LinkedListNode head = null;

        LinkedListNode temp = null;

        while(list != null){

            if(head == null && list.val%2 == 0){

                head = list;

                temp = head;

            }

            else{

                if(list.val%2 == 0){

                    temp.next = list;

                    temp = temp.next;

                }

            }

            list = list.next;

            

        }

        temp.next = null;

        

        return head;



    }