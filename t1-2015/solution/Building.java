import java.util.ArrayList;

public class Building implements Facility { 

	private String name;
	private int minFloor;
	private int maxFloor;
	private int capacity;
	
	private ArrayList<Room> rooms = new ArrayList<Room>();

	public Building(String name, int min, int max) {
		this.name = name;
		this.minFloor = min;
		this.maxFloor = max;
		if(min > max) 
			throw new IllegalArgumentException();
	}	
	
	@Override
	public String getName() {
		return name;
	}
	
	public int getMinFloor() {
		return minFloor;
	}
	
	public int getMaxFloor() {
		return maxFloor;
	}
	
	public ArrayList<Room> getRooms() {
		ArrayList<Room> clone = (ArrayList<Room>) rooms.clone();
		return clone;
	}
	
	public void addRoom(Room r) throws DuplicateRoomException {
		rooms.add(r);
	}
	
	public String toString() {
		return "Building(" + name + ")";
	}
	
	public void addCapacity(int value) {
		capacity += value;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean canEnter(User u) {
		for(Room elem : rooms) {
			if(elem.canEnter(u))
				return true;
		}
		
		return false;
	}
}
