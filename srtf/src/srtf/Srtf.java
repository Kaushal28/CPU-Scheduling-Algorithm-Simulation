/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srtf;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 *
 * @author kaushal28
 */
public class Srtf {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				JFrame frame = new JFrame("Shortest Remaining Time First Simulation");
				frame.add(new MainPanel());
				frame.setSize(900,300);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				new Thread(new Runnable(){
					@Override
					public void run() {
						new algo().algox();						
					}				
				}).start();	
			}
		});
    }
}
