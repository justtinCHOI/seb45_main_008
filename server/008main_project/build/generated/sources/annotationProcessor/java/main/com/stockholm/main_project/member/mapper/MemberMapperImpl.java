package com.stockholm.main_project.member.mapper;

import com.stockholm.main_project.cash.entity.Cash;
import com.stockholm.main_project.member.dto.MemberPatchDto;
import com.stockholm.main_project.member.dto.MemberPostDto;
import com.stockholm.main_project.member.dto.MemberResponseDto;
import com.stockholm.main_project.member.entity.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-18T12:06:42+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostToMember(MemberPostDto requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.name( requestBody.getName() );
        member.email( requestBody.getEmail() );
        member.password( requestBody.getPassword() );
        member.confirmPassword( requestBody.getConfirmPassword() );

        return member.build();
    }

    @Override
    public Member memberPatchToMember(MemberPatchDto requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.name( requestBody.getName() );
        member.email( requestBody.getEmail() );

        return member.build();
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseDto memberResponseDto = new MemberResponseDto();

        Long cashId = memberCashCashId( member );
        if ( cashId != null ) {
            memberResponseDto.setCash( String.valueOf( cashId ) );
        }
        memberResponseDto.setMemberId( member.getMemberId() );
        memberResponseDto.setEmail( member.getEmail() );
        memberResponseDto.setName( member.getName() );
        memberResponseDto.setCreatedAt( member.getCreatedAt() );

        return memberResponseDto;
    }

    private Long memberCashCashId(Member member) {
        if ( member == null ) {
            return null;
        }
        Cash cash = member.getCash();
        if ( cash == null ) {
            return null;
        }
        long cashId = cash.getCashId();
        return cashId;
    }
}
