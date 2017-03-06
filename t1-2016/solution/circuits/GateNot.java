package circuits;

public class GateNot extends LogicGate {

	public GateNot(LogicVariable output, LogicVariable input1) throws ColisionException, CycleException {
		this.inputs = new LogicVariable[1];
		
		if(input1.getCalculatedBy().getInputs()[0] == output || input1.getCalculatedBy().getInputs()[1] == output)
			throw new CycleException();

		if(output.getCalculatedBy() != null)
			throw new ColisionException();
		output.setCalculatedBy(this);
	
		output.setValue(!input1.getValue());
		
		this.output = output;
		this.inputs[0] = input1;
	}
	
	@Override
	public String getSymbol() {
		return "NOT";
	}
	
	@Override
	public boolean getValue() {
		return !(inputs[0].getValue()); 
	}
	
	@Override
	public String getFormula() {
		return "NOT(" + inputs[0].getFormula() + ")";
	}
}