package example.example3;

public class A {
    private String a;

    public A(String a) {
        this.a = a;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A{" +
                "a='" + a + '\'' +
                '}';
    }


    public static void main(String[] args) {
        int [] a=new int[5];
        System.out.println(a[0]);
    }
}