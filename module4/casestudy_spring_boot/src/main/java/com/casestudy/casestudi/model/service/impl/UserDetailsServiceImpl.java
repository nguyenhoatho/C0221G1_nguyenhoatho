package com.casestudy.casestudi.model.service.impl;

import com.casestudy.casestudi.model.entity.AppRole;
import com.casestudy.casestudi.model.entity.AppUser;
import com.casestudy.casestudi.model.entity.UserRole;
import com.casestudy.casestudi.model.repository.AppRoleRepository;
import com.casestudy.casestudi.model.repository.AppUserRepository;
import com.casestudy.casestudi.model.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private AppRoleRepository appRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.appUserRepository.findByUserName(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> userRoles = this.userRoleRepository.findByAppUser(appUser);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);

        return userDetails;
    }

    public void saveAppUser(AppUser appUser){
        appUserRepository.save(appUser);
    }
    public void saveUserRole(UserRole userRole){
        userRoleRepository.save(userRole);
    }

    public AppUser findAppUserById(Long id){
        return appUserRepository.findById(id).orElse(null);
    }
    public UserRole findUserRoleById(Long id){
        return userRoleRepository.findById(id).orElse(null);
    }
    public List<AppUser>findAllAppUser(){
        return (List<AppUser>) appUserRepository.findAll();
    }
    public List<UserRole> findAllUserRole(){
        return (List<UserRole>) userRoleRepository.findAll();
    }
    public List<AppRole> findAllAppRole(){
        return (List<AppRole>) appRoleRepository.findAll();
    }
    public AppRole findAppRoleById(Long id){
        return appRoleRepository.findById(id).orElse(null);

    }

}
