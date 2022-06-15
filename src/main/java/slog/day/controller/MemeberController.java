package slog.day.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import slog.day.entity.MemberInfo;
import slog.day.model.Member;
import slog.day.service.MemberService;

@RestController
public class MemeberController {
	
	@Autowired
	MemberService memberService;
		
	@GetMapping("/member/get/{id}")
	public MemberInfo getEmployeeByID(@PathVariable("id") Integer id) {
	//	return repository.retrieve(id);
		return memberService.getMemberById(id);
	}

	
	 @PostMapping(path= "/memberinfo", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> createMember(@RequestBody Member member ) {

		memberService.postMemberInfo(member);

		return new ResponseEntity<String>(member.getFirstName()+ "Created Successfully", HttpStatus.OK);
	}
	 



	 @DeleteMapping("/member/{id}")
	 public void deleteStudent(@PathVariable Integer id) {
		 memberService.deleteMemberInfo(id);
	 }
	
	

}
