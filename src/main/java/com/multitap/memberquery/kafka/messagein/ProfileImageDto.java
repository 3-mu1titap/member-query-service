package com.multitap.memberquery.kafka.messagein;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProfileImageDto {
    private String uuid;
    private String profileImageUrl;

    @Builder
    public ProfileImageDto(String uuid, String profileImageUrl) {
        this.uuid = uuid;
        this.profileImageUrl = profileImageUrl;
    }
}
