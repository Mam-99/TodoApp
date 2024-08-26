package com.react.todo_list.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    private String name;

    private String description;

    private boolean status;
}
