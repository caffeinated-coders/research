import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Graphics.*;
import java.lang.Math.*;

public class TestingStuff {
    public static void main(String[] args) {
        //Let's do some caffine calculations. 
        
        int time = 0;             //in hours
        int initialCaffine = 500; //in mg of course     //amount of coffee in body (decays exponentially)
        int initialBloodCaff = 0; //in mg               //amount of coffee in blood and brain
        
        double caffine = initialCaffine;
        double blood = initialBloodCaff;
        
        int iterations = 24; 
        
        for(; time < iterations; time++) {
            double bout = Math.round(blood * 100.0) / 100.0;
            double cafout = Math.round(caffine * 100.0) / 100.0;
            System.out.print("At t = " + time + " Body caffine is " + cafout + "mg");
            System.out.println(" and caffine in brain is " + bout + "mg");
            System.out.println("");
            caffine = caffineTick(caffine);
            blood = bloodTick(blood,caffine);
            
        }

        
        // dA/dt = -(ln(2)/H1/2) × A   		     	      (2)
	// dB/dt = -k1B+k2A,

        //45 minutes after ingestion, caffine reaches 99% absorbtion
        
    }
    
    public static double caffineTick(double caffineAmount) {
        double halfLife = 5.7; //
        double changeInLevels = -(Math.log(2) / halfLife) * caffineAmount;
        
        double result = caffineAmount + changeInLevels;
        return result;
    }
    
    public static double bloodTick(double Blood, double caffineAmount) {
        
        double CAFFINE_METABOLISM = 1/2.5; //per hour
        double CAFFINE_ABSORBTION = 1/2.7; //per hour
        double changeInBlood = (-CAFFINE_METABOLISM * Blood) + (CAFFINE_ABSORBTION * caffineAmount);
        
        double result = Blood + changeInBlood;
        
        return result;
    }
    
}
