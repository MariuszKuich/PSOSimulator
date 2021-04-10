package models;

import org.jzy3d.plot3d.builder.Mapper;

public class FunctionData {

	private String formulaString;

	private Mapper formulaMapper;

	private int defaultMinX;

	private int defaultMaxX;

	private int defaultMinY;

	private int defaultMaxY;

	public FunctionData(String formulaString, Mapper formulaMapper, int minX, int maxX, int minY, int maxY) {
		this.formulaString = formulaString;
		this.formulaMapper = formulaMapper;
		defaultMinX = minX;
		defaultMaxX = maxX;
		defaultMinY = minY;
		defaultMaxY = maxY;
	}

	public String getFormulaString() {
		return formulaString;
	}

	public Mapper getFormulaMapper() {
		return formulaMapper;
	}

	public int getDefaultMinX() {
		return defaultMinX;
	}

	public int getDefaultMaxX() {
		return defaultMaxX;
	}

	public int getDefaultMinY() {
		return defaultMinY;
	}

	public int getDefaultMaxY() {
		return defaultMaxY;
	}
}
