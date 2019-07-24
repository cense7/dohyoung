package com.searchBook.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User implements UserDetails
{

    /**
     *
     */
    private static final long serialVersionUID = 2871410132798310937L;
    @Id
    private String            username;
    private String            password;

    // default fetch type = LAZY
    @OneToMany
    @JoinColumn(name = "UserHistory")
    List<UserHistory>         userHistory;





    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        // TODO Auto-generated method stub
        List<GrantedAuthority> authorities = new ArrayList<>();

        return authorities;
    }





    @Override
    public boolean isAccountNonExpired()
    {
        // TODO Auto-generated method stub
        return true;
    }





    @Override
    public boolean isAccountNonLocked()
    {
        // TODO Auto-generated method stub
        return true;
    }





    @Override
    public boolean isCredentialsNonExpired()
    {
        // TODO Auto-generated method stub
        return true;
    }





    @Override
    public boolean isEnabled()
    {
        // TODO Auto-generated method stub
        return true;
    }
}
