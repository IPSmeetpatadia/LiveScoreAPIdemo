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
import com.example.livescoreapidemo.dataclasses.livematches.Event
import kotlinx.android.synthetic.main.single_view_single_match.view.*

class LiveMatchListAdapter(val context: Context, private val liveMatchLst: List<Event>): RecyclerView.Adapter<LiveMatchListAdapter.LiveMatchListViewHolder>() {
    class LiveMatchListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val matchStatus:TextView = itemView.txt_match_status
        val logoTeamOne: ImageView = itemView.imgView_team_one
        val logoTeamTwo: ImageView = itemView.imgView_team_two
        val teamOneName: TextView = itemView.txt_team_one
        val teamTwoName: TextView = itemView.txt_team_two
        val teamOneScore: TextView = itemView.txt_score_team_one
        val teamTwoScore: TextView = itemView.txt_score_team_two
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveMatchListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_view_single_match, parent, false)
        return LiveMatchListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  liveMatchLst.size
    }

    override fun onBindViewHolder(holder: LiveMatchListViewHolder, position: Int) {
        //scope function `apply`
        holder.apply {
            matchStatus.text = liveMatchLst[position].Eps
            Glide.with(context).load("https://lsm-static-prod.livescore.com/medium/${liveMatchLst[position].T1[0].Img}").into(logoTeamOne)
            Glide.with(context).load("https://lsm-static-prod.livescore.com/medium/${liveMatchLst[position].T2[0].Img}").into(logoTeamTwo)
            teamOneName.text = liveMatchLst[position].T1[0].Nm
            teamTwoName.text = liveMatchLst[position].T2[0].Nm
            teamOneScore.text = liveMatchLst[position].Tr1
            teamTwoScore.text = liveMatchLst[position].Tr2
        }
    }

}