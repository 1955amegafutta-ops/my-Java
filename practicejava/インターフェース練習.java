package practicejava;

//1. インターフェース（共通のルール）を作成
interface Washable {
 void wash(); // 「洗う」という名前だけ決める（中身は無し）
}

//2. ルールを守って「洗剤」クラスを作る
class Detergent implements Washable {
 public void wash() {
     System.out.println("洗剤：泡を立てて洗浄します。");
 }
}

//3. ルールを守って「シャツ」クラスを作る
class Shirt implements Washable {
 public void wash() {
     System.out.println("シャツ：洗濯機で丸洗いします。");
 }
}

public class インターフェース練習 {
 public static void main(String[] args) {
     // インターフェースを使えば、別々の種類のものを同じ型として扱える
     Washable item1 = new Detergent();
     Washable item2 = new Shirt();

     item1.wash();
     item2.wash();
 }
}