package com.example.mutia_exer5_lightsoutv2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.mutia_exer5_lightsoutv2.databinding.FragmentWinBinding

class WinFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentWinBinding>(inflater,
            R.layout.fragment_win,container,false)

        binding.playAgainButton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_winFragment_to_titleFragment)
        }

        return binding.root
    }


}
