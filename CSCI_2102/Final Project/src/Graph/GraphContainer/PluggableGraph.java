package Graph.GraphContainer;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import Graph.GraphData.HistogramData;
import Graph.GraphElements.PieChart;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;

public class PluggableGraph {

	private ApplicationFrame chart;
	private JFrame frame;
	private JPanel panel;
	private JMenuBar menuBar;
	private JLabel label;

	/**
	 * @wbp.parser.constructor
	 */
	public PluggableGraph() {
		initialize();
	}
	
	public PluggableGraph(ApplicationFrame chart) {
		this.chart = chart;
		initialize();
	}
	
	public void setPanelComponent(Component comp) {
		if (panel.getComponents().length > 0)
			panel.removeAll();
		panel.add(comp);
		comp.setPreferredSize((new Dimension(panel.getWidth()-2, panel.getHeight()-12)));
	}
	/*
	public void setTextAreaComponent(Component comp) {
		if (panel.getComponents().length > 0)
			textArea.removeAll();
			textArea.add(comp);
		comp.setPreferredSize((new Dimension(panel.getWidth()-2, panel.getHeight()-12)));
	}
	*/
	private void initialize() {
		chart.setResizable(true);
		frame = new JFrame("Pluggable Grapher");
		frame.setBounds(0, 0, 977, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.getContentPane().setLayout(null);
		RefineryUtilities.centerFrameOnScreen(frame);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 30, 578, 509);
		frame.getContentPane().add(panel);
		
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
	}
	
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public JFrame getFrame() {
		return frame;
	}
	
	public ApplicationFrame getChart() {
		return chart;
	}
	
	public void setVisible(boolean b) {
		if (b) frame.setVisible(true);
		else frame.setVisible(false); 
	}
}