package com.multitap.memberquery.dto.in;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.kafka.messagein.HashtagDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class HashtagRequestDto {

    private Long hashtagId;

    @Builder
    public HashtagRequestDto(Long hashtagId) {
        this.hashtagId = hashtagId;
    }

    public static HashtagRequestDto from(HashtagDto hashtagDto) {
        return HashtagRequestDto.builder()
                .hashtagId(hashtagDto.getHashtagId())
                .build();
    }

    public static MemberInfo toEntity(List<HashtagRequestDto> hashtagRequestDto, String uuid) {
        return MemberInfo.builder()
                .uuid(uuid)
                .hashtagRequestDto(hashtagRequestDto)
                .build();
    }
}
