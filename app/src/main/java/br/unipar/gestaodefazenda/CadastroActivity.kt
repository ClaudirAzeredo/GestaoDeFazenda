package br.unipar.gestaodefazenda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class CadastroActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.cadastro_activity)

            val viewPager = findViewById<ViewPager>(R.id.viewPager)
            val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

            // Configurando o adapter para o ViewPager
            val adapter = object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
                override fun getCount(): Int = 2

                override fun getItem(position: Int): Fragment {
                    // Retorna o fragmento correspondente com base na posição da aba
                    return when (position) {
                        0 -> CadastroAnimal()  // Aba 0 -> Cadastro de Animais
                        1 -> CadastroPlanta()  // Aba 1 -> Cadastro de Plantas
                        else -> throw IllegalStateException("Invalid position $position")
                    }
                }

                override fun getPageTitle(position: Int): CharSequence {
                    // Define o título da aba com base na posição
                    return when (position) {
                        0 -> "Animais"
                        1 -> "Plantas"
                        else -> ""
                    }
                }
            }

            // Configura o ViewPager e o TabLayout com o adapter
            viewPager.adapter = adapter
            tabLayout.setupWithViewPager(viewPager)
        }
    }

