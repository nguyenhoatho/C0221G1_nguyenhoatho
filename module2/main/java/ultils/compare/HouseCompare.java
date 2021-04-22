package ultils.compare;

import models.House;

import java.util.Comparator;

public class HouseCompare implements Comparator<House> {
    @Override
    public int compare(House o1, House o2) {
        if (o1.getServiceName().equals(o2.getServiceName())||o2.getServiceName().equals(o1.getServiceName())){
            return 0;
        }
        return 1;
    }
}
