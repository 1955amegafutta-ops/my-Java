package practicejava;

import java.util.Scanner;

public class Array配列練習 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("何日分の記録を見ますか？（数字を入れてね）: ");
		int maxPlates = sc.nextInt();

		// ① 配列の宣言(maxPlatesは入力した数字分の部屋を作る）
		int[] counts = new int[maxPlates];

		// ② 各部屋（要素）に数字を入れる ※番号は「0」から始まります！
		counts[0] = 5; // 1日目
		counts[1] = 8; // 2日目
		counts[2] = 3; // 3日目　以降はjavaが自動で0を出す

		int sum = 0;
		System.out.println("--- 記録の確認 ---");

		// 配列の中身を順番に全部表示する
		for (int i = 0; i < counts.length; i++) {
			System.out.println((i + 1) + "日目の記録: " + counts[i] + "口");

			sum += counts[i];
			//[ ] のカッコは、配列の特定の部屋を指差している。指している番号が i です。
			// （データが100個あったら100行書くことになる為）
		}
		System.out.println("----------------");
		System.out.println(counts.length + "日間の合計は: " + sum + "口でした！");

		sc.close();
	}

}