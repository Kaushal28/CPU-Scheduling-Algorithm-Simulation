/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preemptivepriority;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import javax.swing.JPanel;

/**
 *
 * @author kaushal28
 */
public class Chart extends JPanel{
        	int startx = 0;
	int endx = 900;
	int delta = 70;
        
        
        
	Chart(){
	}
        
        public int GetN(int z){
            Iterator<Integer> itr = Utility.time.iterator();
            int nth = z;
            int value = 0;

            for(int i = 0; itr.hasNext(); i++) {
              value = itr.next();
              if (i == nth) {
                break;
              }
            }
            return value;
        }
	
        
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.black);
		g2.setFont(new Font("SansSerif",Font.BOLD,20));
		
		g2.drawLine(startx, 50, endx, 50);
		g2.drawLine(startx, 150, endx, 150);
		g2.drawString("GANTT CHART", (startx+endx)/2 - 15, 40);
		
		
		int position,pivotY,pivotX;

                for(int i=0;i<Utility.one.size();i++){
                    pivotY = 50;
                    pivotX = 10 + 40 * (i);	
                    addProcess(Utility.one.get(i),pivotX, pivotY,g2);
                }
                
                for(int i=0;i<Utility.time.size();i++){
                    pivotY = 150;
                    pivotX = 15 + 40 * (i);	
                    addTime(pivotX, pivotY,GetN(i),g2);
                }


            
            drawVal(g2);
		
	}
	
	public void addProcess(int i ,int pivotX,int  pivotY,Graphics2D g2){
		g2.setColor(Color.GRAY);
		g2.setFont(new Font("SansSerif",Font.BOLD,15));
		g2.drawRect(pivotX,pivotY,30,100);
		g2.fillRect(pivotX, pivotY,30,100);
		g2.setColor(Color.black);
                int x = i+1;
		g2.drawString("P" + x  , pivotX+5, pivotY+20);
	}
        public void addTime(int x, int y,int i,Graphics2D g2){
            g2.drawString(i+"", x-9,y+15);
        }        
        public void drawVal(Graphics2D g2){
            g2.drawString("Avg. Turn around Time:" + Utility.at, 15,205);
            g2.drawString("Avg. Waiting Time:" + Utility.wt, 15,225);
        }
}
