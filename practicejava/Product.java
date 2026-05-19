package practicejava;
//クラスを型として使う（コレクション練習.javaで使用）
public class Product {//戻り値（出力）を書かない: public void Product ではなく public Product と書く
   
	// フィールド（そのモノが持っているデータ）
    String name;  // 商品名
    int price;    // 価格
    int stock;

    // コンストラクタ（「new」した瞬間に中身をセットする役割）
    public Product(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}