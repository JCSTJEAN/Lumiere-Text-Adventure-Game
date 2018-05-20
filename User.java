import java.util.Scanner;
import java.util.Stack;

class User
    {
        protected String name;
        public String getName() { return name; }
    }

    class Character extends User
    {
        private boolean regrets; //regrets or map inventory can determine the end result of the game.
        private String flavourText;
        private Stack<Items> inventory = new Stack<Items>(); //empty inventory initially

        public Character() //create a character requesting and storing a name
        {      
        	Scanner s = new Scanner(System.in);
            System.out.println("Enter a name"); name = s.nextLine();
            set_flavourText();
        }

        private void set_flavourText() { flavourText = ("You are " + name + " who's background in life is a mystery."); }

        public void addInventoryItem(Items i)
        {
            inventory.push(i);
        }

        public String getInventoryName()
        {
            Items a = inventory.pop(); return a.get_ItemName(); }

        public boolean doesPlayerRegret()
        {
            if (inventory.isEmpty()) //if the inventory has at least 1 item in it
                return (regrets = false);
            else return (regrets = true);
        }

        //return flavour text of the character background
        public String get_flavourText() { return flavourText; }

    }