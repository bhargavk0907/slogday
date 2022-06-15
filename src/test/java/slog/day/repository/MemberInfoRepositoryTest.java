package slog.day.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import slog.day.entity.MemberInfo;

@SuppressWarnings("all")
/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class MemberInfoRepositoryTest {


    @Autowired
    MemberInfoRepository memberInfoRepository;

    @Test
    public void findByMemId() {

        MemberInfo memberInfo = memberInfoRepository.findByMemId(1);
        System.out.println("memberInfo"+ memberInfo.getMemberId());
  

    }


    @Test
    public void one(){

    }
}