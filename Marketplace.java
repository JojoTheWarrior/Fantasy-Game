import java.util.ArrayList;

/**
 * The Marketplace is where Elves can go to trade with Merchants.
 * The "stalls" variable stores an ArrayList of Merchants.
 * Once a Merchant leaves its stall, Elves can no longer trade with that stall.
 * Additionally, Marketplaces can only be traded in when they're open.
 */
public class Marketplace {
    public String name;
    public ArrayList<Merchant> stalls;
    public boolean isOpen;
    public ArrayList<Elf> customers;

    public Marketplace(String n){
        isOpen = false;
        name = n;
    }

    /**
     * Set method for isOpen.
     * @param state State to change isOpen to.
     */
    public void setOpen(boolean state){
        isOpen = state;
    }

    /**
     * Adds an elf to the customers ArrayList.
     */
    public void addElf(Elf elf){
        customers.add(elf);
    }

    /**
     * Removes an elf from the customers ArrayList.
     */
    public void removeElf(Elf elf){
        customers.remove(elf);
    }

    /**
     * Returns the Merchant at a specific stall.
     * @param i The index of the Merchant. 
     */
    public Merchant atStall(int i){
        return stalls.get(i);
    }
}
