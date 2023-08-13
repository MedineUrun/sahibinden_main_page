package com.example.sahibindenproject

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sahibindenproject.databinding.CategoryListItemBinding

class CategoryAdapter(
    val context: Context,
    var categories:List<Category>,
    val onClick:(category:Category, position:Int ) -> Unit
):
    RecyclerView.Adapter<CategoryAdapter.MyViewHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryAdapter.MyViewHolder {
        return  MyViewHolder(
        CategoryListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryAdapter.MyViewHolder, position: Int) {
        val pCategory = categories[position]
        holder.category.text = pCategory.categoryName
        holder.detail.text = pCategory.categoryDetail
        holder.logo.setImageResource(pCategory.categoryLogo)

        holder.myItemView.setOnClickListener {
            onClick(pCategory, position)
        }
    }

    fun updateList(filteredList: List<Category>) {
        categories = filteredList
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class MyViewHolder(private val view:CategoryListItemBinding): RecyclerView.ViewHolder(view.root){
        val myItemView = itemView
        val category = view.tvCategory
        val detail = view.tvCategoryDetail
        val logo = view.tvLogo

    }


}