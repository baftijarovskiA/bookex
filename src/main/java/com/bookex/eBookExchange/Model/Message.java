package com.bookex.eBookExchange.Model;

import javax.persistence.*;

@Entity
@Table(name = "message_table")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    private String email;
    private String message;

    public String created_at;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public String getCreated_at() { return created_at; }

    public void setCreated_at(String created_at) { this.created_at = created_at; }
}
