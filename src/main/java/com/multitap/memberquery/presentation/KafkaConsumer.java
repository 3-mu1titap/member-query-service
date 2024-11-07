package com.multitap.memberquery.presentation;

import com.multitap.memberquery.dto.in.HashtagRequestDto;
import com.multitap.memberquery.dto.in.MemberRequestDto;
import com.multitap.memberquery.kafka.KafkaConsumerService;
import com.multitap.memberquery.kafka.messagein.HashtagDto;
import com.multitap.memberquery.kafka.messagein.MemberDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaConsumer {

    private final KafkaConsumerService kafkaConsumerService;

    @KafkaListener(topics = "create-member-topic", groupId = "member-consumer-group", containerFactory = "memberDtoListener")
    public void processMember(MemberDto memberDto) {
        log.info("@@@@, {}", memberDto);
        kafkaConsumerService.addMember(MemberRequestDto.from(memberDto));
    }

    @KafkaListener(topics = "create-hashtag-topic", groupId = "member-consumer-group", containerFactory = "hashtagDtoListener")
    public void processHashtag(List<HashtagDto> hashtagDto) {
        log.info("@@@@ , {}", hashtagDto);
//        List<HashtagRequestDto> hashtagRequestDtos = hashtagDto.stream()
//                .map(HashtagRequestDto::from)
//                .toList();
//        kafkaConsumerService.addHashtag(hashtagRequestDtos, hashtagDto.get(0).getUuid());
    }

}
