package practicejava;

public class Hellojava { // ここを Hellojava に書き換えます

    public static void main(String[] args) {
        // --- 1. 配列の準備 ---
        int[] prices = {450, 500, 750, 200, 850};
        int max = prices[0]; // 暫定1位
        
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i] > max) {
                max = prices[i];// ここに if文を書いて、maxを更新してください
        }
        }
        String[] names = {"ブレンド", "ラテ", "カプチーノ", "モカ", "キャラメル","いつもの"};

        int sum = 0; 

        System.out.println("=== コーヒーメニュー一覧 ===");

        // --- 2. 繰り返し処理 (for文) ---
        for (int i = 0; i < prices.length; i++) {
            System.out.println(names[i] + ": " + prices[i] + "円");
            sum = sum + prices[i];

            if (prices[i] >= 700) {
                System.out.println("  -> [★高級メニュー]");
            }
        }

        // --- 3. 結果の表示 ---
        System.out.println("----------------------------");
        System.out.println("合計: " + sum + "円");
        double average = (double) sum / prices.length;
        System.out.println("平均: " + average + "円");
        System.out.println("最高価格は " + max + "円です");
    }
}