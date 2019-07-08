package com.bookex.eBookExchange.Model;

import javax.persistence.*;

@Entity
@Table(name = "promotion_table")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private String id;

    private String link;
    private String picture;

    private boolean display;

    private String created_at;
    private String updated_at;


    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }

    public String getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }

    public boolean isDisplay() { return display; }

    public void setDisplay(boolean display) { this.display = display; }

    public String getCreated_at() { return created_at; }

    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }
}
