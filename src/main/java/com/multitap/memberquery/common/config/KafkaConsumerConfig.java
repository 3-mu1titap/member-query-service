package com.multitap.memberquery.common.config;

import com.multitap.memberquery.kafka.messagein.HashtagDto;
import com.multitap.memberquery.kafka.messagein.MemberDto;
import com.multitap.memberquery.kafka.utils.ListDeserializer;
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

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, MemberDto> memberConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092, localhost:39092, localhost:49092");
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
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:29092, localhost:39092, localhost:49092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "member-consumer-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(List.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, List<HashtagDto>> hashtagDtoListener() {
        ConcurrentKafkaListenerContainerFactory<String, List<HashtagDto>> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(hashtagConsumerFactory());
        return factory;
    }

}

