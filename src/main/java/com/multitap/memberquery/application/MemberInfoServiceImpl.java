package com.multitap.memberquery.application;

import com.multitap.memberquery.common.exception.BaseException;
import com.multitap.memberquery.common.response.BaseResponseStatus;
import com.multitap.memberquery.dto.in.ProfileImageRequestDto;
import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.infrastructure.MemberInfoRepository;
import com.multitap.memberquery.vo.out.MemberInfoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
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

}
