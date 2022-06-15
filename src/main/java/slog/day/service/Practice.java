package slog.day.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import slog.day.entity.MemberInfo;
import slog.day.repository.MemberInfoRepository;

import java.sql.SQLOutput;
import java.util.*;


@SuppressWarnings("all")
@Component
public class Practice {

@Autowired
MemberInfoRepository memberInfoRepository;

    public static List<MemberInfo> testList(){

        List<MemberInfo> memberInfos = new ArrayList<>();

        MemberInfo  memberInfo1 = new MemberInfo();
        memberInfo1.setMemberId(1);
        memberInfo1.setLastName("kilaru");
        memberInfos.add(memberInfo1);

        MemberInfo  memberInfo2 = new MemberInfo();
        memberInfo2.setMemberId(4);
        memberInfo2.setLastName("kilaru");
        memberInfos.add(memberInfo2);
        MemberInfo  memberInfo3 = new MemberInfo();
        memberInfo3.setMemberId(3);
        memberInfo3.setLastName("puchakayala");
        memberInfos.add(memberInfo3);







        return    memberInfos;

    }


    public static Set<String> setTest(){
        Set<String> stringSet = new HashSet<>();
        stringSet.add("bk");
        stringSet.add("pc");
        stringSet.add(null);
        stringSet.add(null);
  return stringSet;
    }


    public static Set<String> setTest1(){
        Set<String> stringSet = new HashSet<>();
        stringSet.add("bk");
        stringSet.add("bl");
        stringSet.add(null);
        stringSet.add(null);
        return stringSet;
    }



    public static void main(String[] args){

        System.out.println(setTest().remove("bk"));


        if(setTest().containsAll(setTest1())){
            System.out.println("Sets are same");
        }

        Map<String, List<MemberInfo>>  memberInfoHashMap= new HashMap<>();

        for (MemberInfo  memberInfo : testList()){
            System.out.println("id" + memberInfo.getMemberId());
            if(memberInfoHashMap.containsKey(memberInfo.getLastName())){
              memberInfoHashMap.get(memberInfo.getLastName()).add(memberInfo);
                System.out.println("if" + memberInfo.getLastName());
            }else{
                List<MemberInfo> memberIns = new ArrayList<>();
                memberIns.add(memberInfo);
                memberInfoHashMap.put(memberInfo.getLastName(), memberIns);
                System.out.println("else" + memberInfo.getLastName());
            }

        }

    }





}
