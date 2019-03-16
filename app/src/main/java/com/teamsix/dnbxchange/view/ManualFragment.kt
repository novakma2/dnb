package com.teamsix.dnbxchange.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.teamsix.dnbxchange.DataAccess
import com.teamsix.dnbxchange.model.SharedValue
import it.sephiroth.android.library.uigestures.UIGestureRecognizer
import it.sephiroth.android.library.uigestures.UIGestureRecognizerDelegate
import it.sephiroth.android.library.uigestures.UISwipeGestureRecognizer
import kotlinx.android.synthetic.main.fragment_manual.*


class ManualFragment : Fragment() {
    lateinit var sharedValue: SharedValue
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.teamsix.dnbxchange.R.layout.fragment_manual, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val delegate = UIGestureRecognizerDelegate()
        val swipeleft = UISwipeGestureRecognizer(this.context!!.applicationContext)
        swipeleft.direction = UISwipeGestureRecognizer.LEFT
        swipeleft.numberOfTouchesRequired = 1
        swipeleft.tag = "SwipeLeft"
        swipeleft.actionListener = swipeFragment
        delegate.addGestureRecognizer(swipeleft)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        sharedValue = DataAccess.sharedValue
        editConvert.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s!!.isNotEmpty()) {
                    sharedValue.number.postValue(s.toString().toBigDecimal())
                }
            }

        })
        super.onActivityCreated(savedInstanceState)

    }


    private val swipeFragment = { _: UIGestureRecognizer ->
        {
            Toast.makeText(this.requireContext(), "Swipe left", Toast.LENGTH_SHORT).show()
        }
    }
}