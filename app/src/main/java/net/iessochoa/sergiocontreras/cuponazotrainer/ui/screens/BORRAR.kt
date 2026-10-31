@file:OptIn(ExperimentalMaterial3Api::class)

package net.iessochoa.sergiocontreras.cuponazotrainer.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.AssistChip
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.cuponazotrainer.R
import net.iessochoa.sergiocontreras.cuponazotrainer.ui.theme.CuponazoTrainerTheme

/**
 * Project: Cuponazo Trainer
 * From: net.iessochoa.sergiocontreras.cuponazotrainer.ui.screens
 * Created by: Contr
 * On: 25/10/2026 at 18:29
 * Creado en Settings -> Editor -> File and Code Templates
 *
 * Previews para las capturas de T05 · Componentes de interfaz y mensajes.
 * Los diálogos, menús abiertos y el Toast no se pintan en la preview estática:
 * para esos hay una versión "maqueta" o hay que usar el modo interactivo.
 */

// region 1. Botones

@Preview(showBackground = true, name = "1.1 Cinco variantes")
@Composable
fun BotonesPreview() {
    CuponazoTrainerTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { }) { Text("Button") }
            FilledTonalButton(onClick = { }) { Text("FilledTonalButton") }
            ElevatedButton(onClick = { }) { Text("ElevatedButton") }
            OutlinedButton(onClick = { }) { Text("OutlinedButton") }
            TextButton(onClick = { }) { Text("TextButton") }
            Button(onClick = { }, enabled = false) { Text("Deshabilitado") }
        }
    }
}

@Preview(showBackground = true, name = "1.2 Botón con icono (ranura)")
@Composable
fun BotonConIconoPreview() {
    CuponazoTrainerTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { },
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_send),
                    contentDescription = null,
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Enviar")
            }
            OutlinedButton(onClick = { }) { Text("Cancelar") }
        }
    }
}

@Preview(showBackground = true, name = "1.3 Shape y colors")
@Composable
fun BotonPersonalizadoPreview() {
    CuponazoTrainerTheme {
        Button(
            onClick = { },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary
            ),
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Botón personalizado")
        }
    }
}

@Preview(showBackground = true, name = "1.4 Botones de icono")
@Composable
fun BotonesIconoPreview() {
    CuponazoTrainerTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { }) {
                Icon(painterResource(R.drawable.ic_delete), contentDescription = "Borrar")
            }
            FilledIconButton(onClick = { }) {
                Icon(painterResource(R.drawable.ic_delete), contentDescription = "Borrar")
            }
            FilledTonalIconButton(onClick = { }) {
                Icon(painterResource(R.drawable.ic_delete), contentDescription = "Borrar")
            }
            OutlinedIconButton(onClick = { }) {
                Icon(painterResource(R.drawable.ic_delete), contentDescription = "Borrar")
            }
        }
    }
}

@Preview(showBackground = true, name = "1.5 IconToggleButton")
@Composable
fun IconToggleButtonPreview() {
    CuponazoTrainerTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            listOf(false, true).forEach { esFavorito ->
                IconToggleButton(checked = esFavorito, onCheckedChange = { }) {
                    Icon(
                        painter = painterResource(
                            if (esFavorito) R.drawable.ic_favorite else R.drawable.ic_favorite_border
                        ),
                        contentDescription = "Favorito"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "1.6 FABs")
@Composable
fun FabsPreview() {
    CuponazoTrainerTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SmallFloatingActionButton(onClick = { }) {
                    Icon(painterResource(R.drawable.ic_add), contentDescription = "Nuevo")
                }
                FloatingActionButton(onClick = { }) {
                    Icon(painterResource(R.drawable.ic_add), contentDescription = "Nuevo")
                }
                LargeFloatingActionButton(onClick = { }) {
                    Icon(painterResource(R.drawable.ic_add), contentDescription = "Nuevo")
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ExtendedFloatingActionButton(
                    onClick = { },
                    icon = { Icon(painterResource(R.drawable.ic_edit), contentDescription = null) },
                    text = { Text("Redactar") }
                )
                ExtendedFloatingActionButton(
                    onClick = { },
                    expanded = false,
                    icon = { Icon(painterResource(R.drawable.ic_edit), contentDescription = null) },
                    text = { Text("Redactar") }
                )
            }
        }
    }
}

// endregion

// region 2. Menú desplegable

@Composable
fun DynamicSelectTextField(
    selectedValue: String,
    options: List<String>,
    label: String,
    onValueChangedEvent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = selectedValue,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable)
                .fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onValueChangedEvent(option)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}

private val frutas = listOf("Manzana", "Plátano", "Fresa", "Naranja")

@Preview(showBackground = true, name = "2.1 Desplegable cerrado (interactivo para abrirlo)")
@Composable
fun EjemploDropdownMenu() {
    val (seleccion, setSeleccion) = remember { mutableStateOf(frutas[1]) }
    CuponazoTrainerTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            DynamicSelectTextField(
                selectedValue = seleccion,
                options = frutas,
                label = "Fruta favorita",
                onValueChangedEvent = setSeleccion
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Has seleccionado: $seleccion")
        }
    }
}

/** Maqueta del menú abierto: el popup real no se pinta en la preview estática. */
@Preview(showBackground = true, name = "2.2 Desplegable abierto (maqueta)")
@Composable
fun DropdownAbiertoMaquetaPreview() {
    CuponazoTrainerTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            OutlinedTextField(
                value = frutas[0],
                onValueChange = {},
                readOnly = true,
                label = { Text("Fruta favorita") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = true) },
                modifier = Modifier.fillMaxWidth()
            )
            Surface(
                shape = MaterialTheme.shapes.extraSmall,
                color = MaterialTheme.colorScheme.surfaceContainer,
                shadowElevation = 3.dp,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(vertical = 8.dp)) {
                    frutas.forEach { fruta ->
                        DropdownMenuItem(
                            text = { Text(fruta) },
                            onClick = { },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
        }
    }
}

// endregion

// region 3. RatingBar

@Composable
fun RatingBar(
    rating: Int,
    onRatingChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    maxRating: Int = 5,
    starSize: Dp = 40.dp,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Row(modifier = modifier.selectableGroup()) {
        for (i in 1..maxRating) {
            Icon(
                painter = painterResource(
                    if (i <= rating) R.drawable.ic_star else R.drawable.ic_star_border
                ),
                contentDescription = "$i / $maxRating",
                tint = color,
                modifier = Modifier
                    .size(starSize)
                    .selectable(
                        selected = i == rating,
                        onClick = { onRatingChange(if (i == 1 && rating == 1) 0 else i) },
                        role = Role.RadioButton
                    )
            )
        }
    }
}

@Preview(showBackground = true, name = "3.1 RatingBar")
@Composable
fun RatingBarPreview() {
    val (rating, setRating) = remember { mutableIntStateOf(3) }
    CuponazoTrainerTheme {
        Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
            RatingBar(rating = rating, onRatingChange = setRating)
        }
    }
}

@Preview(showBackground = true, name = "3.2 RatingBar personalizado")
@Composable
fun RatingBarPreviewAlt() {
    var rating by remember { mutableIntStateOf(2) }
    CuponazoTrainerTheme {
        Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
            RatingBar(
                rating = rating,
                onRatingChange = { rating = it },
                starSize = 32.dp,
                color = Color(0xFFFFC107)
            )
        }
    }
}

// endregion

// region 4. Card

/** Hueco de color en lugar de imagen, para no depender de drawables del ejercicio. */
@Composable
private fun ImagenFalsa(texto: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .background(MaterialTheme.colorScheme.secondaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(texto, style = MaterialTheme.typography.displayMedium)
    }
}

@Preview(showBackground = true, name = "4.1 IngredienteCard")
@Composable
fun IngredienteCardPreview() {
    CuponazoTrainerTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("🧀" to "Queso", "🍄" to "Champiñón", "🍍" to "Piña").forEach { (emoji, nombre) ->
                Card(modifier = Modifier.width(120.dp)) {
                    ImagenFalsa(emoji)
                    Text(
                        text = nombre,
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "4.2 Tres variantes de Card")
@Composable
fun CardVariantesPreview() {
    CuponazoTrainerTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val contenido: @Composable (String) -> Unit = { nombre ->
                Text(
                    text = nombre,
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(100.dp)
                        .padding(vertical = 32.dp, horizontal = 8.dp)
                )
            }
            Card { contenido("Card") }
            ElevatedCard { contenido("ElevatedCard") }
            OutlinedCard { contenido("OutlinedCard") }
        }
    }
}

// endregion

// region 5. Diálogos

@Composable
private fun DialogoVaciar() {
    AlertDialog(
        onDismissRequest = { },
        icon = { Icon(painterResource(R.drawable.ic_warning), contentDescription = null) },
        title = { Text("¿Vaciar el pedido?") },
        text = { Text("Se quitarán todos los ingredientes.") },
        confirmButton = { TextButton(onClick = { }) { Text("Vaciar") } },
        dismissButton = { TextButton(onClick = { }) { Text("Cancelar") } }
    )
}

/** El AlertDialog real. Si la preview estática sale en blanco, usa el modo interactivo. */
@Preview(showBackground = true, widthDp = 360, heightDp = 400, name = "5.1 AlertDialog real")
@Composable
fun AlertDialogPreview() {
    CuponazoTrainerTheme {
        DialogoVaciar()
    }
}

/** Maqueta con el mismo aspecto que el AlertDialog, que sí sale siempre en la preview. */
@Preview(showBackground = true, name = "5.2 AlertDialog (maqueta)")
@Composable
fun AlertDialogMaquetaPreview() {
    CuponazoTrainerTheme {
        Box(modifier = Modifier.padding(24.dp)) {
            Surface(
                shape = AlertDialogDefaults.shape,
                color = AlertDialogDefaults.containerColor,
                tonalElevation = AlertDialogDefaults.TonalElevation,
                shadowElevation = 6.dp
            ) {
                Column(
                    modifier = Modifier
                        .width(312.dp)
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painterResource(R.drawable.ic_warning),
                        contentDescription = null,
                        tint = AlertDialogDefaults.iconContentColor
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        "¿Vaciar el pedido?",
                        style = MaterialTheme.typography.headlineSmall,
                        color = AlertDialogDefaults.titleContentColor
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        "Se quitarán todos los ingredientes.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = AlertDialogDefaults.textContentColor,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { }) { Text("Cancelar") }
                        TextButton(onClick = { }) { Text("Vaciar") }
                    }
                }
            }
        }
    }
}

// endregion

// region 6. Scaffold y TopAppBar

@Preview(showBackground = true, widthDp = 360, heightDp = 640, name = "6.1 Scaffold completo")
@Composable
fun ScaffoldPreview() {
    CuponazoTrainerTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Top app bar") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Text(
                        "Bottom app bar",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    Icon(painterResource(R.drawable.ic_add), contentDescription = "Añadir")
                }
            }
        ) { innerPadding ->
            Text(
                text = "Contenido de la pantalla. Recibe el innerPadding para no quedar " +
                        "tapado por las barras.",
                modifier = Modifier.padding(innerPadding).padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, name = "6.2 TopAppBar con ranuras")
@Composable
fun TopAppBarPreview() {
    CuponazoTrainerTheme {
        TopAppBar(
            title = { Text("Cuponazo Trainer") },
            navigationIcon = {
                IconButton(onClick = { }) {
                    Icon(painterResource(R.drawable.ic_arrow_back), contentDescription = "Volver")
                }
            },
            actions = {
                IconButton(onClick = { }) {
                    Icon(painterResource(R.drawable.ic_favorite_border), contentDescription = "Favorito")
                }
                IconButton(onClick = { }) {
                    Icon(painterResource(R.drawable.ic_share), contentDescription = "Compartir")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        )
    }
}

@Preview(showBackground = true, widthDp = 360, name = "6.3 Variantes de TopAppBar")
@Composable
fun TopAppBarVariantesPreview() {
    val menu: @Composable () -> Unit = {
        IconButton(onClick = { }) {
            Icon(painterResource(R.drawable.ic_menu), contentDescription = "Menú")
        }
    }
    CuponazoTrainerTheme {
        Column {
            TopAppBar(title = { Text("TopAppBar") }, navigationIcon = menu)
            HorizontalDivider()
            CenterAlignedTopAppBar(title = { Text("CenterAlignedTopAppBar") }, navigationIcon = menu)
            HorizontalDivider()
            MediumTopAppBar(title = { Text("MediumTopAppBar") }, navigationIcon = menu)
            HorizontalDivider()
            LargeTopAppBar(title = { Text("LargeTopAppBar") }, navigationIcon = menu)
        }
    }
}

// endregion

// region 7. Snackbar

@Preview(showBackground = true, widthDp = 360, name = "7.1 Snackbar simple y con acción")
@Composable
fun SnackbarPreview() {
    CuponazoTrainerTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Snackbar { Text("Pedido enviado") }
            Snackbar(
                action = { TextButton(onClick = { }) { Text("Deshacer") } }
            ) {
                Text("Ingrediente borrado")
            }
        }
    }
}

/** El Snackbar se pinta directamente en la ranura snackbarHost para la captura. */
@Preview(showBackground = true, widthDp = 360, heightDp = 640, name = "7.2 Snackbar en el Scaffold")
@Composable
fun SnackbarEnScaffoldPreview() {
    CuponazoTrainerTheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text("Cuponazo Trainer") }) },
            snackbarHost = {
                Snackbar(modifier = Modifier.padding(16.dp)) { Text("Sergio Contreras: Pizza") }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    Icon(painterResource(R.drawable.ic_favorite), contentDescription = "Mostrar mensaje")
                }
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding).fillMaxSize())
        }
    }
}

// endregion

// region 8. Otros componentes

@Composable
fun SliderConEtiqueta(
    etiqueta: String,
    valor: Float,
    onValorChange: (Float) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("$etiqueta: ${valor.toInt()}")
        Slider(
            value = valor,
            onValueChange = onValorChange,
            valueRange = 0f..255f
        )
    }
}

@Preview(showBackground = true, widthDp = 360, name = "8.1 Sliders RGB")
@Composable
fun SlidersPreview() {
    var r by remember { mutableFloatStateOf(149f) }
    var g by remember { mutableFloatStateOf(208f) }
    var b by remember { mutableFloatStateOf(115f) }
    CuponazoTrainerTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            SliderConEtiqueta("R", r, { r = it })
            SliderConEtiqueta("G", g, { g = it })
            SliderConEtiqueta("B", b, { b = it })
            Text("Color: (${r.toInt()}, ${g.toInt()}, ${b.toInt()})")
            Spacer(Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(
                        Color(r.toInt(), g.toInt(), b.toInt()),
                        RoundedCornerShape(16.dp)
                    )
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, name = "8.2 Slider con steps")
@Composable
fun SliderStepsPreview() {
    var valor by remember { mutableFloatStateOf(3f) }
    CuponazoTrainerTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Ingredientes: ${valor.toInt()}")
            Slider(
                value = valor,
                onValueChange = { valor = it },
                valueRange = 0f..5f,
                steps = 4
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, name = "8.3 Los cuatro chips")
@Composable
fun ChipsPreview() {
    CuponazoTrainerTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AssistChip(
                onClick = { },
                label = { Text("AssistChip") },
                leadingIcon = {
                    Icon(
                        painterResource(R.drawable.ic_share),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }
            )
            FilterChip(
                selected = true,
                onClick = { },
                label = { Text("FilterChip") },
                leadingIcon = {
                    Icon(
                        painterResource(R.drawable.ic_check),
                        contentDescription = null,
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            )
            InputChip(
                selected = false,
                onClick = { },
                label = { Text("InputChip") },
                trailingIcon = {
                    Icon(
                        painterResource(R.drawable.ic_delete),
                        contentDescription = "Quitar",
                        modifier = Modifier.size(InputChipDefaults.IconSize)
                    )
                }
            )
            SuggestionChip(onClick = { }, label = { Text("SuggestionChip") })
        }
    }
}

@Preview(showBackground = true, widthDp = 360, name = "8.4 FilterChip para ingredientes")
@Composable
fun FilterChipsPreview() {
    CuponazoTrainerTheme {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            listOf("Queso" to true, "Pepperoni" to true, "Piña" to false).forEach { (nombre, marcado) ->
                FilterChip(
                    selected = marcado,
                    onClick = { },
                    label = { Text(nombre) },
                    leadingIcon = if (marcado) {
                        {
                            Icon(
                                painter = painterResource(R.drawable.ic_check),
                                contentDescription = null,
                                modifier = Modifier.size(FilterChipDefaults.IconSize)
                            )
                        }
                    } else null
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, name = "8.5 Indicadores de progreso")
@Composable
fun ProgresoPreview() {
    CuponazoTrainerTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircularProgressIndicator()
                CircularProgressIndicator(progress = { 0.7f })
            }
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
            LinearProgressIndicator(progress = { 0.4f }, modifier = Modifier.fillMaxWidth())
        }
    }
}

// endregion
