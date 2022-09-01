package com.duanwu.ankang.controller.valid;

import com.duanwu.ankang.mode.Check;
import com.duanwu.ankang.sysconfig.CRUDI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@RestController
public class ValidController {

    @PostMapping("/validated")
    public String validated(@Validated() @RequestBody Check validVO){
        log.info("validEntity is {}", validVO);
        return "test1 valid success"+ validVO;
    }

    @PostMapping("/validated/save")
    public String validatedSave(@Validated(value = CRUDI.SAVE.class) @RequestBody Check validVO){
        log.info("validEntity is {}", validVO);
        return "test1 valid success"+ validVO;
    }

    @PostMapping("/validated/select")
    public String validatedSelect(@Validated(value = CRUDI.SELECT.class) @RequestBody Check validVO){
        log.info("validEntity is {}", validVO);
        return "test1 valid success"+ validVO;
    }
}
