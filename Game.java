/**
 * Name: Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 * Teacher: Ms. Krasteva
 * Date: April 21, 2023
 * Description:  This class is responsible for constructing levels and coordinating interaction of Elves with Darkrooms.
 * 
 * @version 23.04.21
 * @author Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 */

public class Game {
    /**
     * Initiates the start of game play.
     */
    void play() {
        Castle castle1 = new Castle("Small-Fry Keep");
        Castle castle2 = new Castle("Fort Bigger-Fish");
        Marketplace marketplace1 = new Marketplace("Fairview Mall");
        Marketplace marketplace2 = new Marketplace("Yorkdale Mall");
        
        createLevel1(castle1, marketplace1);
        createLevel2(castle2, marketplace2);
        
        Elf elf = new Elf("Sam");

        // Narrator lines
        System.out.println("This is " + elf.getName() + ":");
        System.out.println(elf.getName() + ": \"Hello!\"");
        System.out.println(elf.getName() + " will visit " + castle1.getName() + " and loot the rooms for gold.");
        System.out.println();

        // Sam explores the Small-Fry Keep - but he'll leave earlier if his health drops to or below 30%
        castle1.enterCastle(elf);
        System.out.println();
        
        for (int i = 0; i < castle1.rooms.size(); i++){
            DarkRoom d = castle1.getRoom(i);
            boolean willStay = d.enter(elf);

            if (!willStay){
                castle1.exitCastle(elf);
                break;
            }

            d.exit(elf);

            System.out.println();

            // Elf Sam leaves the castle1 after visiting the last room
            if (i == castle1.rooms.size() - 1){
                castle1.exitCastle(elf);
                System.out.println();
            }
        }

        // Narrator lines
        System.out.println("With his newly found riches, " + elf.getName() + " plans a shopping spree at " + marketplace1.getName() + ".");
        System.out.println("However, he recognizes that he is rather weak; he only made it out of " + castle1.getName() + " with " + elf.health + "% health!");
        System.out.println("He plans to gear up on potions and shields to get stronger.");
        System.out.println();

        // Fairview Mall opens, and Elf Sam goes on a shopping spree
        marketplace1.setOpen(true);
        System.out.println();
        marketplace1.addElf(elf);
        System.out.println();

        // Narrator lines
        System.out.println("There are all sorts of interesting Merchants in Fairview Mall. Hopefully " + elf.getName() + " doesn't get scammed!");
        System.out.println();

        for (int i = 0; i < marketplace1.stalls.size(); i++){
            // Sam speaks to each of the merchants, then purchases 5 of whatever they are selling
            Merchant m = marketplace1.atStall(elf, i);

            m.speakTo();
            m.purchase(elf, 5);
            elf.printStats();

            System.out.println();
        }

        // Narrator lines
        System.out.println(elf.getName() + " suddenly realizes that the EvilMerchant at stall #2 scammed him!");
        marketplace1.atStall(elf, 1).purchase(elf, 0);
        System.out.println("However, it seems like EvilMerchant Eva had already disappeared.");

        // Elf Sam leaves the Marketplace
        System.out.println();
        marketplace1.removeElf(elf);
        System.out.println();
        marketplace1.setOpen(false);
        System.out.println();

        // Narrator lines
        System.out.println(elf.getName() + " is now ready to explore " + castle2.getName() + " with his potions and shields ready.");
        System.out.println();

        // Sam explores the Fort Bigger-Fish - but he'll leave earlier if his health drops to or below 30%
        castle2.enterCastle(elf);
        System.out.println();

        for (int i = 0; i < castle2.rooms.size(); i++){
            DarkRoom d = castle2.getRoom(i);
            boolean willStay = d.enter(elf);

            if (!willStay){
                castle2.exitCastle(elf);
                break;
            }

            d.exit(elf);

            System.out.println();

            if (i == castle2.rooms.size() - 1){
                // Narrator lines
                System.out.println("It seems like the boss was not at home.");

                // Elf Sam leaves the castle2 after visiting the last room
                castle2.exitCastle(elf);
                System.out.println();
            }
        }

        // Narrator lines
        System.out.println("Now that " + elf.getName() + " is extremely wealthy, he will visit the Merchants at " + marketplace2.getName() + ".");
        System.out.println("However, while " + elf.getName() + " does have " + elf.getGold() + "x Gold, will he be able to keep up with " + marketplace2.getName() + "'s outrageous prices??");

        // Yorkdale Mall opens, and Elf Sam goes on a shopping spree
        marketplace2.setOpen(true);
        System.out.println();
        marketplace2.addElf(elf);
        System.out.println();

        for (int i = 0; i < marketplace2.stalls.size(); i++){
            // Sam speaks to each of the merchants, then gets robbed by them
            Merchant m = marketplace2.atStall(elf, i);

            m.speakTo();
            m.purchase(elf, 5);
            elf.printStats();

            System.out.println();
        }

        // Narrator lines
        System.out.println(elf.getName() + " couldn't keep up with " + marketplace2.getName() + "s prices.");

        // Elf Sam leaves the Marketplace
        System.out.println();
        marketplace2.removeElf(elf);
        System.out.println();
        marketplace2.setOpen(false);
        System.out.println();

        // Narrator lines
        System.out.println(elf.getName() + " returns home with empty pockets.");
    }

    /**
     * Constructs one level of the game for a character.
     * Initializes the Castle with 9 rooms and initializes the Marketplace with 5 Merchants.
     * @param castle1 The Castle, Small-Fry Keep
     * @param marketplace1 The Marketplace, Fairview Mall
     */
    void createLevel1(Castle castle1, Marketplace marketplace1)
    {
        // adds DarkRooms to the Castle
        DarkRoom room = new DarkRoom("foyer", 50, true);
        castle1.addRoom(room);
        
        room = new DarkRoom("kitchen", 100, false);
        castle1.addRoom(room);
        
        room = new DarkRoom("living room", 0, true);
        castle1.addRoom(room);

        room = new DarkRoom("bathroom 1", 25, true);
        castle1.addRoom(room);

        room = new DarkRoom("bathroom 2", 40, true);
        castle1.addRoom(room);

        room = new DarkRoom("bathroom 3", 75, true);
        castle1.addRoom(room);

        room = new DarkRoom("bedroom 1", 50, false);
        castle1.addRoom(room);

        room = new DarkRoom("bedroom 2", 90, true);
        castle1.addRoom(room);

        room = new DarkRoom("bedroom 3", 45, false);
        castle1.addRoom(room);

        // adds Merchants to the Marketplace
        Merchant merch = new Merchant(150, 15, "potion", true, "Norman");
        marketplace1.addStall(merch);
        
        merch = new EvilMerchant(600, 20, "potion", true, "Eva");
        marketplace1.addStall(merch);

        merch = new GullibleMerchant(0, 10, "shield", true, "Sully");
        marketplace1.addStall(merch);

        merch = new Merchant(900, 40, "potion", true, "Toothbrush");
        marketplace1.addStall(merch);

        merch = new GullibleMerchant(100, 60, "shield", true, "Portobello");
        marketplace1.addStall(merch);
    }

    /**
     * Constructs the second level of the game for a character, which is more difficult than the first.
     * Initializes the Castle with 18 rooms and initializes the Marketplace with 6 Merchants. 
     * @param castle2 The Castle, Fort Bigger-Fish
     * @param marketplace2 The Marketplace, Yorkdale Mall
     */
    public void createLevel2(Castle castle2, Marketplace marketplace2){
        // adds DarkRooms to the Castle
        DarkRoom room = new DarkRoom("castle entrance", 200, true);
        castle2.addRoom(room);

        room = new DarkRoom("foyer", 300, true);
        castle2.addRoom(room);

        room = new DarkRoom("main floor", 400, true);
        castle2.addRoom(room);

        room = new DarkRoom("bedroom 1", 100, true);
        castle2.addRoom(room);

        room = new DarkRoom("bedroom 2", 250, true);
        castle2.addRoom(room);

        room = new DarkRoom("stairwell 1", 50, true);
        castle2.addRoom(room);

        room = new DarkRoom("second floor", 500, true);
        castle2.addRoom(room);

        room = new DarkRoom("bedroom 3", 250, true);
        castle2.addRoom(room);

        room = new DarkRoom("bedroom 4", 400, true);
        castle2.addRoom(room);

        room = new DarkRoom("stairwell 3", 150, true);
        castle2.addRoom(room);

        room = new DarkRoom("royal bedroom", 250, true);
        castle2.addRoom(room);

        room = new DarkRoom("royal bathroom", 900, true);
        castle2.addRoom(room);

        room = new DarkRoom("royal throne room", 1500, true);
        castle2.addRoom(room);

        room = new DarkRoom("secret stairwell", 200, true);
        castle2.addRoom(room);

        room = new DarkRoom("basement entrance", 150, true);
        castle2.addRoom(room);

        room = new DarkRoom("dungeon entrance", 300, true);
        castle2.addRoom(room);

        room = new DarkRoom("dungeon hallway", 250, true);
        castle2.addRoom(room);

        room = new DarkRoom("bossfight room", 2000, true);
        castle2.addRoom(room);

        // adds Merchants to the Marketplace
        Merchant merch = new EvilMerchant(10000, 815, "potion", true, "York");
        marketplace2.addStall(merch);

        merch = new EvilMerchant(10000, 1015, "shield", true, "Pork");
        marketplace2.addStall(merch);

        merch = new EvilMerchant(10000, 615, "potion", true, "Storks");
        marketplace2.addStall(merch);

        merch = new EvilMerchant(10000, 2540, "shield", true, "Stonks");
        marketplace2.addStall(merch);

        merch = new EvilMerchant(10000, 1540, "potion", true, "Bonks");
        marketplace2.addStall(merch);

        merch = new EvilMerchant(10000, 815, "shield", true, "York");
        marketplace2.addStall(merch);
    }
}