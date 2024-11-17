package com.example.movieapp.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailBinding
import com.example.movieapp.ui.search.SearchViewModelInterface
import com.example.movieapp.utils.PicassoImage
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {
    private lateinit var design:FragmentDetailBinding
    private lateinit var viewModel:MovieDetailViewModelInterface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,
            container, false)
        val bundle:DetailFragmentArgs by navArgs()
        val id = bundle.id
        viewModel.getId(id)
        design.casrRyc.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        viewModel.casts.observe(viewLifecycleOwner){
            val castAdapter = CastAdapter(requireContext(),it)
            design.castAdapter = castAdapter
        }

       viewModel.movieDetail.observe(viewLifecycleOwner){
           design.nameTxt.text = it.name
           PicassoImage.covertToPicasso(it.detailimage,design.moveiDetailImage)
           design.categoryTxt.text = it.categories.joinToString(", ")
           val writer = it.writter.joinToString(", ")
           design.writterTxt.text = "Writer: ${writer}"
           val director = it.director.joinToString(", ")
           design.directorTxt.text = "Director: ${director}"
           design.infotxt.text = it.info


       }

        return  design.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:MovieDetailViewModelInterface by viewModels<MovieDetailViewModel>()
        viewModel = tempViewModel
    }
}