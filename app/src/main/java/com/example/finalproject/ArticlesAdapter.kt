package com.example.finalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.dataclasses.Article

class ArticlesAdapter(private  val articlesList: List<Article>, private val onItemClick : (String) -> Unit)
    : RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleText = itemView.findViewById<TextView>(R.id.article_title)
        val publisherText = itemView.findViewById<TextView>(R.id.article_publisher)
        val publishedDateText = itemView.findViewById<TextView>(R.id.article_publish_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.article_item, parent, false)
        return ArticleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = articlesList[position];
        holder.publisherText.text = item.publisher.name;
        holder.titleText.text = item.title;
        holder.publishedDateText.text = item.published_date;
    }

    override fun getItemCount() : Int = articlesList.size
}