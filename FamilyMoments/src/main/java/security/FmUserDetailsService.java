package security;

import dao.UserDao;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shihan on 16/5/6.
 */
public class FmUserDetailsService implements UserDetailsService {
    private UserDao userDao;

    public FmUserDetailsService(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = userDao.findByName(s);
        if (u == null)
            throw new UsernameNotFoundException("User '" + s + "' not found.");
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        FmUserDetails fmUserDetails = new FmUserDetails(s, u.getPassword(), authorities, u.getId());
        return fmUserDetails;
    }
}
