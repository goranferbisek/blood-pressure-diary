package si.ferbisek.bpdiary;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import si.ferbisek.bpdiary.security.UserGroup;
import si.ferbisek.bpdiary.security.UserService;

@ApplicationScoped
public class DataInitializer {

    @Inject
    private UserService userService;

    public void execute(@Observes @Initialized(ApplicationScoped.class) Object event) {
        if (userService.listUserGroups().isEmpty()) { // and there are no users
            UserGroup adminGroup = userService.createUserGroup("admin");
            userService.createUser("Admin", "admin", "admin", adminGroup);

            UserGroup usersGroup = userService.createUserGroup("user");
            userService.createUser("User", "user", "user", usersGroup);

            userService.createUser("Goran Ferbisek", "goran", "goran", usersGroup);
        }
    }
}
