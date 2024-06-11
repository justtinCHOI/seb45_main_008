package com.stockholm.main_project.auth.memberdetail;

import com.stockholm.main_project.auth.utils.CustomAuthorityUtils;
import com.stockholm.main_project.member.entity.Member;
import com.stockholm.main_project.member.repository.MemberRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
//데이터베이스에서 사용자 정보를 조회하고, 권한을 설정하며, 사용자 계정의 상태를 관리
@Component
public class MemberDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final CustomAuthorityUtils authorityUtils;

    public MemberDetailsService(MemberRepository memberRepository, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.authorityUtils = authorityUtils;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        Member findMember = optionalMember.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new MemberDetails(findMember);
    }

    //Spring Security에서 사용자 정보를 다루기 위한 객체를 정의
    private final class MemberDetails extends Member implements UserDetails {

        MemberDetails(Member member) {
            setMemberId(member.getMemberId());
            setEmail(member.getEmail());
            setPassword(member.getPassword());
            setRoles(member.getRoles());
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorityUtils.createAuthorities(this.getRoles());
        }

        @Override
        public String getUsername() {
            return getEmail();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;//계정이 활성 상태
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;//계정이 활성 상태
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;//계정이 활성 상태
        }

        @Override
        public boolean isEnabled() {
            return true;//계정이 활성 상태
        }
    }
}
