package com.multitap.memberquery.presentation;

import com.multitap.memberquery.application.MemberInfoService;
import com.multitap.memberquery.common.response.BaseResponse;
import com.multitap.memberquery.vo.out.MemberInfoResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "마이페이지 조회 API", description = "마이페이지 조회 관련 API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/memberInfo")

public class MemberQueryController {

    private final MemberInfoService memberInfoService;

    @Operation(summary = "회원 마이페이지 프로필 조회", description = "프로필에 등록 된 정보를 조회합니다.")
    @GetMapping("")
    public BaseResponse<MemberInfoResponseVo> getMemberInfo(@RequestHeader("Uuid") String uuid) {
        return new BaseResponse<>(memberInfoService.getMemberInfo(uuid).toVo());
    }
}
