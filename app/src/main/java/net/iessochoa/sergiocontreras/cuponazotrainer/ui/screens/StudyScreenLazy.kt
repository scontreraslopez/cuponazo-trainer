package net.iessochoa.sergiocontreras.cuponazotrainer.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
fun StudyScreenLazySingleItem(
    modifier: Modifier = Modifier
) {
    val repository = NumerosInMemoryRepository
    val allTerminaciones = repository.TERMINACIONES

    val singleTerminacion = allTerminaciones.random()

    LazyColumn(modifier = modifier){
        item {
            TerminacionCard(
                codigo = singleTerminacion.codigo,
                nombre = singleTerminacion.nombre,
                cardImage = singleTerminacion.imagen
            )

        }
    }
}


@Composable
fun StudyScreenLazyGrid(
    modifier: Modifier = Modifier
) {
    val repository = NumerosInMemoryRepository
    val allTerminaciones = repository.TERMINACIONES

    // Agrupa por decena: 0 -> 0-9, 1 -> 10-19, 2 -> 20-29...
    val terminacionesPorDecena = remember(allTerminaciones) {
        allTerminaciones
            .groupBy { it.codigo.toString().toInt() / 10 }
            .toSortedMap()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        terminacionesPorDecena.forEach { (decena, terminaciones) ->
            val inicio = decena * 10
            val fin = inicio + 9

            stickyHeader(key = "header_$decena") {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Terminaciones $inicio-$fin",
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }

            items(
                items = terminaciones,
                key = { it.codigo.toString() }
            ) { singleTerminacion ->
                TerminacionCard(
                    codigo = singleTerminacion.codigo,
                    nombre = singleTerminacion.nombre,
                    cardImage = singleTerminacion.imagen
                )
            }
        }
    }
}


@Composable
fun StudyScreenLazyColumnFull(
    modifier: Modifier = Modifier
) {
    val repository = NumerosInMemoryRepository
    val allTerminaciones = repository.TERMINACIONES

    LazyColumn(
        modifier = modifier
    ){
        items(allTerminaciones) { singleTerminacion ->
            TerminacionCard(
                codigo = singleTerminacion.codigo,
                nombre = singleTerminacion.nombre,
                cardImage = singleTerminacion.imagen
            )

        }
    }
}



@Preview(showBackground = true)
@Composable
private fun StudyScreenLazySingleItemPreview() {
    CuponazoTrainerTheme() {
        StudyScreenLazySingleItem(

        )
    }
}


@Preview(showBackground = true)
@Composable
private fun StudyScreenLazyColumnFullPreview() {
    CuponazoTrainerTheme() {
        StudyScreenLazyColumnFull(
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun StudyScreenLazyGridPreview() {
    CuponazoTrainerTheme() {
        StudyScreenLazyGrid(
        )
    }
}



