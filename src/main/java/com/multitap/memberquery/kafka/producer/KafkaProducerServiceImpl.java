package com.multitap.memberquery.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService{

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendCreateProfileImageUrl(ProfileImageDto profileImageDto) {
        try {
            kafkaTemplate.send("review-profile-image-topic", profileImageDto);
        } catch (Exception e) {
            log.info("create profile Image event send 실패 : " + e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendCreateNickName(NickNameDto nickNameDto) {
        try {
            kafkaTemplate.send("review-profile-nickname-topic", nickNameDto);
        } catch (Exception e) {
            log.info("create profile nickname event send 실패 : " + e);
            throw new RuntimeException(e);
        }
    }
}
