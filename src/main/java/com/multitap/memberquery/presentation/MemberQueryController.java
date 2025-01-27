package com.multitap.memberquery.presentation;

import com.multitap.memberquery.application.MemberInfoService;
import com.multitap.memberquery.common.response.BaseResponse;
import com.multitap.memberquery.dto.in.ProfileImageRequestDto;
import com.multitap.memberquery.vo.in.ProfileImageRequestVo;
import com.multitap.memberquery.vo.out.MemberInfoResponseVo;
import com.multitap.memberquery.vo.out.ReactionProfileVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Tag(name = "마이페이지 조회 API", description = "마이페이지 조회 관련 API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/memberInfo")

public class MemberQueryController {

    private final MemberInfoService memberInfoService;

    @Operation(summary = "회원 마이페이지 프로필 조회", description = "프로필에 등록 된 정보를 조회합니다.")
    @GetMapping("/profile")
    public BaseResponse<MemberInfoResponseVo> getMemberInfo(@RequestHeader("userUuid") String uuid) {
        return new BaseResponse<>(memberInfoService.getMemberInfo(uuid).toVo());
    }

    @Operation(summary = "회원 프로필 이미지, 닉네임 반환", description = "uuid를 통해 회원의 프로필이미지, 닉네임을 반환합니다.")
    @GetMapping("/profileImage")
    public BaseResponse<ReactionProfileVo> getMemberProfileImage(@RequestHeader("userUuid") String uuid) {
        return new BaseResponse<>(memberInfoService.getProfileImage(uuid).toVo());
    }

}
