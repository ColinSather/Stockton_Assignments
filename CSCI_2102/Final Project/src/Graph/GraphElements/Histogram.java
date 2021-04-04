package Graph.GraphElements;
import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

@SuppressWarnings("serial")
public class Histogram extends ApplicationFrame {
	
	private ChartPanel chartPanel;
	private DefaultCategoryDataset dataset;
	private JFreeChart chart;
	
	private String chartTitle = "";
	private String subTitle = "";
	private String horzAxis = "";
	private String vertAxis = "";
	
	public Histogram() {
		super("Histogram");
		
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
        chartPanel.setPreferredSize(new Dimension(2000, 1000));
        
        /* Add Panel to the ApplicationFrame */
        setContentPane(chartPanel);
       
	}
	
	private DefaultCategoryDataset createDataset() {
		dataset = new DefaultCategoryDataset();		
		return dataset;
	}
	
	private JFreeChart createChart(CategoryDataset dataset) {

		/* Create Chart using Parameters */
		JFreeChart chart = 
			ChartFactory.createBarChart(
					/* Chart Title */
					chartTitle,
					/* X-Axis Label */
					horzAxis,
					/* Y-Axis Label */
					vertAxis, 		
					/* Dataset Reference */
					dataset);
		
		/* Add Chart Subtitle */
        chart.addSubtitle(new TextTitle(subTitle));
        
        /* Configure Chart BG Color */
        chart.setBackgroundPaint(Color.white);
        
        /* Setup Plot */
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        chart.getLegend().setFrame(BlockBorder.NONE);
        return chart;
	}
	
	public Histogram getChart() {
		return this;
	}
	
	public ChartPanel getChartPanel() {
		return chartPanel;
	}
	
	public DefaultCategoryDataset getDataset() {
		return dataset;
	}
	
	public String getChartTitle() {
		return chartTitle;
	}

	public String getSubTitle() {
		return subTitle;
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

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
		initializeChart();
	}

	public void setHorzAxis(String horzAxis) {
		this.horzAxis = horzAxis;
		initializeChart();
	}

	public void setVertAxis(String vertAxis) {
		this.vertAxis = vertAxis;
		initializeChart();
	}

	public void displayChart() {
		initializeChart();
		this.pack();		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		RefineryUtilities.centerFrameOnScreen(this);
		this.setVisible(true);
	}

}
