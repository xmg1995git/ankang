package com.duanwu.ankang.mode;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
@Valid
public class Check {

    private String id;

    @NotBlank(message = "名字为必填项")
    private String message;
}
