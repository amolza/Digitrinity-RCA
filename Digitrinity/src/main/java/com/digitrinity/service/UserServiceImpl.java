package com.digitrinity.service;

import com.digitrinity.model.Role;
import com.digitrinity.model.RoleUsers;
import com.digitrinity.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.digitrinity.model.Users;
import com.digitrinity.repository.RoleRepository;
import com.digitrinity.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public void save(Users user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public Users findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<Users> findById(long l) {
        return userRepository.findById(l);
    }

    @Override
    public List<String> allSiteTypeForUser(String user) {
        List<String> siteType = new ArrayList<>();
        Users savedUser = findByUsername(user);
        RoleUsers r = userRoleRepository.getOne(Long.valueOf(savedUser.getRoleId()));
        if (r.getTee() > 0)
            siteType.add(String.valueOf(r.getTee()));
        if (r.getHybrid() > 0)
            siteType.add(String.valueOf(r.getHybrid()));
        if (r.getLithiumIon() > 0)
            siteType.add(String.valueOf(r.getLithiumIon()));
        return siteType;
    }
}
