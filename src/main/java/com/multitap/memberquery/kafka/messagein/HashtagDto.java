package com.multitap.memberquery.kafka.messagein;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.entity.MemberInfo;
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

    public static HashtagRequestDto from(HashtagDto hashtagDto) {
        return HashtagRequestDto.builder()
                .hashtagId(hashtagDto.getHashtagId())
                .build();
    }

    public MemberInfo toEntity(List<HashtagRequestDto> hashtagRequestDto) {
        return MemberInfo.builder()
                .uuid(uuid)
                .hashtagRequestDto(hashtagRequestDto)
                .build();
    }
}





