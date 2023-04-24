import java.util.ArrayList;

 /**
 * Name: Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 * Teacher: Ms. Krasteva
 * Date: April 21, 2023
 * Description: DarkRooms have certain properties that Elves can interact with.
 * 				They can contain gold and / or radiation, which is either good or bad for the Elf that visits it.
 * 
 * @version 23.04.21
 * @author Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 */

class DarkRoom {
	String name;
	int gold;
	boolean radioactive;
	
	ArrayList<Elf> elves;
	
	/**
	 * Constructs a DarkRoom
	 * @param name The name of the room.
	 * @param gold The amount of the gold.
	 * @param radioactive If radioactivity is present
	 */
	DarkRoom(String name, int gold, boolean radioactive)
	{
		this.name = name;
		this.gold = gold;
		this.radioactive = radioactive;
		
		elves = new ArrayList<Elf>();
	}
	
	/**
	 * Have Elf interact with DarkRoom.
	 * @param elf
     * @return Whether or not the Elf stays in the castle after visiting this room.
	 */
	public boolean enter(Elf elf)
	{
        System.out.println(elf.getName() + " enters the " + getName() + ".");
		elves.add(elf);

        gold = elf.takeGold(gold);
		
		if (radioactive){
            boolean willStay = elf.exposeToRadiation();
            return willStay;
        }
        return true;
	}
	
	/**
	 * Remove Elf from room.
	 * @param elf
	 */
	void exit(Elf elf)
	{
        System.out.println(elf.getName() + " exits the " + getName() + ".");
		elves.remove(elf);
	}

	/**
	 * A description of this DarkRoom
	 * @return the name of the DarkRoom
	 */
	String getName() {
		
		return name;
	}
}