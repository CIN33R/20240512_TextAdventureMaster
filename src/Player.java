import java.util.HashMap;
import java.util.Set;

public class Player {
    private HashMap<String, Item> inventory;

    public Player() {
        inventory = new HashMap<>();
    }

    public Item getItem(String key) {
        return inventory.remove(key);
    }

    public void setItem(String key, Item value) {
        inventory.put(key, value);
    }

    public String getInventoryString()
    {
        String returnString = "Player Inventory:";

        if(inventory.isEmpty())
            return returnString + " empty";

        Set<String> keys = inventory.keySet();
        for(String key : keys) {
            returnString += " " + key;
        }
        return returnString;
    }
}