package CP_ABE;

import java.util.Arrays;

public class Cipher {
	
	
    static String [] reverse(String a[], int n)
    {
        String[] b = new String[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
 
        return b ;
    }
	
	
	public static String GetMk(String k, String p, Policy po) {
		k = "000000" + k ;
		String [] AccessList = p.split(" ");
		String [] key = k.split("(?!^)");
		
		key = reverse(key, key.length);
		
		System.out.println("==============================================ACL==================================================");
		for (int i = 0; i < AccessList.length; i++) {
			System.out.println(AccessList[i]);
		}
		
		System.out.println("==============================================Key==================================================");
		for (int i = 0; i < key.length; i++) {
			System.out.println(key[i]);
		}
		
		System.out.println("==============================================decrypt==================================================");
		
		Boolean t = false ; 
	
		System.out.println("ACL 0 : "+AccessList[0]);
		
		if (AccessList[0].equals("UIDESIGNER")) {
			System.out.println("UIDESIGNER"+key[0]);
			if (key[0].equals("1")) {
				t = true ;
			}
		}
		if (AccessList[0].equals("UXDESIGNER")) {
			System.out.println("UXDESIGNER"+key[1]);
			if (key[1].equals("1")) {
				t = true ;
			}
		}
		if (AccessList[0].equals("FRONTDEV")) {
			System.out.println("FRONTDEV"+key[2]);
			if (key[2].equals("1")) {
				t = true ;
			}
		}
		if (AccessList[0].equals("BACKDEV")) {
			System.out.println("BACKDEV"+key[3]);
			if (key[3].equals("1")) {
				t = true ;
			}
		}
		if (AccessList[0].equals("FULLDEV")) {
			System.out.println("FULLDEV"+key[4]);
			if (key[4].equals("1")) {
				t = true ;
			}
		}
		if (AccessList[0].equals("QUALITYENGINEER")) {
			System.out.println("QUALITYENGINEER"+key[5]);
			if (key[5].equals("1")) {
				t = true ;
			}
		}
		if (AccessList[0].equals("TESTER")) {
			System.out.println("TESTER"+key[6]);
			if (key[6].equals("1")) {
				t = true ;
			}
		}
		
		System.out.println("for now : "+t);
		int c = 0 ; 
		
		for (int i = 1; i < AccessList.length; i++) {
			
			System.out.println(AccessList[i]);
			if (!(AccessList[i].equals("and")||AccessList[i].equals("or"))) {
				//UIDESIGNER and UXDESIGNER and FRONTDEV and BACKDEV and FULLDEV and QUALITYENGINEER and TESTER
				if (AccessList[i].equals("UIDESIGNER")) {
					if (c == 0) {
						t = key[0].equals("1") && t;
					} else {
						t = key[0].equals("1") || t;
					}
				}
				if (AccessList[i].equals("UXDESIGNER")) {
					if (c == 0) {
						t = key[1].equals("1") && t;
					} else {
						t = key[1].equals("1") || t;
					}
				}
				if (AccessList[i].equals("FRONTDEV")) {
					if (c == 0) {
						t =key[2].equals("1") && t;
					} else {
						t = key[2].equals("1") || t;
					}
				}
				if (AccessList[i].equals("BACKDEV")) {
					if (c == 0) {
						t = key[3].equals("1") && t;
					} else {
						t = key[3].equals("1") || t;
					}
				}
				if (AccessList[i].equals("FULLDEV")) {
					if (c == 0) {
						t = key[4].equals("1") && t;
					} else {
						t = key[4].equals("1") || t;
					}
				}
				if (AccessList[i].equals("QUALITYENGINEER")) {
					if (c == 0) {
						t = key[5].equals("1") && t;
					} else {
						t = key[5].equals("1") || t;
					}
				}
				if (AccessList[i].equals("TESTER")) {
					if (c == 0) {
						t = key[6].equals("1") && t;
					} else {
						t = key[6].equals("1") || t;
					}
				}
			} else {
				if (AccessList[i].equals("and")) {
					c = 0 ;
				}
				if (AccessList[i].equals("or")) {
					c = 1 ;
				}
			}
		}
		 
		System.out.println("acces is : " +t);
		if (t) {
			System.out.println(po.getMKey()+" was the key");
			return po.getMKey()+"";
		}
		else {
			return "" ;
		}
	}
	
	
	
	
//------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	

	
	
	

	
	
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------	

	
	private static String[] replace(String key, String [] arr) {		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("acc list = "+arr[i]);
			if (arr[i].equals(key)) {
				arr[i]="T";
			}
			else {
				if (!(arr[i].equals("and")||arr[i].equals("or")||arr[i].equals("T")||arr[i].equals("F"))) {
					arr[i]="F";
				}
			}
		}
		
		return arr;
	}
	
	
	
    private static Boolean check(String[] arr, String toCheckValue)
    {
    	
        Arrays.sort(arr);
 
        int res = Arrays.binarySearch(arr, toCheckValue);
 
        boolean test = res > 0 ? true : false;
        
        return test ;
    }
 
}
