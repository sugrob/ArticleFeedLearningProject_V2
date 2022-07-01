package com.sugrob.app.entity;

import org.hibernate.annotations.CreationTimestamp;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Access;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.PrePersist;
import javax.persistence.GenerationType;
import javax.persistence.AccessType;
import java.sql.Timestamp;
import java.time.Instant;

@Entity(name = "Article")
@Table(name = "article")
@Access(value=AccessType.FIELD)
public class Article {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_time", nullable = false)
    @CreationTimestamp
    private Timestamp createdTime;

    @Column(name = "title")
    @Size(max = 128, min = 5, message = "{article.title.invalid}")
    @NotEmpty(message = "{article.title.empty}")
    private String title;

    @Column(name = "content")
    @Size(max = 21844, min = 10, message = "{article.content.invalid}")
    @NotEmpty(message = "{article.content.empty}")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}