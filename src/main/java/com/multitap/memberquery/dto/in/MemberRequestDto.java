package com.multitap.memberquery.dto.in;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.kafka.consumer.messagein.MemberDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberRequestDto {
    private String name;
    private String nickName;
    private String email;
    private String accountId;
    private String phoneNumber;

    @Builder
    public MemberRequestDto(String name, String nickName, String email, String accountId, String phoneNumber) {
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.accountId = accountId;
        this.phoneNumber = phoneNumber;
    }

    public static MemberRequestDto from(MemberDto memberDto) {
        return MemberRequestDto.builder()
                .name(memberDto.getName())
                .nickName(memberDto.getNickName())
                .email(memberDto.getEmail())
                .accountId(memberDto.getAccountId())
                .phoneNumber(memberDto.getPhoneNumber())
                .build();
    }

    public MemberRequestDto updateNickNameAndPhoneNumber(NicknamePhoneRequestDto nicknamePhoneRequestDto, MemberRequestDto memberRequestDto) {
        return MemberRequestDto.builder()
                .name(memberRequestDto.name)
                .nickName(nicknamePhoneRequestDto.getNickName())
                .email(memberRequestDto.email)
                .accountId(memberRequestDto.accountId)
                .phoneNumber(nicknamePhoneRequestDto.getPhoneNumber())
                .build();
    }

    public MemberInfo toEntity(MemberRequestDto memberRequestDto, String uuid, String profileImage) {
        return MemberInfo.builder()
                .id(uuid)
                .accountDetails(memberRequestDto)
                .profileImageUrl(profileImage)
                .build();
    }
}
