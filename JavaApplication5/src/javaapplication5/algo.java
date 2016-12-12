/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author kaushal28
 */
public class algo {
    
    public static ArrayList<Integer> process;
    
    public void algox(){
          
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the number of process:");
        int n = in.nextInt(); 
        int at[] = new int[n];
        int bt[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        int ct[] = new int[n];
        int cp[] = new int[n];
        double avgTat, avgWt;
        int currenttime=0,totaltime=0,timeQ;
        
        for(int i=0;i<n;i++){
            System.out.println("Enter Arrival time of process "+i+": ");
            at[i] = in.nextInt();
            System.out.println("Enter Burst time of process "+i+": ");
            bt[i] = in.nextInt();
            totaltime+=bt[i];  
            cp[i] = bt[i];
        }
        
        System.out.println("Enter the value of Time quantum:");
        timeQ = in.nextInt();
        
        
        Queue<Integer> q = new LinkedList<>();
        int pushed[] = new int[n];

        Set<Integer> time = new HashSet<>();
        process = new ArrayList<>();
        time.add(0);
        Utility.time.add(0);
        
        q.add(0);
        pushed[0] = 1;
        process.add(1);
         MainPanel.panel.repaint();
         Utility.one.add(0);
        System.out.println(1+"st Process added" );
        do{ 
            if(bt[q.peek()] >= timeQ){
                bt[q.peek()]-=timeQ;
                currenttime += timeQ;  
                time.add(currenttime);
                Utility.time.add(currenttime);
                for(int i=0;i<n;i++){
                    if(pushed[i] == 0 && at[i]<=currenttime){
                        q.add(i);
                        System.out.println(i+1+"th Process added" );
                         MainPanel.panel.repaint();
                         Utility.one.add(i);
                        process.add(i+1);
                        pushed[i] = 1;
                    }
                }
                if(bt[q.peek()] > 0){
                    int appendingProcess = q.remove();
                    q.add(appendingProcess);
                    System.out.println(appendingProcess+1+"th Process added" );
                    Utility.one.add(appendingProcess);
                     MainPanel.panel.repaint();
                    process.add(appendingProcess+1);
                }

            }
            else{
                currenttime += bt[q.peek()];
                ct[q.peek()] = currenttime;
                bt[q.peek()] = 0;
                time.add(currenttime);
                Utility.time.add(currenttime);
                for(int i=0;i<n;i++){
                    if(pushed[i] == 0 && at[i]<=currenttime){
                        q.add(i);
                        System.out.println(i+1+"th Process added" );
                        Utility.one.add(i);
                         MainPanel.panel.repaint();
                        pushed[i] = 1;
                    }
                }
                q.remove();
            }
            //System.out.println("dd");
             try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        while(!q.isEmpty());
        System.out.println(time);
        System.out.println(process); 
        int sumTat = 0;
        
        for(int i=0;i<n;i++){
            sumTat += ct[i]-at[i];
            tat[i] = ct[i]-at[i];
        }
        avgTat = sumTat*1.0/n;
        System.out.println("Avg. TAT is " + avgTat);
        Utility.at = avgTat;
        int sumWt = 0;
        for(int i=0;i<n;i++){
            sumWt += (tat[i]-cp[i]);
        }
        avgWt = sumWt*1.0/n;
        System.out.println("Avg. WT is " + avgWt);        
        Utility.wt = avgWt;
        MainPanel.panel.repaint();
    }
    
}
