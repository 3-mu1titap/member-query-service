package com.multitap.memberquery.dto.in;

import com.multitap.memberquery.entity.MemberInfo;
import com.multitap.memberquery.kafka.messagein.MentorProfileDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MentorProfileRequestDto {
    private String mentoringField;
    private Integer age;
    private String gender;
    private String jobExperience;

    @Builder
    public MentorProfileRequestDto(String mentoringField, Integer age, String gender, String jobExperience) {
        this.mentoringField = mentoringField;
        this.age = age;
        this.gender = gender;
        this.jobExperience = jobExperience;
    }

    public static MentorProfileRequestDto from(MentorProfileDto mentorProfileDto) {
        return MentorProfileRequestDto.builder()
                .mentoringField(mentorProfileDto.getMentoringField())
                .age(mentorProfileDto.getAge())
                .gender(mentorProfileDto.getGender())
                .jobExperience(mentorProfileDto.getJobExperience())
                .build();
    }

    public MemberInfo toEntity(MentorProfileRequestDto mentorProfileRequestDto, MemberInfo memberInfo) {
        return MemberInfo.builder()
                .id(memberInfo.getId())
                .memberRequestDto(memberInfo.getMemberRequestDto())
                .hashtagRequestDto(memberInfo.getHashtagRequestDto())
                .mentorProfileRequestDto(mentorProfileRequestDto)
                .menteeProfileRequestDto(memberInfo.getMenteeProfileRequestDto())
                .build();
    }


}
