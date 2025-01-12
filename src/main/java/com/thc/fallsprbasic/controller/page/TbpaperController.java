package com.thc.fallsprbasic.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/tbpaper")
@Controller
public class TbpaperController {

    @GetMapping("/{page}")
    public String page(@PathVariable String page){
        return "tbpaper/" + page;
    }

    @GetMapping("/{page}/{id}")
    public String page2(@PathVariable String page, @PathVariable String id){
        return "tbpaper/" + page;
    }

}
