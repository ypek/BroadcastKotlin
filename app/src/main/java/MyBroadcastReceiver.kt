package com.atitus.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // Recebe o broadcast e executa a lógica desejada
        if (intent?.action == "com.atitus.broadcast.MEU_BROADCAST") {
            // Interage com a tela aqui
            // Por exemplo, exibe um Toast com a mensagem
            showToast(context, "Broadcast Recebido!")
        }
    }

    private fun showToast(context: Context?, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
