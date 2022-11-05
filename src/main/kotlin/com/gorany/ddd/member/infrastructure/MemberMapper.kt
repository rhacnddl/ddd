package com.gorany.ddd.member.infrastructure

import com.gorany.ddd.member.domain.Member
import com.gorany.ddd.member.infrastructure.entity.MemberJpaEntity

object MemberMapper {

    fun mapToJpaEntity(entity: Member) = MemberJpaEntity(
        id = entity.id,
        username = entity.username,
        password = entity.password
    )

    fun mapToDomainEntity(jpaEntity: MemberJpaEntity) = Member(
        0L,
        "",
        ""
    )
}