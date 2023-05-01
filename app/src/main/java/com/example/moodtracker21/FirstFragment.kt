package com.example.moodtracker21

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.example.moodtracker21.databinding.FragmentFirstBinding
import java.util.*

/**
 * implement histroy fragment
 * add coments and refactor
 * create apk
 */
class FirstFragment : Fragment() {
    var x = 0.0f
    var y = 0.0f
    var currentEmotion =3 // 3 is normal
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }





    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emotionValueChanger()


        binding.commentBtn.setOnClickListener {
            // saveSharedPref("The mood is normal","The comment is something")
            val builder = AlertDialog.Builder(requireContext())
            val inflater = LayoutInflater.from(requireContext())
            val dialogLayout = inflater.inflate(R.layout.comment_layout, null)
            val editText = dialogLayout.findViewById<EditText>(R.id.commentET)
            with(builder) {
                setTitle("Enter Your Comment")
                setPositiveButton("Submit") { _, _ ->
                    saveSharedPref(currentEmotion.toString(),
                        editText.text.toString())
                }
                setNegativeButton("Cancel") { _, _ ->
                    Log.d("main", "Negative Button Clicked")
                }
                setView(dialogLayout)
                show()
            }
            }

        binding.historyBtn.setOnClickListener {
            loadSharedPref()
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.emoteChangerView.setOnTouchListener { v, event ->

            when (event.actionMasked) {

                MotionEvent.ACTION_DOWN -> {
                    x = event.x
                    y = event.y
                }

                MotionEvent.ACTION_UP -> {
                    val dx = event.x - x
                    val dy = event.y - y

                    if (Math.abs(dy) > Math.abs(dx)) {
                        if (dy < 0 ) {
                            if (currentEmotion != 5) {
                                currentEmotion++
                            }
                            println("Swiped up current emotion is " + currentEmotion)
                           emotionValueChanger()// Statement for swiping up
                        } else {
                            if(currentEmotion != 1) {
                                currentEmotion--
                            }
                            println("Swiped down " + currentEmotion)
                          emotionValueChanger()// Statement for swiping down
                        }
                    }
                }
            }

            true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun emotionValueChanger(){
                if (currentEmotion == 1){
            binding.emoteChangerView.setImageResource(R.drawable.smiley_super_happy)
                    binding.fragmentFirst.setBackgroundColor(Color.parseColor("#0000FF"))
        }

        else if (currentEmotion == 2 ){
            binding.emoteChangerView.setImageResource(R.drawable.smiley_happy)
                    binding.fragmentFirst.setBackgroundColor(Color.parseColor("#00FF00"))
                }

        else if (currentEmotion == 3){
            binding.emoteChangerView.setImageResource(R.drawable.smiley_normal)
                    binding.fragmentFirst.setBackgroundColor(Color.parseColor("#FF03DAC5"))
        }

        else if (currentEmotion == 4){
            binding.emoteChangerView.setImageResource(R.drawable.smiley_disappointed)
                    binding.fragmentFirst.setBackgroundColor(Color.parseColor("#808080"))
                }

        else if (currentEmotion == 5){
            binding.emoteChangerView.setImageResource(R.drawable.smiley_sad)
                    binding.fragmentFirst.setBackgroundColor(Color.parseColor("#FF0000"))
                }
    }

    fun saveSharedPref(mood:String, comment:String){
        val sharedPref = requireContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val dayOfWeek = getDayOfWeek()
        var colourMood = ""

        if(mood == "1" ){
            colourMood = "#0000FF"
        }

        else if(mood == "2" ){
            colourMood = "#00FF00"
        }

        else if(mood == "3" ){
            colourMood = "#FF03DAC5"
        }

        else if(mood == "4" ){
            colourMood = "#808080"
        }

        else if(mood == "5" ){
            colourMood = "#FF0000"
        }

        editor.putString(dayOfWeek+"emotion", colourMood)
        editor.putString(dayOfWeek+"comment", comment)
        editor.putInt("age", 31)
        editor.apply()
    }




    fun loadSharedPref(){
        val sharedPref = requireContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        val dayOfWeek = getDayOfWeek()
        val emotion = sharedPref.getString(dayOfWeek+"emotion", "")
        val comment = sharedPref.getString(dayOfWeek+"comment", "")
println("The current day is $dayOfWeek")
        println("The current emotion is $emotion and the comment is $comment" )
    }

    fun getDayOfWeek():String{
        val calendar = Calendar.getInstance()
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        var dayOftheWeek = "Fail"

        when (dayOfWeek) {
            Calendar.MONDAY -> dayOftheWeek = "mon"
            Calendar.TUESDAY -> dayOftheWeek = "tue"
            Calendar.WEDNESDAY -> dayOftheWeek = "wed"
            Calendar.THURSDAY -> dayOftheWeek = "thu"
            Calendar.FRIDAY -> dayOftheWeek = "fri"
            Calendar.SATURDAY -> dayOftheWeek = "sat"
            Calendar.SUNDAY -> dayOftheWeek = "sun"
        }

return dayOftheWeek

    }

}