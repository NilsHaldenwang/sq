package purchaseOrders;

/**
 * @author nils
 *
 */
public class PurchaseOrder {
	
	private String material;
	private static final String[] VALID_MATERIALS = {"Ton", "Marmor", "Granit"};
	
	private float edgeLength;
	private static final float MIN_EDGE_LENGTH = 17.0f;
	private static final float MAX_EDGE_LENGTH = 68.0f;
	
	private int quantity;
	private static final float MIN_QUANTITY = 1;
	private static final float MAX_QUANTITY = 9999;
	
	private String orderNumber;
	private static int orderCount = 0;
	
	/**
	 * Construct a PurchaseOrder.
	 * 
	 * Also performs validation of the data.
	 * 
	 * @raise IllegalArgumentException when the data is not valid
	 * 
	 * @param material
	 * @param edgeLength
	 * @param quantity
	 */
	public PurchaseOrder(String material, float edgeLength, int quantity){
		this.material = material;
		this.edgeLength = edgeLength;
		this.quantity = quantity;
		validateData();
		generateOrderNumber();
	}
	
	private void generateOrderNumber(){
		orderNumber =  "F" + orderCount + "2";
	}
	
	/**
	 * Validates the data given to the constructor.
	 * 
	 * @railse IllegalArgumentException if the data was invalid
	 * @return true if the data was valid
	 */
	private boolean validateData(){
		return validateMaterial() && validateEdgeLength() && validateQuantity();
	}
	
	/**
	 * Checks the material for validity.
	 * 
	 * @raise IllegalArgumentException when material is not valid
	 * @return true if the material is valid
	 */
	private boolean validateMaterial(){
		boolean valid = false;
		
		for(String validMaterial: VALID_MATERIALS){
			if(validMaterial.equals(material)){
				valid = true;
			}
		}
		
		if(!valid){
			throw new IllegalArgumentException("Falsches Material");
		}
		
		return valid;
	}
	
	/**
	 * Checks the edge length for validity.
	 * 
	 * @raise IllegalArgumentException when the edgelength is invalid
	 * @return true if the edge length is valid
	 */
	private boolean validateEdgeLength(){
		boolean valid = false;
		
		if(edgeLength >= MIN_EDGE_LENGTH && edgeLength <= MAX_EDGE_LENGTH){
			valid = true;
		}
		
		if(!valid){
			throw new IllegalArgumentException("Falsche KantenlŠnge");
		}
		
		return valid;
	}
	
	/**
	 * Checks the quantity for validity.
	 * 
	 * @raise IllegalArgumentException when the quantity is invalid
	 * @return true if the quantity is valid
	 */
	private boolean validateQuantity(){
		boolean valid = false;
		
		if(quantity >= MIN_QUANTITY && quantity <= MAX_QUANTITY){
			valid = true;
		}
		
		if(!valid){
			throw new IllegalArgumentException("Falsche Menge");
		}
		
		return valid;
	}
	
	/**
	 * @return the material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * @return the edgeLength
	 */
	public float getEdgeLength() {
		return edgeLength;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
