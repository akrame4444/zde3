package CP_ABE;

import java.util.Iterator;

public class Policy {
	String Policy;
	int Key ;
	String[] PolicyList ;
	
	public Policy (String policy) {
		this.Policy = policy ;
		Key = Key(policy);
		PolicyList = Plist(policy);
	}
	
	private int Key (String policy) {
		if (policy.equals("everyone")) {
			return 10000000;
		} else {
			//UI DESIGNER and UX DESIGNER and FRONT DEV and BACK DEV and FULL DEV and QUALITY ENGINEER and TESTER
			
			String[] Attribute = policy.split(" ");  
			int k = 10000000;
			for (int i = 0; i < Attribute.length; i++) {
				if (Attribute[i].equals("or")||Attribute[i].equals("and")) {
					
				} else {
					if (Attribute[i].equals("UIDESIGNER")) {
						k = k + 0000001;
					}
					if (Attribute[i].equals("UXDESIGNER")) {
						k = k + 0000010;
					}
					if (Attribute[i].equals("FRONTDEV")) {
						k = k + 0000100;
					}
					if (Attribute[i].equals("BACKDEV")) {
						k = k + 0001000;
					}
					if (Attribute[i].equals("FULLDEV")) {
						k = k + 0010000;
					}
					if (Attribute[i].equals("QUALITYENGINEER")) {
						k = k + 0100000;
					}
					if (Attribute[i].equals("TESTER")) {
						k = k + 1000000;
					}
				}
			}
			System.out.println("k= "+k);
			return k ;
		}
	}
	
	private String[] Plist (String policy) {
		if (policy.equals("everyone")) {
			return null ; 
		}
		else {
			String[] p = policy.split(" ");
			for (int i = 0; i < p.length; i++) {
				if (p[i].equals("or")||p[i].equals("and")) {
					
				} else {
					if (p[i].equals("UIDESIGNER")) {
						p[i] = "0000001";
					}
					if (p[i].equals("UXDESIGNER")) {
						p[i] = "0000010";
					}
					if (p[i].equals("FRONTDEV")) {
						p[i] = "0000100";
					}
					if (p[i].equals("BACKDEV")) {
						p[i] = "0001000";
					}
					if (p[i].equals("FULLDEV")) {
						p[i] = "0010000";
					}
					if (p[i].equals("QUALITYENGINEER")) {
						p[i] = "0100000";
					}
					if (p[i].equals("TESTER")) {
						p[i] = "1000000";
					}
				}
			}
			
			return p;
		}
	}
	
	public int getMKey () {
		return this.Key;
	}
	
	public String[] getpolList() {
		return PolicyList; 
	}
}
