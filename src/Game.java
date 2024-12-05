public class Game
{
    private Parser parser;
    private Room currentRoom;

    private Player player;

    public Game()
    {
        createRooms();
        parser = new Parser();

        player = new Player();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }

    private void createRooms()
    {
        Room outside, theater, pub, lab, office;
        Item test1, test2, test3;

        // create the rooms
        outside = new Room("outside shortDescription", "outside longDescription");
        theater = new Room("theater shortDescription", "theater longDescription");
        pub = new Room("pub shortDescription", "pub longDescription");
        lab = new Room("lab shortDescription", "lab longDescription");
        office = new Room("office shortDescription", "office longDescription");

        test1 = new Item();
        test2 = new Item();
        test3 = new Item();

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside

        // init room items
        outside.setItem("test1", test1);
        outside.setItem("test2", test2);

        theater.setItem("test3", test3);
    }

    public void play()
    {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to my text adventure game!");
        System.out.println("Introduction text goes here"); // maybe multiline string?
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getShortDescription());
    }

    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;

            //finish game first
            case LOOK:
                look();
                break;

            case GRAB:
                grab(command);
                break;

            case DROP:
                drop(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:
    private void grab(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word
            System.out.println("Grab what?");
            return;
        }

        String key = command.getSecondWord();

        // Try to leave current room.
        Item item = currentRoom.getItem(key);

        if (item == null) {
            System.out.println("You can't grab that!");
        }
        else {
            player.setItem(key, item);
            System.out.println(currentRoom.getInventoryString());
            System.out.println(player.getInventoryString());
        }
    }

    private void drop(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word
            System.out.println("Drop what?");
            return;
        }

        String key = command.getSecondWord();

        // Try to leave current room.
        Item item = player.getItem(key);

        if (item == null) {
            System.out.println("You can't drop that!");
        }
        else {
            currentRoom.setItem(key, item);
            System.out.println(player.getInventoryString());
            System.out.println(currentRoom.getInventoryString());
        }
    }

    private void look() {
        System.out.println(currentRoom.getLongDescription());
        System.out.println(player.getInventoryString());
    }

    private void printHelp()
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getShortDescription());
        }
    }

    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
