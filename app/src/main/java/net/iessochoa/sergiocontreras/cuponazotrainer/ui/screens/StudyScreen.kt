package net.iessochoa.sergiocontreras.cuponazotrainer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                pair.forEach { terminacion ->
                    TerminacionCard(
                        codigo = terminacion.codigo,
                        nombre = terminacion.nombre,
                        cardImage = terminacion.imagen
                    )
                }
            }

        }
    }
}


