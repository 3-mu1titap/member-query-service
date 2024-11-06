package com.multitap.memberquery.common.exception;

import com.multitap.member.common.response.BaseResponseStatus;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private final BaseResponseStatus status;

    public BaseException(BaseResponseStatus status) {
        this.status = status;

    }
}
