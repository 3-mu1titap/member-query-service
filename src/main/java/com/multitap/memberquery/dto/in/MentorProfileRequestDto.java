package com.multitap.memberquery.dto.in;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MentorProfileRequestDto {
    private String uuid;
    private String mentoringField;
    private Integer age;
    private String gender;
    private String jobExperience;

    @Builder
    public MentorProfileRequestDto(String uuid, String mentoringField, Integer age, String gender, String jobExperience) {
        this.uuid = uuid;
        this.mentoringField = mentoringField;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
    }
}
