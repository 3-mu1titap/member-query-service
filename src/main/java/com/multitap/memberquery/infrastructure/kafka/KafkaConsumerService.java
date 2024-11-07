package com.multitap.memberquery.infrastructure.kafka;


import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.infrastructure.kafka.messagein.*;

public interface KafkaConsumerService {

void addMemberInfo(MemberInfo memberInfo);
void addHashtag(HashtagDto hashtagDto);
void addMenteeProfile(MenteeProfileDto menteeProfileDto);
void addMentorProfile(MentorProfileDto mentorProfileDto);
void addReaction(ReactionDto reactionDto);
void addProfileImage(ProfileImageDto profileImageDto);
}
