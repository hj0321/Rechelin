package com.example.rechelin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rechelin.databinding.ActivityListBinding
import com.example.rechelin.databinding.StoreListBinding


class ListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 데이터 불러오기
        val data = loadStore()
        // 2. 아답터를 생성
        val customAdapter = CustomAdapter(data)
        // 3. 화면의 recycler view 와 연결
        binding.recyclerView.adapter = customAdapter
        // 4. 레이아웃 매니저 설정
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun loadStore(): MutableList<StoreEntity>{              // 100개의 StoreEntity를 넘겨받도록 해논것..
        val storelist = mutableListOf<StoreEntity>()
        for (no in 1..100){
            val store = "가게이름"
            val score = "점수"
            val info = StoreEntity(store,score)
            storelist.add(info)
        }
        return storelist
    }

    class CustomAdapter(val storelist : MutableList<StoreEntity>) : RecyclerView.Adapter<CustomAdapter.Holder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val binding = StoreListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return Holder(binding)
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            val store = storelist[position]
        }

        override fun getItemCount(): Int {
            return storelist.size
        }

        class Holder(val binding:StoreListBinding):RecyclerView.ViewHolder(binding.root){
            // 클릭처리 init에서
            init {
                binding.root.setOnClickListener{

                }
            }
            val store_name = binding.storeName
            val store_score = binding.storeScore
            val root = binding.root
        }
    }


}