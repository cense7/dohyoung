package com.searchBook.service.Impl.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.searchBook.domain.User;
import com.searchBook.repository.UserRepository;
import com.searchBook.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService
{
    @Autowired
    private UserRepository  userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;





    public PasswordEncoder passwordEncoder()
    {
        return this.passwordEncoder;
    }





    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException
    {
        // TODO Auto-generated method stub

        Optional<User> user = this.userRepository.findByUsername(username);

        if ( !user.isPresent() )
        {
            throw new UsernameNotFoundException(username);
        }

        User currentUser = user.get();
        currentUser.setPassword(currentUser.getPassword());
        return currentUser;
    }





    @Override
    public void regist(final String username, final String password)
    {
        User user = new User();
        user.setUsername(username);
        user.setPassword(this.passwordEncoder.encode(password));

        try
        {
            this.userRepository.save(user);
        }
        catch ( Exception e )
        {

        }

    }





    @Override
    public boolean isUserName(final String username)
    {
        Optional<User> user = this.userRepository.findByUsername(username);

        return user.isPresent();
    }

}
