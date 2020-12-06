package edu.tum.ase.project.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
    // ... additional members, often include @OneToMany mappings
    // Uni-directionale Verbindung von Project zu SourceFile
    // Da wenn Project geöffnet wird, alle zugehörigen Files laden sollen
    // nicht aber umgekehrt
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "project_id")
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Set<SourceFile> sourcefiles;


    protected Project() {
// no-args constructor required by JPA spec
// this one is protected since it shouldn't be used directly
    }

    public Project(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
