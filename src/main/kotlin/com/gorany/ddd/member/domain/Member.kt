package com.gorany.ddd.member.domain

import com.gorany.ddd.member.application.InvalidPasswordException
import com.gorany.ddd.member.ui.request.RequestCreateMember

data class Member(
    val id: Long,
    val username: String,
    val password: String
) {

    companion object {
        fun signup(request: RequestCreateMember): Member {
            checkValidPassword(request.password)
            return Member(0L, username = request.username, password = request.password)
        }

        private fun checkValidPassword(password: String) {
            if (password.length in 7..14) {
                throw InvalidPasswordException("사용할 수 없는 비밀번호 입니다.")
            }
        }
    }


}