package edu.tum.ase.project.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    //add user list assignment to projects
    @ElementCollection
//    @OnDelete( action = OnDeleteAction.CASCADE )
    @CollectionTable(name = "project_users", joinColumns = @JoinColumn(name = "id") )
    @MapKeyColumn(name = "id")
    @Column(name = "users")
    @OrderColumn
    private Set<String> users = new HashSet();
//    @Column(name = "users")
//    private Set<String> users = new HashSet<>();



    // Uni-directionale Verbindung von Project zu SourceFile, Da wenn Project geöffnet wird, alle zugehörigen Files laden sollen, nicht aber umgekehrt
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "project_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<SourceFile> sourcefiles;
    // no-args constructor required by JPA spec, this one is protected since it shouldn't be used directly
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

    public Set<String> getUsers() {
        return this.users;
    }

    public void setUsers(Set<String> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<SourceFile> getSourcefiles() {
//        return sourcefiles;
//    }
//
//    public void setSourcefiles(Set<SourceFile> sourcefiles) {
//        this.sourcefiles = sourcefiles;
//    }
}
