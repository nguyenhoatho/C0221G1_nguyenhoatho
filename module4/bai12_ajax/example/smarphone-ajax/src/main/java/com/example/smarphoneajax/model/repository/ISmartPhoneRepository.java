package com.example.smarphoneajax.model.repository;

import com.example.smarphoneajax.model.entiry.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone,Long> {
}
