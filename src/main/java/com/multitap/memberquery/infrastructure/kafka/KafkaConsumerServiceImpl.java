package com.multitap.memberquery.infrastructure.kafka;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.infrastructure.kafka.messagein.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {


    @Override
    public void addMemberInfo(MemberInfo memberInfo) {

    }

    @Override
    public void addHashtag(HashtagDto hashtagDto) {

    }

    @Override
    public void addMenteeProfile(MenteeProfileDto menteeProfileDto) {

    }

    @Override
    public void addMentorProfile(MentorProfileDto mentorProfileDto) {

    }

    @Override
    public void addReaction(ReactionDto reactionDto) {

    }

    @Override
    public void addProfileImage(ProfileImageDto profileImageDto) {

    }
}
