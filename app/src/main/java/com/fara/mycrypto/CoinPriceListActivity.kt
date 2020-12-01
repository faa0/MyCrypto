package com.fara.mycrypto

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fara.mycrypto.adapter.CoinInfoAdapter
import com.fara.mycrypto.databinding.ActivityCoinPriceListBinding
import com.fara.mycrypto.pojo.CoinPriceInfo
import com.fara.mycrypto.utils.AppConstants.Companion.EXTRA_FROM_SYMBOL

class CoinPriceListActivity : AppCompatActivity() {

    private lateinit var viewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCoinPriceListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CoinInfoAdapter(this)
        binding.rvCoinPriceList.adapter = adapter

        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.priceList.observe(this, {
            adapter.coinInfoList = it
        })

        adapter.onCoinClickListener = object : CoinInfoAdapter.OnCoinClickListener {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
                val intent = Intent(this@CoinPriceListActivity, CoinDetailActivity::class.java)
                intent.putExtra(EXTRA_FROM_SYMBOL, coinPriceInfo.fromSymbol)
                startActivity(intent)
            }
        }
    }
}