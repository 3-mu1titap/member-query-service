package com.multitap.memberquery.infrastructure.kafka.messagein;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberDto {

    private String name;
    private String nickName;
    private String email;
    private String accountId;
    private String phoneNumber;

    @Builder
    public MemberDto(String name, String nickName, String email, String accountId, String phoneNumber) {
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.accountId = accountId;
        this.phoneNumber = phoneNumber;
    }
}