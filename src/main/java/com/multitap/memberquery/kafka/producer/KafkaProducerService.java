package com.multitap.memberquery.kafka.producer;

public interface KafkaProducerService {

    void sendCreateProfileImageUrl(ProfileImageDto profileImageDto);
    void sendCreateNickName(NickNameDto nickNameDto);
}
