package com.multitap.memberquery.infrastructure.kafka.messagein;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MentorProfileDto {
    private String uuid;
    private String mentoringField;
    private Integer age;
    private String gender;
    private String jobExperience;

    @Builder
    public MentorProfileDto(String uuid, String mentoringField, Integer age, String gender, String jobExperience) {
        this.uuid = uuid;
        this.mentoringField = mentoringField;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
    }

}
