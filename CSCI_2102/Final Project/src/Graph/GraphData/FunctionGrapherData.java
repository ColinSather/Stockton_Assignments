package Graph.GraphData;
public class FunctionGrapherData {
	
	private String xValue;
	private Number yValue;
	
	public FunctionGrapherData() {
		
	}
	
	public FunctionGrapherData(String xValue, Number yValue) {
		this.xValue = xValue;
		this.yValue = yValue;
	}

	public String getxValue() {
		return xValue;
	}

	public Number getyValue() {
		return yValue;
	}

	public void setxValue(String xValue) {
		this.xValue = xValue;
	}

	public void setyValue(Number yValue) {
		this.yValue = yValue;
	}
	
		
}
