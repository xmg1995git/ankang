package com.duanwu.ankang.mode.response;

import lombok.Data;

@Data
public class TableFieldInfo {

    private String fieldName;
    private String fieldType;
    private String nullable;
    private String key;
    private String extra;



}
