package practicejava;

//import:この道具（クラス）を使うから準備しておいてというもの
import java.sql.Connection;//データベースとの接続,イメージ: 電話回線
import java.sql.DriverManager;//DriverManagerにお願いしてSQLへのConnectionを作る
import java.sql.PreparedStatement;//PreparedStatementにSQLをセットして実行しDBに保存する
import java.sql.SQLException;//もし途中で失敗したらSQLExceptionが原因を教えてくれる
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SQL連動練習 {
    public static void main(String[] args) {
        
    	String url = "jdbc:sqlite:shop.db";//接続先情報jdbc : sqlite : shop.dbの3つのパーツで構成
    	
    	// 共通で使う道具や設定を準備(宣言と実行（初期化）を同時に行う)
    	try (Scanner scanner = new Scanner(System.in);  
    		Connection conn = DriverManager.getConnection(url)){
  //try:これからカッコ内の道具を使ってある処理を試みます（tryしますよ）という導入の言葉
  //try()のおかげでscanner.close();と書かなくてよくなる
        
    		List<Product> productList = new ArrayList<>();
        	
        // --- データベースから既存データを読み込む ---
        String selectSql = "SELECT name, price, stock FROM products"; 
        //String selectSql:SQLを文字列として用意
        //SELECT:取り出せ name, price, stock:この項目を FROM products:商品棚から
    	
     // 共通で使う道具や設定を準備(宣言と実行（初期化）を同時に行う)
        try (PreparedStatement pstmt = conn.prepareStatement(selectSql);
        		//PreparedStatement（プリペアド・ステートメント）:型
        		//pstmt:変数名
             var rs = pstmt.executeQuery()) {//executeQuery:データを書き換えるメソッド名(命令)

            while (rs.next()) {//rs:ResultSetの略（変数名）
            	
            	//String dbName:宣言、文字列を入れる箱を用意しその箱にdbNameという名前をつける
            	//rs:データの表（ResultSet）　　.getString(...):文字列として取りす命令
            	//name:データベースの表にあるnameという列から取ってきてという指定
                String dbName = rs.getString("name");
                int dbPrice = rs.getInt("price");
                int dbStock = rs.getInt("stock");
                productList.add(new Product(dbName, dbPrice, dbStock));
                //productList:最初の方で準備したArrayList<Product
                //.add():リストの一番後ろに新しく追加してというメソッド
                //new:新しく実体を作る合図
                //Product(...):Productクラスを呼び出す
                //(dbName,dbPrice,dbStock):データベースから取り出した名前・価格・在庫を材料として渡す
                }
           System.out.println("データベースから " + productList.size() + " 件のデータを読み込みました。");
        
        } catch (SQLException e) {
            System.out.println("読み込みエラー: " + e.getMessage());
        }

        // --- 商品登録 & データベース保存モード ---
        System.out.println("\n--- 商品登録（自動保存） ---");
        System.out.print("登録する商品名：");
        String name = scanner.next(); 
        System.out.print("価格：");
        int price = scanner.nextInt(); 
        System.out.print("在庫数：");
        int stock = scanner.nextInt();

        // リストに追加
        productList.add(new Product(name, price, stock));

        // DBに保存するSQL
        String insertSql = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";
        //insert:SQLの命令の種類（挿入・追加）Sql:SQLという言語の命令
        //INSERT INTO products:productsという名前のテーブルにデータを挿入（INSERT）という宣言
        //(?, ?, ?):プレースホルダ（仮置き場)
        //2つのメリット:SQLインジェクション対策,使い回しができる

        try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            
            pstmt.setString(1, name);
            pstmt.setInt(2, price);
            pstmt.setInt(3, stock);
            pstmt.executeUpdate();
            
            System.out.println("【完了】リストに追加し、データベースにも永続保存しました！\n");//￥n:改行コード

        } catch (SQLException e) {
            System.out.println("保存エラーが発生しました：" + e.getMessage());
        }

        // --- 削除処理 ---
        int removeIndex = 1;
        if (productList.size() > removeIndex) {
            System.out.println(productList.get(removeIndex).name + " を削除します。");
            productList.remove(removeIndex);
        } else {
            System.out.println("削除対象（インデックス " + removeIndex + "）が見つかりません。");
        }
        
    	}
    	//閉じる作業自体が失敗することも稀にあり,そのエラーを誰も受け取る準備をしていないと判断して、
    	//catchを書くかメソッドの外に投げなさいとエラーを出して教えてくれている
 catch (SQLException e) {e.printStackTrace();}
    }
}