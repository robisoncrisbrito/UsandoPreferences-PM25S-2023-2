package br.edu.utfpr.usandopreferences_pm25s_2023_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var ivEstrela : ImageView

    var ligado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivEstrela = findViewById( R.id.ivEstrela )
    }

    fun btOnOffOnClick(view: View) {

        when ( ligado ) {
            true -> {
               ivEstrela.setImageResource( android.R.drawable.star_big_off)
            }
            false -> {
                ivEstrela.setImageResource( android.R.drawable.star_big_on)
            }
        }

        ligado = !ligado

    }
}