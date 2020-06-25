package com.murkoto.footballnotsoccer.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.footballnotsoccer.R
import com.murkoto.footballnotsoccer.databinding.ItemLeagueListBinding
import com.murkoto.footballnotsoccer.model.League
import com.murkoto.footballnotsoccer.view.LeagueDetailActivity

class LeagueRecyclerViewAdapter(private val leagues: List<League>, private val context: Context): RecyclerView.Adapter<LeagueRecyclerViewAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val inflater = LayoutInflater.from(context)
        return LeagueViewHolder(DataBindingUtil.inflate(inflater, R.layout.item_league_list, parent, false))
    }

    override fun getItemCount(): Int = leagues.size

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        val league = leagues[position]
        holder.binding.league = league
        holder.binding.ivBadge.setImageResource(league.badgeRes)
        holder.setupItemClick(context)
    }

    class LeagueViewHolder(val binding: ItemLeagueListBinding): RecyclerView.ViewHolder(binding.root) {
        fun setupItemClick(context: Context) {
            binding.root.setOnClickListener {
                val intent = Intent(context, LeagueDetailActivity::class.java)
                context.startActivity(intent)
            }
        }
    }

}