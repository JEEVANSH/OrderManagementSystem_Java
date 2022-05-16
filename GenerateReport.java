import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GenerateReport extends Thread{
	
	public GenerateReport() throws Exception {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss a");
	LocalDateTime deliverydate = LocalDateTime.now();
	dtf.format(deliverydate);}

	@Override
	public void run() {
	List<Orders> list=new ArrayList<Orders>();
	File file=new File("GenerateReports.txt");
	try {
	FileWriter fw=new FileWriter(file);
	if(file.exists()) {
	file.delete();
	}
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
	LocalDateTime deliverydate = LocalDateTime.now();
	dtf.format(deliverydate);
	fw.write("------------------------------------------------------\n");
	fw.write("Order report "+dtf.format(deliverydate)+"\n" );
	fw.write("------------------------------------------------------\n");
	for(Orders ord:list) {
	if(ord.getDeliveryDate().equals(deliverydate))
	fw.write("order id :"+ord.getOrderId()+"\n");
	fw.write("Order Desc :"+ord.getOrderDesc()+"\n");
	fw.write("Amount :" +ord.getAmount()+"\n");
	fw.write("Delivery Date :"+ord.getDeliveryDate()+"\n");
	fw.close();
					
				}
			}catch(Exception e) {}
		
			
			
			
			
		}
	
	}


