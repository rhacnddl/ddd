package com.gorany.ddd.member.ui

import com.gorany.ddd.member.application.CreateMemberService
import com.gorany.ddd.member.ui.dto.request.RequestCreateMember
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    val createMemberService: CreateMemberService,
) {

    private val log = LoggerFactory.getLogger(Logger::class.java)

    @PostMapping("/api/v1/members/create")
    fun createMember(@RequestBody request: RequestCreateMember): ResponseEntity<*> =
        try {
            log.info("[Create Member] Request -> $request")
            val memberId = createMemberService.signup(request)
            ResponseEntity(memberId, HttpStatus.OK)
        } catch (e: Exception) {
            log.error("[Create Member] Exception -> ${e.message} // ${e.stackTraceToString()}")
            ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
}