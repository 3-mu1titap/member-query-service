package com.multitap.memberquery.infrastructure.kafka.messagein;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class HashtagDto {

    private Long hashtagId;
    private String uuid;

    @Builder
    public HashtagDto(Long hashtagId, String uuid) {
        this.hashtagId = hashtagId;
        this.uuid = uuid;
    }

}



