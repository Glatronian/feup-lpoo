
public class File extends Node {

	public File(Folder parent, String name) throws DuplicateNameException {
		this.parent = parent;
		this.name = name;
		this.formatter = parent.getFormatter();

		parent.addChild(((Node) this));
	}
	
	public File(Folder parent, String name, int size) throws DuplicateNameException {
		this.parent = parent;
		this.name = name;
		this.size = size;
		this.formatter = parent.getFormatter();

		parent.addChild(((Node) this));
	}

	@Override
	public Node getChildByName(String name) {
		return null;
	}
	
	@Override
	public int getSize() {
		return size;
	}
	
	@Override
	public void setFormatter(NameFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public String getPath() {
		String result = parent.getPath();
		result += formatter.getSeparator() + name;
		return result;
	}

	@Override
	public Node clone(Node parent, String name) throws DuplicateNameException {
		return ((Node) new File((Folder) parent, name));
	}
	
	@Override
	public boolean equals(Object obj) {
		return name.equals(((File) obj).getName()) && (size == ((File) obj).getSize());
	}

	@Override
	public void move(Folder parent, String name) throws DuplicateNameException, CycleException {
		this.parent = parent;
		this.name = name;
	}
}
