package com.multitap.memberquery.dto.in;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.entity.Reaction;
import com.multitap.memberquery.kafka.messagein.ReactionDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReactionRequestDto {

        private String uuid;
        private String targetUuid;
        private boolean type;
        private boolean liked;

    @Builder
    public ReactionRequestDto(String uuid, String targetUuid, boolean type, boolean liked) {
        this.uuid = uuid;
        this.targetUuid = targetUuid;
        this.type = type;
        this.liked = liked;
    }

    public static ReactionRequestDto from(ReactionDto reactionDto) {
        return ReactionRequestDto.builder()
                .uuid(reactionDto.getUuid())
                .targetUuid(reactionDto.getTargetUuid())
                .type(reactionDto.isType())
                .liked(reactionDto.isLiked())
                .build();
    }

    public Reaction toEntity(ReactionRequestDto reactionRequestDto) {
        return Reaction.builder()
                .id(reactionRequestDto.getUuid())
                .reaction(reactionRequestDto)
                .build();
    }

}
