package com.example.voiceassistant

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.SpeechRecognizer
import android.speech.tts.TextToSpeech
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.voiceassistant.assistant.AssistantActivity
import com.example.voiceassistant.assistant.AssistantViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var imageActionButton: ImageButton
    val RecordAudioRequestCode: Int = 1

//    private lateinit var assistantViewModel: AssistantViewModel

//    private lateinit var textToSpeech: TextToSpeech
//    private lateinit var keeper: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageActionButton = findViewById(R.id.action_button)
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            checkPermission()
        }

        imageActionButton.setOnClickListener {
            startActivity(Intent(this, AssistantActivity::class.java))
        }

    }

//    fun speak(text: String) {
//        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
//        assistantViewModel.sendMessageToDatabase(keeper, text)
//    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == RecordAudioRequestCode && grantResults.size>0) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun checkPermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.RECORD_AUDIO),
                RecordAudioRequestCode
            )
        }
    }

}