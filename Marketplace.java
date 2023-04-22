import java.util.ArrayList;

/**
 * The Marketplace is where Elves can go to trade with Merchants.
 * The "stalls" variable stores an ArrayList of Merchants.
 * Once a Merchant leaves its stall, Elves can no longer trade with that stall.
 * Additionally, Marketplaces can only be traded in when they're open.
 */
public class Marketplace {
    public String name;
    public ArrayList<Merchant> stalls; // =  new ArrayList<Merchant>();
    public boolean isOpen;
    public ArrayList<Elf> customers; // = new ArrayList<Elf>();

    public Marketplace(String n){
        isOpen = false;
        name = n;
        customers = new ArrayList<Elf>(); 
        stalls = new ArrayList<Merchant>(); 
    }

    /**
     * Set method for isOpen.
     * @param state State to change isOpen to.
     */
    public void setOpen(boolean state){
        isOpen = state;
        if (isOpen)
        System.out.println("The market place is open!"); 
        else 
        System.out.println ("The market place is close"); 
    }

    /**
     * Adds an elf to the customers ArrayList.
     */
    public void addElf(Elf elf){
        customers.add(elf);
        System.out.println(elf.getName() + " has entered the marketplace"); 
    }

    /**
     * Removes an elf from the customers ArrayList.
     */
    public void removeElf(Elf elf){
        customers.remove(elf);
        System.out.println (elf.getName() +" has left the marketplace"); 
    }

    /**
     * Returns the Merchant at a specific stall.
     * @param i The index of the Merchant. 
     */
    /*public Merchant atStall(int i){
        System.out.println("The elf is at stall" +i); 
        return stalls.get(i);
        
    }*/
}
