package practicejava;

public class for文練習 {

	public static void main(String[] args) {
		int total = 0; // 合計を入れる箱

		// 1から10まで繰り返す
		for (int i = 1; i <= 10; i++) {
			//int i: 整数を入れる i という名前の箱を作ります。
		    total = total + i; // 今の数字を合計に足す
		}
		System.out.println("合計は：" + total); // 結果を表示
	}
}
