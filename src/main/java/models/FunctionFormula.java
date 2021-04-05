package models;

import org.jzy3d.plot3d.builder.Mapper;

public class FunctionFormula {

	private String formulaString;

	private Mapper formulaMapper;

	public FunctionFormula(String formulaString, Mapper formulaMapper) {
		this.formulaString = formulaString;
		this.formulaMapper = formulaMapper;
	}

	public String getFormulaString() {
		return formulaString;
	}

	public void setFormulaString(String formulaString) {
		this.formulaString = formulaString;
	}

	public Mapper getFormulaMapper() {
		return formulaMapper;
	}

	public void setFormulaMapper(Mapper formulaMapper) {
		this.formulaMapper = formulaMapper;
	}
}
