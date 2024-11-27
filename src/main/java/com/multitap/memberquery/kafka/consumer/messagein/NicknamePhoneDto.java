package com.multitap.memberquery.kafka.consumer.messagein;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NicknamePhoneDto {
    private String uuid;
    private String nickName;
    private String phoneNumber;

    @Builder
    public NicknamePhoneDto(String uuid, String nickName, String phoneNumber) {
        this.uuid = uuid;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }
}
