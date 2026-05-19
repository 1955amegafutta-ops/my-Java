package practicejava;

public class while文練習 {

	public static void main(String[] args) {
		
		int platesCount = 5; // 最初は5口分のご飯がある
		//スタート: platesCount は 5。 「5 > 0」は YES なので実行！		//int i = 5; に変えると？		//5からスタートするので、5, 6, 7, 8, 9, 10 の 6回だけ 繰り返されます。		
				
		// ご飯が残っている間（0より大きい間）は繰り返す
		while (0 < platesCount) {//i <= 100; に変えると？1から100まで、100回 繰り返されます。
		    System.out.println("あーん！一口食べました。");
		    
		    platesCount--; 
		    // 1口分減らす1回目終了後: platesCount-- により、中身が 4 になる
		}

		System.out.println("ピカピカ！完食です。");
	}//終了: while のループを抜けて、次の処理へ。

}
//もしこの一行（platesCount--）を書き忘れると、platesCount はずっと 5 のままです。