package geometria;

public class Circulo extends Figura {
	private Ponto centro;
	private int raio;
	
	public Circulo(Ponto c, int r) {
		if(r < 0)
			throw new IllegalArgumentException();
		this.centro = c;
		this.raio = r;
	}
	
	public int getRaio() {
		return raio;
	}
	
	public Ponto getCentro() {
		return centro;
	}
	
	public double getArea() {
		return Math.PI * raio * raio;
	}

	@Override
	public double getPerimetro() {
		return Math.PI*2*raio;
	}
}
