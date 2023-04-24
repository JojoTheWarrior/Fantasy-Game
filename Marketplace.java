import java.util.ArrayList;

 /**
 * Name: Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 * Teacher: Ms. Krasteva
 * Date: April 21, 2023
 * Description: The Marketplace is where Elves can go to trade with Merchants.
 *              The "stalls" variable stores an ArrayList of Merchants.
 *              Once a Merchant leaves its stall, Elves can no longer trade with that stall.
 *              Additionally, Marketplaces can only be traded in when they're open.
 * 
 * @version 23.04.21
 * @author Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 */

public class Marketplace {
    public String name;
    public ArrayList<Merchant> stalls; 
    public boolean isOpen;
    public ArrayList<Elf> customers; 

    /**
     * Constructor for Marketplace.
     * @param n The name of the marketplace.
     */
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
        if (isOpen) System.out.println(getName() + " is open!"); 
        else 
        System.out.println (getName() + " is closed."); 
    }

    /**
     * Adds an elf to the customers ArrayList.
     * @param elf The elf to add.
     */
    public void addElf(Elf elf){
        customers.add(elf);
        System.out.println(elf.getName() + " has entered " + getName() + "."); 
    }

    /**
     * Removes an elf from the customers ArrayList.
     * @param elf The elf to remove.
     */
    public void removeElf(Elf elf){
        customers.remove(elf);
        System.out.println (elf.getName() + " has left " + getName() + "."); 
    }

    /**
     * Adds a merchant to the stalls.
     * @param m The merchant to add.
     */
    public void addStall(Merchant m){
        stalls.add(m);
    }

    /**
     * Sets which Merchant the Elf is at.
     * @param elf The Elf to set which Merchant they're at.
     * @param i The index of the Merchant. 
     * @return The Merchant the Elf is at.
     */
    public Merchant atStall(Elf elf, int i){
        System.out.println(elf.getName() + " is at stall #" + (i + 1) + "."); 
        return stalls.get(i);
    }

    /**
     * Name of the marketplace.
     * @return The name of the marketplace.
     */
    public String getName(){
        return name;
    }
}
