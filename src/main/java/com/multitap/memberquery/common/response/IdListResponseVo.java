package com.multitap.memberquery.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class IdListResponseVo<T> {

    private T id;

    @Builder
    public IdListResponseVo(T id) {
        this.id = id;
    }
}
