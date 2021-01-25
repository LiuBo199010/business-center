package com.txj.business.config.controller;

import com.txj.business.config.domain.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lenovo
 */
@RestController
public class GitController {


    @Autowired
    private GitConfig gitConfig;

    @GetMapping(value = "show")
    public Object show(){
        return gitConfig;
    }


}
