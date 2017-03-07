import java.util.ArrayList;

public class Folder extends Node {
	
	private ArrayList<Node> children = new ArrayList<Node>();
	
	public Folder() {
		this.parent = null;
		this.name = "root";
	};
	
	public Folder(Folder parent, String name) throws DuplicateNameException {
		super();
		this.parent = (Node) parent;
		this.name = name;
		this.formatter = parent.getFormatter();

		parent.addChild(((Node) this));
	}
	
	public void addChild(Node child) throws DuplicateNameException {
		for(Node elem : children) {
			if(elem.getName().equals(child.getName()))
				throw new DuplicateNameException();
		}
		
		children.add(child);
	}
	
	public Node[] getChild() {
		return children.toArray(new Node[children.size()]);
	}

	@Override
	public Node getChildByName(String name) {
		for(Node elem : children) {
			if(elem.getName().equals(name))
				return elem;
		}
		
		return null;
	}
	
	@Override
	public int getSize() {
		int result = 0;
		for(Node elem : children) {
			result += elem.getSize();
		}
		
		return result;
	}
	
	@Override
	public void setFormatter(NameFormatter formatter) {
		this.formatter = formatter;

		for(Node elem : children) {
			elem.setFormatter(formatter);
		}
	}
	
	@Override
	public String getPath() {
		if(parent == null)
			return ""; 

		String result = parent.getPath() + formatter.getSeparator() + name;
		return result;
	}
	
	public Folder clone(Folder parent, String name) throws DuplicateNameException {
		Folder clone = new Folder(parent, name);
		
		for(Node elem : children) {
			elem.clone((Node) clone, elem.getName());
		}
		
		return clone;
	}
	
	@Override
	public Node clone(Node parent, String name) throws DuplicateNameException {
		Folder clone = new Folder((Folder) parent, name);
		
		for(Node elem : children) {
			elem.clone((Node) clone, elem.getName());
		}
		
		return ((Node) clone);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(name.equals(((Folder) obj).getName()))) 
			return false;
		
		return true;
		//Should also compare the folder's chilren, but whatever
	}

	@Override
	public void move(Folder parent, String name) throws DuplicateNameException, CycleException {
		if(this.parent != parent && this.parent.getParent() != parent)
			throw new CycleException();

		this.parent = parent;
		for(Node elem : children)
			elem.move(this, elem.getName());
	}
}
