package com.springapp.service;

import com.springapp.entity.User;
import com.springapp.entity.enums.UserRoles;
import com.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
	user.setRole(UserRoles.USER);
	//PasswordEncoder passwordEncoder=new
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	String hashedPassword = passwordEncoder.encode(user.getPassword());
	user.setPassword(hashedPassword);
	User savedUser = userRepository.saveAndFlush(user);
	return savedUser;
    }

    @Override
    public void delete(long id) {
	userRepository.delete(id);
    }

   /* @Override
    public UserDetails getByLogin(String login) {
	User user = userRepository.findByLogin(login);
	Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();


	roles.add((new SimpleGrantedAuthority((user.getRole().name()))));
	UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
	return userDetails;
    }*/

    @Override
    public User editUser(User user) {
	return userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
	return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {


	User user = userRepository.findByLogin(login);
	if (user != null) {
	    Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();


	    roles.add((new SimpleGrantedAuthority((user.getRole().name()))));
	    UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), roles);
	    //UserDetails user = new User(username, "password", true, true, true, true, new GrantedAuthority[]{ new GrantedAuthorityImpl("ROLE_USER") });
	    return userDetails;
	} else {
	    throw new UsernameNotFoundException("Неправильный логин или пароль");
	}

    }
}
