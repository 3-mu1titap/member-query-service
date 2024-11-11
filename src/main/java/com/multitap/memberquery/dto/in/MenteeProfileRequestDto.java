package com.multitap.memberquery.dto.in;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.kafka.messagein.MenteeProfileDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenteeProfileRequestDto {
    private String occupationStatus;
    private String educationLevel;
    private Integer age;
    private String gender;
    private String jobExperience;
    private String jobType;
    private Integer jobApplicationCount;

    @Builder
    public MenteeProfileRequestDto(String occupationStatus, String educationLevel, Integer age, String gender, String jobExperience, String jobType, Integer jobApplicationCount) {
        this.occupationStatus = occupationStatus;
        this.educationLevel = educationLevel;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
        this.jobType = jobType;
        this.jobApplicationCount = jobApplicationCount;
    }

    public static MenteeProfileRequestDto from(MenteeProfileDto menteeProfileDto) {
        return MenteeProfileRequestDto.builder()
                .occupationStatus(menteeProfileDto.getOccupationStatus())
                .educationLevel(menteeProfileDto.getEducationLevel())
                .age(menteeProfileDto.getAge())
                .gender(menteeProfileDto.getGender())
                .jobExperience(menteeProfileDto.getJobExperience())
                .jobType(menteeProfileDto.getJobType())
                .jobApplicationCount(menteeProfileDto.getJobApplicationCount())
                .build();
    }

    public MemberInfo toEntity(MenteeProfileRequestDto mentorProfileRequestDto, MemberInfo memberInfo) {
        return MemberInfo.builder()
                .id(memberInfo.getId())
                .profileImageUrl(memberInfo.getProfileImageUrl())
                .accountDetails(memberInfo.getAccountDetails())
                .hashtag(memberInfo.getHashtag())
                .mentorProfileInfo(memberInfo.getMentorProfileInfo())
                .menteeProfileInfo(mentorProfileRequestDto)
                .build();
    }
}
