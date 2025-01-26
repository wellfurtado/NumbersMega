package br.com.livrokotlin.ganheinamega

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //buscar objetos de tela (activity_main.xml) para ter referências dentro do codigo
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        //Banco de dados de PReferencias
        prefs = getSharedPreferences("db", MODE_PRIVATE)
        val result = prefs.getString("result", null)
        if (result != null) {
            txtResult.text = "Última aposta: $result"
        }


        btnGenerate.setOnClickListener {
            val text = editText.text.toString()
            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        if (text.isNotEmpty()) {
            val qtd = text.toIntOrNull() // Evita crash caso o usuário insira um valor inválido

            if (qtd == null || qtd < 6 || qtd > 15) {
                Toast.makeText(this, "Informe um número entre 6 e 15", Toast.LENGTH_LONG).show()
                return
            }

            // Criar um conjunto (set) para evitar números duplicados
            val numbers = mutableSetOf<Int>()

            while (numbers.size < qtd) {
                numbers.add(Random.nextInt(1, 61)) // Gera um número entre 1 e 60
            }

            val resultText = numbers.joinToString(" - ") // Formata a saída como "12 - 23 - 45..."
            txtResult.text = resultText // Exibir resultado no TextView

            //Salvando no banco de dados local (Preferencias)
            val editor = prefs.edit()
            editor.putString("result", txtResult.text.toString())
            editor.apply()

            Log.i("TESTE", "Números sorteados: $resultText")
        } else {
            Toast.makeText(this, "Informe um número válido!", Toast.LENGTH_LONG).show()
        }
    }
}










/*
//ESCUTANDO O EVENTO DE CLICK NO BOTÃO
//OPÇÃO 01 - XML
//OPÇÃO 02 - criar variavel do tipo View.OnClickListener  (Interface)
//OPÇÃO 03 - bloco de codigo disparado direto

//OPÇÃO 03
btnGenerate.setOnClickListener {
    Log.i("Teste03", "Botão Clicado")
}

        //OPÇÃO 02
        btnGenerate.setOnClickListener(buttonClickedListener)

    private val buttonClickedListener = View.OnClickListener { Log.i("Teste02", "Botão Clicado") }
}


        //OPÇÃO 01 - XML
    no arquivo activity_main.xml no bloco do botão, adiciona a linha android:onClick="buttonClicked"
    Depois cria a função abaixo dentro da classe MainActivity (ou onde precisa chamar)

    fun buttonClicked(view: View) {
        //escutando o evento de click no botão
        Log.i("Teste01", "Botão Clicado") //teste pra saber se está funcionando, vai aparecer no logcat
    }
*/
