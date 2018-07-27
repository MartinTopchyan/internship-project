package edu.inconcept.netflix.service.dto;

public class DirectorDto {
    private Long id;
    private String name;


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

    @Override
    public String toString() {
        return "DirectorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
