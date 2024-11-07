package com.multitap.memberquery.dto.in;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.kafka.messagein.MemberDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String uuid;
    private String name;
    private String nickName;
    private String email;
    private String accountId;
    private String phoneNumber;

    @Builder
    public MemberRequestDto(String uuid, String name, String nickName, String email, String accountId, String phoneNumber) {
        this.uuid = uuid;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.accountId = accountId;
        this.phoneNumber = phoneNumber;
    }

    public static MemberRequestDto from(MemberDto memberDto) {
        return MemberRequestDto.builder()
                .uuid(memberDto.getUuid())
                .name(memberDto.getName())
                .nickName(memberDto.getNickName())
                .email(memberDto.getEmail())
                .accountId(memberDto.getAccountId())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }

    public MemberInfo toEntity(MemberRequestDto memberRequestDto) {
        return MemberInfo.builder()
                .uuid(memberRequestDto.getUuid())
                .memberRequestDto(memberRequestDto)
                .build();
    }
}
