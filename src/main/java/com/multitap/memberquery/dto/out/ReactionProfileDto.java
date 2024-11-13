package com.multitap.memberquery.dto.out;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.vo.out.ReactionProfileVo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.lang.reflect.Member;

@Getter
@NoArgsConstructor
public class ReactionProfileDto {

    private String nickName;
    private String profileImageUrl;

    @Builder
    public ReactionProfileDto(String nickName, String profileImageUrl) {
        this.nickName = nickName;
        this.profileImageUrl = profileImageUrl;
    }

    public static ReactionProfileDto from(MemberInfo memberInfo) {
        return ReactionProfileDto.builder()
                .nickName(memberInfo.getAccountDetails().getNickName())
                .profileImageUrl(memberInfo.getProfileImageUrl())
                .build();
    }

    public ReactionProfileVo toVo() {
        return ReactionProfileVo.builder()
                .nickName(nickName)
                .profileImageUrl(profileImageUrl)
                .build();
    }
}
