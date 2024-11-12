package com.multitap.memberquery.dto.in;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.vo.ProfileImageRequestVo;
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

    public static ProfileImageRequestDto from(ProfileImageRequestVo profileImageRequestVo, String uuid){
        return ProfileImageRequestDto.builder()
               .uuid(uuid)
               .profileImageUrl(profileImageRequestVo.getProfileImageUrl())
               .build();
    }

    public MemberInfo toEntity(ProfileImageRequestDto profileImageRequestDto, MemberInfo memberInfo){
        return MemberInfo.builder()
               .id(memberInfo.getId())
               .profileImageUrl(profileImageRequestDto.getProfileImageUrl())
               .build();
    }

}
