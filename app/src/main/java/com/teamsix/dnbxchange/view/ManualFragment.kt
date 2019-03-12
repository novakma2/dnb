package com.teamsix.dnbxchange.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.teamsix.dnbxchange.R
import com.teamsix.dnbxchange.model.SharedValue
import kotlinx.android.synthetic.main.fragment_manual.*

class ManualFragment : Fragment() {
    private lateinit var sharedValue: SharedValue
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_manual, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        activity?.let {
            sharedValue = ViewModelProvider.AndroidViewModelFactory.getInstance(this.activity!!.application)
                .create(SharedValue::class.java)
        }
        editConvert.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                sharedValue.number.postValue(editConvert.text.toString().toBigDecimal())
            }
        })
    }
}