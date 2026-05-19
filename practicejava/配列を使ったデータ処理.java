package practicejava;

public class 配列を使ったデータ処理 {

	public static void main(String[] args) {
	    // 3日間の食事の記録（配列）
	    int[] counts = {5, 8, 3};//int[] は整数を複数入れる箱　int なら整数を1つだけ入れる箱
	    //配列は配列数を決めると後から変更できない
	    
	    int min = counts[0];
	    int sum = 0; // ★ここで貯金箱を準備！

	    // ② 繰り返しの中で「最小値チェック」と「合計計算」をやる
	    for (int i = 0; i < counts.length; i++) { // length = 配列の「部屋の数」
	        
	        // 最小値のチェック（これはifの中）
	        if (counts[i] < min) {
	            min = counts[i];
	        }
	        
	        // 合計の加算（これはifの外、でもforの中！）
	        sum += counts[i];
	    }

	    System.out.println("一番少なかったのは " + min + "口でした！");
	    
	    // ③ 平均の計算
	    double average = (double) sum / counts.length;
	    System.out.println("平均は " + average + "口でした！");
	}
}