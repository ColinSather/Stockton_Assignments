import AdvancedGraphics.Unit2Proj;

import java.awt.*;

public class Bootstrap {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Unit2Proj window = new Unit2Proj();
					window.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}