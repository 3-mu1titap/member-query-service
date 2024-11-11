package com.multitap.memberquery.application;

import com.multitap.memberquery.common.response.IdListResponseDto;
import com.multitap.memberquery.infrastructure.ReactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReactionServiceImpl implements ReactionService {

    private final ReactionRepository reactionRepository;

    @Override
    public List<IdListResponseDto<String>> getMemberLikeUuid(String uuid) {
        return reactionRepository.findTargetUuidsByIdAndTypeAndLiked(uuid)
                .stream()
                .map(reaction -> IdListResponseDto.from(reaction.getReaction().getTargetUuid()))
                .collect(Collectors.toList());
    }
}
