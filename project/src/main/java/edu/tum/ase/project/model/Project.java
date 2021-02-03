package edu.tum.ase.project.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@JsonSerialize
@Entity
@Table(name = "projects")
public class Project implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "project_id")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    //add user list assignment to projects
    @ElementCollection
    @CollectionTable(name = "project_users", joinColumns = @JoinColumn(name = "id") )
    @MapKeyColumn(name = "id")
    @Column(name = "users")
    @OrderColumn
    private Set<String> users = new HashSet();

    protected Project() {}

    public Project(String name, Set<String> users) {
        this.name = name;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<String> getUsers() { return this.users; }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
