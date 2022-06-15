/**
 * 
 */
package slog.day.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import slog.day.entity.MemberInfo;
import slog.day.mapper.MemberMapper;
import slog.day.model.Member;
import slog.day.repository.MemberInfoRepository;

/**
 * @author kilaru
 *
 */

@Service
public class MemberService {
	
	@Autowired
	MemberInfoRepository memberInfoRepository;
	
	@Autowired
	MemberMapper membermapper;
	
	
	public MemberInfo getMemberById(Integer id){
		
		return memberInfoRepository.findByMemId(id);
		
		
	}

	
	public void postMemberInfo(Member member) {
		
		Integer max = memberInfoRepository.getMax();
		
		MemberInfo memberInfo = membermapper.transformMemtoMemInfo(member);
		memberInfo.setMemberId(++max);
		
		memberInfo.setCreatedTs( new Timestamp(System.currentTimeMillis()));
		memberInfo.setUpdatedTs(new Timestamp(System.currentTimeMillis()));
		memberInfo.setCreatedBy("SLOGDAY");
		memberInfo.setUpdatedBy("SLOGDAY");
		memberInfoRepository.save(memberInfo);
		
	}
	
	
	public void deleteMemberInfo(Integer id) {
		
		memberInfoRepository.deleteById(id);
		
	}
	
}
