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
import com.example.livescoreapidemo.dataclasses.todaymatches.Stage
import kotlinx.android.synthetic.main.single_view_league_view.view.*

class TodayLeagueAdapter(val context: Context, private val todayLeaguesList: List<Stage>): RecyclerView.Adapter<TodayLeagueAdapter.TodayLeagueViewHolder>() {

    class TodayLeagueViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var leaImg: ImageView = itemView.img_leagueLogo
        var leaName: TextView? = itemView.txt_leagueName
        var conName: TextView? = itemView.txt_leagueCountry
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayLeagueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_view_league_view, parent, false)
        return TodayLeagueViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todayLeaguesList.size
    }

    override fun onBindViewHolder(holder: TodayLeagueViewHolder, position: Int) {
        holder.apply {
            Glide.with(context).load("https://static.livescore.com/i2/fh/${todayLeaguesList[position].Ccd}.jpg").into(leaImg)
            leaName?.text = todayLeaguesList[position].Snm
            conName?.text = todayLeaguesList[position].Cnm
            itemView.findViewById<RecyclerView>(R.id.recyclerView_Events).adapter = TodayMatchesAdapter(context, todayLeaguesList[position].Events)
        }
    }

}