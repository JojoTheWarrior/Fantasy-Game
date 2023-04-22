/**
 * This class is responsible for constructing levels and coordinating interaction of
 * Elves with Darkrooms.
 *
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
        //createLevel2(castle2, marketplace2);
        
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
            DarkRoom d = castle1.rooms.get(i);
            boolean willStay = d.enter(elf);

            if (!willStay){
                castle1.exitCastle(elf);
                break;
            }

            d.exit(elf);

            System.out.println();

            // leaves the castle1 after visiting the last room
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

        // With his newly found riches, Sam visits the Marketplace and buys from all the Merchants there
        marketplace1.setOpen(true);
        System.out.println();
        marketplace1.addElf(elf);
        System.out.println();

        // Narrator lines
        System.out.println("There are all sorts of interesting Merchants in Fairview Mall. Hopefully " + elf.getName() + " doesn't get scammed!");
        System.out.println();

        for (int i = 0; i < marketplace1.stalls.size(); i++){
            // Sam speaks to each of the merchants, then purchases 5 of whatever they are selling.
            Merchant m = marketplace1.atStall(elf, i);

            m.speakTo();
            m.purchase(elf, 5);
            elf.printStats();

            System.out.println();
        }

        System.out.println();
        marketplace1.removeElf(elf);
        System.out.println();
    }

    /**
     * Constructs one level of the game for a character.
     * Initializes the Castle with 9 rooms and initializes the Marketplace with 5 Merchants.
     * @param castle1
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

        room = new DarkRoom("bedroom 1", 0, false);
        castle1.addRoom(room);

        room = new DarkRoom("bedroom 2", 0, true);
        castle1.addRoom(room);

        room = new DarkRoom("bedroom 3", 0, false);
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

        merch = new EvilMerchant(100, 60, "shield", true, "Portobello");
        marketplace1.addStall(merch);
    }
}