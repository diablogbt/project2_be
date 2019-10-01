package app.bootproj;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.bootproj.pojo.UserInfo;
import app.bootproj.service.UserService;

@RestController
@Validated
public class HelloController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    String hello() {
        String res = "Hello World~~~";
        for(UserInfo ui: userService.getAll())
            res+=ui.toString()+", ";
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

    // SQL sample
    @RequestMapping("calc")
    Result calc(@RequestParam int left, @RequestParam int right) {
        MapSqlParameterSource source = new MapSqlParameterSource()
                .addValue("left", left)
                .addValue("right", right);
        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
                (rs, rowNum) -> new Result(left, right, rs.getLong("answer")));
    }
}
