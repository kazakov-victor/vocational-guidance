package com.globallogic.guidance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long root_id;
    private Long root_number;
    private String content_reference;

    public Root(Long number, String content) {
        this.root_number = number;
        this.content_reference = content;
    }

    public Root() {
    }

    public Long getRoot_id() {
        return root_id;
    }

    public void setRoot_id(Long root_id) {
        this.root_id = root_id;
    }

    public Long getRoot_number() {
        return root_number;
    }

    public void setRoot_number(Long root_number) {
        this.root_number = root_number;
    }

    public String getContent_reference() {
        return content_reference;
    }

    public void setContent_reference(String content_reference) {
        this.content_reference = content_reference;
    }
}
