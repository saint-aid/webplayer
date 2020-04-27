package com.nevermind.webplayer.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Videos {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long hits;

    private Long likes;

    private String title;

    private String description;

    private String fileName;

    private String path;

    @Builder
    public Videos(Long id, String title, String path) {
        this.id = id;
        this.title = title;
        this.path = path;
    }

}
