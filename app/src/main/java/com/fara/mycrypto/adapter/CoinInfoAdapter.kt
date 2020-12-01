package com.fara.mycrypto.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.fara.mycrypto.R
import com.fara.mycrypto.databinding.ItemCoinInfoBinding
import com.fara.mycrypto.pojo.CoinPriceInfo

class CoinInfoAdapter(private val context: Context) :
    RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var onCoinClickListener: OnCoinClickListener? = null

    inner class CoinInfoViewHolder(binding: ItemCoinInfoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val ivIcon = binding.ivIcon
        val tvSymbols = binding.tvSymbols
        val tvPrice = binding.tvPrice
        val tvUpdate = binding.tvUpdated
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CoinInfoViewHolder(
        ItemCoinInfoBinding.inflate(LayoutInflater.from(context), parent, false)
    )

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                tvSymbols.text = String.format(
                    context.resources.getString(R.string.symbols_template), fromSymbol, toSymbol
                )
                tvPrice.text = price
                tvUpdate.text = String.format(
                    context.resources.getString(R.string.update_template), getFormattedTime()
                )
                ivIcon.load(getFullImageUrl())
                itemView.setOnClickListener {
                    onCoinClickListener?.onCoinClick(this)
                }
            }
        }
    }

    override fun getItemCount() = coinInfoList.size

    interface OnCoinClickListener {
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }
}