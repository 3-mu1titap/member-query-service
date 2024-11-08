package com.multitap.memberquery.presentation;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.dto.in.MenteeProfileRequestDto;
import com.multitap.memberquery.dto.in.MentorProfileRequestDto;
import com.multitap.memberquery.kafka.KafkaConsumerService;
import com.multitap.memberquery.kafka.messagein.HashtagDto;
import com.multitap.memberquery.kafka.messagein.MemberDto;
import com.multitap.memberquery.kafka.messagein.MenteeProfileDto;
import com.multitap.memberquery.kafka.messagein.MentorProfileDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaConsumer {

    private final KafkaConsumerService kafkaConsumerService;

    @KafkaListener(topics = "create-member-topic", groupId = "member-consumer-group", containerFactory = "memberDtoListener")
    public void processMember(MemberDto memberDto) {
        log.info("Received memberDto, {}", memberDto);
        kafkaConsumerService.addMember(MemberRequestDto.from(memberDto), memberDto.getUuid());
    }

    @KafkaListener(topics = "create-hashtag-topic", groupId = "member-consumer-group", containerFactory = "hashtagDtoListener")
    public void processHashtag(List<HashtagDto> hashtagDtoList) {
        log.info("Received hashtagDtoList: {}", hashtagDtoList.get(1).getHashtagId());
        HashtagRequestDto hashtagRequestDto = HashtagRequestDto.from(hashtagDtoList);
        kafkaConsumerService.addHashtag(hashtagRequestDto, hashtagDtoList.get(0).getUuid());
    }

    @KafkaListener(topics = "create-mentor-profile-topic", groupId = "member-consumer-group", containerFactory = "mentorProfileDtoListener")
    public void processMentorProfile(MentorProfileDto mentorProfileDto) {
        log.info("Received mentorProfile: {}", mentorProfileDto.getUuid());
        MentorProfileRequestDto mentorProfileRequestDto = MentorProfileRequestDto.from(mentorProfileDto);
        kafkaConsumerService.addMentorProfile(mentorProfileRequestDto, mentorProfileDto.getUuid());
    }

    @KafkaListener(topics = "create-mentee-profile-topic", groupId = "member-consumer-group", containerFactory = "menteeProfileDtoListener")
    public void processMentorProfile(MenteeProfileDto menteeProfileDto) {
        log.info("Received menteeProfile: {}", menteeProfileDto.getUuid());
        MenteeProfileRequestDto menteeProfileRequestDto = MenteeProfileRequestDto.from(menteeProfileDto);
        kafkaConsumerService.addMenteeProfile(menteeProfileRequestDto, menteeProfileDto.getUuid());
    }

}
