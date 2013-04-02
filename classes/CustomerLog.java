package walmart;
import java.util.*;
import java.io.*;

//	The customer log is a collection of customers in a line
public class CustomerLog {

	ArrayList<Customer> log;

	CustomerLog(){
		this.log = new ArrayList<Customer>();
	}

	public void add(Customer c){
		log.add(c);
	}

	public void print(){
		for(int i=0; i<log.size(); i++){
			System.out.println(log.get(i).getNoLine());
		}
	}

}