package com.proa.futuramamvvm.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.proa.futuramamvvm.R
import com.proa.futuramamvvm.view.home.MainActivity

/**
 * A simple [Fragment] subclass.
 * Use the [HomeNavigationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeNavigationFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_navigation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Aqui deberia bindiear el boton para que me pase a la pantalla de consumo
        /*openButtonR.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }*/
    }

}