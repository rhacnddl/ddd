package com.gorany.ddd.member.application

import com.gorany.ddd.member.application.CreateMemberService
import com.gorany.ddd.member.application.DuplicatedMemberException
import com.gorany.ddd.member.domain.Member
import com.gorany.ddd.member.infrastructure.MemberMapper
import com.gorany.ddd.member.domain.repository.MemberRepository
import com.gorany.ddd.member.ui.request.RequestCreateMember
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = false)
class CreateMemberServiceImpl(

) : CreateMemberService {

    lateinit var memberRepository: MemberRepository

    override fun signup(request: RequestCreateMember): Long {
        checkDuplicatedUsername(request.username)

        val memberEntity = Member.signup(request)
        val memberJpaEntity = MemberMapper.mapToJpaEntity(memberEntity)

        return memberRepository.save(memberJpaEntity).id
    }

    private fun checkDuplicatedUsername(username: String) {
        memberRepository.findByUsername(username)
            .ifPresent { throw DuplicatedMemberException("${username}으로 중복된 사용자가 있습니다.") }
    }
}