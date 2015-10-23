package com.springapp.service.impl;

import com.springapp.dao.UserDAO;
import org.springframework.security.core.userdetails.User;
import com.springapp.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by skaramched on 10/21/15.
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    //get user from the database, via Hibernate
    @Autowired
    private UserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(final String username)
        throws UsernameNotFoundException {

        com.springapp.domain.User user = userDao.findByUserName(username);

        List<GrantedAuthority> authorities =
            buildUserAuthority(user.getUserRole());

        return buildUserForAuthentication(user, authorities);

    }

    public List<com.springapp.domain.User> findAll() {
        return userDao.findAll();
    }

    // Converts com.springapp.domain.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(com.springapp.domain.User user,
        List<GrantedAuthority> authorities) {
        return new User(user.getUsername(), user.getPassword(),
            user.isEnabled(), true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (UserRole userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }

}