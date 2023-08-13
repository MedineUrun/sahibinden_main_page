package com.example.sahibindenproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.example.sahibindenproject.databinding.ActivityCategoryDetailBinding
import com.example.sahibindenproject.databinding.ActivityMainBinding

class CategoryDetail : AppCompatActivity() {

    val data = listOf(
        Data(1, "DERİN YAPI'DAN DENİZ MANZARALI DUBLEKS DAİREMİZ SİZLERİ BEKLİYOR", "DERİN YAPI GAYRİMENKUL", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVpE_r2rwhLxfNnEO--svpCE-RHtZjfRRPjA&usqp=CAU")
    )

    lateinit var binding: ActivityCategoryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root) //içeriği binding yaptık

        binding.textCategory.text = data[0].explanation
        binding.textDetail.text = data[0].name
        binding.tvHome.load(data[0].image)

    }



}