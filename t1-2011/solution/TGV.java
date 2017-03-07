
public class TGV extends Comboio {

	public TGV(String nome) {
		super(nome);
		this.servico = new ServicoPrioritario();
	}

	@Override
	public String toString() {
		return "TGV " + nome + ", " + getNumCarruagens() + " carruagem, " + getNumLugares() + " lugar, " + passageiros + " passageiros";
	}
}
