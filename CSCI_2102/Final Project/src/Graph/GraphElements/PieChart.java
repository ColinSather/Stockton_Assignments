package Graph.GraphElements;
import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.Rotation;

@SuppressWarnings("serial")
public class PieChart extends ApplicationFrame {
	
	private ChartPanel chartPanel;
	private DefaultPieDataset dataset;
	private JFreeChart chart;
	
	private String chartTitle = "";
	
	public PieChart() {
		super("Pie Chart");
		
		/* Create the Dataset */
		dataset = createDataset();
		
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
	
	private DefaultPieDataset createDataset() {
		dataset = new DefaultPieDataset();		
		return dataset;
	}
	
	private JFreeChart createChart(PieDataset dataset) {

		/* Create Chart using Parameters */
		JFreeChart chart = 
			ChartFactory.createPieChart(
				/* Chart Title */
				chartTitle,
				/* Dataset Reference */
				dataset,
				true,
				true,
				false);
					
        /* Configure Chart BG Color */
        chart.setBackgroundPaint(Color.white);
        
        /* Setup Plot */
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.6f);
        
        return chart;
	}
	
	public PieChart getChart() {
		return this;
	}
	
	public ChartPanel getChartPanel() {
		return chartPanel;
	}
	
	public DefaultPieDataset getDataset() {
		return dataset;
	}
	
	public String getChartTitle() {
		return chartTitle;
	}

	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	public void displayChart() {
		initializeChart();
		this.pack();		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}

}
