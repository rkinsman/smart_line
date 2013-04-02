package walmart;
import java.util.*;
import java.io.*;


public class Customer {
	
	private String fullname;
	private int aHour;
	private int aMin;
	private int proccessTime;

	Customer(String lname, String fname, int hours, int mins, int proccessTime){	
		this.fullname = lname + ", " + fname;
		this.aMin = mins;
		this.aHour = hours;
		this.proccessTime = proccessTime;
	}	

	//	Returns the customer name
	public String getName(){
		return fullname;
	}

	//	Returns the time the customer takes to checkout
	public int getProccessTime(){
		return proccessTime;
	}

	//	Returns the time in minutes that the customer gets in line
	public int getArrivalMin(){
		return (aHour * 60) + aMin;
	}


	//	Returns the time in minutes that the customer is done being proccessed
	public int getDepartMin(){
		int hour = aHour;
		int min = aMin;
		String post = " - " + fullname + " left";

		if((aMin + proccessTime) >= 60){
			min = (aMin+proccessTime) - 60;
			hour++;
		}
		else {
			min = (aMin+proccessTime);
		}

		return (hour * 60) + min;
	}

	//	Prints the time that every customer is done being processed
	public String getNoWait(){
		int hour = aHour;
		int min = aMin;
		String post = " - " + fullname + " left";

		if((aMin + proccessTime) >= 60){
			min = (aMin+proccessTime) - 60;
			hour++;
		}
		else {
			min = (aMin+proccessTime);
		}

		String extra = (min < 10) ? "0" : "";

		return  hour + ":" + extra + min + post;
	}

}
