import java.util.Scanner;

import net.webservicex.Periodictable;
import net.webservicex.PeriodictableSoap;

public class PeriodicElementLookup {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String elementName = input.next();
		
		// use wsimport to create the Service End-point Interface
		// -keep keeps the generated java files
		// -s src stores the generated java files in the src sub-directory
		// copy the generated java files into the net.webservicex package
		// wsimport -keep -s src http://www.webservicex.net/geoipservice.asmx?WSDL
		
		// Create the service object
		Periodictable periodicTable = new Periodictable();
		
		// Create service port stub that gives us access to the service methods
		PeriodictableSoap periodictableSoap = periodicTable.getPeriodictableSoap();

		// Get the GeoIP object
		System.out.println(periodictableSoap.getAtomicNumber(elementName));
		System.out.println(periodictableSoap.getElementSymbol(elementName));
		
		
		input.close();


	}

}
