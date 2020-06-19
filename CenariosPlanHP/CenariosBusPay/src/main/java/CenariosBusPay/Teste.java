package CenariosBusPay;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		
		List<String> x = new ArrayList<String>();
		x.add("1");
		x.add("2");
		x.add("3");
		
		List<String> y = new ArrayList<String>();
		y.add("1");
		y.add("3");
		
		Iterator<String> xI = x.iterator();
		
		while(xI.hasNext()) {
			String xIS = xI.next();
			System.out.println("xIS: "+xIS);
			Iterator<String> yI = y.iterator();
			while(yI.hasNext()) {
				String yIS = yI.next();
				System.out.println("yIS: "+yIS);
				if(xIS.equals(yIS)) {
					System.out.println(xIS+" "+yIS);
					break;
				}
			}
		}	
	}

}
