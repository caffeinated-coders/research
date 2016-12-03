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
        int initialCaffine = 453; //in mg of course
        int initialBloodCaff = 0; //don't really know the units of this one
        
        double caffine = initialCaffine;
        double blood = initialBloodCaff;
        
        int iterations = 10; 
        
        for(; time < iterations; time++) {
            caffine = caffineTick(caffine);
            blood = bloodTick(blood,caffine);
            double bout = Math.round(blood * 100.0) / 100.0;
            double cafout = Math.round(caffine * 100.0) / 100.0;
            System.out.println("Caffine in Body at time t= " + time + " is " + cafout + "mg");
            System.out.println("Caffine in Blood at time t= " + time + " is " + bout + "mg");
            System.out.println("");
        }

        
        // dA/dt = -(ln(2)/H1/2) × A   		     	      (2)
	// dB/dt = -k1B+k2A,

        //45 minutes after ingestion, caffine reaches 99% absorbtion
        
    }
    
    public static double caffineTick(double caffineAmount) {
        double halfLife = 1;
        double changeInLevels = -(Math.log(2) / halfLife) * caffineAmount;
        
        double result = caffineAmount + changeInLevels;
        return result;
    }
    
    public static double bloodTick(double Blood, double caffineAmount) {
        
        double CAFFINE_METABOLISM = 2.5; //per hour
        double CAFFINE_ABSORBTION = 2.7; //per hour
        double changeInBlood = -(CAFFINE_METABOLISM * Blood) + (CAFFINE_ABSORBTION * caffineAmount);
        
        double result = Blood + changeInBlood;
        
        return result;
    }
    
}
