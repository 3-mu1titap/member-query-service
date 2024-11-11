package com.multitap.memberquery.infrastructure;

import com.multitap.memberquery.entity.MemberInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberInfoRepository extends MongoRepository<MemberInfo, String> {
        Optional<MemberInfo> findById(String id);
}
