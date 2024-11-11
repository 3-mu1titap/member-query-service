package com.multitap.memberquery.vo.out;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.dto.in.MenteeProfileRequestDto;
import com.multitap.memberquery.dto.in.MentorProfileRequestDto;
import com.multitap.memberquery.entity.MemberInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberInfoResponseDto {

    private MemberRequestDto memberRequestDto;
    private HashtagRequestDto hashtagRequestDto;
    private MentorProfileRequestDto mentorProfileRequestDto;
    private MenteeProfileRequestDto menteeProfileRequestDto;

    @Builder
    public MemberInfoResponseDto(MemberRequestDto memberRequestDto, HashtagRequestDto hashtagRequestDto, MentorProfileRequestDto mentorProfileRequestDto, MenteeProfileRequestDto menteeProfileRequestDto) {
        this.memberRequestDto = memberRequestDto;
        this.hashtagRequestDto = hashtagRequestDto;
        this.mentorProfileRequestDto = mentorProfileRequestDto;
        this.menteeProfileRequestDto = menteeProfileRequestDto;
    }

    public static MemberInfoResponseDto from(MemberInfo memberInfo) {
        return MemberInfoResponseDto.builder()
                .memberRequestDto(memberInfo.getAccountDetails())
                .hashtagRequestDto(memberInfo.getHashtag())
                .mentorProfileRequestDto(memberInfo.getMentorProfileInfo())
                .menteeProfileRequestDto(memberInfo.getMenteeProfileInfo())
                .build();
    }

    public MemberInfoResponseVo toVo() {
        return MemberInfoResponseVo.builder()
                .memberRequestDto(memberRequestDto)
                .hashtagRequestDto(hashtagRequestDto)
                .mentorProfileRequestDto(mentorProfileRequestDto)
                .menteeProfileRequestDto(menteeProfileRequestDto)
                .build();
    }
}
