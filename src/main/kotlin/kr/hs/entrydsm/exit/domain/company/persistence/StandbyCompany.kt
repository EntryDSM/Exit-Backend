package kr.hs.entrydsm.exit.domain.company.persistence

import kr.hs.entrydsm.exit.global.entity.BaseUUIDEntity
import org.hibernate.validator.constraints.Length
import org.jetbrains.annotations.NotNull
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "tbl_standby_company")
class StandbyCompany(

    @field: NotNull
    val name: String,

    @field: NotNull
    @Length(min = 5)
    val email: String,

    @field: NotNull
    @Length(min = 8, max = 60)
    val password: String,

    @field: NotNull
    val managerName: String,

    @field: NotNull
    @Length(max = 11)
    val managerNumber: String,

    @field: NotNull
    val location: String

) : BaseUUIDEntity()