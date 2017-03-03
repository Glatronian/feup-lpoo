package geometria;

public class Ponto implements Comparable<Ponto> {
	private int x;
	private int y;
	
	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public boolean equals(Ponto p2) {
		return x == p2.getX() && y == p2.getY();
	}
	
	public int compareTo(Ponto p2) {
		if(x == p2.getX())
			return y - p2.getY();
		
		return x - p2.getX();
	}
}
