package com.multitap.memberquery.infrastructure;

import com.multitap.memberquery.entity.Reaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReactionRepository extends MongoRepository<Reaction, String> {
    Optional<Reaction> findById(String id);

    @Query(value = "{ 'id': ?0, 'type': true, 'liked': true }", fields = "{ 'targetUuid' : 1 }")
    List<Reaction> findTargetUuidsByIdAndTypeAndLiked(String id);
}


