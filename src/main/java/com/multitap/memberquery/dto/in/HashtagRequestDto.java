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

    private List<HashtagId> hashtagId;

    @Builder
    public HashtagRequestDto(List<HashtagId> hashtagId) {
        this.hashtagId = hashtagId;
    }

    public static HashtagRequestDto from(List<HashtagDto> hashtagDtoList) {

        if (hashtagDtoList == null || hashtagDtoList.isEmpty()) {
            throw new IllegalArgumentException("hashtagDtoList cannot be null or empty");
        }

        List<HashtagId> hashtagIds = hashtagDtoList.stream()
                .map(dto -> new HashtagId(dto.getHashtagId()))
                .toList();

        return HashtagRequestDto.builder()
                .hashtagId(hashtagIds)
                .build();
    }

    public MemberInfo toEntity(HashtagRequestDto hashtagRequestDto, MemberInfo memberInfo) {
        return MemberInfo.builder()
                .id(memberInfo.getId())
                .memberRequestDto(memberInfo.getMemberRequestDto())
                .hashtagRequestDto(hashtagRequestDto)
                .mentorProfileRequestDto(memberInfo.getMentorProfileRequestDto())
                .menteeProfileRequestDto(memberInfo.getMenteeProfileRequestDto())
                .build();
    }


    @Getter
    @NoArgsConstructor
    public static class HashtagId {
        private Long hashtagId;

        public HashtagId(Long hashtagId) {
            this.hashtagId = hashtagId;
        }
    }
}
