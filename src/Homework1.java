public class Homework1 {

	public static void main(String[] args) {
		String input = "";

		// Begin of arguments input sample

		if (args.length > 0) {
			//input = args[0];
			}

		// End of arguments input sample

		// TODO: Implement your project here

		Node answer = new Node();
		input = "251-*32*+";

		if (args.length!=0) {
		}
		for (int i = 0; i < input.length(); i++) {
			Node tempNode = new Node();
			tempNode.setValue(String.valueOf(input.charAt(i)));
			if (answer.getValue() == null){
				answer = infix(tempNode);
					continue;
			}
			tempNode.setLeft(answer);
			answer = infix(tempNode);
		}
		String infix = inorder(answer);
		System.out.println(infix.substring(1,infix.length()-1) + "=" +calculator(answer));
		//System.out.println(answer.nodeLeft().nodeRight().getValue());
	TreeIconDemo2.main(answer);
	}






	// infix function
	public static Node infix(Node n){
		if (n.getValue().charAt(0) == '+' ||n.getValue().charAt(0) == '-' ||n.getValue().charAt(0) == '*' ||n.getValue().charAt(0) == '/'  ) {
			n.setRight(n.nodeLeft());
			if (n.nodeLeft().getValue().matches("[0-9]")) {
				n.setLeft(n.nodeRight().nodeLeft());
				n.nodeRight().setLeft(null);
			} else {
				n.setRight(n.nodeLeft());
				n.setLeft(n.nodeRight().nodeLeft().nodeLeft());
				n.nodeRight().nodeLeft().setLeft(null);
			}
		}
		return n;
	}

	public static String inorder(Node n) {
		String left = "";
		String right = "";
		if (n.nodeLeft() != null) {
			left = "(" + inorder(n.nodeLeft());
		}
		if (n.nodeRight() != null) {
			right = inorder(n.nodeRight()) + ")";
		}

		return (left + n.getValue() + right);
	}

	public static int calculator(Node calNode) {
		int sum = 0;

		if (calNode.getValue().matches("[0-9]")) return Integer.valueOf(calNode.getValue());

		int a = calculator(calNode.nodeLeft());
		int b = calculator(calNode.nodeRight());

		switch (calNode.getValue()){
			case "+":sum = a + b;break;
			case "-":sum = a - b;break;
			case "*":sum = a * b;break;
			case "/":sum = a / b;break;
		}


		return sum;
	}
}
