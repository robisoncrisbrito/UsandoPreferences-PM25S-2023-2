package br.edu.utfpr.usandopreferences_pm25s_2023_2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

private const val PREFERENCE = "PREFERENCE_NAME"

class MainActivity : AppCompatActivity() {

    private lateinit var ivEstrela : ImageView
    private lateinit var sharedPreference : SharedPreferences

    var ligado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivEstrela = findViewById( R.id.ivEstrela )

        sharedPreference = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE )

        ligado = lerEstado()

        when ( ligado ) {
            true -> ivEstrela.setImageResource( android.R.drawable.star_big_on )
            false -> ivEstrela.setImageResource( android.R.drawable.star_big_off )
        }
    }

    private fun lerEstado(): Boolean {
        val estado = sharedPreference.getBoolean( "ligado", false )
        return estado
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

        salvarEstado( ligado )

    }

    private fun salvarEstado(ligado: Boolean) {
        var editor = sharedPreference.edit()
        editor.putBoolean( "ligado", ligado )
        editor.commit()
    }

    fun btPreferenceOnClick(view: View) {
        val intent = Intent( this, SettingsActivity::class.java)
        startActivity( intent )
    }
}