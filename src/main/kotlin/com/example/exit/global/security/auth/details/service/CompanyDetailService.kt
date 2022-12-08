package com.example.exit.global.security.auth.details.service

import com.example.exit.domain.company.persistence.repository.CompanyRepository
import com.example.exit.global.security.auth.details.CompanyDetails
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component
import java.util.*

@Component
class CompanyDetailService (
     private val companyRepository: CompanyRepository
): UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails {
        val company = companyRepository.findByIdOrNull(UUID.fromString(username)) ?: throw Exception() //TODO

        return CompanyDetails(company.id);
    }

}