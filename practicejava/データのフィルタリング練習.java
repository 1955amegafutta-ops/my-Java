package practicejava;

public class データのフィルタリング練習 {

	public static void main(String[] args) {
	    int[] counts = {5, 8, 3};
	    int target = 5; // target宣言（基準となる数）
	    int count = 0;  // countという名前の箱に3を入れた（条件に合った日を数えるカウンター）

	    System.out.println(target + "口より多く食べた日を探します：");

	    for (int i = 0; i < counts.length; i++) {
	    //　int i = 0　は変数iを0番目の部屋からスタート
	   	//　i < counts.length はiが配列の長さより小さい間は繰り返す
	    	//　i++ は1回処理が終わるたびにiを1増やす
	    	
	        // もし、今の部屋の数字が target より大きかったら
	        if (counts[i] > target) {
	            // カウントを1増やす
	            count++;
	            // その日のデータも表示してみる
	            System.out.println((i + 1) + "日目：" + counts[i] + "口");
	        }
	    }

	    System.out.println("該当する日は合計 " + count + "日でした。");
	}
}