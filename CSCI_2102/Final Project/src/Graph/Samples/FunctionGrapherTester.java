package Graph.Samples;
import org.jfree.data.function.Function2D;
import org.jfree.data.general.DatasetUtilities;

import Graph.GraphElements.FunctionGrapher;

public class FunctionGrapherTester {
	
	public static void main(String[] args) {
		
		// Create a new histogram chart
		FunctionGrapher grapher = new FunctionGrapher();
		grapher.setTitle("X^2");
		grapher.setHorzAxis("X");
		grapher.setVertAxis("Y");
		grapher.setDataset(DatasetUtilities.sampleFunction2D(new xSquared(), -10.0, 10.0, 100, "X^2"));
		grapher.displayChart();
		
	}

	private static class xSquared implements Function2D {
		public double getValue(double x) {
			return x * x;
        }
	}
	
}
