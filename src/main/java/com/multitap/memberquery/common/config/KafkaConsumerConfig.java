package com.multitap.memberquery.common.config;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multitap.memberquery.kafka.messagein.*;
import com.multitap.memberquery.kafka.messagein.MentorProfileDto;
import lombok.Value;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value("${Kafka.cluster.uri}")
    private String kafkaClusterUri;

    @Bean
    public ConsumerFactory<String, MemberDto> memberConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClusterUri);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "member-consumer-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(MemberDto.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MemberDto> memberDtoListener() {
        ConcurrentKafkaListenerContainerFactory<String, MemberDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(memberConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, List<HashtagDto>> hashtagConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClusterUri);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "member-consumer-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

        ObjectMapper objectMapper = new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, HashtagDto.class);

        JsonDeserializer<List<HashtagDto>> jsonDeserializer = new JsonDeserializer<>(type, objectMapper, false);

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new ErrorHandlingDeserializer<>(jsonDeserializer)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, List<HashtagDto>> hashtagDtoListener() {
        ConcurrentKafkaListenerContainerFactory<String, List<HashtagDto>> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(hashtagConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, MentorProfileDto> memtorProfileConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClusterUri);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "member-consumer-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(MentorProfileDto.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MentorProfileDto> mentorProfileDtoListener() {
        ConcurrentKafkaListenerContainerFactory<String, MentorProfileDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(memtorProfileConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, MenteeProfileDto> memteeProfileConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClusterUri);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "member-consumer-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(MenteeProfileDto.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, MenteeProfileDto> menteeProfileDtoListener() {
        ConcurrentKafkaListenerContainerFactory<String, MenteeProfileDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(memteeProfileConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, NicknamePhoneDto> nicknamePhoneConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaClusterUri);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "member-consumer-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(NicknamePhoneDto.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NicknamePhoneDto> nicknamePhoneDtoListener() {
        ConcurrentKafkaListenerContainerFactory<String, NicknamePhoneDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(nicknamePhoneConsumerFactory());
        return factory;
    }


}

