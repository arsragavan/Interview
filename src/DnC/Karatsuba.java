package DnC;

public class Karatsuba {

	//O(n^1.59) better than O(n^2)
	public static long multiply(String a, String b) {
		int countA = a.length();
		int countB = b.length();
		int n = countA;
		if (countA > countB) {
			n = countA;
			while (countB < countA) {
				b = "0"+b;
				countB++;
			}			
		}
		else if (countB > countA) {
			n = countB;
			while (countA < countB) {
				a = "0"+a;
				countA++;
			}
		}
		if (n == 0)
			return 0;
		if (n == 1)
			return (Integer.parseInt(a)*Integer.parseInt(b));
		
		int fh = n/2;
		int sh = n-n/2;
		
		String x1 = a.substring(0,fh);
		String x0 = a.substring(fh,n);
		String y1 = b.substring(0,fh);
		String y0 = b.substring(fh,n);
		
		//x1*y1
		long x1y1 = multiply(x1,y1);
		//x0y0
		long x0y0 = multiply(x0,y0);
		
		//x1y0+x0y1 = ((x1+x0)*(y1+y0)-x1y1-x0y0) to avoid 4 multiplications
		int x1x0 = Integer.parseInt(x1)+Integer.parseInt(x0);
		int y1y0 = Integer.parseInt(y1)+Integer.parseInt(y0);
		long x1y0x0y1 = multiply(Integer.toString(x1x0),Integer.toString(y1y0))-x1y1-x0y0;
		
		return (((x1y1)<<n)+((x1y0x0y1)<<sh)+x0y0);
		
	}
	public static void main(String[] args) {
		int a = 0b10001;
		int b = 0b101;
		System.out.println(multiply(Integer.toBinaryString(a),Integer.toBinaryString(b)));
		
	}

}
