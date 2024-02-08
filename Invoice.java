package JavaFresher01;

public abstract class Invoice implements Payable {
	private String partNumber, partDescription;
	private int quantity;
	private double pricePerItem;
	
	public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getPartDescription() {
		return partDescription;
	}

	public void setPartDescription(String partDescription) {
		this.partDescription = partDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerItem() {
		return pricePerItem;
	}

	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}

	 public double getPaymentAmount() {
	        return quantity * pricePerItem;
	    }
	 @Override
	public String toString() {
		return "Part Number: " + partNumber + "\n Part Description: " + partDescription + "\n Quantity: " 
				+ quantity + "\n Price per item: " + pricePerItem + "\nPayment Amount: " + getPaymentAmount();
	}
}