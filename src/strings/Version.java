package strings;

public class Version {

	public static int compareVersion(String version1, String version2) {
		if (version1.equals(version2))
			return 0;
		String[] v1 = version1.split("[.]");
		String[] v2 = version2.split("[.]");
		int i = 0;

		while (i < v1.length && i < v2.length) {
			Integer ver1 = Integer.parseInt(v1[i]);
			Integer ver2 = Integer.parseInt(v2[i]);
			if (ver1 < ver2)
				return -1;
			else if (ver1 > ver2)
				return 1;
			i++;
		}
		if (i == v1.length && i == v2.length)
			return 0;
		if (i == v1.length) {
			while (i < v2.length) {
				Integer ver2 = Integer.parseInt(v2[i]);
				if (ver2 > 0)
					return -1;
				i++;
			}
		}
		if (i == v2.length) {
			while (i < v1.length) {
				Integer ver1 = Integer.parseInt(v1[i]);
				if (ver1 > 0)
					return 1;
				i++;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(compareVersion("1.1", "1"));

	}

}
