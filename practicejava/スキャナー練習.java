package practicejava; // あなたが作ったパッケージ名に合わせます

import java.util.Scanner; // importは一番上（classの外）に書くルールです

public class スキャナー練習 {

    public static void main(String[] args) {
        // ここから中身を書き始めます
        Scanner sc = new Scanner(System.in);

        System.out.print("今日のご飯は何口分にする？（数字を入れてね）: ");
        
        // 入力された数字を受け取る
        int maxPlates = sc.nextInt();

        System.out.println("--- " + maxPlates + "口のお食事スタート！ ---");

        for (int i = 1; i <= maxPlates; i++) {
            System.out.println(i + "口目をパクり。");
        }

        System.out.println("--- お腹いっぱいです！ ---");
        
        sc.close(); 
    }
}