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
import com.example.livescoreapidemo.dataclass.todaymatches.Stage
import kotlinx.android.synthetic.main.single_view_league_view.view.*

class TodayLeagueAdapter(val context: Context, val todayLeaguesList: List<Stage>): RecyclerView.Adapter<TodayLeagueAdapter.TodayLeagueViewHolder>() {

    class TodayLeagueViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var LEA_IMG: ImageView = itemView.img_leagueLogo
        var LEA_NAME: TextView? = itemView.txt_leagueName
        var CON_NAME: TextView? = itemView.txt_leagueCountry
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodayLeagueViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.single_view_league_view, parent, false)
        return TodayLeagueViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todayLeaguesList.size
    }

    override fun onBindViewHolder(holder: TodayLeagueViewHolder, position: Int) {
        holder.apply {
            Glide.with(context).load("https://static.livescore.com/i2/fh/${todayLeaguesList[position].Ccd}.jpg").into(LEA_IMG)
            LEA_NAME?.text = todayLeaguesList[position].Snm
            CON_NAME?.text = todayLeaguesList[position].Cnm
            itemView.findViewById<RecyclerView>(R.id.recyclerView_Events).adapter = TodayMatchesAdapter(context, todayLeaguesList[position].Events)
        }

    }
}