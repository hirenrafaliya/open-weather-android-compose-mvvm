package com.application.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.application.base.common.AnimatedVisibilityFade
import com.application.base.common.SpacerS
import com.application.base.theme.MyColor
import com.application.base.theme.MyShape
import com.application.base.theme.MyTypography

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector = Icons.Rounded.Search,
    hint: String,
    text: String,
    onTextChange: (String) -> Unit,
    onIme: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    Column(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 12.dp,
                    spotColor = DefaultShadowColor.copy(0.55f),
                    shape = MyShape.round
                )
                .background(MyColor.accentPrimary, MyShape.round)
                .background(color = MyColor.bgTertiaryMuted.copy(0.25f), shape = MyShape.round)
                .border(0.8.dp, MyColor.bgPrimary.copy(0.25f), MyShape.round),
            contentAlignment = Alignment.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                SpacerS()
                Icon(
                    modifier = Modifier.size(28.dp),
                    imageVector = leadingIcon,
                    contentDescription = "",
                    tint = MyColor.bgPrimary
                )
                SpacerS()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), contentAlignment = Alignment.CenterStart
                ) {

                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 300.dp)
                            .padding(vertical = 12.dp),
                        value = text, onValueChange = onTextChange,
                        textStyle = MyTypography.SB16.copy(
                            MyColor.bgPrimary
                        ),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(
                            KeyboardCapitalization.Words,
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions(onSearch = {
                            focusManager.clearFocus()
                            onIme()
                        }),
                        cursorBrush = SolidColor(MyColor.bgPrimary)
                    )


                    AnimatedVisibilityFade(visible = text.isBlank()) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(),
                            text = hint,
                            style = MyTypography.N16,
                            color = MyColor.bgPrimary.copy(0.5f)
                        )
                    }
                }
            }
        }
    }
}