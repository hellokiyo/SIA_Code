package basic.AK_0715;

public class FizzBuzz {

	public static void main(String[] args) {

		int[][] twoArray = { { 1, 2, 3 }, { 4, 5, 6, 4, 4, 5, 6, 2, 2 }, { 7, 8, 9 }, { 1 }, { 4 } };

		// System.out.println(twoArray[0].length);

		for (int i = 0; i < twoArray.length; i++) {

			int sum = 0;
			int avg = 0;

			for (int j = 0; j < twoArray[i].length; j++) {
				sum += twoArray[i][j];
			}		
			
				
			avg = sum / twoArray[i].length;

			System.out.println(i + 1 + "번째 행의 합 : " + sum + "\t평균 : " + avg);
			

		}

	}
}
