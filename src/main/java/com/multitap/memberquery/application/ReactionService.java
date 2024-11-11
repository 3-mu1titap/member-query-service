package com.multitap.memberquery.application;

import com.multitap.memberquery.common.response.IdListResponseDto;

import java.util.List;

public interface ReactionService {
    List<IdListResponseDto<String>> getMemberLikeUuid(String uuid);
}
