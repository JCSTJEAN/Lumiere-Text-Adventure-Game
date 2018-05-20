import java.util.Scanner;


    class Node
    {
        String mapName;
		protected String flavourText;
        protected Items items;
        protected boolean emptyMap;
        protected int mapID;
        public Node next;

        
        public Node() {}
        
        public void set_Node(String mn, String ft, Node n, Items it, boolean eM)
        {
            mapName = mn;
            flavourText = ft;
            next = n;
            items = it;
            emptyMap = eM;
        }

        public String get_flavourTXT() { return flavourText; }
        public String get_mapName() { return mapName; }
        public boolean get_isMapEmpty() { return emptyMap; }
        public Items takeOrLeaveItem()
        {
            System.out.println("Will you take or leave the item that you've found? \n\n");
            System.out.println("1 1 for yes 2 2 for no");
            
            
            Scanner scan = new Scanner(System.in);
            String s = scan.next();
            int i = scan.nextInt();
            
            switch (i)
            {
                case 1:
                    System.out.println("You took " + items.get_ItemName() + " with you \n\n");
                    emptyMap = true;
                    break;
                case 2:
                    System.out.println("You left " + items.get_ItemName() + " where you found it. \n\n");
                    emptyMap = false;
                    break;
            }
            
            
            
            if (emptyMap == true)
                return (items);
            else
                return (null);
        }
    }


    class Node2 extends Node
    {
        public Node2(String mn, String ft, Node n, Items it, boolean eM)
        {
            mapName = mn;
            flavourText = ft;
            next = n;
            items = it;
            emptyMap = eM;
        }
    }

    class Lumiere
    {
        private Node head, tail; //create a head tail and current reference
        public Node curr;

        public Lumiere()
        {
            Node temp;

            head = new Node(); //create our first map
            head.set_Node("Forest Of Life", get_ForestOfLifeTXT(), null, new Items("Pacifier"), false);
            curr = head; //give the reference to our next pointer of our head.   

            temp = new Node(); //
            temp.set_Node("Forest Of Love", get_ForestOfLoveTXT(), null, new Items("Photograph"), false);
            curr.next = temp;
            curr = temp;

            temp = new Node();
            temp.set_Node("Forest Of Loss", get_ForestOfLossTXT(), null, new Items("Small Tombstone"), false);
            curr.next = temp;
            curr = temp;

            temp = new Node2("Forest Of SecondChances", get_ForestOfSecondChancesTXT(), null, null, true);
            curr.next = temp;
            tail = temp;
            curr = head;

        }

        protected String get_ForestOfLifeTXT()
        { return ("A forest that is full of different plants bearing fruit. Within it contains \n" +
                "all life within it, full of energy and happy. \n You notice a pacifier on the ground. Who could have left it there?"
                ); 
        }
        protected String get_ForestOfLoveTXT() 
        { return ("A forest that has a river that is moving against the flow of time, the Elda stream." + 
                "\n The Elda stream contains the force of life of all living things.  You spot a PHOTOGRAPH \n containing happy and painful memories of." +
                "your friends and family, and your love."
                ); 
        }
        protected String get_ForestOfLossTXT() 
        { return ("A forest that has been burned to the ground, only ashes remain. Just as your parents said" + 
                "\n all shall one day return to dust. You sit there trembling at the reality of that. You notice a small tombstone with your name on it." +
                "\n Somehow it's light enough to carry."); 
        }
        protected String get_ForestOfSecondChancesTXT()
        {
            return ("A barren land of white now falling constantly. It's warm rather than cold. A bright light engulfs you. \n It seems you may get a second chance. \n"
                + "Let's see what you've brought... \n\n");
        }

        public void move_throughTheMap() { curr = curr.next; }

        public boolean get_areAllMapsFull()
        {
            for (curr = head; curr.next != null; curr = curr.next)
            {
                if (curr.get_isMapEmpty() == true)
                {
                    return false;
                }
            }

            return true;
        }


        public void FINAL_OUTCOME(boolean b) //the last state of the game. 
        {
            //if the player has taken at least 1 item with him, he regrets
            if (b == true)
                System.out.println("Lucky you, you get another chance at life");
            else
                System.out.println("I'm sorry but you for some reason can't get another chance at life.");
        }

    }


