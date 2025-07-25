package basic.AK_0717;

import java.util.Scanner;

public class homework5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자로 변환할 문자열을 입력바랍니다.");
		String getStr = scan.nextLine();

		try {
			System.out.println(convert(getStr));
		} catch (Exception e) {
			System.out.println("숫자로 변환할 문자열을 입력바랍니다.");
			// e.printStackTrace();
			// System.out.println(e.getMessage());
		}
	}

	private static int convert(String getStr) throws Exception {

		if (getStr.length() == 0)
			throw new Exception("예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다.");
		return Integer.parseInt(getStr);

	}
}


/*사용자로부터 문자열을 입력받아서 그 문자열을 숫자로 변환하여 출력하는 프로그램입니다.

1>convert라는 메서드를 정의합니다.

A.문자열을 전달받아서,그 문자열을 숫자로 변환하여 리턴합니다.

B.전달된 문자가문자열의 길이가 0 이면 Exception을 발생시킨 후 메소드를 호출한 쪽으로 예외를 던집니다.

2>main메서드에서 convert를 호출하고 결과를 출력합니다.

3>예외가 발생되면,“예외가 발생되었습니다.문자열을 입력하지 않고 Enter키를 누르셨습니다.”라고 출력합니다.

실행 예>[사용자가 123 을 입력할 경우,화면으로 출력되는 문자열입니다]

숫자로 변환할 문자열을 입력바랍니다.123 변환된 숫자는 123 입니다.

[사용자가 입력하지 않고 Enter키를 누른 경우,화면으로 출력되는 문자열 입니다]숫자로 변환할 문자열을 입력바랍니다.
*/
