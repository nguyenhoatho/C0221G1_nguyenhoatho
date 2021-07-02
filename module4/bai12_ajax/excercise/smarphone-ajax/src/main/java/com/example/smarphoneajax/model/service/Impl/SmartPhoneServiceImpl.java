package com.example.smarphoneajax.model.service.Impl;

import com.example.smarphoneajax.model.entiry.SmartPhone;
import com.example.smarphoneajax.model.repository.ISmartPhoneRepository;
import com.example.smarphoneajax.model.service.ISmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SmartPhoneServiceImpl implements ISmartPhoneService {
    @Autowired
    ISmartPhoneRepository smartPhoneRepository;
    @Override
    public Iterable<SmartPhone> findAll() {
        return smartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(Long id) {
        return smartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return smartPhoneRepository.save(smartPhone);
    }


    @Override
    public void remove(Long id) {
        smartPhoneRepository.deleteById(id);
    }

    @Override
    public void update(SmartPhone smartPhone) {
        smartPhoneRepository.save(smartPhone);
    }
}
