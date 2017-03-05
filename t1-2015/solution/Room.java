import java.util.ArrayList;

public class Room implements Facility {
	private Building building;
	private String number;
	private String name;
	private int floor;
	private int capacity;

	private ArrayList<User> users = new ArrayList<User>();
	
	public Room(Building b, String n, int f) throws DuplicateRoomException {
		this.building = b;
		this.number = n;
		this.name = b.getName() + n;
		this.floor = f;
		
		if(b.getMaxFloor() < f)
			throw new IllegalArgumentException();

		ArrayList<Room> rooms = b.getRooms();
		for(Room elem : rooms) {
			if(this.equals(elem)) 
				throw new DuplicateRoomException();
		}
		
		b.addRoom(this);
	}

	public Room(Building b, String n, int f, int capacity) throws DuplicateRoomException {
		this.building = b;
		this.number = n;
		this.name = b.getName() + n;
		this.floor = f;
		this.building.addCapacity(capacity);
		this.capacity = capacity;
		
		if(b.getMaxFloor() < f)
			throw new IllegalArgumentException();
		
		ArrayList<Room> rooms = b.getRooms();
		for(Room elem : rooms) {
			if(this.equals(elem)) 
				throw new DuplicateRoomException();
		}
		
		b.addRoom(this);
	}
	
	public Building getBuilding() {
		return building;
	}
	
	public String getNumber() {
		return number;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public String toString() {
		return "Room(" + building.getName() + "," + number + ")";
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean equals(Object obj) {
		return (building == ((Room) obj).getBuilding()) && 
				number.equals(((Room) obj).getNumber()) &&
				(floor == ((Room) obj).getFloor());
	}
	
	public void authorize(User u) {
		users.add(u);
	}
	
	public boolean canEnter(User u) {
		for(User elem : users) {
			if(elem.equals(u))
				return true;
		}
		
		return false;
	}
}
