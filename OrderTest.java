
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderTest{
	public static void main(String[] args) throws Exception {
		OrderManagement orderMang=new OrderMngImp();
		OrderMngImp omg = new OrderMngImp();
	
		omg.getfile();
	   
		Scanner s=new Scanner(System.in);
		int choice;
		do{
		System.out.println("************Order Management System************* ");
		System.out.println(" 1.  Add Order");
		System.out.println(" 2.  View Order List ");
		System.out.println(" 3.  View By Order Id ");
		System.out.println(" 4.  Sort Order");
		System.out.println(" 5.  Delete Order by Id");
		System.out.println(" 6.  Mark as Delivered");
		System.out.println(" 7.  Generate Report");
		System.out.println(" 8.  Exit ");
		System.out.println("Choose Option : ");
		choice=s.nextInt();

		switch (choice) {
		case 1:orderMang.addOrder();
		break;
		case 2:orderMang.viewOrder();
		break;
		case 3:orderMang.viewByOrderId();
		break;
		case 4:orderMang.sortOrder();
		break;
		case 5:orderMang.deletByOrderId();
		break;
		case 6:orderMang.markAsDelivery();
		break;
		case 7:orderMang.generateReport();
		break;
		case 8:orderMang.exit();
		break;
		
		default:System.out.println(" \n Enter the correct option \n");
		
		}if(choice==8)
			break;
		
		}while(choice>0 || choice<9);

	}

}
