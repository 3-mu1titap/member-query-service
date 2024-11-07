package com.multitap.memberquery.kafka;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.dto.in.MenteeProfileRequestDto;
import com.multitap.memberquery.dto.in.MentorProfileRequestDto;
import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.infrastructure.MemberInfoRepository;
import com.multitap.memberquery.kafka.messagein.*;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final MemberInfoRepository memberInfoRepository;


    public void addMember(MemberRequestDto memberRequestDto) {
        memberInfoRepository.save(memberRequestDto.toEntity(memberRequestDto));
    }

    public void addHashtag(List<HashtagRequestDto> hashtagRequestDto, String uuid) {
        memberInfoRepository.save(HashtagRequestDto.toEntity(hashtagRequestDto, uuid));
    }

    @Override
    public void addMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto) {

    }

    @Override
    public void addMentorProfile(MentorProfileRequestDto mentorProfilerequestDto) {

    }

}
