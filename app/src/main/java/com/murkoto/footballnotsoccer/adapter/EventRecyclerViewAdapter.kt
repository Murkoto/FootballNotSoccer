package com.murkoto.footballnotsoccer.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.murkoto.footballnotsoccer.R
import com.murkoto.footballnotsoccer.databinding.ItemEventBinding
import com.murkoto.footballnotsoccer.model.Event

class EventRecyclerViewAdapter(val events: List<Event>, val context: Context):
    RecyclerView.Adapter<EventRecyclerViewAdapter.EventViewHolder>() {

    class EventViewHolder(val binding: ItemEventBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val inflater = LayoutInflater.from(context)
        return EventViewHolder(DataBindingUtil.inflate(
            inflater, R.layout.item_event, parent, false
        ))
    }

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]
        holder.binding.event = event
    }
}