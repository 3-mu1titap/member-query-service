package com.multitap.memberquery.kafka.messagein;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReactionDto {

    private String uuid;
    private String targetUuid;
    private boolean type;
    private boolean liked;

    @Builder
    public ReactionDto(Long id, String uuid, String targetUuid, boolean type, boolean liked) {
        this.uuid = uuid;
        this.targetUuid = targetUuid;
        this.type = type;
        this.liked = liked;
    }

}
