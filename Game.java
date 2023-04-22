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
		Castle castle = new Castle();
      Merchant merch1 = new Merchant(100, 6, "health potion", true, "Max"); 
      Merchant merch2 = new GullibleMerchant(80, 4, "healing potion", true, "niceMax"); 
      Merchant merch3 = new EvilMerchant(200,10, "healthful potion", true, "meanMax"); 

        Marketplace marketplace = new Marketplace("Fairview Mall");

		createLevel1(castle, marketplace);
		
		Elf elf = new Elf("Sam");
		
	//	for (int i=0; i<castle.getRoomCount(); i++)
		//{
			DarkRoom room = castle.getRoom(0);
			castle.enterRoom(elf, room);
			castle.exitRoom(elf, room);
         marketplace.setOpen(true);  
         marketplace.addElf(elf); 
         merch1.speakTo(); 
         merch1.purchase(elf, 5); 
         merch1.leave(); 
         merch2.speakTo(); 
         merch2.purchase(elf, 5); 
         merch2.leave(); 
         merch3.speakTo(); 
         merch3.purchase(elf, 5); 
         merch3.leave(); 

         
         
         marketplace.removeElf(elf); 
  
         
       
		//}
	}

	/**
	 * Constructs one level of the game for a character.
	 * @param castle
	 */
	void createLevel1(Castle castle, Marketplace marketplace)
	{
		DarkRoom room = new DarkRoom("foyer", 50, true);
		castle.addRoom(room);
		
		room = new DarkRoom("kitchen", 100, false);
		castle.addRoom(room);
		
		room = new DarkRoom("living room", 0, true);
		castle.addRoom(room);

        // adds a Merchants to the Marketplace - uses some polymorphism for the subclasses
        
	}
}
