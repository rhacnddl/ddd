package com.gorany.ddd.member.domain

import com.gorany.ddd.member.infrastructure.entity.MemberJpaEntity

object MemberMapper {

    fun mapToJpaEntity(entity: Member) = MemberJpaEntity(

    )

    fun mapToDomainEntity(jpaEntity: MemberJpaEntity) = Member(
        MemberId(0L),
        "",
        ""
    )
}