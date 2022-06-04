package com.example.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(value: String, onValueChange: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = {
            if (!it.contains("\n"))
                onValueChange(it)
        },
        textStyle = TextStyle(fontSize = 17.sp, color = MaterialTheme.colors.onPrimary),
        trailingIcon = { Icon(Icons.Filled.Search, null, tint = MaterialTheme.colors.onPrimary) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(MaterialTheme.colors.primary, RoundedCornerShape(16.dp)),
        placeholder = { Text(text = "Search", color = MaterialTheme.colors.onPrimary.copy(alpha = 0.7f)) },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = MaterialTheme.colors.onSecondary
        )
    )
}