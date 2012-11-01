package purchaseOrders;

public class PurchaseOrderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			shouldWork("Ton", 18, 1);
			shouldFail("Käse", 67, 2, "Material");
			shouldFail("Marmor", 16, 9998, "Kantenlänge");
			shouldFail("Marmor", 69, 9999, "Kantenlänge");
			shouldFail("Granit", 17, 0, "Menge");
			shouldFail("Granit", 68, 10000, "Menge");
	}
	
	/**
	 * Prüft ob die eingegebenen Parameter zu einem gültigen Auftrag
	 * führen und gibt das Ergebnis entsprechend aus.
	 * 
	 * @param material
	 * @param edgeLength
	 * @param quantity
	 */
	private static void shouldWork(String material, float edgeLength, int quantity){
		boolean success = true;
		
		try {
			PurchaseOrder po = new PurchaseOrder(material, edgeLength, quantity);
			if(!po.getOrderNumber().matches("^F.*2$")) {
				success = false;
			}
		} catch(IllegalArgumentException e){
			success = false;
		}
		
		if(success){
			System.out.println("Test erfolgreich: " + material + " " + edgeLength + " " + quantity);
		} else {
			System.out.println("Test fehlgeschlagen: " + material + " " + edgeLength + " " + quantity);
		}
	}
	
	/**
	 * Prüft ob die eingebenen Werte zu einem ungültigen Auftrag führen und die Erstellung wegen
	 * des korrekten Attributes fehlschlägt.
	 * 
	 * @param material
	 * @param edgeLength
	 * @param quantity
	 * @param reason
	 */
	private static void shouldFail(String material, float edgeLength, int quantity, String reason){
		boolean failed = false;
		
		try {
			PurchaseOrder po = new PurchaseOrder(material, edgeLength, quantity);
		} catch(IllegalArgumentException e){
			if(e.getMessage().contains(reason)){
				failed = true;
			}
		}
		
		if(failed){
			System.out.println("Test erfolgreich: " + material + " " + edgeLength + " " + quantity + " schlägt fehl wegen " + reason);
		} else {
			System.out.println("Test fehlgeschlagen: " + material + " " + edgeLength + " " + quantity+ " sollte fehlschlagen wegen " + reason);
		}
	}

}
