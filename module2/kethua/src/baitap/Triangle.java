package baitap1;

public class Triangle extends Shape {
    private double slide1=1;
    private double slide2=1;
    private double slide3=1;

    public Triangle() {
    }

    public Triangle(double slide1, double slide2, double slide3) {
        this.slide1 = slide1;
        this.slide2 = slide2;
        this.slide3 = slide3;
    }

    public Triangle(String color, boolean filled, double slide1, double slide2, double slide3) {
        super(color, filled);
        this.slide1 = slide1;
        this.slide2 = slide2;
        this.slide3 = slide3;
    }

    public double getSlide1() {
        return slide1;
    }



    public double getSlide2() {
        return slide2;
    }


    public double getSlide3() {
        return slide3;
    }
    public double getArea()
    {
        return (this.slide1*this.slide2)/2;
    }
    public double getPerimeter()
    {
        return this.slide1+this.slide2+this.slide3;
    }
    public boolean check(){
        if( slide1>0&&slide2>0&&slide3>0 &&
                (slide1+slide2>slide3)&&(slide1+slide3>slide1)
                &&(slide2+slide3>slide1)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
      if (check()==true){
          return "canh cua tam giac la:"+slide1+" "+slide2+" "+slide3+
                  " "+getArea()+" "+getPerimeter();

      }
      return 0;
    }
}
class TestTriangle{
    public static void main(String[] args) {
        Triangle T = new Triangle();
        System.out.println(T.toString());

    }}