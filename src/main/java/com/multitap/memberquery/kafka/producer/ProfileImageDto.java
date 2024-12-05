package com.multitap.memberquery.kafka.producer;

import com.multitap.memberquery.entity.MemberInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageDto {

    private String uuid;
    private String profileImageUrl;

    @Builder
    public ProfileImageDto(String uuid, String profileImage) {
        this.uuid = uuid;
        this.profileImageUrl = profileImage;
    }

    public static ProfileImageDto from(MemberInfo memberInfo) {
        return ProfileImageDto.builder()
                .uuid(memberInfo.getId())
                .profileImage(memberInfo.getProfileImageUrl())
                .build();
    }
}
