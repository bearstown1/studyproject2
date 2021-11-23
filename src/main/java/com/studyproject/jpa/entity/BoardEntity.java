package com.studyproject.jpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name="BOARD")
@Getter
@Setter
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Builder
    public BoardEntity (Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Builder
    public BoardEntity (String title, String content) {
        this.title = title;
        this.content = content;
    }
}
