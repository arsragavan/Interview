package Bits;

public class GrayCode {

	public static String getGrayCode(String binary) {

		String grayCode = "";
		if (binary.length() > 0)
			grayCode += binary.charAt(0);
		for (int i = 1; i < binary.length(); i++)
			grayCode += Integer.parseInt(binary.substring(i - 1, i))
					^ Integer.parseInt(binary.substring(i, i + 1));
		return grayCode;

	}
	public static int getGrayCode(int binary) {
		char[] binArray = Integer.toBinaryString(binary).toCharArray();
		int grayCode = 0b0;
		if (binArray.length > 0)
			grayCode += Integer.parseInt(String.valueOf(binArray[0]));
		for (int i = 1; i < binArray.length; i++) {
			grayCode = grayCode << 1;
			grayCode += Integer.parseInt(String.valueOf(binArray[i - 1]))
					^ Integer.parseInt(String.valueOf(binArray[i]));
		}
		return grayCode;
	}
	public static void main(String args[]) {

		System.out.println(Integer.toBinaryString(getGrayCode(0b0111)));

	}
}
