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
import kotlinx.android.synthetic.main.single_view_single_match.view.*

class LiveMatchListAdapter(val context: Context, val liveMatchLst: List<com.example.livescoreapidemo.dataclasses.livelist.Event>): RecyclerView.Adapter<LiveMatchListAdapter.LiveMatchListViewHolder>() {
    class LiveMatchListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val match_status:TextView = itemView.txt_match_status
        val logo_team_one: ImageView = itemView.imgView_team_one
        val logo_team_two: ImageView = itemView.imgView_team_two
        val team_one_name: TextView = itemView.txt_team_one
        val team_two_name: TextView = itemView.txt_team_two
        val team_one_score: TextView = itemView.txt_score_team_one
        val team_two_score: TextView = itemView.txt_score_team_two
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
            match_status.text = liveMatchLst[position].Eps
            Glide.with(context).load("https://lsm-static-prod.livescore.com/medium/${liveMatchLst[position].T1[0].Img}").into(logo_team_one)
            Glide.with(context).load("https://lsm-static-prod.livescore.com/medium/${liveMatchLst[position].T2[0].Img}").into(logo_team_two)
            team_one_name.text = liveMatchLst[position].T1[0].Nm
            team_two_name.text = liveMatchLst[position].T2[0].Nm
            team_one_score.text = liveMatchLst[position].Tr1
            team_two_score.text = liveMatchLst[position].Tr2
        }
    }

}