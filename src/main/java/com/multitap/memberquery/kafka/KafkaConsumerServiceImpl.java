package com.multitap.memberquery.kafka;

import com.multitap.memberquery.common.exception.BaseException;
import com.multitap.memberquery.common.response.BaseResponseStatus;
import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.dto.in.MenteeProfileRequestDto;
import com.multitap.memberquery.dto.in.MentorProfileRequestDto;
import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.infrastructure.MemberInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final MemberInfoRepository memberInfoRepository;


    public void addMember(MemberRequestDto memberRequestDto, String uuid) {
        memberInfoRepository.save(memberRequestDto.toEntity(memberRequestDto, uuid));
        log.info("memberInfo, {}", uuid);
    }

    public void addHashtag(HashtagRequestDto hashtagRequestDto, String uuid) {
        log.info("uuid, {}", uuid);
        MemberInfo memberInfo = memberInfoRepository.findById(uuid).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NO_EXIST_MEMBER_INFO));
        memberInfoRepository.save(hashtagRequestDto.toEntity(hashtagRequestDto, memberInfo));
    }

    @Override
    public void addMentorProfile(MentorProfileRequestDto mentorProfilerequestDto, String uuid) {
        log.info("uuid, {}", uuid);
        MemberInfo memberInfo = memberInfoRepository.findById(uuid).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NO_EXIST_MEMBER_INFO));
        memberInfoRepository.save(mentorProfilerequestDto.toEntity(mentorProfilerequestDto, memberInfo));
    }

    @Override
    public void addMenteeProfile(MenteeProfileRequestDto menteeProfileRequestDto, String uuid) {
        log.info("uuid, {}", uuid);
        MemberInfo memberInfo = memberInfoRepository.findById(uuid).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NO_EXIST_MEMBER_INFO));
        memberInfoRepository.save(menteeProfileRequestDto.toEntity(menteeProfileRequestDto, memberInfo));
    }

}
