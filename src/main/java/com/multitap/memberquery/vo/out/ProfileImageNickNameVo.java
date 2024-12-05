package com.multitap.memberquery.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageNickNameVo {

    private String nickName;
    private String profileImageUrl;

    @Builder
    public ProfileImageNickNameVo(String nickName, String profileImageUrl) {
        this.nickName = nickName;
        this.profileImageUrl = profileImageUrl;
    }
}
