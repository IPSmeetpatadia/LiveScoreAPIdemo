package com.example.livescoreapidemo.dataclasses.todaymatches

data class Event(
    val Awt: Int,
    val EO: Int,
    val Ecov: Int,
    val Eid: String,
    val Epr: Int,
    val Eps: String,
    val ErnInf: String,
    val Esd: Long,
    val Esid: Int,
    val Et: Int,
    val Ewt: Int,
    val MD: MD,
    val Pid: Int,
    val Pids: Pids,
    val Spid: Int,
    val T1: List<T1>,
    val T2: List<T1>,
    val Tr1: String,
    val Tr1OR: String,
    val Tr2: String,
    val Tr2OR: String,
    val Trh1: String,
    val Trh2: String,
    val Trp1: String,
    val Trp2: String,
    val seriesInfo: SeriesInfo
)