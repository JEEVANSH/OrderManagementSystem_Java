import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orders implements Serializable {
	private int orderId;
	private String orderDesc;
	private String orderDelAdd;
	private double amount;
	private LocalDateTime orderDate;
	private LocalDateTime deliveryDate;

	public Orders(int orderId, String orderDesc, String orderDelAdd, double amount, LocalDateTime orderDate) {
	super();
	this.orderId = orderId;
	this.orderDesc = orderDesc;
	this.orderDelAdd = orderDelAdd;
	this.amount = amount;
	this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public String getOrderDelAdd() {
		return orderDelAdd;
	}
	public double getAmount() {
		return amount;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
	return  orderId+"   "+ orderDesc+"   "+ orderDelAdd+"   " 
	+ amount +"   "+ orderDate+"   "  +"   "+deliveryDate ;
	}

	


	

	
	
}
