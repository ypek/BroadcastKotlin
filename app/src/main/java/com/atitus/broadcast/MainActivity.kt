package com.atitus.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var broadcastReceiver: MyBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa o BroadcastReceiver
        broadcastReceiver = MyBroadcastReceiver()

        // Registra o BroadcastReceiver para ouvir o broadcast específico
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.atitus.broadcast.MEU_BROADCAST")
        registerReceiver(broadcastReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Desregistra o BroadcastReceiver ao destruir a atividade
        unregisterReceiver(broadcastReceiver)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    inner class MyBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            // Recebe o broadcast e executa a lógica desejada
            if (intent?.action == "com.atitus.broadcast.MEU_BROADCAST") {
                // Interage com a tela aqui
                // Por exemplo, exibe um Toast com a mensagem
                showToast("Broadcast Recebido!")
            }
        }
    }
}
