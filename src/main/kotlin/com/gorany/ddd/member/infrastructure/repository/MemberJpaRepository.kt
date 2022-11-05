package com.gorany.ddd.member.infrastructure.repository

import com.gorany.ddd.member.domain.repository.MemberRepository
import com.gorany.ddd.member.infrastructure.entity.MemberJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberJpaRepository: MemberRepository, JpaRepository<MemberJpaEntity, Long> {
}