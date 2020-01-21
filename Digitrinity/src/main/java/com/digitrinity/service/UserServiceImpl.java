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
        List<RoleUsers> roleUsers = new ArrayList<>();
        for (Role s : savedUser.getRoles()) {
            roleUsers.add(userRoleRepository.getOne(s.getId()));
        }
        for (RoleUsers r : roleUsers) {
            siteType.add(String.valueOf(r.getTee()));
            siteType.add(String.valueOf(r.getHybrid()));
            siteType.add(String.valueOf(r.getLithiumIon()));
        }
        return siteType;
    }
}
