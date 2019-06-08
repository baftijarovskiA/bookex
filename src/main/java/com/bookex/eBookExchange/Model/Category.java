package com.bookex.eBookExchange.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "category_table")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

//    more books published on that category more popularity increased
//    deleting books can cause decreasing popularity
    private int popularity;

    private String created_at;
    private String updated_at;

    private boolean visible;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getPopularity() { return popularity; }

    public void setPopularity(int popularity) { this.popularity = popularity; }

    public String getCreated_at() { return created_at; }

    public void setCreated_at(String created_at) { this.created_at = created_at; }

    public String getUpdated_at() { return updated_at; }

    public void setUpdated_at(String updated_at) { this.updated_at = updated_at; }

    public boolean isVisible() { return visible; }

    public void setVisible(boolean visible) { this.visible = visible; }
}
