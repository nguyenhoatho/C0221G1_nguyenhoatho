package baitap;

public class QuadraticEquation {
    private int a;
    private int b;
    private int c;
    private int delta;

    public QuadraticEquation() {

    }

    public QuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public float getDelta() {
        return delta;
    }

    public int delta(){
        this.delta=  this.b*this.b-4*this.a*this.c;
        return this.delta;
    }
    public int getRoot1()
    {
        if (delta()>=0){
            return (-this.b+delta())/2*this.a;
        }

        return 0;
    }
    public int getRoot2()
    {
        if (delta()>=0){
            return (-this.b-delta())/2*this.a;
        }

        return 0;
    }
}
class Main1{
    public static void main(String[] args) {
        QuadraticEquation bai1=new QuadraticEquation(1,8,2);
        System.out.println(bai1.getRoot2());
        System.out.println(bai1.delta());
        System.out.println(bai1.getRoot1());
    }

}
