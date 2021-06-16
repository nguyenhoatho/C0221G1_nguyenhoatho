package excercise2.model.impl;

import excercise2.model.ICaculator;
import org.springframework.stereotype.Service;

@Service
public class CaculatorServices implements ICaculator {
    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public int subtraction(int a, int b) {
        return a-b;
    }

    @Override
    public int multi(int a, int b) {
        return a*b;
    }

    @Override
    public int div(int a, int b) {
        return a/b;
    }
}
