package kr.hs.entrydsm.exit.domain.common.error

interface DomainCustomErrorProperty {

    fun status(): Int

    fun message(): String

    fun code(): String

}