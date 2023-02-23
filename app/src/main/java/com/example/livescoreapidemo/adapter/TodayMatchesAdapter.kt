package com.example.livescoreapidemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.livescoreapidemo.R
import com.example.livescoreapidemo.dataclass.todaymatches.Event
import kotlinx.android.synthetic.main.single_view_single_match.view.*

class TodayMatchesAdapter(val context: Context, val todayMatchesList: List<Event>): RecyclerView.Adapter<TodayMatchesAdapter.TodayMatchesViewHolder>() {
    class TodayMatchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val match_status: TextView = itemView.txt_match_status
        val logo_team_one: ImageView = itemView.imgView_team_one
        val logo_team_two: ImageView = itemView.imgView_team_two
        val team_one_name: TextView = itemView.txt_team_one
        val team_two_name: TextView = itemView.txt_team_two
        val team_one_score: TextView = itemView.txt_score_team_one
        val team_two_score: TextView = itemView.txt_score_team_two
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayMatchesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_view_single_match, parent, false)
        return TodayMatchesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todayMatchesList.size
    }

    override fun onBindViewHolder(holder: TodayMatchesViewHolder, position: Int) {
        holder.match_status.text = todayMatchesList[position].Eps
        Glide.with(context).load("https://lsm-static-prod.livescore.com/medium/${todayMatchesList[position].T1[0].Img}").into(holder.logo_team_one)
        Glide.with(context).load("https://lsm-static-prod.livescore.com/medium/${todayMatchesList[position].T2[0].Img}").into(holder.logo_team_one)
        Glide.with(context).load("https://lsm-static-prod.livescore.com/medium/${todayMatchesList[position]}").into(holder.logo_team_two)
        holder.team_one_name.text = todayMatchesList[position].T1[0].Nm
        holder.team_two_name.text = todayMatchesList[position].T2[0].Nm
        holder.team_one_score.text = todayMatchesList[position].Tr1
        holder.team_two_score.text = todayMatchesList[position].Tr2
    }
}