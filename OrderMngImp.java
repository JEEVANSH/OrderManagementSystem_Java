import java.io.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class OrderMngImp implements OrderManagement{
	Scanner scannerInt= new Scanner(System.in);
	Scanner scannerStr= new Scanner(System.in);
    static	List<Orders> list=new ArrayList<Orders>();
	DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss a");
	
	public void getfile(){
	File file = new File("final.txt");
	try (BufferedReader br = new BufferedReader(new FileReader(file)))
    {
    br.readLine();
    br.readLine();
    br.readLine();
    while (br.ready()) {
    String[] parts=br.readLine().split(" ");
    for(int i=0;i<parts.length;i++) {
	String oId=parts[0];
	int orderId=Integer.parseInt(oId);
	String orderdes=parts[3];
	String ordadd=parts[5];
	String ordertime=parts[7]+" "+parts[8]+" "+parts[9];
	LocalDateTime dateTime = LocalDateTime.parse(ordertime,dtFormat);
	String amt=parts[11];
	double amount=Double.parseDouble(amt);
	String delverydate=parts[13];
	list.add(new Orders(orderId, orderdes, ordadd, amount, dateTime));
	break;
    }
    for(Orders e:list) {
    	System.out.println(e);
    }
    }
    } catch (IOException e) {
    System.out.println("file is not loading");
    }
	}
	
	@Override
	public void addOrder() throws Exception {
	String choice;int orderId;double amount = 0 ;
	do{
	System.out.println(" Add Order : \n");
	System.out.println("Add the order by entering following values");
	boolean found;
	do{
	found = false;
	System.out.print("Enter the order id : ");
	orderId=scannerInt.nextInt();
	for(Orders ord:list) {
	if(ord.getOrderId()==orderId) {
	System.out.println("Duplicate Order Id. Please enter unique order id");
	found=true;
	}
	}}while(found==true);	
	System.out.print("Order Description : ");
	String orderDesc = scannerStr.nextLine();
	System.out.print("Delivery Address : ");
	String orderDelAdd = scannerStr.nextLine();
	while(true) {
		System.out.print("Enter amount : ");
	try {
	 amount= Integer.parseInt(scannerInt.next());
	 break;}
	catch(Exception e) {
		System.out.println("Entered value is not an integer");	
	}}
	LocalDateTime orderDate = LocalDateTime.now();
	System.out.println("Order time : "+dtFormat.format(orderDate));
	list.add(new Orders(orderId, orderDesc, orderDelAdd,amount,orderDate));
	System.out.println("Do you want to enter more order details(Y/N)");
	choice=scannerStr.nextLine();
	}while(choice.equalsIgnoreCase("Y"));
	System.out.println("Order Added Successfully");
	}
	
	@Override
	public void viewOrder() throws Exception {
	System.out.println("------------------------------------------------------------------------------------------------------------");
	System.out.println("OrderId | OrderDesc | Delivery Address |OrderDate                     |Amount        |DeliveryDate");
	System.out.println("------------------------------------------------------------------------------------------------------------");
	Iterator<Orders> itr=list.iterator();
	while(itr.hasNext()) {
	Orders o=itr.next();
	System.out.println(o.getOrderId()+"  \t " +o.getOrderDesc()+" \t "+o.getOrderDelAdd()+" \t "+o.getOrderDate()+" \t "+o.getAmount()+" \t ");
	}
	System.out.println("-------------------------------------------------------------------------------------------------------------");
	}
	
	@Override
	public void viewByOrderId()throws Exception  {
	boolean found=false;
	System.out.print("Enter the order id  to search : ");
	int searchId=scannerInt.nextInt();
	System.out.println("------------------------------------------------------------------------------------");
	System.out.println("Order Detail :");
	System.out.println("------------------------------------------------------------------------------------");
	Iterator<Orders> itr=list.iterator();
	while(itr.hasNext()) {
	Orders order=itr.next();
	if(order.getOrderId()==searchId){
	System.out.println("Order Id : "+ order.getOrderId());
	System.out.println("Order Desc : "+ order.getOrderDesc());
	System.out.println("Delivery Address : "+ order.getOrderDelAdd());
	System.out.println("Order Date : "+order.getOrderDate());
	System.out.println("Amount : "+order.getAmount());
	System.out.println("Delivery Date : "+order.getDeliveryDate());
	found=true;
	}
	}
	if(!found)
	System.out.println("Record not found");	
	System.out.println("---------------------------------------------------------------------------");
	}
		
	@Override
	public void sortOrder()throws Exception {
	System.out.println("******** Choose Sort Order Property********* ");
	System.out.println("1. OrderId ");
	System.out.println("2. Order Desc ");
	System.out.println("3. Delivery Address ");
	System.out.println("4. Order Date ");
	System.out.println("5. Amount ");
	System.out.println("6. Delivery Datetime ");
	int sort=scannerInt.nextInt();
	switch (sort) {
	case 1:Collections.sort(list, new Comparator<Orders>() {
	@Override
	public int compare(Orders order1, Orders order2) {
	return order1.getOrderId()- order2.getOrderId();}});
	System.out.println("Successfully Sorted by Order Id");
	break;
	case 2: Collections.sort(list, new Comparator<Orders>() {
	@Override
	public int compare(Orders order1, Orders order2) {
	return order1.getOrderDesc().compareTo(order2.getOrderDesc());}});
	System.out.println("Successfully Sorted by Order Desc");
	break;
	case 3: Collections.sort(list, new Comparator<Orders>() {
	@Override
	public int compare(Orders order1, Orders order2) {
	return order1.getOrderDelAdd().compareTo(order2.getOrderDelAdd());}});
	System.out.println("Successfully Sorted by Order Delivery Address");
	break;
	case 4: Collections.sort(list, new Comparator<Orders>() {
	@Override
	public int compare(Orders order1, Orders order2) {
	return order1.getOrderDate().compareTo(order2.getOrderDate());}});
	System.out.println("Successfully Sorted by Order Date");
	break;
	case 5: Collections.sort(list, new Comparator<Orders>() {
	@Override
	public int compare(Orders order1, Orders order2) {
	return order1.getAmount()>order2.getAmount() ? 1 : (order1.getAmount()<order2.getAmount()? -1:0);}});
	System.out.println("Successfully Sorted by Amount");
	break;
	case 6: Collections.sort(list, new Comparator<Orders>() {
	@Override
	public int compare(Orders order1, Orders order2) {
	return order1.getDeliveryDate().compareTo(order2.getDeliveryDate());}});
	System.out.println("Successfully Sorted by Amount");
	break;
	default:System.out.println("Enter correct number");
	}
	}

	@Override
	public void deletByOrderId() throws Exception {
	String choice;
	do{ 
	boolean found=false;
	System.out.print("Enter the Order Id  to delete : ");
	int deletId=scannerInt.nextInt();
	System.out.println("---------------------------------------------------------------------------");
	Iterator<Orders> itr=list.iterator();
	while(itr.hasNext()) {
	Orders ord=itr.next();
	if(ord.getOrderId()==deletId){
	itr.remove();
	found=true;
	}
	}
	if(!found)
	System.out.println("Order Id is not available");	
	else
	System.out.println("Order Deleted successfully");
	System.out.println("---------------------------------------------------------------------------");
	System.out.println("Do you want to delete another order(Y/N)");
	choice=scannerStr.nextLine();
	if(choice.equals("y"))
	choice="Y";
	}
	while(choice.equals("Y"));
	}
	
	@Override
	public void markAsDelivery() throws Exception {
	String choice;
	do{
	LocalDateTime deliverydate = LocalDateTime.now();
	System.out.println("Enter the Order Id for delivery");
	int manageDelv=scannerInt.nextInt();
	boolean found=false;
	System.out.println("---------------------------------------------------------------------------");
	Iterator<Orders> itr=list.iterator();
	while(itr.hasNext()) {
	Orders order=itr.next();
	if(order.getOrderId()==manageDelv){
	dtFormat.format(deliverydate);
	//o.setDeliveryDate(deliverydate);
	found=true;
	}
	}
	if(!found)
	System.out.println("Duplicate Order Id. Please enter unique order id");
	else
	System.out.println("Successfully delivered");
	System.out.println("---------------------------------------------------------------------------");
	System.out.println("Do you want to mark another Order as Delivered(Y/N) ");
	choice=scannerStr.nextLine();
	if(choice.equals("y"))
	choice="Y";
	}
	while(choice.equals("Y"));
	}

	@Override
	public void generateReport() throws Exception {
	GenerateReport gr = null;
	try{
	gr = new GenerateReport();
	} catch (Exception e) {
	System.out.println("Report is not Generated Successfully");}
	gr.start();
	System.out.println("Report Generated Successfully\n");		
	}

	@Override
	public void exit() throws Exception {
		LocalDateTime orderDate = LocalDateTime.now();
		dtFormat.format(orderDate);
	File file1=new File("final.txt");
	try {
	BufferedWriter fw = new BufferedWriter(new FileWriter(file1));  
	fw.write("------------------------------------------------------------------------------------------------------------\n");
	fw.write("OrderId | OrderDesc | Delivery Address |OrderDate                     |Amount        |DeliveryDate\n");
	fw.write("------------------------------------------------------------------------------------------------------------\n");
	Iterator<Orders> i=list.iterator();
	for(Orders o:list) {
	fw.write(o.getOrderId()+"  \t " +o.getOrderDesc()+" \t "+o.getOrderDelAdd()+" \t "+dtFormat.format(orderDate)+" \t " +o.getAmount()+" \t "+o.getDeliveryDate()+"\n");
	}
//	fw.write("-------------------------------------------------------------------------------------------------------------\n");
	fw.close();
	}
	catch(Exception e) {System.out.println("error");}
	System.out.println("Exited");	
	}}



