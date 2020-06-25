package com.murkoto.footballnotsoccer.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.PagerSnapHelper
import com.murkoto.footballnotsoccer.R
import com.murkoto.footballnotsoccer.adapter.LeagueRecyclerViewAdapter
import com.murkoto.footballnotsoccer.databinding.ActivityMainBinding
import com.murkoto.footballnotsoccer.model.League
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mAdapter: LeagueRecyclerViewAdapter

    private val snapHelper = PagerSnapHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mAdapter = LeagueRecyclerViewAdapter(prepareData(), this)
        binding.mAdapter = mAdapter
        snapHelper.attachToRecyclerView(rvLeague)
    }

    private fun prepareData(): List<League> {
        val res = mutableListOf<League>()
        val ids = resources.getStringArray(R.array.id_league)
        val names = resources.getStringArray(R.array.leaguename)
        val badges = resources.obtainTypedArray(R.array.logos)
        for (idx in names.indices) {
            res.add(League(
                id = ids[idx],
                name = names[idx],
                badgeRes = badges.getResourceId(idx, -1)
            ))
        }
        badges.recycle()
        return res
    }

}