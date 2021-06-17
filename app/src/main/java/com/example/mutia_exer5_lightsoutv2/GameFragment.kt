package com.example.mutia_exer5_lightsoutv2

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.mutia_exer5_lightsoutv2.databinding.FragmentGameBinding
import android.widget.Button
import androidx.navigation.findNavController
import com.example.mutia_exer5_lightsoutv2.databinding.FragmentTitleBinding

class GameFragment : Fragment(){
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val binding = DataBindingUtil.inflate<FragmentGameBinding>(inflater,
                R.layout.fragment_game,container,false)

            val titleBinding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
                R.layout.fragment_title,container,false)

            val name = titleBinding.nameText
            val result = binding.playerNameText
            result.text = name.text

            setListeners(binding)
            return binding.root
        }

    private fun changeColor(view:View?){
        var light =  view?.findViewById<TextView>(view.id)
        val lightStatus = light?.text.toString()

        if(lightStatus == "1"){
            light?.setBackgroundColor(Color.DKGRAY)
            light?.text = "0"
        }else{
            light?.setBackgroundColor(Color.parseColor("#EFD657"))
            light?.text = "1"
        }

    }

    private fun checkIfWinner(lightsMatrix: List<List<View?>>){
        for(i in 0..4){
            for( j in 0..4){
                var light = view?.findViewById<TextView>(lightsMatrix[i][j]!!.id)
                val lightStatus = light?.text.toString()

                if(lightStatus == "1"){
                    return
                }

            }
        }
        view?.findNavController()?.navigate(R.id.action_gameFragment2_to_winFragment)
    }

    private fun turnONorOFF(lightsMatrix:List<List<View?>>, i: Int, j: Int){
        var numClicks = view?.findViewById<TextView>(R.id.numberOfClicks)
        val currentNumber = numClicks?.text.toString()
        val updatedNumber = Integer.parseInt(currentNumber) + 1
        numClicks?.text = updatedNumber.toString()

        changeColor(lightsMatrix[i][j])

        if((i == 0) and (j == 0)){
            changeColor(lightsMatrix[i+1][j])
            changeColor(lightsMatrix[i][j+1])
        }else if((i == 0) and (j == 4)){
            changeColor(lightsMatrix[i+1][j])
            changeColor(lightsMatrix[i][j-1])
        }else if((i == 4) and (j == 0)){
            changeColor(lightsMatrix[i-1][j])
            changeColor(lightsMatrix[i][j+1])
        }else if((i == 4) and (j == 4)){
            changeColor(lightsMatrix[i-1][j])
            changeColor(lightsMatrix[i][j-1])
        }

        else if(j == 0){
            changeColor(lightsMatrix[i+1][j])
            changeColor(lightsMatrix[i-1][j])
            changeColor(lightsMatrix[i][j+1])
        }else if(j == 4){
            changeColor(lightsMatrix[i+1][j])
            changeColor(lightsMatrix[i-1][j])
            changeColor(lightsMatrix[i][j-1])
        }else if(i == 0){
            changeColor(lightsMatrix[i][j-1])
            changeColor(lightsMatrix[i][j+1])
            changeColor(lightsMatrix[i+1][j])
        }else if(i == 4){
            changeColor(lightsMatrix[i][j-1])
            changeColor(lightsMatrix[i][j+1])
            changeColor(lightsMatrix[i-1][j])
        }

        else{
            changeColor(lightsMatrix[i+1][j])
            changeColor(lightsMatrix[i-1][j])
            changeColor(lightsMatrix[i][j+1])
            changeColor(lightsMatrix[i][j-1])
        }

        checkIfWinner(lightsMatrix)
    }

    private fun retryGame(clickableLights: List<View>, binding: FragmentGameBinding){

        val rootConstraintLayout = binding.titleConstraint

        for(item in clickableLights){
            if(item != rootConstraintLayout){
                var light = view?.findViewById<TextView>(item.id)
                light?.text = "1"
                item.setBackgroundColor(Color.parseColor("#EFD657"))

            }
        }

    }


    private fun setListeners(binding: FragmentGameBinding){

        val boxOneText = binding.boxOne
        val boxTwoText = binding.boxTwo
        val boxThreeText = binding.boxThree
        val boxFourText = binding.boxFour
        val boxFiveText = binding.boxFive

        val boxSixText = binding.boxSix
        val boxSevenText = binding.boxSeven
        val boxEightText = binding.boxEight
        val boxNineText = binding.boxNine
        val boxTenText = binding.boxTen

        val boxElevenText = binding.boxEleven
        val boxTwelveText = binding.boxTwelve
        val boxThirteenText = binding.boxThirteen
        val boxFourteenText = binding.boxFourteen
        val boxFifteenText = binding.boxFifteen

        val boxSixteenText = binding.boxSixteen
        val boxSeventeenText = binding.boxSeventeen
        val boxEighteenText = binding.boxEighteen
        val boxNineteenText = binding.boxNineteen
        val boxTwentyText = binding.boxTwenty

        val boxTwentyOneText = binding.boxTwentyOne
        val boxTwentyTwoText = binding.boxTwentyTwo
        val boxTwentyThreeText = binding.boxTwentyThree
        val boxTwentyFourText = binding.boxTwentyFour
        val boxTwentyFiveText = binding.boxTwentyFive

        val rootConstraintLayout = binding.titleConstraint

        val retryBtn = binding.retryButton

        val clickableLights: List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText,
            boxSixText, boxSevenText, boxEightText, boxNineText, boxTenText,
            boxElevenText, boxTwelveText, boxThirteenText, boxFourteenText, boxFifteenText,
            boxSixteenText, boxSeventeenText, boxEighteenText, boxNineteenText, boxTwentyText,
            boxTwentyOneText, boxTwentyTwoText, boxTwentyThreeText, boxTwentyFourText, boxTwentyFiveText, rootConstraintLayout)

        val rowOne: List<View> = listOf(boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText)
        val rowTwo: List<View> = listOf(boxSixText, boxSevenText, boxEightText, boxNineText, boxTenText)
        val rowThree: List<View> = listOf(boxElevenText, boxTwelveText, boxThirteenText, boxFourteenText, boxFifteenText)
        val rowFour: List<View> = listOf(boxSixteenText, boxSeventeenText, boxEighteenText, boxNineteenText, boxTwentyText)
        val rowFive: List<View> = listOf(boxTwentyOneText, boxTwentyTwoText, boxTwentyThreeText, boxTwentyFourText, boxTwentyFiveText)

        val lightsMatrix: List<List<View>> = listOf(rowOne, rowTwo, rowThree, rowFour, rowFive)


        for (i in 0..4){
            for(j in 0..4){
                lightsMatrix[i][j].setOnClickListener{turnONorOFF(lightsMatrix, i, j)}
            }
        }
        retryBtn.setOnClickListener{
            retryGame(clickableLights ,binding)

            var numClicks = binding.numberOfClicks
            numClicks.text = "0"
        }

    }
}
