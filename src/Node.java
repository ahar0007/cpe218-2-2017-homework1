public class Node {
    private Node left,right;
    private String value;

    Node(){
        left = null;
        right = null;
    }

    public Node nodeLeft() {
        return left;
    }

    public Node nodeRight() {
        return right;
    }

    public String getValue() {
        return value;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}