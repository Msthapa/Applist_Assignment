package com.example.applist.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.applist.R
import com.example.applist.databinding.FragmentAppDetailBinding

class AppDetailFragment : Fragment() {
    private val args: AppDetailFragmentArgs by navArgs()
    private var binding : FragmentAppDetailBinding ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAppDetailBinding.bind(inflater.inflate(R.layout.fragment_app_detail, container, false))
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = args.appName
        val imageUrl = args.appImage
        val releaseDate = args.releaseDate
        val playStoreUrl = args.playStoreUrl
     binding?.let {
         Glide.with(this)
             .load(imageUrl)
             .placeholder(R.drawable.ic_launcher_background)
             .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC) // for caching images
             .skipMemoryCache(false) // using memory to cache
             .into(it.appImage)

         it.appName.text  = buildString {
             append(requireContext().getString(R.string.item_app_name))
             append("  ${name}")
         }

         it.releaseDate.text = buildString {
             append(requireContext().getString(R.string.release_date))
             append("  ${releaseDate}")
         }

         it.btnDownload.setOnClickListener {
             openExternalLinkOrApp(playStoreUrl)
         }
     }

    }
    fun openExternalLinkOrApp(appUrl : String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(appUrl))
            intent.setPackage("com.android.vending")
            startActivity(intent)
        } catch (e: Exception) {
            // fallback to browser if Play Store not available
            val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse(appUrl))
            startActivity(intent)
        }
    }

}