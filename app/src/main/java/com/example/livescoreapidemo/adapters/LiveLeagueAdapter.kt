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
import com.example.livescoreapidemo.dataclasses.livematches.Stage
import kotlinx.android.synthetic.main.single_view_league_view.view.*

class LiveLeagueAdapter(val context: Context, private val leagueList: List<Stage>): RecyclerView.Adapter<LiveLeagueAdapter.MatchViewHolder>() {
    class MatchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var leaImg: ImageView = itemView.img_leagueLogo
        var leaName: TextView? = itemView.txt_leagueName
        var conName: TextView? = itemView.txt_leagueCountry
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_view_league_view, parent, false)
        return MatchViewHolder(view)
    }

    override fun getItemCount(): Int {
        return leagueList.size
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.apply {
            Glide.with(context).load("https://static.livescore.com/i2/fh/${leagueList[position].Ccd}.jpg").into(leaImg)
            leaName?.text = leagueList[position].Snm
            conName?.text = leagueList[position].Cnm
            itemView.findViewById<RecyclerView>(R.id.recyclerView_Events).adapter = LiveMatchListAdapter(context, leagueList[position].Events)
        }
    }

}