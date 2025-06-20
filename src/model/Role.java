package model;

import java.util.Date;

public class Role {
    private int id;
    private String name;
    private Date created_at;
    private Date updated_at;

    public Role() {
    }

    public int getId() {
        return id;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    
}
