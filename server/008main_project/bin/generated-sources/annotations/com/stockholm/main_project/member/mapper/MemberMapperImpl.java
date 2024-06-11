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
    date = "2024-06-11T16:22:26+0900",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostToMember(MemberPostDto requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.confirmPassword( requestBody.getConfirmPassword() );
        member.email( requestBody.getEmail() );
        member.name( requestBody.getName() );
        member.password( requestBody.getPassword() );

        return member.build();
    }

    @Override
    public Member memberPatchToMember(MemberPatchDto requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.email( requestBody.getEmail() );
        member.name( requestBody.getName() );

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
        memberResponseDto.setCreatedAt( member.getCreatedAt() );
        memberResponseDto.setEmail( member.getEmail() );
        memberResponseDto.setMemberId( member.getMemberId() );
        memberResponseDto.setName( member.getName() );

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
