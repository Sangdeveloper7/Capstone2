package com.thc.fallsprbasic.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/makefile")
@Controller
public class MakefileController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "makefile/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "makefile/" + page;
    }

}
