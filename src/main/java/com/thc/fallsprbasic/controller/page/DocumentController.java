package com.thc.fallsprbasic.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/document")
@Controller
public class DocumentController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "document/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "document/" + page;
    }

}
