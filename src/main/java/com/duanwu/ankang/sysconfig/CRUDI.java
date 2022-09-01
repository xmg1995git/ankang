package com.duanwu.ankang.sysconfig;

import javax.validation.groups.Default;

public interface CRUDI extends Default {

    interface SAVE extends CRUDI{};
    interface UPDATE extends CRUDI{};
    interface DELETE extends CRUDI{};
    interface SELECT extends CRUDI{};
}
