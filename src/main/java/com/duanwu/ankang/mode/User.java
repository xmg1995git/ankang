package com.duanwu.ankang.mode;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("xmg_user")
public class User {

    private String id;

    private String name;

    private String nodes;
}
