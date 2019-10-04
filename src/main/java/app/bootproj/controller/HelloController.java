package app.bootproj.controller;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@CrossOrigin
public class HelloController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    String hello() {
        String res = "Hello World~~~";
        
        return res;
    }

    @Data
    static class Result {
        public Result(int left2, int right2, long long1) {
        }
        private  int left;
        private  int right;
        private  long answer;
    }

}
