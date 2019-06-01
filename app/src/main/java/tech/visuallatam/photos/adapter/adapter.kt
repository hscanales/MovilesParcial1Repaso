package tech.visuallatam.photos.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.photo_cardview.view.*
import tech.visuallatam.photos.R
import tech.visuallatam.photos.database.entities.photo

class adapter(var fotos:List<photo>): RecyclerView.Adapter<adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photo_cardview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = fotos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(fotos[position])

    }

    fun updateList(newFotos:List<photo>){
        this.fotos = newFotos
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(foto : photo) = with(itemView){
            this.autor.text=foto.author
            Glide.with(this).load(foto.download_ulr).into(image)

        }
    }


}