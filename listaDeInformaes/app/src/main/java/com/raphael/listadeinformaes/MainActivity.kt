package com.raphael.listadeinformaes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Cria um adapter
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)

        //Liga o adapter ao listView
        listView.adapter = adapter

        //Configura o evento de clique do botão
        button.setOnClickListener {
            //Verifica se o editText está vazio
            if(editText.text.isEmpty()){
                editText.error = "Por favor preencher esse dado"
            } else{
                val dado = editText.text.toString()
                adapter.add(dado)
                editText.text.clear()
            }
        }
        
        //Configura evento de toque do listView
        listView.setOnItemClickListener { parent, view, position, id ->
            val item = adapter.getItem(position)
            Toast.makeText(applicationContext, "Olá ${item}", Toast.LENGTH_SHORT)
                .show()
            true
        }

        //Configura o evento de long click
        listView.setOnItemLongClickListener { parent, view, position, id ->
            val item = adapter.getItem(position)
            adapter.remove(item)
            true
        }
    }
}
