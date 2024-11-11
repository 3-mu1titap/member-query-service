package com.multitap.memberquery.entity;

import com.multitap.memberquery.dto.in.ReactionRequestDto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Reaction {

    @Id
    private String id;
    private ReactionRequestDto reaction;

}
