package com.example.aquaone.service.user;

import com.example.aquaone.LoggedUser;
import com.example.aquaone.model.User;
import com.example.aquaone.repository.user.UserRepository;
import com.example.aquaone.to.UserTo;
import com.example.aquaone.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.example.aquaone.util.UserUtil.prepareToSave;
import static com.example.aquaone.util.ValidationUtil.checkNotFound;
import static com.example.aquaone.util.ValidationUtil.checkNotFoundWithId;


@Service("userService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService implements UserDetailsService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(User user){
        Assert.notNull(user, "user must not be null");
        return repository.save(prepareToSave(user, passwordEncoder));

    }

    public void delete(int id){
        checkNotFoundWithId(repository.deleteUserById(id), id);
    }

    public User get(int id){
       return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public User getByEmail(String email){
         Assert.notNull(email,"email must not be null" );
         return checkNotFound(repository.getUserByEmail(email), "email=" + email);
    }

    @Transactional
    public void enable(int id, boolean enabled) {
        User user = get(id);
        user.setEnabled(enabled);
        repository.save(user);
    }

    public User getByPhone(String phone){
        Assert.notNull(phone, "phone must not be null");
        return checkNotFound(repository.getUserByPhone(phone), "phone=" + phone);
    }

    public List<User> getUsersByAddress(String address){
        Assert.notNull(address, "address must not be null");
        return checkNotFound(repository.getUsersByAddress(address), "address=" + address);
    }

    public User getWithOrders(int id){
        return checkNotFoundWithId(repository.getWithOrders(id), id);
    }

    public List<User> getAll(){
        return repository.findAll(Sort.by(Sort.Direction.ASC, "name", "email"));
    }

    public void update(User user){
        Assert.notNull(user, "user must not be null");
        repository.save(prepareToSave(user, passwordEncoder));
    }

    @CacheEvict(value = "users", allEntries = true)
    @Transactional
    public void update(UserTo userTo) {
        User user = get(userTo.id());
        repository.save(prepareToSave(UserUtil.updateFromTo(user, userTo), passwordEncoder));
    }

    @Override
    public LoggedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.getUserByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new LoggedUser(user);
    }
}
