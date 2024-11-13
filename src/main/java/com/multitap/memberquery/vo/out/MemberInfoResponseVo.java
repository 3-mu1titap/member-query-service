package com.multitap.memberquery.vo.out;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.dto.in.MenteeProfileRequestDto;
import com.multitap.memberquery.dto.in.MentorProfileRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberInfoResponseVo {
    private String profileImageUrl;
    private MemberRequestDto memberRequestDto;
    private HashtagRequestDto hashtagRequestDto;
    private MentorProfileRequestDto mentorProfileRequestDto;
    private MenteeProfileRequestDto menteeProfileRequestDto;

}
