package com.example.ifwhenapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ifwhenapp.ui.theme.IfWhenAppTheme

//Вариант 5. Ввести символ.
// Если символ не латинская строчная (маленькая) буква – вывести сообщение
// и закончить выполнение программы,
// иначе, если это буквы a, i, e, o, u – вывести сообщение: «Это гласные буквы»,
// для других значений – «Возможно, это согласные буквы».

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView (R.layout.activity_main)

        val sym: EditText = findViewById(R.id.sym)
        val check: Button = findViewById(R.id.check)
        val result: TextView = findViewById(R.id.result)

        check.setOnClickListener(){
            val input = sym.text.toString()

            if (input.isEmpty()){
                result.text = "Введите символ"
                return@setOnClickListener
            }

            val char = input[0]

            if (char !in 'a'..'z'){
                result.text = "Это не маленькая латинская буква"
                return@setOnClickListener
            }

            when(char){
                'a', 'i', 'e', 'o', 'u' -> result.text = "Это гласная буква"
                else -> result.text = "Возможно, это согласная буква"
            }
        }

    }
}