package geometria;

public class Circulo {
	private Ponto centro;
	private int raio;
	
	public Circulo(Ponto c, int r) {
		this.centro = c;
		this.raio = r;
	}
	
	public int getRaio() {
		return raio;
	}
	
	public Ponto getCentro() {
		return centro;
	}
}
