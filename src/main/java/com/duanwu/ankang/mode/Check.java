package com.duanwu.ankang.mode;

import com.duanwu.ankang.sysconfig.CRUDI;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Valid
public class Check {

    private String id;

    @NotBlank(message = "名字为必填项", groups ={CRUDI.SAVE.class, CRUDI.SELECT.class})
    private String name;

    @NotBlank(message = "消息为必填项", groups = {CRUDI.SAVE.class})
    private String message;
}
