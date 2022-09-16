package com.anzeh.apptheme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anzeh.app_theme.data.AppThemeEnums
import com.anzeh.app_theme.utils.disableDarkTheme
import com.anzeh.app_theme.utils.enableDarkTheme
import com.anzeh.app_theme.utils.enableSettingsThemeApp
import com.anzeh.app_theme.utils.getSavedTheme
import com.anzeh.apptheme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSavedAppTheme()
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.rbDark.setOnCheckedChangeListener { _, p1 ->
            if (p1) {
                enableDarkTheme()
                binding.tvAppCurrentTheme.text = getString(R.string.dark)
            }
        }

        binding.rbLight.setOnCheckedChangeListener { _, p1 ->
            if (p1) {
                disableDarkTheme()
                binding.tvAppCurrentTheme.text = getString(R.string.light)
            }
        }
        binding.rbSystem.setOnCheckedChangeListener { _, p1 ->
            if (p1) {
                enableSettingsThemeApp()
                binding.tvAppCurrentTheme.text = getString(R.string.system)
            }
        }
    }

    private fun getSavedAppTheme() {
        when (getSavedTheme()) {
            AppThemeEnums.LIGHT -> {
                binding.rbLight.isChecked = true
                disableDarkTheme()
                binding.tvAppCurrentTheme.text = getString(R.string.light)
            }
            AppThemeEnums.DARK -> {
                binding.rbDark.isChecked = true
                enableDarkTheme()
                binding.tvAppCurrentTheme.text = getString(R.string.dark)
            }
            AppThemeEnums.SETTING -> {
                binding.rbSystem.isChecked = true
                enableSettingsThemeApp()
                binding.tvAppCurrentTheme.text = getString(R.string.system)
            }
        }

    }
}