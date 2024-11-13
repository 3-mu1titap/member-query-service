package com.multitap.memberquery.application;
import com.multitap.memberquery.dto.in.ProfileImageRequestDto;
import com.multitap.memberquery.dto.out.MemberInfoResponseDto;
import com.multitap.memberquery.dto.out.ReactionProfileDto;


public interface MemberInfoService {
 MemberInfoResponseDto getMemberInfo(String uuid);
 void addProfileImage(ProfileImageRequestDto profileImageRequestDto);
 ReactionProfileDto getReactionProfile(String uuid);
}
