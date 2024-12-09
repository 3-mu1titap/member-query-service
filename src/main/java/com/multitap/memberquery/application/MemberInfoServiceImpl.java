package com.multitap.memberquery.application;

import com.multitap.memberquery.common.exception.BaseException;
import com.multitap.memberquery.common.response.BaseResponseStatus;
import com.multitap.memberquery.dto.in.ProfileImageRequestDto;
import com.multitap.memberquery.dto.out.ProfileImageNickNameDto;
import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.infrastructure.MemberInfoRepository;
import com.multitap.memberquery.dto.out.MemberInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberInfoServiceImpl implements MemberInfoService {

    private final MemberInfoRepository memberInfoRepository;

    @Override
    public MemberInfoResponseDto getMemberInfo(String uuid) {
        return MemberInfoResponseDto.from(memberInfoRepository.findById(uuid)
                .orElseThrow(() -> new BaseException(BaseResponseStatus.NO_EXIST_MEMBER_INFO)));
    }

    @Override
    public void addProfileImage(ProfileImageRequestDto profileImageRequestDto) {
        MemberInfo memberInfo = memberInfoRepository.findById(profileImageRequestDto.getUuid()).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NO_EXIST_MEMBER_INFO));
        memberInfoRepository.save(profileImageRequestDto.toEntity(profileImageRequestDto, memberInfo));

    }

    @Override
    public ProfileImageNickNameDto getProfileImage(String uuid) {
        return ProfileImageNickNameDto.from(memberInfoRepository.findNickNameAndProfileImageUrlById(uuid).orElseThrow(() ->
                new BaseException(BaseResponseStatus.NO_EXIST_MEMBER_INFO)));

    }

}
