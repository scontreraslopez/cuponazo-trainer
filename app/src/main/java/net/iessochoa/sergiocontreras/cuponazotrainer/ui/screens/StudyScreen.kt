package net.iessochoa.sergiocontreras.cuponazotrainer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.cuponazotrainer.data.NumerosInMemoryRepository
import net.iessochoa.sergiocontreras.cuponazotrainer.ui.components.TerminacionCard
import net.iessochoa.sergiocontreras.cuponazotrainer.ui.components.imagen
import net.iessochoa.sergiocontreras.cuponazotrainer.ui.theme.CuponazoTrainerTheme

/**
 * Project: Cuponazo Trainer
 * From: net.iessochoa.sergiocontreras.cuponazotrainer.ui.screens
 * Created by: Contr
 * On: 23/10/2026 at 14:00
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun StudyScreen(
    modifier: Modifier = Modifier
) {
    val repository = NumerosInMemoryRepository
    val allTerminaciones = repository.TERMINACIONES

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        allTerminaciones.chunked(2).forEach { pair ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                pair.forEach { terminacion ->
                    TerminacionCard(
                        codigo = terminacion.codigo,
                        nombre = terminacion.nombre,
                        cardImage = terminacion.imagen
                    )
                }
            }
            Spacer(modifier=Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudyScreenPreview() {
    CuponazoTrainerTheme() {
        StudyScreen(

        )
    }
}


