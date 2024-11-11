package com.multitap.memberquery.common.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class IdListResponseDto<T> {

    private T id;

    public IdListResponseVo<T> toVo() {
        return IdListResponseVo.<T>builder()
                .id(this.id)
                .build();
    }

    public static <T> IdListResponseDto<T> from(T id) {
        return IdListResponseDto.<T>builder()
                .id(id)
                .build();
    }

    @Builder
    public IdListResponseDto(T id) {
        this.id = id;
    }

}
