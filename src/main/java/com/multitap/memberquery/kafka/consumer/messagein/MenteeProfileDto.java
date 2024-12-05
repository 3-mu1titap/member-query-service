package com.multitap.memberquery.kafka.consumer.messagein;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenteeProfileDto {

    private String uuid;
    private String occupationStatus;
    private String educationLevel;
    private Integer age;
    private String gender;
    private String jobExperience;
    private String jobType;
    private Integer jobApplicationCount;

    @Builder
    public MenteeProfileDto(String uuid, String occupationStatus, String educationLevel, Integer age, String gender, String jobExperience, String jobType, Integer jobApplicationCount) {
        this.uuid = uuid;
        this.occupationStatus = occupationStatus;
        this.educationLevel = educationLevel;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
        this.jobType = jobType;
        this.jobApplicationCount = jobApplicationCount;
    }

}
