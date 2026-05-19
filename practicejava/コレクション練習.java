package practicejava;

//ListやArrayListはJavaの便利道具セットの中に入っているのでimport宣言する必要がある
import java.util.ArrayList;//これがクラス（実体・中身）
import java.util.List;//これがインターフェース（ルール・窓口）

public class コレクション練習 {
	public static void main(String[] args) {

		//Listの宣言「Product」を入れコンストラクタを使用
		List<Product> productList = new ArrayList<>();
		//左側をインターフェースである List にしておくことで、
		//将来的にArrayListじゃなくて別の種類のリスト（LinkedListなど）に変えたい」と思ったとき、
		//右側の new ... の部分を書き換えるだけで済むようになる

		// 商品を「名前と価格」をセットにして入荷
//		Productクラスとして名前も価格も閉じ込め（カプセル化）それをそのままリストに放り込んでる
		productList.add(new Product("洗剤", 500 , 50));
		productList.add(new Product("シャツ", 2000 , 50));
		productList.add(new Product("靴下", 350 , 50));
		productList.add(new Product("牛乳", 250 , 30));
		productList.add(new Product("ミックスジュース", 300 , 30));
		productList.add(new Product("ケーキセット", 1150 , 20));
		productList.add(new Product("コーヒー豆", 800 , 30));
		
		System.out.println("--- 1,000円以下の商品を検索します ---");
		// --- ① 1,000円以下の商品を検索（1つ目のまとまり） ---
        for (Product item : productList) {
            if (item.price <= 1000) {
                if (item.stock == 0) {
                    System.out.println("【完売！】" + item.name + " は売り切れです");
                } else {
                    System.out.println("【お得！】" + item.name + " (在庫:" + item.stock + ")");
                }
            }
        } // ← 【重要】ここで1つ目のfor文を終了させる！

        // --- ② 削除処理（1回だけ実行） ---
        int removeIndex = 1;
        System.out.println(productList.get(removeIndex).name + " を削除します。");
        productList.remove(removeIndex);

        if (removeIndex < productList.size()) {
            Product nextItem = productList.get(removeIndex); 
            System.out.println("削除後、新たに " + removeIndex + " 番に繰り上がったのは: " 
                                + nextItem.name + "（価格：" + nextItem.price + "円）");
        } else {
            System.out.println("最後の商品を削除したため、インデックス " + removeIndex + " 番は空になりました。");
        }

        // --- ③ キーワード検索（2つ目のまとまり） ---
        System.out.println("\n--- 商品検索を開始します ---");
        String keyword = "ー"; 
        boolean found = false;

        for (Product item11 : productList) { 
            if (item11.name.contains(keyword)) { 
                System.out.println("【ヒット！】" + item11.name + " が見つかりました。");
                found = true;
            }
        }

        if (!found) {
            System.out.println("キーワード「" + keyword + "」に一致する商品はありません。");
        }

    } // mainメソッドの終わり
} // クラスの終わり