package excercise1.model.service.impl;

import excercise1.model.repository.SpiceRepo;
import excercise1.model.service.ISpice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SpiceService implements ISpice {
    @Autowired
    SpiceRepo spiceRepo;
    @Override
    public List<String> spice() {
        return spiceRepo.getAll();
    }
}
