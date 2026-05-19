package practicejava;

public class 練習問題 {

	public static void main(String[] args) {
		String myName = "さゆ"; // ここを自分の名前に書き換えてみて！
		int count = myName.length();
		if (count > 3) {System.out.println("素敵な名前ですね");}
		else {System.out.println("スッキリした名前ですね");}

		System.out.println(myName + " は、全部で " + count + " 文字です。");
	}

}
