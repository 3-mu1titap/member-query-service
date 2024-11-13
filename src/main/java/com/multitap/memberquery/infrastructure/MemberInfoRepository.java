package com.multitap.memberquery.infrastructure;

import com.multitap.memberquery.entity.MemberInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface MemberInfoRepository extends MongoRepository<MemberInfo, String> {
        Optional<MemberInfo> findById(String id);
        @Query(value = "{ 'id': ?0 }", fields = "{ 'accountDetails.nickName': 1, 'profileImageUrl': 1 }")
        Optional<MemberInfo> findNickNameAndProfileImageUrlById(String uuid);
}
