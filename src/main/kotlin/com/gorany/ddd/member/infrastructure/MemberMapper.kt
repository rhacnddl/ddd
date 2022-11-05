package com.gorany.ddd.member.infrastructure

import com.gorany.ddd.member.domain.Member
import com.gorany.ddd.member.infrastructure.entity.MemberJpaEntity

object MemberMapper {

    fun mapToJpaEntity(entity: Member) = MemberJpaEntity(

    )

    fun mapToDomainEntity(jpaEntity: MemberJpaEntity) = Member(
        0L,
        "",
        ""
    )
}