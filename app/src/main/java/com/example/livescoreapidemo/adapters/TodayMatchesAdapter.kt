package com.example.livescoreapidemo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclasses.todaymatches.Event
import kotlinx.android.synthetic.main.single_view_single_match.view.*

class TodayMatchesAdapter(val context: Context, private val todayMatchesList: List<Event>): RecyclerView.Adapter<TodayMatchesAdapter.TodayMatchesViewHolder>() {
    class TodayMatchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val matchStatus: TextView = itemView.txt_match_status
        val logoTeamOne: ImageView = itemView.imgView_team_one
        val logoTeamTwo: ImageView = itemView.imgView_team_two
        val teamOneName: TextView = itemView.txt_team_one
        val teamTwoName: TextView = itemView.txt_team_two
        val teamOneScore: TextView = itemView.txt_score_team_one
        val teamTwoScore: TextView = itemView.txt_score_team_two
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayMatchesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_view_single_match, parent, false)
        return TodayMatchesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todayMatchesList.size
    }

    override fun onBindViewHolder(holder: TodayMatchesViewHolder, position: Int) {
        holder.apply {
            matchStatus.text = todayMatchesList[position].Eps
            Glide.with(context).load("https://lsm-static-prod.livescore.com/medium/${todayMatchesList[position].T1[0].Img}").into(logoTeamOne)
            Glide.with(context).load("https://lsm-static-prod.livescore.com/medium/${todayMatchesList[position].T2[0].Img}").into(logoTeamTwo)
            teamOneName.text = todayMatchesList[position].T1[0].Nm
            teamTwoName.text = todayMatchesList[position].T2[0].Nm
            teamOneScore.text = todayMatchesList[position].Tr1
            teamTwoScore.text = todayMatchesList[position].Tr2
        }
    }

}