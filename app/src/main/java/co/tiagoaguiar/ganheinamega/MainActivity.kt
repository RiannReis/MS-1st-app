package co.tiagoaguiar.ganheinamega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // aqui decide o que o app vai fazer
        setContentView(R.layout.activity_main)

        // buscar o objeto e ter a referência
        val editText: EditText = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: Button = findViewById(R.id.btn_click)

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
            Log.i("teste", "clicado!!")
        }
    }



}