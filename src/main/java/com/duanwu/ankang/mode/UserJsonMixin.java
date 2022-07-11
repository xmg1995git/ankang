package com.duanwu.ankang.mode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonMixin;

@JsonMixin(User.class)
@AllArgsConstructor
@NoArgsConstructor
public class UserJsonMixin {

    @JsonIgnore
    private String jsonMixin;
}
