/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fcfs;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author kaushal28
 */
public class MainPanel extends JPanel {
        public static Chart panel;
	MainPanel(){
		panel = new Chart();
		setLayout(new BorderLayout());
		//add(new menuPanel(),BorderLayout.SOUTH);
		add(panel,BorderLayout.CENTER);
		panel.repaint();
		
	}
}
