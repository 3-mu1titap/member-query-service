package com.multitap.memberquery.dto.in;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.kafka.consumer.messagein.NicknamePhoneDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NicknamePhoneRequestDto {

    private String uuid;
    private String nickName;
    private String phoneNumber;

    @Builder
    public NicknamePhoneRequestDto(String uuid, String nickName, String phoneNumber) {
        this.uuid = uuid;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }

    public static NicknamePhoneRequestDto from(NicknamePhoneDto nicknamePhoneDto) {
        return NicknamePhoneRequestDto.builder()
                .uuid(nicknamePhoneDto.getUuid())
                .nickName(nicknamePhoneDto.getNickName())
                .phoneNumber(nicknamePhoneDto.getPhoneNumber())
                .build();
    }

    public MemberInfo toEntity(MemberRequestDto memberRequestDto, MemberInfo memberInfo){
        return MemberInfo.builder()
                .id(memberInfo.getId())
                .profileImageUrl(memberInfo.getProfileImageUrl())
                .accountDetails(memberRequestDto)
                .hashtag(memberInfo.getHashtag())
                .mentorProfileInfo(memberInfo.getMentorProfileInfo())
                .menteeProfileInfo(memberInfo.getMenteeProfileInfo())
                .build();
    }
}
