package excercise1.service.impl;

import excercise1.service.ConvertVnd;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements ConvertVnd {
    @Override
    public double convert(int a) {
        return a*23000;
    }
}
