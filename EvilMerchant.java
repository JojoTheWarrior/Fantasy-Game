public class EvilMerchant extends Merchant {
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
    }

    /**
     * Evil Merchant constructor
    */
    public EvilMerchant(int w, int pc, String pn, boolean ip, String n)
    {
        super(w,pc,pn,ip,n);

    }
    /**
     * Purchases the product if the Elf can afford it.
     * @param elf The Elf purchasing the product
     * @param amount The number of times to buy the product
     */
    public void purchase(int amount)
    {
        super.purchase( elf, amount);

        if (amount * productCost*2 > elf.getGold()){
            System.out.println(elf.getName() + " tried buying " + amount + " x " + productName + "... but he couldn't afford it!");
        } else {
            elf.subtractGold(amount * productCost*/2);

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