package net.iessochoa.sergiocontreras.cuponazotrainer.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.iessochoa.sergiocontreras.cuponazotrainer.R
import net.iessochoa.sergiocontreras.cuponazotrainer.ui.theme.numeroCupon

@Composable
fun TerminacionCard(
    codigo: String,
    nombre: String,
    modifier: Modifier = Modifier,
    @DrawableRes cardImage: Int = R.drawable.ic_launcher_foreground,
    ) {
    Card(
        modifier = modifier
            .size(width = 150.dp, height = 300.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Color.Black
        )
    ) {
        Column {
            Box (
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    painterResource(cardImage), contentDescription = "Imagen de la carta: " +
                            "terminación $codigo $nombre"
                )
                Text(
                    text = codigo,
                    style = MaterialTheme.typography.numeroCupon,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp, top = 8.dp),
                    textAlign = TextAlign.End
                )
            }
            HorizontalDivider(
                thickness = 1.dp,
                color = Color.Black
            )
            Text(
                text = nombre,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun TerminacionCardPreview() = TerminacionCard(
    codigo = "25",
    nombre = "el cañón"
)