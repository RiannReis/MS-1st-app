package co.tiagoaguiar.ganheinamega

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // aqui decide o que o app vai fazer
        setContentView(R.layout.activity_main)

        // buscar o objeto e ter a referência
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_click)

        //preferences database
        prefs = getSharedPreferences("db", Context.MODE_PRIVATE)
        val result = prefs.getString("result", null)

        /*if(result != null){
            txtResult.text = "Last numbers: $result"
        }*/

        result?.let {
            txtResult.text = "Previous numbers:\n $it"
        }

        /*EVENTOS DE TOUCH

        OP1: (XML)
        adiciona no XML do Button:
        android:onClick="buttonClicked"

        depois, fora da classe MainActivity adiciona a função:

        fun buttonClicked(view: View){
        Log.i("Teste", "Clicado!!")
    }

    OP2: (variável que sejado tipo (objeto anônimo) View.OnClickListener (interface) )

        adiciona dentro da classe MainActivity, depois de ter buscado o objeto e ter a referência:
        btnGenerate.setOnClickListener(buttonClickListener)

        depois, fora da classe MainActivity adiciona a função:

        val buttonClickListener = object : View.OnClickListener{
        override fun onClick(v: View?) {
            Log.i("Teste", "Clicado!!")
        }

        OP3: mais simples - bloco de código que será disparado pelo OnClickListener: */

        btnGenerate.setOnClickListener {

            val text = editText.text.toString()

            numberGenerator(text, txtResult)

        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        if (text.isEmpty()) {
            Toast.makeText(this, "Number must be between 6 and 15.", Toast.LENGTH_LONG).show()
            return
        }

        val quantity = text.toInt()

        if (quantity < 6 || quantity > 15) {
            Toast.makeText(this, "Number must be between 6 and 15 .", Toast.LENGTH_LONG).show()
            return
        }

        val numbers = mutableSetOf<Int>()
        val rand = Random()

        while (true) {
            val number = rand.nextInt(60)
            numbers.add(number + 1)

            if (numbers.size == quantity) {
                break
            }
        }

        txtResult.text = numbers.joinToString(" - ")

        val editor = prefs.edit()
        editor.putString("result", txtResult.text.toString())
        editor.apply()

        /*prefs.edit().apply {
            putString("result", txtResult.text.toString())
            apply()
        }*/

    }


}