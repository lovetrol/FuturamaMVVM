package com.proa.futuramamvvm.view.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.proa.futuramamvvm.databinding.ActivityMainBinding
import com.proa.futuramamvvm.view.adapters.CharactersAdapter
import com.proa.futuramamvvm.viewmodel.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: CharacterViewModel by viewModels()

    lateinit var imagesCharacters: String
    lateinit var charactersAdapter: CharactersAdapter

    var imagesArray: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.characterResponse.observe(this, { charactersFutu ->
            binding.apply {
                for (characterS in charactersFutu){
                    imagesCharacters = characterS.images.imageCharacter
                    imagesArray.add(imagesCharacters)
                }
                charactersAdapter = CharactersAdapter(imagesArray)
                reciclerViewCharacterFuturama.setHasFixedSize(true)
                reciclerViewCharacterFuturama.layoutManager = LinearLayoutManager(this@MainActivity)
                reciclerViewCharacterFuturama.adapter = charactersAdapter
            }
        })
    }
}