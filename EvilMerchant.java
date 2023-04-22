public class EvilMerchant extends Merchant {
    /**
     * Evil Merchant constructor.
     */
    public EvilMerchant(int w, int pc, String pn, boolean ip, String n){
        super(w, pc, pn, ip, n);
    }

    /**
     * Introduces the merchant. This one seems a bit suspicious.
     */
    @Override
    public void speakTo(){
        System.out.println(name + ": Yo, what's up? Pay me " + productCost + "x Gold for 1x " + productName + ". Worry not, I will *not* scam you.");
    }

    /**
     * This EvilMerchant decides to take the Elf's money and disappear before the Elf notices.
     */
    @Override
    public void leave(){
        System.out.println(name + ": What a silly Elf. Better scram before I get caught.");
        isPresent = false;
    }

    /**
     * Purchases the product if the Elf can afford it.
     * @param elf The Elf purchasing the product
     * @param amount The number of times to buy the product
     */
    @Override
    public void purchase(Elf elf, int amount)
    {
        if (amount * productCost * 2 > elf.getGold()){
            System.out.println(elf.getName() + " tried buying " + amount + " x " + productName + "... but he couldn't afford it!");
        } else {
            elf.subtractGold(amount * productCost * 2);

            // adds the item that the Elf bought
            if (productName == "potion"){
                elf.addPotions(amount);
            } else if (productName == "shield"){
                elf.addShields(amount);
            }

            System.out.println(elf.getName() + " bought " + amount + "x " + productName + (amount > 1 ? "s" : ""));
            elf.printStats();
            System.out.println("However, " + elf.getName() + " did not notice that the Merchant charged him double!");

            leave();
        }

    }
}
