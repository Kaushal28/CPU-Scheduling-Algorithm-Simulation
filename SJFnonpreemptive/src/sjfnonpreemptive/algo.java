/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjfnonpreemptive;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kaushal28
 */
public class algo {
    
     static int[] at, bt,cp,ct;
    static int n=0;

    
    public void algox(){
                Scanner in = new Scanner(System.in);
        System.out.println("Enter number of process:");
        n = in.nextInt();
        at = new int[n];
        bt = new int[n];
        cp = new int[n];
        ct = new int[n];
        int tat[] = new int[n];
        double avgTat, avgWt;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Arrival Time of process " + i);
            at[i] = in.nextInt();
            System.out.println("Enter Burst Time of Process " + i);
            bt[i] = in.nextInt();
            cp[i] = bt[i];
        }

       int currentTime = 0;
       
      
       ArrayList<Integer> process = new ArrayList<>();
       ArrayList<Integer> time = new ArrayList<>();
       
       time.add(currentTime);
       Utility.time.add(currentTime);
       while(checkFlag()){
           
           int min = Integer.MAX_VALUE;
           int index=0;
           for(int i=0;i<n;i++){
               if(currentTime>=at[i]){
                   if(min > bt[i] && bt[i]!=0){
                       min = bt[i];
                       index = i;
                   }
               }
           }
           
           process.add(index);
           System.out.println(index+1);
           Utility.one.add(index);
           currentTime+=bt[index];
           ct[index] = currentTime;
           time.add(currentTime);
           Utility.time.add(currentTime);
           bt[index] = 0;
           MainPanel.panel.repaint();

           try{
               Thread.sleep(1000);
           }
           catch(Exception e){
               
           }
           
       }
       
        for(int x:process){
            System.out.print(x+" ");
        }
        System.out.println();
        
                        
        for(int x:time){
            System.out.print(x+" ");
        }
        
        int sumTat = 0;
        
        for(int i=0;i<n;i++){
            sumTat += ct[i]-at[i];
            tat[i] = ct[i]-at[i];
        }
        avgTat = sumTat*1.0/n;
        Utility.at = avgTat;
        System.out.println("Avg. TAT is " + avgTat);
        int sumWt = 0;
        for(int i=0;i<n;i++){
            sumWt += tat[i]-cp[i];
        }
        avgWt = sumWt*1.0/n;
         Utility.wt = avgWt;
        System.out.println("Avg. WT is " + avgWt);
        MainPanel.panel.repaint();
        
    }
    
    
        public static boolean checkFlag(){
        boolean flag = false;
         for(int i=0;i<n;i++){
           if(bt[i] != 0){
               flag=true;
               break;
           }
       }
       return flag;
    }
}
