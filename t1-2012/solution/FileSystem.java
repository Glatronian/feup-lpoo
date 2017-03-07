
public class FileSystem {
	protected String type;
	protected Folder root;
	protected NameFormatter formatter;

	public FileSystem(String type) {
		super();
		this.type = type;
		this.root = new Folder();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Folder getRoot() {
		return root;
	}
	
	public void setNameFormatter(NameFormatter formatter) {
		this.formatter = formatter;
		root.setFormatter(formatter);
	}
}
