package basic.AK_0717;

import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자로 변환할 문자열을 입력바랍니다.");
		String getStr = scan.nextLine();
		try {
			int convertedNum = convert(getStr);
			System.out.println(convertedNum);
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	private static int convert(String str) throws Exception {
		if (str.length() == 0)
			throw new Exception("그냥 엔터를 치셨군요!");
		int result = 0;
		try {
			result = Integer.parseInt(str);

		} catch (Exception e) {
			throw new Exception("숫자로 변환할 수 없습니다!");
		}
		return result;
	}
}
