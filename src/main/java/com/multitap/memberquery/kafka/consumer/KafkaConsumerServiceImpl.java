package com.multitap.memberquery.kafka.consumer;

import com.multitap.memberquery.common.exception.BaseException;
import com.multitap.memberquery.common.response.BaseResponseStatus;
import com.multitap.memberquery.dto.in.*;
import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.infrastructure.MemberInfoRepository;
import com.multitap.memberquery.kafka.producer.KafkaProducerService;
import com.multitap.memberquery.kafka.producer.NickNameDto;
import com.multitap.memberquery.kafka.producer.ProfileImageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    private final MemberInfoRepository memberInfoRepository;
    private final KafkaProducerService kafkaProducerService;

    public void addMember(MemberRequestDto memberRequestDto, String uuid, String profileImage) {
        memberInfoRepository.save(memberRequestDto.toEntity(memberRequestDto, uuid, profileImage));
        log.info("회원가입 정보 저장 성공,{}", memberRequestDto.getName());
    }

    @Override
    public void addNicknamePhone(NicknamePhoneRequestDto nicknamePhoneRequestDto, String uuid) {
        MemberInfo memberInfo = memberInfoRepository.findById(uuid).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NO_EXIST_MEMBER_INFO));
        log.info("회원 닉네임, 전화번호 수정, {}", nicknamePhoneRequestDto.getNickName());
        kafkaProducerService.sendCreateNickName(NickNameDto.from(memberInfoRepository.save(nicknamePhoneRequestDto.toEntity(memberInfo.getAccountDetails().updateNickNameAndPhoneNumber(nicknamePhoneRequestDto, memberInfo.getAccountDetails()), memberInfo))));
    }

    @Override
    public void addProfileImage(ProfileImageRequestDto profileImageRequestDto) {
        MemberInfo memberInfo = memberInfoRepository.findById(profileImageRequestDto.getUuid()).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NO_EXIST_MEMBER_INFO));
        kafkaProducerService.sendCreateProfileImageUrl(ProfileImageDto.from(memberInfoRepository.save(profileImageRequestDto.toEntity(profileImageRequestDto, memberInfo))));
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
