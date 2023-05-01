package com.example.moodtracker21

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.moodtracker21.databinding.FragmentSecondBinding
import showCustomToast
import java.util.*


class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    var emotion = ArrayList<String?>()
    var comment = ArrayList<String?>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadSharedPref()
        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)



        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setFields(){

        binding.commentToday.setOnClickListener {
            if (comment[0] == "" || comment[0]== null )
            {
                Toast(requireContext()).showCustomToast("No Record Available", requireActivity())
            }

            else {
                comment[0]?.let { it1 ->
                    Toast(requireContext()).showCustomToast(
                        it1,
                        requireActivity()
                    )
                }
            }
 }

        binding.comment2DaysAgo.setOnClickListener {
            if (comment[1] == "" || comment[1]== null )
            {
                Toast(requireContext()).showCustomToast("No Record Available", requireActivity())
            }

            else {
                comment[1]?.let { it1 ->
                    Toast(requireContext()).showCustomToast(
                        it1,
                        requireActivity()
                    )
                }
            }
        }


        binding.comment3DaysAgo.setOnClickListener {
            if (comment[2] == "" || comment[2]== null )
            {
                Toast(requireContext()).showCustomToast("No Record Available", requireActivity())
            }

            else {
                comment[2]?.let { it1 ->
                    Toast(requireContext()).showCustomToast(
                        it1,
                        requireActivity()
                    )
                }
            }
        }

        binding.comment4DaysAgo.setOnClickListener {
            if (comment[3] == "" || comment[3]== null )
            {
                Toast(requireContext()).showCustomToast("No Record Available", requireActivity())
            }

            else {
                comment[3]?.let { it1 ->
                    Toast(requireContext()).showCustomToast(
                        it1,
                        requireActivity()
                    )
                }
            }
        }

        binding.comment5DaysAgo.setOnClickListener {
            if (comment[4] == "" || comment[4]== null )
            {
                Toast(requireContext()).showCustomToast("No Record Available", requireActivity())
            }

            else {
                comment[4]?.let { it1 ->
                    Toast(requireContext()).showCustomToast(
                        it1,
                        requireActivity()
                    )
                }
            }
        }

        binding.comment6DaysAgo.setOnClickListener {


            if (comment[5] == "" || comment[5]== null )
            {
                Toast(requireContext()).showCustomToast("No Record Available", requireActivity())
            }

            else {
                comment[5]?.let { it1 ->
                    Toast(requireContext()).showCustomToast(
                        it1,
                        requireActivity()
                    )
                }
            }
        }

        binding.comment7DaysAgo.setOnClickListener {
            if (comment[6] == "" || comment[6]== null )
            {
                Toast(requireContext()).showCustomToast("No Record Available", requireActivity())
            }

            else {
                comment[6]?.let { it1 ->
                    Toast(requireContext()).showCustomToast(
                        it1,
                        requireActivity()
                    )
                }
            }
            println(comment[6])
        }





        if (emotion[0]?.isNotEmpty() == true){
            binding.day1Layout.setBackgroundColor(Color.parseColor(emotion[0]))
        }
        if (emotion[1]?.isNotEmpty() == true){
           binding.day2Layout.setBackgroundColor(Color.parseColor(emotion[1]))

        }

        if (emotion[2]?.isNotEmpty() == true){
            binding.day3Layout.setBackgroundColor(Color.parseColor(emotion[2]))

        }
        if (emotion[3]?.isNotEmpty() == true){
            binding.day4Layout.setBackgroundColor(Color.parseColor(emotion[3]))
        }

        if (emotion[4]?.isNotEmpty() == true){
            binding.day5Layout.setBackgroundColor(Color.parseColor(emotion[4]))

        }

        if (emotion[5]?.isNotEmpty() == true){
            binding.day6Layout.setBackgroundColor(Color.parseColor(emotion[5]))

        }

        if (emotion[6]?.isNotEmpty() == true){
            binding.day7Layout.setBackgroundColor(Color.parseColor(emotion[6]))
        }




    }



    //Fix this so it loads the entire file
    fun loadSharedPref(){
        val sharedPref = requireContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

        val monEmotion =  sharedPref.getString("monemotion", "")
        val monComment =  sharedPref.getString("moncomment", "")
        println("Mon emotion is $monEmotion and the comment is $monComment" )
        emotion.add(monEmotion)
        comment.add(monComment)

        val tueEmotion =  sharedPref.getString("tueemotion", "")
        val tueComment =  sharedPref.getString("tuecomment", "")
        println("tue emotion is $tueEmotion and the comment is $tueComment" )
        emotion.add(tueEmotion)
        comment.add(tueComment)

        val wedEmotion =  sharedPref.getString("wedemotion", "")
        val wedComment =  sharedPref.getString("wedcomment", "")
        println("wed emotion is $wedEmotion and the comment is $wedComment" )
        emotion.add(wedEmotion)
        comment.add(wedComment)

        val thuEmotion =  sharedPref.getString("thuemotion", "")
        val thuComment =  sharedPref.getString("thucomment", "")
        println("thu emotion is $thuEmotion and the comment is $thuComment" )
        emotion.add(thuEmotion)
        comment.add(thuComment)

        val friEmotion =  sharedPref.getString("frimotion", "")
        val friComment =  sharedPref.getString("fricomment", "")
        println("fri emotion is $friEmotion and the comment is $friComment" )
        emotion.add(friEmotion)
        comment.add(friComment)


        val satEmotion =  sharedPref.getString("satemotion", "")
        val satComment =  sharedPref.getString("satcomment", "")
        println("sat emotion is $satEmotion and the comment is $satComment" )
        emotion.add(satEmotion)
        comment.add(satComment)

        val sunEmotion =  sharedPref.getString("sunemotion", "")
        val sunComment =  sharedPref.getString("suncomment", "")
        println("sun emotion is $sunEmotion and the comment is $sunComment" )
        emotion.add(sunEmotion)
        comment.add(sunComment)
        setFields()
    }

}