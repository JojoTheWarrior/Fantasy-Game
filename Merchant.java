/**
 * This is the default type of merchant, and it is the superclass for all merchants. 
 * Each merchant sells exactly one type of item for a set price.
 */
public class Merchant {
    public int wealth;
    public int productCost;
    public String productName;
    public boolean isPresent;
    public String name;

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
        System.out.println(name + ": Welcome to my store! You can buy " + productName + " for " + productCost + " gold here.");
    }

    /**
     * Purchases the product if the Elf can afford it.
     * @param elf The Elf purchasing the product
     * @param amount The number of times to buy the product
     */
    public void purchase(Elf elf, int amount){
        if (amount * productCost > elf.getGold()){
            System.out.println(elf.getName() + " tried buying " + amount + " x " + productName + "... but he couldn't afford it!");
        } else {
            elf.subtractGold(amount * productCost);

            // adds the item that the Elf bought
            if (productName == "potion"){
                elf.addPotions(amount);
            } else if (productName == "shield"){
                elf.addShields(amount);
            } 

            System.out.println(elf.getName() + " bought " + amount + "x " + productName + (amount > 1 ? "s" : ""));
            elf.printStats();
        }
    }
}