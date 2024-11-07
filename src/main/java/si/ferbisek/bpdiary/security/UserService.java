package si.ferbisek.bpdiary.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    @PersistenceContext()
    private EntityManager entityManager;

    @Inject
    private Pbkdf2PasswordHash passwordHasher;

    @Transactional
    public User createUser(String name, String username, String password, UserGroup userGroup) {
        User user = new User(name, username, passwordHasher.generate(password.toCharArray()), userGroup);
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    @Transactional
    public UserGroup createUserGroup(String name) {
        UserGroup userGroup = new UserGroup(name);
        entityManager.persist(userGroup);
        entityManager.flush();
        return userGroup;
    }

    public List<UserGroup> listUserGroups() {
        return entityManager.createNamedQuery("UserGroup.all", UserGroup.class).getResultList();
    }

    public Optional<User> getUser(String username) {
        return entityManager.createNamedQuery("User.byUsername", User.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findFirst();
    }
}
