package CP_ABE;

import java.util.Iterator;

public class Key {
	private String attributes;
	private int keyValue = 0;
	private String [] key;
	
	
	public Key(String att) {
		attributes = att;
		generateKey(att);
	}
	private void generateKey(String attributes) {
		
		// email:frfh ,attribut:/FRONT DEV /BACK DEV /TESTER
		String[] attri = attributes.split(" ");
		int j = 0 ;
		
		for (int i = 0; i < attri.length; i++) {
			
			System.out.println("attri is = " +attri[i]);
			if (attri[i].equals("/UIDESIGNER") || attri[i].equals("/UXDESIGNER") || attri[i].equals("/FRONTDEV") || attri[i].equals("/BACKDEV") || attri[i].equals("/FULLDEV") || attri[i].equals("/QUALITYENGINEER") || attri[i].equals("/TESTER")) {
				
				if (attri[i].equals("/UIDESIGNER")) {
					attri[i] = ""+1;
				}
				if (attri[i].equals("/UXDESIGNER")) {
					attri[i] = ""+10;
				}
				if (attri[i].equals("/FRONTDEV")) {
					attri[i] = ""+100;
				}
				if (attri[i].equals("/BACKDEV")) {
					attri[i] = ""+1000;
				}
				if (attri[i].equals("/FULLDEV")) {
					attri[i] = ""+10000;
				}
				if (attri[i].equals("/QUALITYENGINEER")) {
					attri[i] = ""+100000;
				}
				if (attri[i].equals("/TESTER")) {
					attri[i] = ""+1000000;
				}
			} else {
				attri[i] = ""+0;
			}
		}
		
		for (int i = 0; i < attri.length; i++) {
			System.out.println("adding = "+attri[i]);
			j = j + Integer.parseInt(attri[i]);
		}
		keyValue = j ;
			// /UI DESIGNER /UX DESIGNER /FRONT DEV /BACK DEV /FULL DEV /FULL DEV /QUALITY ENGINEER /TESTER
		
		key = attri ;
	}
	
	public int getValue() {
		return keyValue;
	}
	
	public String[] getKey() {
		return key;
	}
}
