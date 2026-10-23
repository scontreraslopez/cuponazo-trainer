package net.iessochoa.sergiocontreras.cuponazotrainer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.iessochoa.sergiocontreras.cuponazotrainer.ui.theme.CuponazoTrainerTheme

/**
 * Project: Cuponazo Trainer
 * From: net.iessochoa.sergiocontreras.cuponazotrainer
 * Created by: Contr
 * On: 23/10/2026 at 13:59
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun CuponazoTrainerApp() {
    CuponazoTrainerTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Text(
                text = "Hello, Cuponazo Trainer!",
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}