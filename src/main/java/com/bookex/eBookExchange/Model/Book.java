package com.bookex.eBookExchange.Model;

import javax.persistence.*;

@Entity
@Table(name = "book_table")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    private String userId;
    private String name;
    private String authors;
    private int published;
    private String description;
    private String picture;
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String created_at;
    private String updated_at;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAuthors() { return authors; }

    public void setAuthors(String authors) { this.authors = authors; }

    public int getPublished() { return published; }

    public void setPublished(int published) { this.published = published; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

    public String getFileUrl() { return fileUrl; }

    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }

    public Category getCategory() { return category; }

    public void setCategory(Category category) { this.category = category; }

    public String getCreated_at() { return created_at; }

    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }
}
