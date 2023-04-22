/**
* This is the GullibleMerchant class. This class extends the regular Merchant class. The Merchant objects are more
* gullible, which means the elfs have the ability to scam them. The elfs have the ability to steal or not pay at all for 
* the potion or health they are purchasing. The merchant also has the ability to speak or to flee. 
*
*/

public class GullibleMerchant extends Merchant {    
    public GullibleMerchant(int w, int pc, String pn, boolean ip, String n){
        super(w, pc, pn, ip, n);
    }

    /**
     * Introduces the merchant. This one seems to be a bit unconfident.
     */
    @Override
    public void speakTo(){
        System.out.println(getName() + ": \"H-hey there! Welcome to my store, you can buy " + productName + "s for " + productCost + "x Gold here. Also, please be patient with me, it's my first day on the job... haha...\"");
    }

    /**
     * This GullibleMerchant feels embarassed after being robbed.
     * They decide to go home.
     */
    @Override
    public void leave(){
        System.out.println(getName() + ": \"Oh man... how could I have been so gullible? Time to go home, I guess...\"");
        isPresent = false;
    }

    /**
     * The Elf tricks the GullibleMerchant and gets the product for free.
     * @param elf The Elf purchasing the product
     * @param amount The number of times to buy the product
     */
    @Override
    public void purchase(Elf elf, int amount){
        if (productName == "potions"){
            elf.addPotions(amount);
        } else if (productName == "shield"){
            elf.addShields(amount);
        }

        System.out.println(elf.getName() + " bought " + amount + "x " + productName + (amount > 1 ? "s" : ""));
        elf.printStats();
        System.out.println("However, " + elf.getName() + " easily tricked " + name + " the GullibleMerchant and did not pay!");

        leave();
    }

    /**
     * The name of this Merchant, with "GullibleMerchant" as its prefix.
     * @return This Merchant's full name.
     */
    @Override
    public String getName(){
        return "GullibleMerchant " + name;
    }
}
