package app.bootproj.model;

import java.io.Serializable;

/**
 * JwtResponse
 */
public class JwtResponse implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final String jwttoken;
    private Integer userid;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public JwtResponse(String jwttoken, Integer userid) {
        this.jwttoken = jwttoken;
        this.userid = userid;
    }
    
    public String getToken() {
        return this.jwttoken;
    }

    public Integer getUserid(){
        return this.userid;
    }

    public void setUserid(Integer id){
        this.userid = id;
    }
}