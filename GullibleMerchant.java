public class GullibleMerchant extends Merchant {    
    public GullibleMerchant(int w, int pc, String pn, boolean ip, String n){
        super(w, pc, pn, ip, n);
    }

    /**
     * Introduces the merchant. This one seems to be a bit unconfident.
     */
    @Override
    public void speakTo(){
        System.out.println(name + ": H-hey there! Welcome to my store, you can buy " + productName + " for " + productCost + "x gold here. Also, please be patient with me, it's my first day on the job... haha...");
    }

    /**
     * This GullibleMerchant feels embarassed after being robbed.
     * They decide to go home.
     */
    @Override
    public void leave(){
        System.out.println(name + ": Oh man... how could I have been so gullible? Time to go home, I guess...");
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
        System.out.println("However, " + elf.getName() + " easily tricked " + name + " the GullibleMerchant and did not pay!");

        leave();
    }
}
