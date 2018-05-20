
    class GameEngine
    {
        protected Character player;
        protected Lumiere world1;

        public GameEngine()//initialize characters maps and values
        {
            player = new Character();
            world1 = new Lumiere();

        }

        public void RUN_LUMIERE()
        {

                // INTRODUCE THE CHARACTER
                System.out.println(player.get_flavourText());

                //line spacing
                System.out.println("=========================================");

                //FIRST ROOM IN THE MAP
                System.out.println(world1.curr.get_flavourTXT());

                Items a = world1.curr.takeOrLeaveItem();
                if (a != null)
                player.addInventoryItem(a);


                //line spacing
                System.out.println("=========================================");

                //SECOND ROOM
                world1.move_throughTheMap();
                System.out.println(world1.curr.get_flavourTXT());
                a = world1.curr.takeOrLeaveItem();
                if (a != null)
                    player.addInventoryItem(a);

                //line spacing
                System.out.println("=========================================");

                //THIRD ROOM
                world1.move_throughTheMap();
                System.out.println(world1.curr.get_flavourTXT());
                a = world1.curr.takeOrLeaveItem();
                if (a != null)
                    player.addInventoryItem(a);

                //line spacing
                System.out.println("=========================================");
                //LAST
                world1.move_throughTheMap();
                System.out.println(world1.curr.get_flavourTXT());
                world1.FINAL_OUTCOME(world1.get_areAllMapsFull());


                System.out.println("\n'\n THANKS FOR PLAYING \n\n Made by Curtis St-Jean");
        
        }
    }

