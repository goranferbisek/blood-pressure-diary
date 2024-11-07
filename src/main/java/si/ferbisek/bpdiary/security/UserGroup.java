package si.ferbisek.bpdiary.security;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "user_groups")
@NamedQuery(name = "UserGroup.all", query = "SELECT ug FROM UserGroup ug")
public class UserGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public UserGroup() {
    }

    public UserGroup(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGroup userGroup = (UserGroup) o;
        return Objects.equals(id, userGroup.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
