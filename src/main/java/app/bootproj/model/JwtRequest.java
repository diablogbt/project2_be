package app.bootproj.model;

import java.io.Serializable;

/**
 * JwtRequest
 */
public class JwtRequest implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    private String uname;
    private String pwd;    
    
    public JwtRequest() { }

    public JwtRequest(String uname, String pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "JwtRequest [pwd=" + pwd + ", uname=" + uname + "]";
    }
    
    
}