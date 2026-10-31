package net.iessochoa.sergiocontreras.cuponazotrainer.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.cuponazotrainer.data.NumerosInMemoryRepository
import net.iessochoa.sergiocontreras.cuponazotrainer.ui.components.TerminacionCard
import net.iessochoa.sergiocontreras.cuponazotrainer.ui.components.imagen

/**
 * Project: Cuponazo Trainer
 * From: net.iessochoa.sergiocontreras.cuponazotrainer.ui.screens
 * Created by: Contr
 * On: 23/10/2026 at 14:00
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val repository = NumerosInMemoryRepository
    var terminacion by remember {mutableStateOf(repository.getRandomTerminacion())}
    val onRefresh = {
        terminacion = repository.getRandomTerminacion()
        Toast.makeText(context, "Terminación actualizada", Toast.LENGTH_SHORT).show()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TerminacionCard(
            codigo = terminacion.codigo,
            nombre = terminacion.nombre,
            cardImage = terminacion.imagen
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = onRefresh

        ) {
            Text("Refrescar")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() = MainScreen()