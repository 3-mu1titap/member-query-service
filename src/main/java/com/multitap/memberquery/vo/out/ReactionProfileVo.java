package com.multitap.memberquery.vo.out;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReactionProfileVo {

    private String nickName;
    private String profileImageUrl;

    @Builder
    public ReactionProfileVo(String nickName, String profileImageUrl) {
        this.nickName = nickName;
        this.profileImageUrl = profileImageUrl;
    }
}
