package com.gorany.ddd.member.application

import com.gorany.ddd.member.ui.request.RequestCreateMember

interface CreateMemberService {

    fun signup(request: RequestCreateMember): MemberId
}