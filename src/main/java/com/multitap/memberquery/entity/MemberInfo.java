package com.multitap.memberquery.entity;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.dto.in.MenteeProfileRequestDto;
import com.multitap.memberquery.dto.in.MentorProfileRequestDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collation = "memberInfo")
@Data
@Builder
public class MemberInfo {

    @Id
    private String id;

    private String profileImageUrl;
    private MemberRequestDto accountDetails;
    private HashtagRequestDto hashtag;
    private MentorProfileRequestDto mentorProfileInfo;
    private MenteeProfileRequestDto menteeProfileInfo;

}
