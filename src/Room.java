import java.util.Set;
import java.util.HashMap;


public class Room
{
    private String shortDescription;
    private String longDescription;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Item> inventory;

    public Room(String shortDescription, String longDescription)
    {
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        exits = new HashMap<>();
        inventory = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return shortDescription;
    }


    public String getLongDescription()
    {
        return "You are " + longDescription + "\n" + getExitString() + "\n" + getInventoryString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String key : keys) {
            returnString += " " + key;
        }
        return returnString;
    }

    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    public Item getItem(String key) {
        return inventory.remove(key);
    }

    public void setItem(String key, Item value) {
        inventory.put(key, value);
    }

    public String getInventoryString()
    {
        String returnString = "Room Inventory:";

        if(inventory.isEmpty())
            return returnString + " empty";


        Set<String> keys = inventory.keySet();
        for(String key : keys) {
            returnString += " " + key;
        }
        return returnString;
    }
}

