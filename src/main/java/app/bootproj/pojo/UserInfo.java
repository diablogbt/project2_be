package app.bootproj.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * User
 */
@Entity
@Table(name = "userinfo")
public class UserInfo {

    @Id
    // @GenericGenerator(name="asc_gen", strategy = "increment")
    @GeneratedValue
    // (generator = "asc_gen")
    private Integer userid;

    private String username;
    private String password;
    private String token;
    private String role="USER";

    private String email;

    private String addition;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAddition() {
        return addition;
    }

    public void setAddition(String addition) {
        this.addition = addition;
    }

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserInfo() { }

    

    @Override
    public String toString() {
        return "UserInfo [addition=" + addition + ", email=" + email + ", password=" + password + ", role=" + role + ", token="
                + token + ", userid=" + userid + ", username=" + username + "]";
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

}