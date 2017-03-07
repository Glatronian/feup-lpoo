import java.util.ArrayList;

public class Comboio {
	protected String nome;
	protected int passageiros;
	protected ServicoABordo servico;
	
	protected ArrayList<Carruagem> carruagens = new ArrayList<Carruagem>();

	public int getNumCarruagens() {
		return carruagens.size();
	}

	public void addCarruagem(Carruagem a) {
		carruagens.add(a);
	}
	
	public Carruagem getCarruagemByOrder(int index) {
		return carruagens.get(index);
	}
	
	public int getNumLugares() {
		int result = 0;
		for(Carruagem elem : carruagens) {
			result+= elem.getNumLugares();
		}
		return result;
	}
	
	public int getNumPassageiros() {
		return passageiros;
	}
	
	public int getLugaresLivres() {
		return getNumLugares() - passageiros;
	}
	
	public void addPassageiros(int value) throws PassengerCapacityExceeded {
		if( (passageiros + value) > getNumLugares())
			throw new PassengerCapacityExceeded();
		passageiros += value;
	}
	
	public void removeAllCarruagens(int capacity) {
		ArrayList<Carruagem> temp = new ArrayList<Carruagem>();
		
		for(Carruagem elem: carruagens) {
			if(elem.getNumLugares() != capacity)
				temp.add(elem);
		}
		
		this.carruagens = temp;
	}
	
	public void removePassageiros(int value) {
		passageiros -= value;
	}
	
	public void removePassageiros() {
		passageiros = 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ServicoABordo getServicoABordo() {
		return servico;
	}
	
	public String getDescricaoServico() {
		return servico.getDescricaoServico();
	}
	
	public void setServicoABordo(ServicoABordo servico) {
		this.servico = servico;
	}

	public Comboio(String nome) {
		super();
		this.nome = nome;
		this.servico = new ServicoRegular();
	}
	
	@Override
	public String toString() {
		return "Comboio " + nome + ", " + getNumCarruagens() + " carruagens, " + getNumLugares() + " lugares, " + passageiros + " passageiros";
	}
	
	public boolean equals(Object obj) {
		if(getNumCarruagens() != ((Comboio) obj).getNumCarruagens())
			return false;
		
		for(int i = 0 ; i < getNumCarruagens(); i++) {
			if(carruagens.get(i).getNumLugares() != ((Comboio) obj).getCarruagemByOrder(i).getNumLugares())
				return false;
		}
		
		return true;
	}
}
