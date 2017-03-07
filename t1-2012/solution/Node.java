
public abstract class Node {
	protected static int number;
	protected Node parent;
	protected String name;
	protected int size;
	protected NameFormatter formatter;
	
	public Node() {
		number++;
	};

	public Node getParent() {
		return parent;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract Node getChildByName(String name);
	
	public static void resetNumbering(int value) {
		number = value;
	}
	
	public static int getNumber() {
		return number;
	}
	
	public abstract int getSize();
	
	public abstract void setFormatter(NameFormatter formatter);
	
	public NameFormatter getFormatter() {
		return formatter;
	}

	public abstract String getPath();
	
	public abstract Node clone(Node parent, String name) throws DuplicateNameException;
	
	public abstract void move(Folder parent, String name) throws DuplicateNameException, CycleException;
}

