/**
 * Elves explore Dark Rooms and gain gold from them.
 * To protect themselves, they have potions that can heal their HP and shields that can lower the amount of damage that they take.
 * With the gold that they get, they can go to a Marketplace and trade with the Merchants there.
 * 
 */
class Elf {
    String name;
    int health;
    int gold;
    int potions;
    int shields;
    final static int MAXGOLD = 1000;
        
    Elf(String name)
    {
        this.name = name;
        health = 100;
        gold = 0;
        potions = 1;
    }
        
    /**
     * Takes the maximum amount of gold and returns the leftover amount.
     * @param available The amount of gold available to be taken.
     * @return The amount of gold leftover.
     */
    int takeGold(int available)
    {
        int taken = 0;
        if (available + gold <= MAXGOLD)
        {
            gold += available;
            taken = available;
        }
        else
        {
            gold = MAXGOLD;
            taken = available - MAXGOLD;
        }
        
        System.out.println(getName() + " takes " + taken + " gold.");
        printStats();
        
        return available - taken;
    }
    
    /**
     * Drinking potion restores health.
     */
    void drinkPotion()
    {
        if (potions == 0){
            System.out.println(getName() + " tried drinking a potion... but he didn't have any more left!");
            return;
        }

        potions--;
        health = 100;    
        System.out.println(getName() + " drinks potion. Health=" + health + "%");
    }
    
    /**
     * Reduce the health by 10%, but every shield that they have decreases the damage by 1% (to a minimum of 5%). 
     * If an Elf's health falls to 30% or below, they will try drinking a potion to heal.
     * If they do not have enough potions, they will simply leave the Castle to avoid dying.
     * @return Whether or not the Elf has enough health to continue.
     */
    public boolean exposeToRadiation()
    {
        health = health - Math.max(5, 10 - shields);
            
        System.out.println(getName() + " is exposed to radiation. Health=" + health + "%");

        if (health <= 30){
            System.out.println("Since " + getName() + "'s health is <= 30%, he will try drinking a potion.");
            
            if (potions > 0){
                System.out.println("The potion heals " + getName() + " to 100%");
                potions--;
                return true;
            } else {
                System.out.println("Unfortunately, " + getName() + " does not have any potions left!");
                return false;
            }
        }
        return true;
    }

    /**
     * Prints how many potions, shields, and gold this Elf has.
     */
    public void printStats(){
        System.out.println(getName() + " has: \n\t> " + gold + "x Gold,\n\t> " + potions + "x Potions,\n\t> " + shields + "x Shields");
    }

    /**
     * A description of this Elf.
     * @return
     */
    String getName() {
        return "Elf " + name;
    }

    /**
     * Adds to the number of potions that this Elf has.
     */
    public void addPotions(int amount){
        potions += amount;
    }

    /**
     * Returns the amount of gold this Elf has.
     */
    public int getGold(){
        return gold;
    }

    /**
     * Removes from the amount of gold this Elf has.
     * @param amount How much gold this Elf loses.
     */
    public void subtractGold(int amount){
        gold -= amount;
    }

    /**
     * Adds to the number of shields that this Elf has.
     * @param amount The number of shields that this Elf gains.
     */
    public void addShields(int amount){
        shields += amount;
    }
}
