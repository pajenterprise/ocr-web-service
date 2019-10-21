package com.jalasoft.ocrwebservice.database;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


public class User {

    private String userId;
    private String password;
    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * @return id.
     */
    public String getId() {
        return userId;
    }

    /**
     * @param id id.
     */
    public void setId(final String id) {
        this.userId = id;
    }

    /**
     * @return password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password password.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

}
