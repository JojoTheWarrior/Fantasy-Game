import java.util.ArrayList;

/**
 * Name: Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 * Teacher: Ms. Krasteva
 * Date: April 21, 2023
 * Description: The Castle holds DarkRooms, which can be explored by the Elf.
 * 
 * @version 23.04.21
 * @author Joshua Wang, Ma'ayan Shai, and Chelsea Wong
 */

class Castle {
	public ArrayList<DarkRoom> rooms;
    public String name;
	
	/**
	 * constructor for Castle class
	 * @param n The name of the Castle
	 */
	Castle(String n)
	{
        name = n;
		rooms = new ArrayList<DarkRoom>();
	}
	
	/**
	 * Adds a DarkRoom to the Castle level
	 * @param room The DarkRoom to add
	 */
	void addRoom(DarkRoom room)
	{
		rooms.add(room);
	}
	
	/**
	 * Occurs when an Elf enters a DarkRoom
	 * @param elf The Elf
	 * @param room The DarkRoom
     * @return Whether the Elf will stay in the Castle after visiting this room.
	 */
	public boolean enterRoom(Elf elf, DarkRoom room)
	{
        System.out.println(elf.getName() + " enters the " + room.getName() );
		return room.enter(elf);
	}
	
	/**
	 * Occurs when an Elf leaves a DarkRoom.
	 * @param elf The Elf.
	 * @param room The DarkRoom
	 */
	void exitRoom(Elf elf, DarkRoom room)
	{
		room.exit(elf);
		System.out.println(elf.getName() + " leaves the " + room.getName() );
	}
	
	/**
	 * Returns the number of DarkRooms.
	 * @return The number of DarkRooms.
	 */
	int getRoomCount()
	{
		return rooms.size();
	}

	/**
	 * Returns a DarkRoom according to index.
	 * @param index
	 * @return The DarkRoom at the index.
	 */
	DarkRoom getRoom(int index) {
		return rooms.get(index);
	}

    /**
     * Enters the elf into the castle.
     * @param elf The elf to enter the castle.
     */
    public void enterCastle(Elf elf){
        System.out.println(elf.getName() + " has entered " + getName() + ".");
    }

    /**
     * Makes the Elf exit the castle by removing him from every room.
     * The method is static so that it can be used from other Classes.
	 * @param elf The Elf to exit the castle.
     */
    public void exitCastle(Elf elf){
        for (DarkRoom d : rooms){
            if (d.elves.contains(elf)){
                d.exit(elf);
            }   
        }
        System.out.println(elf.getName() + " has exited " + getName() + ".");
    }

    /**
     * Returns the name of this Castle.
     * @return The name of this Castle.
     */
    public String getName(){
        return name;
    }
}
