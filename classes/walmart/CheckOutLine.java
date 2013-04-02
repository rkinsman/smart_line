package walmart;
import java.util.*;
import java.io.*;

// The CheckOutLine is a collection of Customers in a single line at Walmart.
public class CheckOutLine {

	ArrayList<Customer> line;

	CheckOutLine(){
		this.line = new ArrayList<Customer>();
	}

	//	Puts target customer at the back of the line
	public void add(Customer c){
		line.add(c);
	}

	//	gets total wait time for specific customer
	public int getTotalWait(Customer c){
		if(!line.contains(c)){	//check that target is in line
			return 0;
		}
		else if(line.indexOf(c) == 0){	//check that target is not at front of line
			return c.getProccessTime();
		}
		else if(line.get(line.indexOf(c)-1).getDepartMin() < c.getArrivalMin()){	//check that target has to wait on another customer
			return c.getProccessTime();
		}
		else{	//add process time of target to wait time of customer ahead of target
			return c.getProccessTime() + (line.get(line.indexOf(c)-1).getDepartMin() - c.getArrivalMin());
		//	return (c.getProccessTime() + getTotalWait(line.get(line.indexOf(c)-1)));
		}	
	}

	//	gets the time the customer waited to be processed
	public int getWait(Customer c){
		return getTotalWait(c) - c.getProccessTime();
	}

	//	Returns the average time spent in the line, including process time
	public int getAvgTotalWait(){
		int sum = 0;

		for(int i=0;i<line.size();i++){
			sum += getTotalWait(line.get(i));
		}

		return (sum / line.size());
	}

	//	Returns the average time spent waiting to be processed
	public int getAvgWait(){
		int sum = 0;

		for(int i=0;i<line.size();i++){
			sum += getWait(line.get(i));
		}

		return (sum / line.size());
	}

	private String formatTime(int mins){
		int h = mins/60;
		int m = mins%60;

		return h + ":" + m;
	}

	// Prints the wait time of every customer in the line
	public void printDepartureNoWait(){
		for(int i=0; i<line.size(); i++){
			System.out.println(line.get(i).getNoWait());
		}
	}

	public void printWaitTime(){
		for(int i=0;i<line.size();i++){
			System.out.println(line.get(i).getName() + " arrived at " + formatTime(line.get(i).getArrivalMin()) + " waited " + getWait(line.get(i)) + 
				" minutes before being helped, took " + line.get(i).getProccessTime() + 
				" minutes to check out, for a total wait time of " + getTotalWait(line.get(i)) + 
				" minutes, leaving at " + formatTime(line.get(i).getDepartMin()));
		}
		System.out.println("The average wait time was " + getAvgWait() + 
			", and the average total tim spent in line was " + getAvgTotalWait() + ".");
	}

}