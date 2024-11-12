package com.multitap.memberquery.application;
import com.multitap.memberquery.dto.in.ProfileImageRequestDto;
import com.multitap.memberquery.vo.out.MemberInfoResponseDto;


public interface MemberInfoService {
 MemberInfoResponseDto getMemberInfo(String uuid);
 void addProfileImage(ProfileImageRequestDto profileImageRequestDto);
}
