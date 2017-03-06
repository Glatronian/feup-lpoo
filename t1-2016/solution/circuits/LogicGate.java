package circuits;

public abstract class LogicGate {
	protected LogicVariable inputs[];
	protected LogicVariable output;
	
	public LogicVariable[] getInputs() {
		return inputs.clone();
	}

	public LogicVariable getOutput() {
		return output;
	}
	
	public abstract String getSymbol();
	
	public abstract boolean getValue(); 
	public abstract String getFormula();
}
