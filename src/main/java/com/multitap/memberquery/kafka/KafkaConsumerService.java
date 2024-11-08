package com.multitap.memberquery.kafka;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.dto.in.MenteeProfileRequestDto;
import com.multitap.memberquery.dto.in.MentorProfileRequestDto;

public interface KafkaConsumerService {

void addMember(MemberRequestDto memberRequestDto, String uuid);
void addHashtag(HashtagRequestDto hashtagRequestDto, String uuid);
void addMentorProfile(MentorProfileRequestDto mentorProfilerequestDto, String uuid);
void addMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto, String uuid);

//void addReaction(ReactionDto reactionDto);
//void addProfileImage(ProfileImageDto profileImageDto);
}
