package com.example.mutia_exer5_lightsoutv2

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mutia_exer5_lightsoutv2.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        binding.playButton.setOnClickListener { view : View ->
            val givenName = binding.nameEdit
            val playBtn = binding.playButton
            //val result = binding.nameText

            givenName.visibility = View.GONE
            playBtn.visibility = View.GONE
            binding.nameText.text = givenName.text



            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment2)


//            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        }

        return binding.root
    }


}