package com.training.micro.validation.security.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@TableGenerator(name = "user_gen",
                table = "id_gen",
                pkColumnName = "gen_index",
                pkColumnValue = "user_id",
                valueColumnName = "current_id",
                initialValue = 0,
                allocationSize = 1)
@Table(name = "kullanici")
public class UserObject {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_gen")
    private Long   userId;
    @Column(unique = true)
    private String username;
    private String password;
    private String role;

    @PrePersist
    public void encrypt() {
        BCryptPasswordEncoder encoderLoc = new BCryptPasswordEncoder();
        this.password = encoderLoc.encode(this.password);
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(final Long userIdParam) {
        this.userId = userIdParam;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String usernameParam) {
        this.username = usernameParam;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String passwordParam) {
        this.password = passwordParam;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(final String roleParam) {
        this.role = roleParam;
    }


}
