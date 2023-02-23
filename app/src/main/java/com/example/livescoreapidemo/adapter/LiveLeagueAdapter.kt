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
import com.example.livescoreapidemo.dataclasses.livelist.Stage
import kotlinx.android.synthetic.main.single_view_league_view.view.*

class LiveLeagueAdapter(val context: Context, val leagueList: List<Stage>): RecyclerView.Adapter<LiveLeagueAdapter.MatchViewHolder>() {
    class MatchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var LEA_IMG: ImageView = itemView.img_leagueLogo
        var LEA_NAME: TextView? = itemView.txt_leagueName
        var CON_NAME: TextView? = itemView.txt_leagueCountry

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.single_view_league_view, parent, false)
        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return leagueList.size
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        Glide.with(context).load("https://static.livescore.com/i2/fh/${leagueList[position].Ccd}.jpg").into(holder.LEA_IMG)
        holder.LEA_NAME?.text = leagueList[position].Snm
        holder.CON_NAME?.text = leagueList[position].Cnm
        holder.itemView.findViewById<RecyclerView>(R.id.recyclerView_Events).adapter = LiveMatchListAdapter(context, leagueList[position].Events)
    }
}