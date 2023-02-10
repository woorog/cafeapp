package com.example.myapplication.FrBoardDTO

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemlistBinding

class ProfileAdapter: ListAdapter<ResponseData, ProfileAdapter.ItemViewHolder>(diffUtil) {

    inner class  ItemViewHolder(private val binding: ItemlistBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(bookModel:ResponseData){
            binding.title.text=bookModel.searchObj.data.boardCn //제목
            binding.info.text=bookModel.searchObj.data.boardSj  //내용
            //이미지
            Glide
                .with(binding.coverImage)
                .load("https://yhapidev.teamfresh.co.kr/content")
                .into(binding.coverImage)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return  ItemViewHolder(ItemlistBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }//뷰홀더 없을 경우

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }//

    //새로운 값을 할당 결정
    companion object{
        val diffUtil = object : DiffUtil.ItemCallback<ResponseData>(){
            override fun areItemsTheSame(oldItem: ResponseData, newItem: ResponseData): Boolean {
                return oldItem==newItem

            }//동일컨텐츠 확인

            override fun areContentsTheSame(oldItem: ResponseData, newItem: ResponseData): Boolean {
                return oldItem.searchObj.data.boardInfoSeqNo==newItem.searchObj.data.boardInfoSeqNo
            }


        }
    }


}