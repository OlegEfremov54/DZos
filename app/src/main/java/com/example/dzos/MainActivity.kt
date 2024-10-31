package com.example.dzos

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var toolbarMain: Toolbar
    private lateinit var textET:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        toolbarMain=findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title="Оценка за урок"
        toolbarMain.subtitle="версия 1"
        toolbarMain.setLogo(R.drawable.ic_android_black_24dp)
        textET=findViewById(R.id.editText)
        registerForContextMenu(textET)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu,menu)
    }

    @SuppressLint("ResourceAsColor")
    override fun onContextItemSelected(item: MenuItem): Boolean {
//var a:Int=textET.text.toInt()
        when(item.itemId){
            R.id.chen_color-> when(textET.toString().toInt()) {

                1 -> {
                    textET.setBackgroundColor(R.color.orange)
                    Toast.makeText(this, "ОРАНЖЕВЫЙ цвет оценки ", Toast.LENGTH_SHORT).show()
                }

                2 -> {
                    textET.setBackgroundColor(R.color.yellow)
                    Toast.makeText(this, "ЖЕЛТЫЙ цвет оценки ", Toast.LENGTH_SHORT).show()
                }

                3 -> {
                    textET.setBackgroundColor(R.color.green)
                    Toast.makeText(this, "ЗЕЛЕНЫЙ цвет оценки ", Toast.LENGTH_SHORT).show()
                }

                4 -> {
                    textET.setBackgroundColor(R.color.blue)
                    Toast.makeText(this, "СИНИЙ цвет оценки ", Toast.LENGTH_SHORT).show()
                }

                5 -> {
                    textET.setBackgroundColor(R.color.red)
                    Toast.makeText(this, "КРАСНЫЙ цвет оценки ", Toast.LENGTH_SHORT).show()
                }
                else ->{textET.setBackgroundColor(R.color.white)
                    Toast.makeText(this, "Введите оценку от 1 до 5", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.clean->{

                textET.text.clear()
                textET.setBackgroundColor(R.color.white)
                Toast.makeText(this, "Очистка поля ввода", Toast.LENGTH_SHORT).show()
            }
            R.id.exit->{
                finish()
                Toast.makeText(this, "Завершение работы приложения", Toast.LENGTH_SHORT).show()
            }
            else -> {
                return super.onContextItemSelected(item)
            }
        }
        return true
    }
}
