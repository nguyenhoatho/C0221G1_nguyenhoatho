package example.example1;

import java.util.Comparator;

public  class PriceComparatorOfProduct implements Comparator<Product>  {
    @Override
    public int compare(example.example1.Product o1, example.example1.Product o2) {
        if (o1.getPrice()>o2.getPrice()){
           return 1;
       }
        else if (o1.getPrice()==o2.getPrice()){ return 0;
       }
        else {
           return -1;}
    }



//        if (o1.getPrice()>o2.getPrice()){
//            return 1;
//        }else if (o1.getPrice()==o2.getPrice()){
//            return 0;
//        }else {
//            return -1;
//        }


    }



