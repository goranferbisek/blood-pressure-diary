package si.ferbisek.bpdiary.security;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.byUsername", query = "SELECT u FROM User u WHERE u.username = :username")
public class User implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @ManyToOne
    @JoinColumn(name = "user_group_id", referencedColumnName = "id", nullable = false)
    private UserGroup userGroup;

    public User() {
    }

    public User(String name, String username, String userPassword, UserGroup userGroup) {
        this.name = name;
        this.username = username;
        this.userPassword = userPassword;
        this.userGroup = userGroup;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
