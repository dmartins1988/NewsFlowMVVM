package com.example.newsflowmvvm.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.newsflowmvvm.R
import com.example.newsflowmvvm.extensions.loadUrl
import com.example.newsflowmvvm.model.Article

class ListAdapter(
    private val context: Context,
    private val listener: ListInteraction
) : ListAdapter<Article, RecyclerView.ViewHolder>(ArticleCallback()) {

    interface ListInteraction {
        fun onClick(article: Article, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_list_item, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ListViewHolder).bind(item, position)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var articleImageView: ImageView = itemView.findViewById(R.id.news_image)
        private var articleTitleTextView : TextView = itemView.findViewById(R.id.news_title)
        private var articleAuthorTextView: TextView = itemView.findViewById(R.id.news_author)
        private var articleContentTextView: TextView = itemView.findViewById(R.id.news_content)
        private var articleDateTextView: TextView = itemView.findViewById(R.id.news_date)

        fun bind(article: Article, position: Int) {
            articleImageView.loadUrl(context, article.urlToImage)
            articleTitleTextView.text = article.title
            articleAuthorTextView.text = article.author
            articleContentTextView.text = article.description
            articleDateTextView.text = article.publishedAt

            itemView.setOnClickListener {
                listener.onClick(article, position)
            }
        }
    }

    class ArticleCallback : DiffUtil.ItemCallback<Article>() {

        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem.author == newItem.author &&
                    oldItem.content == newItem.content &&
                    oldItem.description == newItem.description &&
                    oldItem.url == newItem.url &&
                    oldItem.urlToImage == newItem.urlToImage

    }

}