/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonpreemptivepriority;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author kaushal28
 */
public class NonPreemptivePriority {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                SwingUtilities.invokeLater(new Runnable(){

			@Override
			public void run() {
				JFrame frame = new JFrame("Non-Preemptive Priority Scheduling Simulation");
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
