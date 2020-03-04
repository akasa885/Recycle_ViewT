package android.latihan.recycle_viewt

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list.view.*

class Adapter(private val list:ArrayList<Users>, val say: String, val listener: ItemListener) : RecyclerView.Adapter<Adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list,parent,false))
    }

    override fun getItemCount() : Int = list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.view.lbList.text = list.get(position).name
        holder.view.halo.text = say
        holder.bindData(list.get(position).name, listener)
    }

    class Holder(val view: View) : RecyclerView.ViewHolder(view)
    {
        var nama = view.findViewById<TextView>(R.id.lbList)

        fun bindData(name : String , listener: ItemListener)
        {
            //mendapatkan nama tiap list dan memasukkannya ke listener
            nama.text = name
            nama.setOnClickListener { view -> listener.onClicked(name) }
        }
    }

}