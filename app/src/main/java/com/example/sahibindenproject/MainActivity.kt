package com.example.sahibindenproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sahibindenproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    val categories = listOf(
        Category(1, "Emlak","Konut, İş Yeri, Arsa, Konut Projeleri, Bina, Devre Mülk",R.drawable.home_button),
        Category(2, "Vasıta","Otomobil, Arazi, SUV & Pickup, Motosiklet, Miniva" ,R.drawable.car_button),
        Category(5, "İş Makineleri & Sanayi","İş Makineleri, Tarım Makineleri, Sanayi, Elektrik & Arıza",R.drawable.factory),
        Category(3, "Yedek Parça, Aksesuar","Otomotiv Ekipmanları, Motosiklet Ekipmanları, De",R.drawable.wrench),
        Category(6, "Ustalar ve Hizmetler","Ev Tadilat & Dekorasyon, Nakliye, Araç Servis & Bakım",R.drawable.drill),
        Category(4, "İkinci El ve Sıfır Alışveriş","Param Güvende Bilgisayar, Cep Telefonu, Fotoğtaf",R.drawable.shoping),
        Category(7, "Özel Ders Verenler","Lise & Üniversite, İlkokul & Ortaokul, Yabancı Dil",R.drawable.open_book),
        Category(9, "İş İlanları","Avukatlık & Hukuki Danışmanlık, Eğitim, Eğlence ve",R.drawable.profile),
        Category(10, "Yardımcı Arayanlar","Bebek & Çocuk Bakıcısı, Yaşlı Hasta Bakıcısı, Temizlik",R.drawable.healthcare),
        Category(11, "Hayvanlar Alemi","Evcil Hayvanlar, Akvaryum Balıkları, Aksesuarlar",R.drawable.cat),

        )

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater) //binding yapısı tanımladık
        setContentView(binding.root) //içeriği binding yaptık

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter = CategoryAdapter(this, categories){pCategory, position ->
            val intent = Intent(this, CategoryDetail::class.java)
            startActivity(intent)
        }

        binding.recyclerView.adapter = adapter

        //filtreleme işlemleri
        binding.tvSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                println("beforeTextChanged: $s")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty()){
                    val filteredList = categories.filter { it.categoryName.contains(s.toString(),true) || it.categoryDetail.contains(s.toString(), true)  }
                    adapter.updateList(filteredList)
                }else{
                    adapter.updateList(categories)
                }
                adapter.notifyDataSetChanged()
            }

            override fun afterTextChanged(s: Editable?) {
                println("afterTextChanged: ${s.toString()}")
            }

        })


    }
}