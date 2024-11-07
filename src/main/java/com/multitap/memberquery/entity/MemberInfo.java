package com.multitap.memberquery.entity;

import com.multitap.memberquery.infrastructure.kafka.messagein.HashtagDto;
import com.multitap.memberquery.infrastructure.kafka.messagein.MemberDto;
import com.multitap.memberquery.infrastructure.kafka.messagein.MenteeProfileDto;
import com.multitap.memberquery.infrastructure.kafka.messagein.MentorProfileDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collation = "memberInfo")
@Data
public class MemberInfo {

    @Id
    private String uuid;
    private MemberDto memberDto;
    private List<HashtagDto> hashtagDto;
    private MentorProfileDto mentorProfileDto;
    private MenteeProfileDto menteeProfileDto;

}
