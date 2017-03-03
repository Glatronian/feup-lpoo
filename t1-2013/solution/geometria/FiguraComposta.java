package geometria;

public class FiguraComposta extends Figura {
	private Figura[] figuras;
	
	FiguraComposta(Figura[] figs) {
		this.figuras = figs;
	}

	@Override
	public double getArea() {
		double result = 0;
		for(Figura elem : figuras)
			result += elem.getArea();
		return result;
	}

	@Override
	public double getPerimetro() {
		double result = 0;
		for(Figura elem : figuras)
			result += elem.getPerimetro();
		return result;
	}
	
	@Override
	public int count() {
		return figuras.length;
	}
}
