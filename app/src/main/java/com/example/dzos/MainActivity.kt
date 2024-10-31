package com.example.dzos

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(),  View.OnClickListener {

    private lateinit var toolbarMain: Toolbar
    private lateinit var textET:EditText
    private lateinit var randomBTN: Button
    private lateinit var randomTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Оценка за урок"
        toolbarMain.subtitle = "версия 1"
        toolbarMain.setLogo(R.drawable.ic_android_black_24dp)
        textET = findViewById(R.id.editText)
        registerForContextMenu(textET)

        randomBTN = findViewById(R.id.randomBTN)
        randomBTN.setOnClickListener(this)

        randomTV = findViewById(R.id.randomTV)
        registerForContextMenu(randomTV)
    }
        val listNum = (1..50)

        override fun onClick(v: View) {
            when(v.id) {
                R.id.randomBTN -> {
                    val ranNum = listNum.random().toString()
                    randomTV.text = ranNum
                    randomTV.setBackgroundResource(R.color.white)
                    Toast.makeText(this,
                        "Случайное число сгенерировано",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        when(v?.id) {
            R.id.editText -> menuInflater.inflate(R.menu.context_menu, menu)
            R.id.randomTV -> menuInflater.inflate(R.menu.menu_random_, menu)
        }
    }

    @SuppressLint("ResourceAsColor")
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.chen_color -> {
                val inputInt: String = textET.text.toString()
                when (inputInt) {
                    "1" -> {
                        textET.setBackgroundResource(R.color.orange)
                        Toast.makeText(
                            this,
                            "Оранжевая оценка",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    "2" -> {
                        textET.setBackgroundResource(R.color.yellow)
                        Toast.makeText(
                            this,
                            "Желтая оценка",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    "3" -> {
                        textET.setBackgroundResource(R.color.green)
                        Toast.makeText(
                            this,
                            "Зеленая оценка",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    "4" -> {
                        textET.setBackgroundResource(R.color.blue)
                        Toast.makeText(
                            this,
                            "Синяя оценка",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    "5" -> {
                        textET.setBackgroundResource(R.color.red)
                        Toast.makeText(
                            this,
                            "Красная оценка",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    else -> Toast.makeText(
                        this,
                        "Ошибка! Необходимо ввести цифру от 1 до 5",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            R.id.clean -> {

                textET.text.clear()
                textET.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                Toast.makeText(this, "Очистка поля ввода", Toast.LENGTH_SHORT).show()
            }

            R.id.exit -> {
                finish()
                Toast.makeText(this, "Завершение работы приложения", Toast.LENGTH_SHORT).show()
            }


            R.id.menu_random_number -> {
                val randomNumber = Integer.parseInt(randomTV.text.toString())
                when (randomNumber) {
                    in 1..10 -> {
                        randomTV.setBackgroundResource(R.color.red)
                        Toast.makeText(
                            this,
                            "$randomNumber - Красный цвет",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    in 11..20 -> {
                        randomTV.setBackgroundResource(R.color.orange)
                        Toast.makeText(
                            this,
                            "$randomNumber - Оранжевый цвет",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    in 21..30 -> {
                        randomTV.setBackgroundResource(R.color.yellow)
                        Toast.makeText(
                            this,
                            "$randomNumber - Жёлтый цвет",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    in 31..40 -> {
                        randomTV.setBackgroundResource(R.color.green)
                        Toast.makeText(
                            this,
                            "$randomNumber - Зелёный цвет",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    in 41..50 -> {
                        randomTV.setBackgroundResource(R.color.blue)
                        Toast.makeText(
                            this,
                            "$randomNumber - Синий цвет",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                    else -> {
                        randomTV.setBackgroundResource(R.color.white)
                        Toast.makeText(
                            this,
                            "Число вне диапазона",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
            else -> {
                return super.onContextItemSelected(item)
            }
        }
        return true
    }
}
