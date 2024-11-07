package com.multitap.memberquery.kafka;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.dto.in.MenteeProfileRequestDto;
import com.multitap.memberquery.dto.in.MentorProfileRequestDto;
import com.multitap.memberquery.kafka.messagein.*;

import java.util.List;

public interface KafkaConsumerService {

void addMember(MemberRequestDto memberRequestDto);
void addHashtag(List<HashtagRequestDto> hashtagRequestDto, String uuid);
void addMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto);
void addMentorProfile(MentorProfileRequestDto mentorProfilerequestDto);
//void addReaction(ReactionDto reactionDto);
//void addProfileImage(ProfileImageDto profileImageDto);
}
