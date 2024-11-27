package com.multitap.memberquery.kafka.consumer;

import com.multitap.memberquery.dto.in.*;

public interface KafkaConsumerService {

void addMember(MemberRequestDto memberRequestDto, String uuid);
void addHashtag(HashtagRequestDto hashtagRequestDto, String uuid);
void addMentorProfile(MentorProfileRequestDto mentorProfilerequestDto, String uuid);
void addMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto, String uuid);
void addNicknamePhone(NicknamePhoneRequestDto nicknamePhoneRequestDto, String uuid);
void addProfileImage(ProfileImageRequestDto profileImageRequestDto);
}
