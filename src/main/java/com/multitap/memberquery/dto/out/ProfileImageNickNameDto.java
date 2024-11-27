package com.multitap.memberquery.dto.out;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.vo.out.ProfileImageNickNameVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageNickNameDto {

    private String nickName;
    private String profileImageUrl;

    @Builder
    public ProfileImageNickNameDto(String nickName, String profileImageUrl) {
        this.nickName = nickName;
        this.profileImageUrl = profileImageUrl;
    }

    public static ProfileImageNickNameDto from(MemberInfo memberInfo) {
        return ProfileImageNickNameDto.builder()
                .nickName(memberInfo.getAccountDetails().getNickName())
                .profileImageUrl(memberInfo.getProfileImageUrl())
                .build();
    }

    public ProfileImageNickNameVo toVo() {
        return ProfileImageNickNameVo.builder()
                .nickName(nickName)
                .profileImageUrl(profileImageUrl)
                .build();
    }
}
