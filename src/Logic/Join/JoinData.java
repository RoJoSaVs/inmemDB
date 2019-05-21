package Logic.Join;

public class JoinData<J> {

    private J right = null;
    private J left = null;

    public void setJoin(J right, J left){
        this.setLeft(left);
        this.setRight(right);
    }

    private void setRight(J right){
        this.right = right;
    }
    private void setLeft(J left){
        this.left = left;
    }

    public void getData(){
        System.out.println(this.getLeft());
        System.out.println(this.getRight());
    }
    private J getLeft() {
        return left;
    }
    private J getRight() {
        return right;
    }
}
