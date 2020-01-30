package app.bootproj.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;

/**
 * ResourceController
 */
@RestController
@CrossOrigin
@RequestMapping("/res")

public class ResourceController {
    @GetMapping(value = "/avatar", produces = MediaType.IMAGE_PNG_VALUE)
    public void getPNGAvatar(@RequestParam String avatarlocation, HttpServletResponse resp) throws IOException{
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(
            new ClassPathResource("public/images/avatar/"+avatarlocation).getInputStream(),
            resp.getOutputStream()
        );
    }

    @GetMapping(value = "/product", produces = MediaType.IMAGE_PNG_VALUE)
    public void getPNGProductImage(@RequestParam String productlocation, HttpServletResponse resp) throws IOException{
        resp.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(
            new ClassPathResource("public/images/product/"+productlocation).getInputStream(),
            resp.getOutputStream()
        );
    }
}