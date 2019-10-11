package app.bootproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.bootproj.pojo.FanList;
import app.bootproj.service.FanListService;

/**
 * ProductController
 */
@RestController
@CrossOrigin
@Validated
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private FanListService fanListService;

    @GetMapping("getAll")
    List<FanList> getAll(){
        System.out.println("request fanlist");
        return fanListService.getAll();
    }
}