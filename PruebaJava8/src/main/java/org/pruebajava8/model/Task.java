package org.pruebajava8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre no debe ir vacio!")
    @Column(nullable = false, length = 45)
    private String name;
    @NotEmpty(message = "La descripción no debe ir vacía!")
    @Column(nullable = false, length = 100)
    private String description;

    @NotNull(message = "La fecha de inicio no debe ser nula!")
    @Column(nullable = false)
    private String startDate;



    public Task() {
    }

    public Task(Long id, String name, String description, String startDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }


}

