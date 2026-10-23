package net.iessochoa.sergiocontreras.cuponazotrainer.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.cuponazotrainer.data.NumerosInMemoryRepository
import net.iessochoa.sergiocontreras.cuponazotrainer.ui.components.TerminacionCard

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
    val repository = NumerosInMemoryRepository
    var terminacion by remember {mutableStateOf(repository.getRandomTerminacion())}
    val onRefresh = { terminacion = repository.getRandomTerminacion() }

    Column(
        modifier = modifier
    ) {
        TerminacionCard(
            codigo = terminacion.codigo,
            nombre = terminacion.nombre
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