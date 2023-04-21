import java.util.ArrayList;

/**
 * 
 */
class Castle {
	public static ArrayList<DarkRoom> rooms;
	
	Castle()
	{
		rooms = new ArrayList<DarkRoom>();
	}
	
	/**
	 * Adds a DarkRoom to the Castle level
	 * @param room
	 */
	void addRoom(DarkRoom room)
	{
		rooms.add(room);
	}
	
	/**
	 * Occurs when an Elf enters a DarkRoom
	 * @param elf The Elf
	 * @param room The DarkRoom
	 */
	void enterRoom(Elf elf, DarkRoom room)
	{
		room.enter(elf);
		
		System.out.println(elf.getName() + " enters the " + room.getName() );
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
	 * @return
	 */
	DarkRoom getRoom(int index) {
		return rooms.get(index);
	}

    /**
     * Makes the Elf exit the castle by removing him from every room.
     * The method is static so that it can be used from other Classes.
     */
    public static void exitCastle(Elf elf){
        for (DarkRoom d : rooms){
            d.exit(elf);
        }
        System.out.println(elf.getName() + " has exited the castle.");
    }
}
