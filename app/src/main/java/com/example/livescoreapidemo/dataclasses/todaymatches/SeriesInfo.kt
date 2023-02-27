package com.example.livescoreapidemo.dataclasses.todaymatches

data class SeriesInfo(
    val aggScoreTeam1: Int,
    val aggScoreTeam2: Int,
    val currentLeg: Int,
    val totalLegs: Int
)