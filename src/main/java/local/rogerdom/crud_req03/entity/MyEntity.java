package local.rogerdom.crud_req03.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


@Entity
@Table
public class MyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @NotNull(message = "O nome não pode ser vazio")
    String Name;
    String Version;

    public MyEntity() {
    }

    public MyEntity(Long id, String name, String version) {
        Id = id;
        Name = name;
        Version = version;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getVersion() {
        return Version;
    }

    @Override
    public String toString() {
        return "Entidade{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Version='" + Version + '\'' +
                '}';
    }
}
