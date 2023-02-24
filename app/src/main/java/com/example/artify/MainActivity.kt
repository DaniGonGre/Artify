package com.example.artify

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    // definir el requestCode
    val RESULTADO_UNO = 1
    val RESULTADO_DOS = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bCamara = findViewById<Button>(R.id.bCamara)
        val bArtify = findViewById<Button>(R.id.bArtify)

        bCamara.setOnClickListener {
            // Crea un Intent para iniciar la actividad
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
                takePictureIntent.resolveActivity(packageManager)?.also {
                    startActivityForResult(takePictureIntent, RESULTADO_UNO)
                }
            }

        }

    }


    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val imagen = findViewById<ImageView>(R.id.imagen)

        if (requestCode == RESULTADO_UNO && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imagen.setImageBitmap(imageBitmap)
        }

    }
}
