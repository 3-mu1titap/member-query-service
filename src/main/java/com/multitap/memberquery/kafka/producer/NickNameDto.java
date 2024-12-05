package com.multitap.memberquery.kafka.producer;

import com.multitap.memberquery.entity.MemberInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NickNameDto {
    private String uuid;
    private String nickName;

    @Builder
    public NickNameDto(String uuid, String nickName) {
        this.uuid = uuid;
        this.nickName = nickName;
    }

    public static NickNameDto from(MemberInfo memberInfo) {
        return NickNameDto.builder()
                .uuid(memberInfo.getId())
                .nickName(memberInfo.getAccountDetails().getNickName())
                .build();
    }
}
