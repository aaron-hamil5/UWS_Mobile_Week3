package org.uniqstudio.week3uws.ui.screens.premade

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.uniqstudio.week3uws.ui.theme.WindowSizeClass
import org.uniqstudio.week3uws.ui.theme.getWindowSizeClass
import uws_mobile_week3.composeapp.generated.resources.Res
import uws_mobile_week3.composeapp.generated.resources.alert_dialog_tap_anywhere
import uws_mobile_week3.composeapp.generated.resources.app_name
import uws_mobile_week3.composeapp.generated.resources.arrow_left
import uws_mobile_week3.composeapp.generated.resources.arrow_right
import uws_mobile_week3.composeapp.generated.resources.block_1
import uws_mobile_week3.composeapp.generated.resources.menu_vertical
import uws_mobile_week3.composeapp.generated.resources.settings
import uws_mobile_week3.composeapp.generated.resources.uniq_studio_logo
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    text: String,
    goBack: Boolean = true,
    menu: Boolean = false,
    onClickBack: () -> Unit,
    onClickMenu: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(if (getWindowSizeClass() == WindowSizeClass.Compact) 100.dp else 50.dp)
            .padding(top = if (getWindowSizeClass() == WindowSizeClass.Compact) 50.dp else 10.dp),
    ) {
        //Back Button
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            if (goBack) {
                IconButton(
                    onClick = onClickBack,
                    modifier = Modifier.size(50.dp)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.arrow_left),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        //Text and Image
        Column(
            modifier = Modifier
                .weight(5f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Row {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(25.dp)
                )
                Spacer(modifier = Modifier.size(5.dp))

                TextForUI(
                    text = text,
                    bold = true
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }

        //Balance it out
        Box(
            modifier = Modifier
                .weight(1f)
        ) {
            if (menu) {
                Box(modifier = Modifier.size(50.dp).align(Alignment.CenterEnd)) {
                    IconButton(
                        onClick = onClickMenu,
                        modifier = Modifier.size(50.dp)
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.menu_vertical),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar(
        modifier = Modifier,
        image = Res.drawable.uniq_studio_logo,
        text = stringResource(Res.string.app_name),
        goBack = true,
        menu = true,
        onClickBack = {},
        onClickMenu = {},
    )
}

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    bold: Boolean = false,
    extraThin: Boolean = false,
    largeText: Boolean = false,
    appNameSize: Boolean = false,
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineLarge,
        fontSize = if (appNameSize) 60.sp else if (largeText) 50.sp else 35.sp,
        fontWeight = if (bold) FontWeight.Bold else if (extraThin) FontWeight.ExtraLight else FontWeight.Normal,
        color = color
    )
}

@Preview
@Composable
fun TitleTextPreview() {
    Column {
        TitleText(text = "Normal Title Text")
        TitleText(text = "Bold Title Text", bold = true)
        TitleText(text = "Extra Thin Title Text", extraThin = true)
        TitleText(text = "Large Title Text", largeText = true)
    }
}

@OptIn(InternalResourceApi::class)
@Composable
fun TextForUI(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    bold: Boolean = false,
    extraThin: Boolean = false,
    fontSize: TextUnit = 20.sp,
    textAlign: TextAlign = TextAlign.Center
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.titleLarge,
        color = color,
        fontWeight = if (bold) FontWeight.Bold else if (extraThin) FontWeight.ExtraLight else FontWeight.Normal,
        fontSize = fontSize,
        textAlign = textAlign
    )
}

@Preview
@Composable
fun TextForUIPreview() {
    Column {
        TextForUI(text = "Normal Text")
        TextForUI(text = "Bold Text", bold = true)
        TextForUI(text = "Extra Thin Text", extraThin = true)
        TextForUI(text = "Large Text", fontSize = 50.sp)
        TextForUI(
            modifier = Modifier.fillMaxWidth(),
            text = "Center Text",
            textAlign = TextAlign.Center
        )
        TextForUI(modifier = Modifier.fillMaxWidth(), text = "End Text", textAlign = TextAlign.End)
    }
}


@Composable
fun SmallTextTitle(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodySmall,
        fontSize = 14.sp,
        color = color
    )
}

@Preview
@Composable
fun SmallTextTitlePreview() {
    SmallTextTitle(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    )
}

@Composable
fun DescriptionText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        fontSize = 15.sp,
        color = color
    )
}

@Preview
@Composable
fun DescriptionTextPreview() {
    DescriptionText(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi."
    )
}

@Composable
fun TitleAndParagraph(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    bold: Boolean = false
) {
    Column(
        modifier = modifier
    ) {
        TitleText(
            text = title,
            bold = bold,

            )
        Spacer(modifier = Modifier.size(10.dp))
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            DescriptionText(text = text)
        }
    }
}

@Preview
@Composable
fun TitleAndParagraphPreview() {
    TitleAndParagraph(
        title = "Title text",
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi."
    )
}


@Composable
fun BlankSpaceFiller(
    modifier: Modifier = Modifier
) {
    Spacer(modifier = modifier.size(150.dp))
}

@Preview
@Composable
fun BlankSpaceFillerPreview() {
    BlankSpaceFiller()
}


@Composable
fun NextButton(
    modifier: Modifier = Modifier,
    backButton: Boolean = false,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        if (backButton) {
            IconButton(
                onClick = onClickBack,
                modifier = Modifier.size(75.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.arrow_left),
                    contentDescription = null,
                    modifier = Modifier
                        .size(75.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
        BlankSpaceFiller(modifier = Modifier.weight(1f))
        //Next button
        IconButton(
            onClick = onClickNext,
            modifier = Modifier.size(150.dp)
        ) {
            Icon(
                painter = painterResource(Res.drawable.arrow_right),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp),
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview
@Composable
fun NextButtonPreview() {
    Column {
        NextButton(
            onClickBack = {},
            onClickNext = {}
        )
        NextButton(
            backButton = true,
            onClickBack = {},
            onClickNext = {}
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DualButton(
    modifier: Modifier = Modifier,
    icon: DrawableResource? = null,
    text: String,
    color: Color = MaterialTheme.colorScheme.primaryContainer,
    onColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    onClick: () -> Unit,
    onLongClick: () -> Unit = {},
    bold: Boolean = false,

    height: Dp = 75.dp,

    topStartRound: Dp = 50.dp,
    bottomStartRound: Dp = 50.dp,
    topEndRound: Dp = 50.dp,
    bottomEndRound: Dp = 50.dp,
) {
    val interactionSource = remember { MutableInteractionSource() }

    var isPressed by remember { mutableStateOf(false) }

    val buttonHeight by animateDpAsState(
        targetValue = if (isPressed) (height * 1.3f) else height,
        animationSpec = tween(durationMillis = 500)
    )

    Box(
        modifier = modifier
            .height(buttonHeight)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = topStartRound,
                    bottomStart = bottomStartRound,
                    topEnd = topEndRound,
                    bottomEnd = bottomEndRound
                )
            )
            .background(color)
            .combinedClickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick,
                onLongClick = onLongClick
            )
            .pointerInput(Unit) {
                // Detect press and release gestures
                while (true) {
                    // Restricted scope — only pointer suspend functions allowed here
                    awaitPointerEventScope {
                        awaitFirstDown(pass = PointerEventPass.Main)
                        isPressed = true
                        waitForUpOrCancellation()
                    }
                    // Normal coroutine scope — delay is fine here
                    delay(200)
                    isPressed = false
                }

            }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            )
    ) {
        Row() {
            if (icon != null && getWindowSizeClass() != WindowSizeClass.Medium) {
                Box(modifier = Modifier.size(buttonHeight)) {
                    Icon(
                        modifier = modifier.fillMaxSize().padding(10.dp),
                        painter = painterResource(icon),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Box(modifier = Modifier.fillMaxSize()) {
                TextForUI(
                    modifier = Modifier.align(Alignment.Center),
                    text = text,
                    bold = bold,
                    color = onColor
                )
            }
        }
    }
}

@Preview
@Composable
fun DualButtonPreview() {
    DualButton(
        text = "Button Text",
        onClick = {},
        onLongClick = {}
    )
}


@Composable
fun SquareIconButton(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    text: String,
    bold: Boolean,
    size: Dp = 150.dp,
    mini: Boolean = false,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    var isPressed by remember { mutableStateOf(false) }

    val buttonSize by animateDpAsState(
        targetValue = if (isPressed) (size * 1.3f) else size,
        animationSpec = tween(durationMillis = 500)
    )
    Box(
        modifier = modifier
            .size(buttonSize)
            .clip(
                RoundedCornerShape(
                    topStart = if (mini) 2.dp else 25.dp,
                    bottomStart = if (mini) 2.dp else 25.dp,
                    topEnd = if (mini) 2.dp else 25.dp,
                    bottomEnd = if (mini) 2.dp else 25.dp
                )
            )
            .background(MaterialTheme.colorScheme.primaryContainer)
            .combinedClickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick,
                onLongClick = onLongClick
            )
            .pointerInput(Unit) {
                // Detect press and release gestures
                while (true) {
                    // Restricted scope — only pointer suspend functions allowed here
                    awaitPointerEventScope {
                        awaitFirstDown(pass = PointerEventPass.Main)
                        isPressed = true
                        waitForUpOrCancellation()
                    }
                    // Normal coroutine scope — delay is fine here
                    delay(200)
                    isPressed = false
                }

            }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            )
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = text,
                modifier = Modifier
                    .size(if (mini) buttonSize else buttonSize * (2f / 3f))
                    .padding(buttonSize / 10),
                tint = MaterialTheme.colorScheme.primary
            )
            if (!mini) TextForUI(text = text, bold = bold)
        }
    }
}

@Preview
@Composable
fun SquareIconButtonPreview() {
    Row {
        SquareIconButton(
            icon = Res.drawable.uniq_studio_logo,
            text = stringResource(Res.string.app_name),
            bold = false,
            onClick = { },
            onLongClick = { }
        )
        SquareIconButton(
            icon = Res.drawable.uniq_studio_logo,
            text = stringResource(Res.string.app_name),
            bold = true,
            onClick = { },
            onLongClick = { }
        )
        SquareIconButton(
            icon = Res.drawable.uniq_studio_logo,
            text = stringResource(Res.string.app_name),
            bold = true,
            mini = true,
            size = 50.dp,
            onClick = { },
            onLongClick = { }
        )
    }
}

@Composable
fun SquareImageButton(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    text: String,
    bold: Boolean,
    size: Dp = 150.dp,
    mini: Boolean = false,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    var isPressed by remember { mutableStateOf(false) }

    val buttonSize by animateDpAsState(
        targetValue = if (isPressed) (size * 1.3f) else size,
        animationSpec = tween(durationMillis = 500)
    )
    Box(
        modifier = modifier
            .size(buttonSize)
            .clip(
                RoundedCornerShape(
                    topStart = if (mini) 2.dp else 25.dp,
                    bottomStart = if (mini) 2.dp else 25.dp,
                    topEnd = if (mini) 2.dp else 25.dp,
                    bottomEnd = if (mini) 2.dp else 25.dp
                )
            )
            .background(MaterialTheme.colorScheme.primaryContainer)
            .combinedClickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick,
                onLongClick = onLongClick
            )
            .pointerInput(Unit) {
                // Detect press and release gestures
                while (true) {
                    // Restricted scope — only pointer suspend functions allowed here
                    awaitPointerEventScope {
                        awaitFirstDown(pass = PointerEventPass.Main)
                        isPressed = true
                        waitForUpOrCancellation()
                    }
                    // Normal coroutine scope — delay is fine here
                    delay(200)
                    isPressed = false
                }

            }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            )
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = text,
                modifier = Modifier
                    .size(if (mini) buttonSize else buttonSize * (2f / 3f))
                    .padding(buttonSize / 10),
            )
            if (!mini) TextForUI(text = text, bold = bold)
        }
    }
}

@Preview
@Composable
fun SquareImageButtonPreview() {
    Row {
        SquareImageButton(
            image = Res.drawable.uniq_studio_logo,
            text = stringResource(Res.string.app_name),
            bold = false,
            onClick = { },
            onLongClick = { }
        )
        SquareImageButton(
            image = Res.drawable.uniq_studio_logo,
            text = stringResource(Res.string.app_name),
            bold = true,
            onClick = { },
            onLongClick = { }
        )
        SquareImageButton(
            image = Res.drawable.uniq_studio_logo,
            text = stringResource(Res.string.app_name),
            bold = true,
            mini = true,
            size = 50.dp,
            onClick = { },
            onLongClick = { }
        )
    }
}

@Composable
fun TripleButtonBar(
    modifier: Modifier = Modifier,
    text1: String,
    text2: String,
    text3: String,
    bold1: Boolean = false,
    bold2: Boolean = false,
    bold3: Boolean = true,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row {
            DualButton(
                text = text1,
                onClick = onClick1,
                onLongClick = { },
                bold = bold1,
                modifier = Modifier.weight(1f),
                topStartRound = 15.dp,
                bottomStartRound = 0.dp,
                topEndRound = 0.dp,
                bottomEndRound = 0.dp
            )

            Spacer(modifier = Modifier.size(5.dp))

            DualButton(
                text = text2,
                onClick = onClick2,
                onLongClick = { },
                bold = bold2,
                modifier = Modifier.weight(1f),
                topStartRound = 0.dp,
                bottomStartRound = 0.dp,
                topEndRound = 15.dp,
                bottomEndRound = 0.dp
            )
        }

        Spacer(modifier = Modifier.size(5.dp))

        DualButton(
            text = text3,
            onClick = onClick3,
            onLongClick = { },
            bold = bold3,
            topStartRound = 0.dp,
            bottomStartRound = 15.dp,
            topEndRound = 0.dp,
            bottomEndRound = 15.dp
        )
    }
}

@Preview
@Composable
fun TripleButtonBarPreview() {
    TripleButtonBar(
        text1 = "Button 1",
        text2 = "Button 2",
        text3 = "Button 3",
        onClick1 = { },
        onClick2 = { },
        onClick3 = { }
    )
}

@Composable
fun IconInlineText(
    modifier: Modifier = Modifier,
    icon: DrawableResource,
    iconColor: Color = MaterialTheme.colorScheme.primary,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    Row(
        modifier = modifier
            .width(225.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(25.dp),
            tint = iconColor
        )
        DescriptionText(
            text = text,
            color = textColor
        )
    }
}

@Preview
@Composable
fun IconInlineTextPreview() {
    IconInlineText(
        icon = Res.drawable.uniq_studio_logo,
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla facilisi."
    )
}

@Composable
fun ImageTitleAndDescriptionColumn(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: String,
    titleColor: Color = MaterialTheme.colorScheme.primary,
    description: String,
    descriptionColor: Color = MaterialTheme.colorScheme.onSurfaceVariant,
    bold: Boolean = false,
    extraThin: Boolean = true,
    largeText: Boolean = false
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.size(150.dp),
        )

        TitleText(
            text = title,
            bold = bold,
            extraThin = extraThin,
            largeText = largeText,
            color = titleColor
        )

        Text(
            text = description,
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            color = descriptionColor
        )
    }
}

@Preview
@Composable
fun ImageTitleAndDescriptionColumnPreview() {
    ImageTitleAndDescriptionColumn(
        image = Res.drawable.uniq_studio_logo,
        title = "Title text",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    )
}

@Composable
fun IconTitleAndDescriptionColumn(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: String,
    description: String,
    bold: Boolean = false,
    extraThin: Boolean = true,
    largeText: Boolean = false
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Icon(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier.size(150.dp),
            tint = MaterialTheme.colorScheme.primary
        )

        TitleText(
            text = title,
            bold = bold,
            extraThin = extraThin,
            largeText = largeText,
        )

        Text(
            //Displays title in thick, light gray font
            text = description,
            fontSize = 15.sp,
            fontWeight = FontWeight.ExtraBold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview
@Composable
fun IconTitleAndDescriptionColumnPreview() {
    IconTitleAndDescriptionColumn(
        image = Res.drawable.uniq_studio_logo,
        title = "Title text",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    )
}

@Composable
fun ImageTitleAndDescriptionRow(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: String,
    titleColor: Color = MaterialTheme.colorScheme.primary,
    description: String,
    infoText: String,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp, top = 20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier.size(75.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Column {
                SmallTextTitle(
                    text = infoText,
                    color = textColor
                )
                TitleText(
                    text = title,
                    color = titleColor,
                    bold = true
                )
            }
        }
        Column(
            modifier = Modifier
                .height(100.dp)
                .verticalScroll(rememberScrollState())
        ) {
            SmallTextTitle(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                text = description,
                color = textColor
            )
        }
    }
}

@Preview
@Composable
fun ImageTitleAndDescriptionRowPreview() {
    ImageTitleAndDescriptionRow(
        image = Res.drawable.uniq_studio_logo,
        title = "Title text",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        infoText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrossPlatformTimePicker(
    modifier: Modifier = Modifier,
    buttonText: String,
    initialHour: Int,
    initialMinute: Int,
    onTimeSelected: (Int, Int) -> Unit
) {
    var showPicker by remember { mutableStateOf(false) }
    val state = rememberTimePickerState(
        initialHour = initialHour,
        initialMinute = initialMinute,
        is24Hour = true
    )
    Column(
        modifier = modifier.size(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleText(
            text = "${state.hour.toString().padStart(2, '0')}:${
                state.minute.toString().padStart(2, '0')
            }",
            bold = true,
            largeText = true
        )
        DualButton(
            text = buttonText,
            onClick = { showPicker = true },
            onLongClick = { showPicker = true },
            modifier = Modifier.fillMaxWidth(),
            height = 35.dp
        )
    }
    if (showPicker) {
        AlertDialog(
            onDismissRequest = { showPicker = false },
            confirmButton = {
                Button(
                    onClick = {
                        onTimeSelected(state.hour, state.minute)
                        showPicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showPicker = false }) {
                    Text("Cancel")
                }
            },
            title = { Text("Select Time") },
            text = {
                TimePicker(
                    state = state,
                    layoutType = TimePickerDefaults.layoutType()
                )
            }
        )
    }
}

@Preview
@Composable
fun CrossPlatformTimePickerPreview() {
    CrossPlatformTimePicker(
        buttonText = "Select Time",
        initialHour = 12,
        initialMinute = 0,
        onTimeSelected = { _, _ -> }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDownMenu(
    modifier: Modifier = Modifier,
    items: List<String>,
    onSelectedItem: (String) -> Unit,
    onClick: () -> Unit
) {
    val items = items

    var selectedItem by remember { mutableStateOf(items[0]) }

    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded = !isExpanded }
        ) {
            TextField(
                modifier = Modifier.menuAnchor(),
                value = selectedItem,
                onValueChange = {},
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
            )

            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                items.forEachIndexed { index, item ->
                    DropdownMenuItem(
                        text = { Text(text = item) },
                        onClick = {
                            selectedItem = item
                            onSelectedItem(item)
                            isExpanded = false
                            onClick()
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun DropDownMenuPreview() {
    val items = listOf("Item 1", "Item 2", "Item 3")
    DropDownMenu(
        items = items,
        onSelectedItem = {},
        onClick = {}
    )
}

@Composable
fun CheckListItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    showImage: Boolean = true,
    preview: Boolean = false,
    icon: Painter = painterResource(Res.drawable.block_1),
    onClick: () -> Unit = {},
    onLongClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .pointerInput(onLongClick) {
                detectTapGestures(
                    onTap = {
                        onClick()
                    },
                    onLongPress = {
                        onLongClick()
                    }
                )
            }

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(start = 5.dp, end = 5.dp),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextForUI(
                modifier = Modifier.weight(1f),
                text = title,
                bold = true,
                textAlign = TextAlign.Start
            )
            if (!preview) {
                SmallTextTitle(
                    text = description
                )
                if (showImage) {
                    Icon(
                        painter = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun CheckListItemPreview() {
    CheckListItem(
        title = "Title text",
        description = "Mini Text."
    )
}

@Composable
fun ImageCardWithText(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    fillImage: Boolean = false,
    title: String,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = if (!fillImage) ContentScale.Fit else ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f)
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(5.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                TextForUI(
                    text = title,
                    bold = true
                )
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    text: String,
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    selected: Boolean = false,

    height: Dp = 50.dp,
    width: Dp = 100.dp

) {
    val interactionSource = remember { MutableInteractionSource() }

    var isPressed by remember { mutableStateOf(false) }

    val buttonHeight by animateDpAsState(
        targetValue = if (isPressed) (height * 1.3f) else height,
        animationSpec = tween(durationMillis = 500)
    )

    val buttonWidth by animateDpAsState(
        targetValue = if (isPressed) (width * 1.3f) else width,
        animationSpec = tween(durationMillis = 500)
    )

    Box(
        modifier = modifier
            .height(buttonHeight)
            .width(buttonWidth)
            .clip(
                RoundedCornerShape(
                    topStart = 50.dp,
                    bottomStart = 50.dp,
                    topEnd = 50.dp,
                    bottomEnd = 50.dp
                )
            )
            .background(if (selected) MaterialTheme.colorScheme.primaryContainer else Color.Transparent)
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = CircleShape
            )
            .combinedClickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = onClick,
                onLongClick = onLongClick
            )
            .pointerInput(Unit) {
                // Detect press and release gestures
                while (true) {
                    // Restricted scope — only pointer suspend functions allowed here
                    awaitPointerEventScope {
                        awaitFirstDown(pass = PointerEventPass.Main)
                        isPressed = true
                        waitForUpOrCancellation()
                    }
                    // Normal coroutine scope — delay is fine here
                    delay(200)
                    isPressed = false
                }

            }
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessVeryLow
                )
            )
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                modifier = Modifier.size(25.dp),
                painter = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            if (text != "") {
                TextForUI(
                    text = text,
                    bold = selected,
                    extraThin = !selected
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdaptiveFloatingActionButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    text: String,
    onClick: () -> Unit,
    isStartAligned: Boolean = false
) {
    Box(modifier = modifier.fillMaxSize()) {
        if (getWindowSizeClass() == WindowSizeClass.Expanded) {
            ExtendedFloatingActionButton(
                modifier = if (isStartAligned) Modifier.align(Alignment.BottomStart)
                    .padding(15.dp) else Modifier.align(Alignment.BottomEnd).padding(15.dp),
                onClick = { onClick() },
                icon = {
                    Icon(
                        modifier = Modifier.padding(5.dp).size(36.dp),
                        painter = icon,
                        contentDescription = text
                    )
                },
                text = { Text(text = text) },
            )
        } else {
            FloatingActionButton(
                modifier = if (isStartAligned) Modifier.align(Alignment.BottomStart)
                    .padding(15.dp) else Modifier.align(Alignment.BottomEnd).padding(15.dp),
                onClick = { onClick() },
                content = {
                    Icon(
                        modifier = Modifier.padding(5.dp).size(36.dp),
                        painter = icon,
                        contentDescription = text
                    )
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun AdaptiveFloatingOptionsButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    text: String,
    iconOptionOne: Painter,
    iconOptionTwo: Painter,
    iconOptionThree: Painter,
    textOptionOne: String,
    textOptionTwo: String,
    textOptionThree: String,
    onClickOptionOne: () -> Unit,
    onClickOptionTwo: () -> Unit,
    onClickOptionThree: () -> Unit,
    isStartAligned: Boolean = false
) {
    var showOptions by remember { mutableStateOf(false) }
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = if (isStartAligned) Modifier.align(Alignment.BottomStart)
                .padding(15.dp) else Modifier.align(Alignment.BottomEnd).padding(15.dp),
        ) {
            AnimatedContent(
                targetState = showOptions,
                transitionSpec = {
                    slideInVertically(
                        animationSpec = tween(durationMillis = 300),
                        initialOffsetY = { fullWidth -> fullWidth }
                    ) togetherWith slideOutVertically(
                        animationSpec = tween(durationMillis = 300),
                        targetOffsetY = { fullWidth -> -fullWidth }
                    )
                },
                modifier = modifier,
            )
            {
                if (showOptions) {
                    Column() {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            FloatingActionButton(
                                modifier = Modifier.padding(bottom = 10.dp)
                                    .size(45.dp),
                                onClick = {
                                    onClickOptionOne()
                                    showOptions = !showOptions
                                },
                                content = {
                                    Icon(
                                        modifier = Modifier.padding(5.dp).size(28.dp),
                                        painter = iconOptionOne,
                                        contentDescription = textOptionOne
                                    )
                                }
                            )
                            Text(
                                modifier = Modifier.padding(start = 5.dp)
                                    .offset(y = (-5).dp),
                                text = textOptionOne
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            FloatingActionButton(
                                modifier = Modifier.padding(bottom = 10.dp)
                                    .size(45.dp),
                                onClick = {
                                    onClickOptionTwo()
                                    showOptions = !showOptions
                                },
                                content = {
                                    Icon(
                                        modifier = Modifier.padding(5.dp).size(28.dp),
                                        painter = iconOptionTwo,
                                        contentDescription = textOptionTwo
                                    )
                                }
                            )
                            Text(
                                modifier = Modifier.padding(start = 5.dp)
                                    .offset(y = (-5).dp),
                                text = textOptionTwo
                            )
                        }

                        Row(verticalAlignment = Alignment.CenterVertically) {
                            FloatingActionButton(
                                modifier = Modifier.padding(bottom = 10.dp)
                                    .size(45.dp),
                                onClick = {
                                    onClickOptionThree()
                                    showOptions = !showOptions
                                },
                                content = {
                                    Icon(
                                        modifier = Modifier.padding(5.dp).size(28.dp),
                                        painter = iconOptionThree,
                                        contentDescription = textOptionThree
                                    )
                                }
                            )
                            Text(
                                modifier = Modifier.padding(start = 5.dp)
                                    .offset(y = (-5).dp),
                                text = textOptionThree
                            )
                        }
                    }
                }
            }

            if (getWindowSizeClass() == WindowSizeClass.Expanded) {
                ExtendedFloatingActionButton(
                    onClick = { showOptions = !showOptions },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(5.dp).size(56.dp),
                            painter = icon,
                            contentDescription = text
                        )
                    },
                    text = { Text(text = text) },
                )
            } else {
                FloatingActionButton(
                    onClick = { showOptions = !showOptions },
                    content = {
                        Icon(
                            modifier = Modifier.padding(10.dp).size(46.dp),
                            painter = icon,
                            contentDescription = text
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun UserInputShellNoScrollCompact(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: String,
    description: String,
    infoText: String,
    composableContent: @Composable () -> Unit,
    onClickNext: () -> Unit = {},
    disableNextButton: Boolean = false
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        ImageTitleAndDescriptionRow(
            modifier = Modifier
                //.padding(top = (-10).dp)
                .weight(1f),
            image = image,
            title = description,
            description = title,
            infoText = infoText
        )

        Spacer(modifier = Modifier.size(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            composableContent()
        }

        if (!disableNextButton) {
            NextButton(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .weight(1f),
                onClickBack = {},
                onClickNext = onClickNext
            )
        } else if (disableNextButton) {
            BlankSpaceFiller()
        }
    }
}

@Composable
fun WideImageButtonBar(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    text: String,
    bold: Boolean,
    onClick: () -> Unit
) {
    FilledTonalButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.extraSmall,
        modifier = modifier
            .fillMaxWidth()
            .height(75.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .size(75.dp)
                    .weight(1f),
                tint = MaterialTheme.colorScheme.primary
            )
            Box(
                modifier = Modifier.weight(3f),
                contentAlignment = Alignment.Center
            ) {
                TextForUI(
                    text = text,
                    bold = bold
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalTime::class)
@Composable
fun DatePickerModel(
    title: String,
    modifier: Modifier = Modifier,
    onDateSelected: (LocalDate?) -> Unit,
) {
    val datePickerState = rememberDatePickerState()
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    var showDatePicker by remember { mutableStateOf(false) }
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    val localDate = datePickerState.selectedDateMillis?.let { millis: Long ->
                        Instant.fromEpochMilliseconds(millis)
                            .toLocalDateTime(TimeZone.currentSystemDefault())
                            .date
                    }
                    selectedDate = localDate
                    onDateSelected(localDate)
                    showDatePicker = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextForUI(text = title, bold = false)
        Spacer(modifier = Modifier.weight(1f))
        TitleText(
            modifier = Modifier.clickable(onClick = { showDatePicker = true }),
            text = "${if (selectedDate != null) selectedDate else "Select a Date"}",
            bold = true,
            largeText = true
        )
    }
    UniqDivider()
}

@Composable
fun UniqDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    Box(
        modifier = modifier
            .background(color)
            .fillMaxWidth()
            .height(1.dp)
            .padding(vertical = 5.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrossPlatformTimePickerCompact(
    modifier: Modifier = Modifier,
    title: String,
    initialHour: Int,
    initialMinute: Int,
    onTimeSelected: (Int, Int) -> Unit
) {
    var showPicker by remember { mutableStateOf(false) }
    val state = rememberTimePickerState(
        initialHour = initialHour,
        initialMinute = initialMinute,
        is24Hour = true
    )
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextForUI(text = title, bold = false)
        Spacer(modifier = Modifier.weight(1f))

        TitleText(
            modifier = Modifier.clickable { showPicker = true },
            text = "${state.hour.toString().padStart(2, '0')}:${
                state.minute.toString().padStart(2, '0')
            }",
            bold = true,
            largeText = true
        )
    }
    UniqDivider()
    if (showPicker) {
        AlertDialog(
            onDismissRequest = { showPicker = false },
            confirmButton = {
                Button(
                    onClick = {
                        onTimeSelected(state.hour, state.minute)
                        showPicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showPicker = false }) {
                    Text("Cancel")
                }
            },
            title = { Text("Select Time") },
            text = {
                TimePicker(
                    state = state,
                    layoutType = TimePickerDefaults.layoutType()
                )
            }
        )
    }
}

@Preview
@Composable
fun CrossPlatformTimePickerCompactPreview() {
    CrossPlatformTimePickerCompact(
        title = "Time",
        initialHour = 12,
        initialMinute = 0,
        onTimeSelected = { _, _ -> }
    )
}

@Composable
fun DialogBox(
    modifier: Modifier = Modifier,
    title: StringResource,
    subTitle: StringResource,
    text: StringResource,
    showButton: Boolean,
    leftButtonText: StringResource,
    rightButtonText: StringResource,
    onClickLeft: () -> Unit,
    onClickRight: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            SmallTextTitle(
                text = stringResource(title)
            )
            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = stringResource(subTitle),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(vertical = 5.dp),
                text = stringResource(text),
                fontSize = 15.sp,
            )

            if (showButton) {
                Row(
                    modifier = Modifier.padding(vertical = 5.dp),
                    horizontalArrangement = Arrangement.spacedBy(5.dp)

                ) {
                    OutlinedButton(
                        modifier = Modifier.weight(1f),
                        onClick = onClickLeft
                    ) {
                        DescriptionText(
                            text = stringResource(leftButtonText),
                        )
                    }
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = onClickRight
                    ) {
                        DescriptionText(
                            text = stringResource(rightButtonText)
                        )
                    }
                }

            }
        }

    }
}

@Preview
@Composable
fun DialogBoxPreview() {
    DialogBox(
        title = Res.string.settings,
        subTitle = Res.string.settings,
        text = Res.string.settings,
        showButton = true,
        leftButtonText = Res.string.settings,
        rightButtonText = Res.string.settings,
        onClickLeft = {},
        onClickRight = {}
    )
}

@Composable
fun PopUpAlert(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: StringResource,
    text: StringResource,
    showButton: Boolean = false,
    leftButtonText: StringResource = Res.string.settings,
    rightButtonText: StringResource = Res.string.settings,
    onClickLeft: () -> Unit = {},
    onClickRight: () -> Unit = {}
) {
    Column {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                    )
                ),
            painter = painterResource(image),
            contentDescription = ""
        )
        Card(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .offset(y = (-10).dp)
        ) {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.surface)
                    .fillMaxWidth()
                    .padding(15.dp),
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 5.dp).fillMaxWidth(),
                    text = stringResource(title),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.padding(vertical = 5.dp),
                    text = stringResource(text),
                    fontSize = 15.sp,
                )

                if (showButton) {
                    Row(
                        modifier = Modifier.padding(vertical = 5.dp),
                        horizontalArrangement = Arrangement.spacedBy(5.dp)

                    ) {
                        OutlinedButton(
                            modifier = Modifier.weight(1f),
                            onClick = onClickLeft
                        ) {
                            DescriptionText(
                                text = stringResource(leftButtonText),
                            )
                        }
                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = onClickRight
                        ) {
                            DescriptionText(
                                text = stringResource(rightButtonText)
                            )
                        }
                    }

                } else {
                    DescriptionText(
                        text = stringResource(Res.string.alert_dialog_tap_anywhere),
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun PopUpAlertPreview() {
    PopUpAlert(
        image = Res.drawable.uniq_studio_logo,
        title = Res.string.app_name,
        text = Res.string.app_name
    )
}

@Preview
@Composable
fun PopUpAlertOptionsPreview() {
    PopUpAlert(
        image = Res.drawable.uniq_studio_logo,
        title = Res.string.app_name,
        text = Res.string.app_name,
        showButton = true,
        leftButtonText = Res.string.settings,
        rightButtonText = Res.string.settings
    )
}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    imageDescription: StringResource,
    title: StringResource,
    description: StringResource,
    buttonText: StringResource,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(imageDescription),
            modifier = Modifier.weight(2f)
        )
        Box(
            Modifier.weight(1f)
        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                TitleText(
                    text = stringResource(title),
                    bold = true,
                    largeText = true,
                    color = MaterialTheme.colorScheme.secondary
                )
                TextForUI(
                    text = stringResource(description),
                    fontSize = 20.sp
                )
            }
        }
        DualButton(
            modifier = Modifier.fillMaxWidth().padding(15.dp).height(50.dp),
            text = stringResource(buttonText),
            onClick = onClick,
        )
    }
}

@Preview
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(
        image = Res.drawable.uniq_studio_logo,
        imageDescription = Res.string.app_name,
        title = Res.string.app_name,
        description = Res.string.app_name,
        buttonText = Res.string.app_name,
        onClick = {}
    )
}

@Composable
fun TitleScreenCompact(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: String,
    description: String,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            BlankSpaceFiller()

            IconTitleAndDescriptionColumn(
                image = image,
                title = title,
                description = description,
            )

            BlankSpaceFiller()
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Column {
                NextButton(
                    backButton = true,
                    onClickBack = onClickBack,
                    onClickNext = onClickNext
                )
                BlankSpaceFiller(
                    modifier = if (getWindowSizeClass() != WindowSizeClass.Compact) Modifier.size(
                        50.dp
                    ) else Modifier.size(150.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun TitleScreenCompactPreview() {
    TitleScreenCompact(
        image = Res.drawable.uniq_studio_logo,
        title = "Title text",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        onClickBack = {},
        onClickNext = {}
    )
}

@Composable
fun UserInputShellCompact(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: String,
    titleColor: Color = MaterialTheme.colorScheme.primary,
    description: String,
    infoText: String,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    composableContent: @Composable () -> Unit,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit = {},
    disableNextButton: Boolean = false
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        ImageTitleAndDescriptionRow(
            modifier = Modifier
                .weight(1f),
            image = image,
            title = title,
            titleColor = titleColor,
            description = description,
            infoText = infoText,
            textColor = textColor
        )

        Spacer(modifier = Modifier.size(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2.4f)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            composableContent()
        }

        if (!disableNextButton) {
            NextButton(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .weight(1f),
                onClickBack = onClickBack,
                onClickNext = onClickNext
            )
        } else if (disableNextButton) {
            BlankSpaceFiller()
        }
    }
}

@Preview
@Composable
fun UserInputShellCompactPreview() {
    UserInputShellCompact(
        image = Res.drawable.uniq_studio_logo,
        title = "Title text",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        infoText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        composableContent = {
        },
        onClickBack = {},
        onClickNext = {}
    )
}

@Composable
fun UserInputShellExpanded(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: String,
    description: String,
    infoText: String,
    composableContent: @Composable () -> Unit,
    onClickBack: () -> Unit,
    onClickNext: () -> Unit = {},
    disableNextButton: Boolean = false
) {
    Row(modifier = modifier.padding(15.dp)) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                Icon(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.size(85.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Column {
                    SmallTextTitle(
                        text = description
                    )
                    TitleText(
                        text = title,
                        bold = true
                    )

                    SmallTextTitle(
                        modifier = Modifier
                            .padding(top = 15.dp, end = 15.dp)
                            .fillMaxWidth()
                            .height(150.dp),
                        text = infoText
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                composableContent()
            }
            if (!disableNextButton) {
                NextButton(
                    modifier = Modifier.weight(1f),
                    onClickBack = onClickBack,
                    onClickNext = onClickNext
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputShellExpandedPreview() {
    UserInputShellExpanded(
        image = Res.drawable.uniq_studio_logo,
        title = "Title text",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        infoText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        composableContent = {
        },
        onClickBack = {},
    )
}

@Composable
fun UserInputShellNoScrollExpanded(
    modifier: Modifier = Modifier,
    image: DrawableResource,
    title: String,
    description: String,
    infoText: String,
    composableContent: @Composable () -> Unit,
    onClickNext: () -> Unit = {},
    disableNextButton: Boolean = false
) {
    Row(modifier = modifier.padding(15.dp)) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
                Icon(
                    painter = painterResource(image),
                    contentDescription = null,
                    modifier = Modifier.size(85.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Column {
                    SmallTextTitle(
                        text = description
                    )
                    TitleText(
                        text = title,
                        bold = true
                    )

                    SmallTextTitle(
                        modifier = Modifier
                            .padding(top = 15.dp, end = 15.dp)
                            .fillMaxWidth()
                            .height(150.dp)
                            .verticalScroll(rememberScrollState()),
                        text = infoText
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                composableContent()
            }
            if (!disableNextButton) {
                NextButton(
                    modifier = Modifier.weight(1f),
                    onClickBack = {},
                    onClickNext = onClickNext
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputShellNoScrollExpandedPreview() {
    UserInputShellNoScrollExpanded(
        image = Res.drawable.uniq_studio_logo,
        title = "Title text",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        infoText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        composableContent = {
        },
        onClickNext = {}
    )
}

@Preview
@Composable
fun SmartBackground(
    modifier: Modifier = Modifier,
    image: DrawableResource = Res.drawable.uniq_studio_logo,
    alpha: Float = 0.1f,
    icon: Boolean = false
) {
    Box(modifier = modifier.fillMaxSize()) {
        val isDark = isSystemInDarkTheme()
        if (icon) {
            Icon(
                modifier = Modifier.align(Alignment.BottomEnd).width(600.dp).height(600.dp)
                    .offset(x = (100).dp, y = (100).dp)
                    .graphicsLayer { this.alpha = if (isDark) (alpha * 3) else alpha },
                painter = painterResource(image),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        } else {
            Image(
                modifier = Modifier.align(Alignment.BottomEnd).width(600.dp).height(600.dp)
                    .offset(x = (100).dp, y = (100).dp)
                    .graphicsLayer { this.alpha = if (isDark) (alpha * 3) else alpha },
                painter = painterResource(image),
                contentDescription = null,
            )
        }
    }
}
