package br.unipar.gestaodefazenda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCadastro = findViewById<Button>(R.id.btnCadastro)
        val btnFinancas = findViewById<Button>(R.id.btnFinancas)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        // Navegação via botões
        btnCadastro.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

        btnFinancas.setOnClickListener {
            startActivity(Intent(this, FinancasActivitiy::class.java))
        }

        // Navegação via Navigation Drawer
        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_cadastro -> {
                    startActivity(Intent(this, CadastroActivity::class.java))
                    true
                }
                R.id.nav_financas -> {
                    startActivity(Intent(this, FinancasActivitiy::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
