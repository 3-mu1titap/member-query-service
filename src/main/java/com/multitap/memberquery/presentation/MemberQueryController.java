package com.multitap.memberquery.presentation;

import com.multitap.memberquery.application.MemberInfoService;
import com.multitap.memberquery.application.ReactionService;
import com.multitap.memberquery.common.response.BaseResponse;
import com.multitap.memberquery.common.response.IdListResponseDto;
import com.multitap.memberquery.common.response.IdListResponseVo;
import com.multitap.memberquery.dto.in.ProfileImageRequestDto;
import com.multitap.memberquery.vo.ProfileImageRequestVo;
import com.multitap.memberquery.vo.out.MemberInfoResponseVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "마이페이지 조회 API", description = "마이페이지 조회 관련 API endpoints")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/memberInfo")

public class MemberQueryController {

    private final MemberInfoService memberInfoService;
    private final ReactionService reactionService;

    @Operation(summary = "회원 마이페이지 프로필 조회", description = "프로필에 등록 된 정보를 조회합니다.")
    @GetMapping("/profile")
    public BaseResponse<MemberInfoResponseVo> getMemberInfo(@RequestHeader("Uuid") String uuid) {
        return new BaseResponse<>(memberInfoService.getMemberInfo(uuid).toVo());
    }

    @Operation(summary = "회원 관심 멘토 uuid 조회", description = "회원의 관심맨토로 등록된 회원 uuid 리스트를 반환합니다..")
    @GetMapping("/like")
    public BaseResponse<List<IdListResponseVo<String>>> getMemberLikeUuid(@RequestHeader("Uuid") String uuid) {
        List<IdListResponseVo<String>> idListResponseVoList = reactionService.getMemberLikeUuid(uuid)
                .stream()
                .map(IdListResponseDto::toVo)
                .toList();
        return new BaseResponse<>(idListResponseVoList);
    }

    @Operation(summary = "프로필 이미지 등록", description = "회원의 프로필 이미지를 등록합니다.")
    @PostMapping("/profileImage")
    public BaseResponse<Void> addProfileImage(@RequestHeader("Uuid") String uuid, @RequestBody ProfileImageRequestVo profileImageRequestVo) {
        memberInfoService.addProfileImage(ProfileImageRequestDto.from(profileImageRequestVo, uuid));
        return new BaseResponse<>();
    }

}
