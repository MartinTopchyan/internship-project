package edu.inconcept.netflix.entity;

import javax.persistence.*;

@Entity
@Table(name = "title_type")
public class TitleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    public TitleType(String name) {
        this.name = name;
    }

    public TitleType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
