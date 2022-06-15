package slog.day.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import slog.day.entity.MemberInfo;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Integer> {

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT mi from MemberInfo mi where mi.memberId  = :memberId")
    public MemberInfo findByMemId(@Param("memberId") Integer memberId);
    
    @Query(value = "SELECT max(mi.memberId) FROM MemberInfo mi")
	public Integer getMax();

    
 

}
