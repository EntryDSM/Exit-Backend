package kr.hs.entrydsm.exit.global.error.custom

interface CustomErrorProperty {

    fun status(): Int

    fun message(): String

    fun code(): String
}