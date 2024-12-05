package com.multitap.memberquery.dto.in;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.kafka.consumer.messagein.ProfileImageDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageRequestDto {

    private String uuid;
    private String profileImageUrl;

    @Builder
    public ProfileImageRequestDto(String uuid, String profileImageUrl) {
        this.uuid = uuid;
        this.profileImageUrl = profileImageUrl;
    }

    public static ProfileImageRequestDto from(ProfileImageDto profileImageDto) {
        return ProfileImageRequestDto.builder()
                .uuid(profileImageDto.getUuid())
                .profileImageUrl(profileImageDto.getProfileImageUrl())
                .build();
    }

    public MemberInfo toEntity(ProfileImageRequestDto profileImageRequestDto, MemberInfo memberInfo) {
        return MemberInfo.builder()
                .id(memberInfo.getId())
                .profileImageUrl(profileImageRequestDto.getProfileImageUrl())
                .accountDetails(memberInfo.getAccountDetails())
                .hashtag(memberInfo.getHashtag())
                .mentorProfileInfo(memberInfo.getMentorProfileInfo())
                .menteeProfileInfo(memberInfo.getMenteeProfileInfo())
                .build();
    }

}
