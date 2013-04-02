package walmart;
import java.util.*;
import java.io.*;

public class Walmart{


	public static void main(String[] args) {
		//CustomerLog cl = new CustomerLog();

		//numLines = args[0];

		CheckOutLine col = new CheckOutLine();
		BufferedReader in;
		int lineWaitTime = 0;

		try {
			in = new BufferedReader(new FileReader("../input2.txt"));

			String line;;

			while ((line = in.readLine()) != null) {
				String data[] = line.split(",");
				String minHour[] = data[2].split(":");
				int hour = Integer.parseInt(minHour[0].trim());
				int min = Integer.parseInt(minHour[1].trim());
				int proccess = Integer.parseInt(data[3].trim());


				Customer c = new Customer(data[0],data[1],hour,min,proccess);
			//	cl.add(c);
				col.add(c);
			}

			in.close();

		} catch (IOException err){
			err.printStackTrace();
		}


		//col.printDepartureNoWait();
		col.printWaitTime();
	}


}