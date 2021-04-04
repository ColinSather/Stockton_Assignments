package Graph.GraphElements;
import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;

@SuppressWarnings("serial")
public class FunctionGrapher extends ApplicationFrame {
	
	private ChartPanel chartPanel;
	private XYDataset dataset;
	private JFreeChart chart;
	
	private String chartTitle = "";
	private String horzAxis = "";
	private String vertAxis = "";
	private boolean includeLegend = true;
	private boolean includeTooltips = true;
	private boolean includeURLs = false;
	
	public FunctionGrapher() {
		super("Function Grapher");
	}
	
	public void initializeChart() {
		/* Create the Chart */
        chart = createChart(dataset);
        
        /* Create a Chart Panel */
        chartPanel = new ChartPanel(chart);
        
        /* Setup Panel */
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(600, 400));
        
        /* Add Panel to the ApplicationFrame */
        setContentPane(chartPanel);
       
	}
	
	public void setDataset(XYDataset dataset) {
		this.dataset = dataset;
		chart = createChart(dataset);
	}
		
	public JFreeChart createChart(XYDataset dataset) {

		/* Create Chart */
		JFreeChart chart = 
			ChartFactory.createXYLineChart(
				/* Chart Title */
				chartTitle,
				/* X-Axis Label */
				horzAxis,
				/* Y-Axis Label */
				vertAxis, 		
				/* Dataset Reference */
				dataset,
				/* Plot Orientation */
				PlotOrientation.VERTICAL,
				/* Include Legend */
				includeLegend,
				/* Include Tooltips */
				includeTooltips,
				/* Include URLs */
				includeURLs
			);
		
        /* Configure Chart BG Color */
        chart.setBackgroundPaint(Color.white);
        
        /* Setup Plot */
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.getDomainAxis().setLowerMargin(0.0);
        plot.getDomainAxis().setUpperMargin(0.0);
        return chart;
	}
	
	public FunctionGrapher getChart() {
		return this;
	}
	
	public ChartPanel getChartPanel() {
		return chartPanel;
	}
	
	public XYDataset getDataset() {
		return dataset;
	}
	
	public String getChartTitle() {
		return chartTitle;
	}

	public String getHorzAxis() {
		return horzAxis;
	}

	public String getVertAxis() {
		return vertAxis;
	}

	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	public void setHorzAxis(String horzAxis) {
		this.horzAxis = horzAxis;
	}

	public void setVertAxis(String vertAxis) {
		this.vertAxis = vertAxis;
	}

	public void displayChart() {
		initializeChart();
		this.pack();		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}

}
