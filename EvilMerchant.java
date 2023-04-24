/**
 * Name: Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 * Teacher: Ms. Krasteva
 * Date: April 21, 2023
 * Description: EvilMerchant is a subclass extended from the Merchant class for evil and suspicious merchants
 * 
 * @version 23.04.21
 * @author Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 */

public class EvilMerchant extends Merchant {
    /**
     * Evil Merchant constructor.
     * @param w The amount of gold the merchant has.
     * @param pc The cost of the product.
     * @param pn The name of the product.
     * @param ip Whether or not the merchant is present.
     * @param n The name of the merchant.
     */
    public EvilMerchant(int w, int pc, String pn, boolean ip, String n){
        super(w, pc, pn, ip, n);
    }

    /**
     * Introduces the merchant. This one seems a bit suspicious.
     */
    @Override
    public void speakTo(){
        System.out.println(getName() + ": \"Yo, what's up? Pay me " + productCost + "x Gold for 1x " + productName + ". Worry not, I will *not* scam you.\"");
    }

    /**
     * This EvilMerchant decides to take the Elf's money and disappear before the Elf notices.
     */
    @Override
    public void leave(){
        System.out.println(getName() + ": \"What a silly Elf. Better scram before I get caught.\"");
        isPresent = false;
    }

    /**
     * Purchases the product if the Elf can afford it, but the Evil Merchant charges double. If the Merchant is not present, calls stallClosed().
     * @param elf The Elf purchasing the product
     * @param amount The number of times to buy the product
     */
    @Override
    public void purchase(Elf elf, int amount){
        if (!isPresent){
            stallClosed(elf);
            return;
        }

        if (amount * productCost * 2 > elf.getGold()){
            System.out.println(elf.getName() + " tried buying " + amount + "x " + productName + "... but he couldn't afford it!");
        } else {
            elf.subtractGold(amount * productCost * 2);
            addGold(amount * productCost * 2);

            // adds the item that the Elf bought
            if (productName == "potion"){
                elf.addPotions(amount);
            } else if (productName == "shield"){
                elf.addShields(amount);
            }

            System.out.println(elf.getName() + " bought " + amount + "x " + productName + (amount > 1 ? "s" : "") + "... for " + (2 * productCost * amount) + "x Gold? Is that not double of what he was supposed to pay?");
            System.out.println("However, " + elf.getName() + " did not notice that the EvilMerchant charged him double!");

            leave();
        }
    }

    /**
     * The name of this Merchant, with "EvilMerchant" as its prefix.
     * @return This Merchant's full name.
     */
    @Override
    public String getName(){
        return "EvilMerchant " + name;
    }
}