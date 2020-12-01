package com.fara.mycrypto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.fara.mycrypto.databinding.ActivityCoinDetailBinding
import com.fara.mycrypto.utils.AppConstants.Companion.EXTRA_FROM_SYMBOL

class CoinDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCoinDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!intent.hasExtra(EXTRA_FROM_SYMBOL)) {
            finish()
            return
        }

        val fromSymbol = intent.getStringExtra(EXTRA_FROM_SYMBOL)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]

        if (fromSymbol != null) {
            viewModel.getDetailInfo(fromSymbol).observe(this, {
                binding.tvPrice.text = it.price
                binding.tvMinPrice.text = it.lowDay
                binding.tvMaxPrice.text = it.highDay
                binding.tvLastMarket.text = it.lastMarket
                binding.tvUpdate.text = it.getFormattedTime()
                binding.tvFromSymbol.text = it.fromSymbol
                binding.tvToSymbol.text = it.toSymbol
                binding.ivLogoCoin.load(it.getFullImageUrl())
            })
        }
    }
}