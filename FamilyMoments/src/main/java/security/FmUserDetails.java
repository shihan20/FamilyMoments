package security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by shihan on 16/5/6.
 */
public class FmUserDetails extends User {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FmUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, int id) {
        super(username, password, authorities);
        setId(id);
    }
}
