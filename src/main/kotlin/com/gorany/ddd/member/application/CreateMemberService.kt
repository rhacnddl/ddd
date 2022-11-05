package com.gorany.ddd.member.application

import com.gorany.ddd.member.ui.dto.request.RequestCreateMember

interface CreateMemberService {

    fun signup(request: RequestCreateMember): MemberId
}