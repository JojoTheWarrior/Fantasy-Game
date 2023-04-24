/**
 * Name: Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 * Teacher: Ms. Krasteva
 * Date: April 21, 2023
 * Description: This is the default type of merchant, and it is the superclass for all merchants. 
 *              Each merchant sells exactly one type of item for a set price.
 * 
 * @version 23.04.21
 * @author Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 */

public class Merchant {
    public int wealth;
    public int productCost;
    public String productName;
    public boolean isPresent;
    public String name;

    /**
     * Constructor for Merchant.
     * @param w The amount of gold the merchant has.
     * @param pc The cost of the product.
     * @param pn The name of the product.
     * @param ip Whether or not the merchant is present.
     * @param n The name of the merchant.
     */
    public Merchant(int w, int pc, String pn, boolean ip, String n){
        wealth = w;
        productCost = pc;
        productName = pn;
        isPresent = ip;
        name = n;
    }

    /**
     * Introduces the merchant, what they sell, and how much the price is.
     */
    public void speakTo(){
        System.out.println(getName() + ": \"Welcome to my store! You can buy " + productName + "s for " + productCost + "x Gold here.\"");
    }

    /**
     * This Merchant closes its stall and leaves for the day.
     */
    public void leave(){
        System.out.println(getName() + ": \"That's it for today, time to go home.\"");
        isPresent = false;
    }

    /**
     * Called when the Elf tries interacting with a closed stall.
     * @param elf The Elf trying to interact with the stall.
     */
    public void stallClosed(Elf elf){
        System.out.println(elf.getName() + " tried interacting with " + getName() + "'s stall... but there was nobody there.");
    }

    /**
     * Purchases the product if the Elf can afford it. If the Merchant is absent, calls stallClosed().
     * @param elf The Elf purchasing the product
     * @param amount The number of times to buy the product
     */
    public void purchase(Elf elf, int amount){
        if (!isPresent){
            stallClosed(elf);
            return;
        }

        if (amount * productCost > elf.getGold()){
            System.out.println(elf.getName() + " tried buying " + amount + "x " + productName + "... but he couldn't afford it!");
        } else {
            elf.subtractGold(amount * productCost);
            addGold(amount * productCost);

            // adds the item that the Elf bought
            if (productName == "potion"){
                elf.addPotions(amount);
            } else if (productName == "shield"){
                elf.addShields(amount);
            } 

            System.out.println(elf.getName() + " bought " + amount + "x " + productName + (amount > 1 ? "s" : "") + " for " + (productCost * amount) + "x Gold.");
        }
    }

    /**
     * The name of this Merchant, with "Merchant" as its prefix.
     * @return This Merchant's full name.
     */
    public String getName(){
        return "Merchant " + name;
    }

    /**
     * This Merchant adds Gold to his wealth.
     * @param amount The amount of Gold to add.
     */
    public void addGold(int amount){
        wealth += amount;
    }
}
