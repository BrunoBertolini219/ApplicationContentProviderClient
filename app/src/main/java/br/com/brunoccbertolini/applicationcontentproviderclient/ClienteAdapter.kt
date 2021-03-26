package br.com.brunoccbertolini.applicationcontentproviderclient

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClienteAdapter(private val mCursor: Cursor): RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder {
        return ClienteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.client_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.apply {
            clientTitle.text = mCursor.getString(mCursor.getColumnIndex("title"))
            clientDescription.text = mCursor.getString(mCursor.getColumnIndex("description"))
        }
    }

    override fun getItemCount() = mCursor.count

    inner class ClienteViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val clientTitle = itemView.findViewById(R.id.tv_client_item_title) as TextView
        val clientDescription = itemView.findViewById(R.id.tv_client_item_description) as TextView

    }
}
