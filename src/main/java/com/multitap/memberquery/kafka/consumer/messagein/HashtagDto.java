package com.multitap.memberquery.kafka.consumer.messagein;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
public class HashtagDto {

    private String uuid;
    private Long hashtagId;

    @Builder
    public HashtagDto(String uuid, Long hashtagId) {
        this.uuid = uuid;
        this.hashtagId = hashtagId;
    }

    public static HashtagRequestDto toRequestDto(List<HashtagDto> hashtagDtoList) {
        String uuid = hashtagDtoList.get(0).getUuid();
        List<HashtagRequestDto.HashtagId> hashtagIds = hashtagDtoList.stream()
                .map(dto -> new HashtagRequestDto.HashtagId(dto.getHashtagId()))
                .toList();

        return HashtagRequestDto.builder()
                .hashtagId(hashtagIds)
                .build();
    }
}





