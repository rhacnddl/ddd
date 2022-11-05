package com.gorany.ddd.member.domain.repository

import com.gorany.ddd.member.infrastructure.entity.MemberJpaEntity
import java.util.*

interface MemberRepository {

    fun findByUsername(username: String): Optional<MemberJpaEntity>
    fun findById(memberId: Long): Optional<MemberJpaEntity>
    fun save(memberJpaEntity: MemberJpaEntity): MemberJpaEntity
}