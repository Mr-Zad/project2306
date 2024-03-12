package com.xust.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultCode {

    SUCCESS(200),
    FAILED(500),
    UNLOGIN(401),
    FORBID(403)
    ;


    private Integer code;
}
