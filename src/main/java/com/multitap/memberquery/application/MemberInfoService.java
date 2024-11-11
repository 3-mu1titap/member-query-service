package com.multitap.memberquery.application;
import com.multitap.memberquery.vo.out.MemberInfoResponseDto;


public interface MemberInfoService {
 MemberInfoResponseDto getMemberInfo(String uuid);
}
