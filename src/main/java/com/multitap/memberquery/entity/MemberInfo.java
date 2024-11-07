package com.multitap.memberquery.entity;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.dto.in.MenteeProfileRequestDto;
import com.multitap.memberquery.dto.in.MentorProfileRequestDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "memberInfo")
@Data
@Builder
public class MemberInfo {

    @Id
    private String uuid;
    private MemberRequestDto memberRequestDto;
    private List<HashtagRequestDto> hashtagRequestDto;
    private MentorProfileRequestDto mentorProfileRequestDto;
    private MenteeProfileRequestDto menteeProfileRequestDto;

}
