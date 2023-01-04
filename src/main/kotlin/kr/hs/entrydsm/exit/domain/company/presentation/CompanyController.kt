package kr.hs.entrydsm.exit.domain.company.presentation

import kr.hs.entrydsm.exit.domain.company.presentation.dto.request.CompanySignUpRequest
import kr.hs.entrydsm.exit.domain.company.usecase.AllowStandbyCompanyUseCase
import kr.hs.entrydsm.exit.domain.company.usecase.CompanySignUpUseCase
import kr.hs.entrydsm.exit.domain.company.usecase.RejectStandbyCompanyUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid

@RequestMapping("/company")
@RestController
class CompanyController(
    private val companySignUpUseCase: CompanySignUpUseCase,
    private val allowStandByCompanyUseCase: AllowStandbyCompanyUseCase,
    private val rejectStandByCompanyUseCase: RejectStandbyCompanyUseCase
) {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sign-up")
    fun singUp(@RequestBody @Valid request: CompanySignUpRequest) {
        companySignUpUseCase.execute(request)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/standby/{standby-company-id}")
    fun allowStandByCompany(@PathVariable("standby-company-id") standbyCompanyId: UUID) {
        allowStandByCompanyUseCase.execute(standbyCompanyId)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/standby/{standby-company-id}")
    fun rejectStandByCompany(@PathVariable("standby-company-id") standbyCompanyId: UUID) {
        rejectStandByCompanyUseCase.execute(standbyCompanyId)
    }
}