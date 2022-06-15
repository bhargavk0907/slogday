package slog.day.mapper;

import org.springframework.stereotype.Component;

import slog.day.entity.MemberInfo;
import slog.day.model.Member;

@Component
public class MemberMapper {
	
	
	public MemberInfo transformMemtoMemInfo(Member member) {
		
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setFirstName(member.getFirstName());
		memberInfo.setLastName(member.getLastName());
		memberInfo.setEmailAddress(member.getEmail());
		memberInfo.setDob(member.getDob());
		
		
		return memberInfo;
		
	}
	

}
