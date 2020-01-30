package app.bootproj.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.bootproj.config.JwtTokenUtil;
import app.bootproj.model.JwtRequest;
import app.bootproj.model.JwtResponse;
import app.bootproj.pojo.UserInfo;
import app.bootproj.service.UserService;

/**
 * JwtAuthenticationController
 */
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserDetailsService myJwtUserDetailsService;

    @Autowired
    UserService userService;

    @PostMapping("/signup")
    
    public ResponseEntity<?> signUp(@RequestBody UserInfo userInfo) throws Exception{
        System.out.println("signup..."+userInfo.toString());
        UserInfo currentUserInfo = userService.get(userInfo.getUsername());
        

        if(currentUserInfo != null){
            System.out.println("user exists...");
            return ResponseEntity.badRequest().build();
        }
        else{
            System.out.println("create user...");
            userService.add(new UserInfo(userInfo.getUsername(),userInfo.getPassword()));
            return createAuthenticationToken(
                new JwtRequest(userInfo.getUsername(), userInfo.getPassword())
            );
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        System.out.println("new auth request: "+ authenticationRequest.toString());
        String uname = authenticationRequest.getUname();
        String pwd = authenticationRequest.getPwd();
        authenticate(uname, pwd);
        final UserDetails userDetails = myJwtUserDetailsService
        .loadUserByUsername(authenticationRequest.getUname());
        final String token = jwtTokenUtil.generateToken(userDetails);
        userService.saveToken(userDetails.getUsername(), token);
        // JwtResponse resp = 
        return ResponseEntity.ok(new JwtResponse(token,userService.get(uname).getUserid()));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/authGetId")
    ResponseEntity<?> authGetId(@RequestHeader String authorization){
        if(authorization == null || authorization.startsWith("bearer "))
            return ResponseEntity.badRequest().build();
        String jwToken = authorization.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(jwToken);
        Integer userid = userService.getId(username);
        if(userid == null)
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok().body(userid);
    }

    @GetMapping("/test")
    ResponseEntity<?> test(){
        String resstr = "it is a body";
        return ResponseEntity.ok().body(resstr);
    }
}