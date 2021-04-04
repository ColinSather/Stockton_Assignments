package Graph.GraphData;
public class HistogramData {
	
	private Number value;
	private String rowKey;
	private String colKey;
	private int rank = 0;

	public HistogramData() {
		
	}
	
	public HistogramData(Number value, String rowKey, String colKey ) {
		this.rowKey = rowKey;
		this.colKey = colKey;
		this.value = value;
	}
	public int getRank() {
		return rank++;
	}
	public String toString() {
		return colKey+" | "+value+"% | "+rowKey;
	}
	
	public void setRowKey(String rowKey) {
		this.rowKey = rowKey;
	}
	
	public void setColKey(String colKey) {
		this.colKey = colKey;
	}
	
	public String getRowKey() {
		return rowKey;
	}
	
	public String getColKey() {
		return colKey;
	}
	
	public void setValue(Number value) {
		this.value = value;
	}
	
	public Number getValue() {
		return value;
	}
		
}
