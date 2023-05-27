package seniordeveloper.peter.skylinearonepoolservice.userFlows

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import seniordeveloper.peter.skylinearonepoolservice.R
import seniordeveloper.peter.skylinearonepoolservice.data_Sets.UseCases
import seniordeveloper.peter.skylinearonepoolservice.data_Sets.UserDataInfo
import seniordeveloper.peter.skylinearonepoolservice.data_Sets.overflowMenu
import seniordeveloper.peter.skylinearonepoolservice.data_Sets.sampleData
import seniordeveloper.peter.skylinearonepoolservice.data_Sets.useCase
import seniordeveloper.peter.skylinearonepoolservice.models.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDashboard(navController:NavHostController) {
    var mainMenu by remember { mutableStateOf(false) }
    var num by remember { mutableStateOf(0) }
    var coroutineScope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar (
                    title = {
                        Text(
                            text = stringResource(R.string.service_page),
                            fontFamily = FontFamily.Monospace,
                            textAlign = TextAlign.Justify,
                            fontSize = 17.sp,
                            modifier = Modifier.offset(4.dp)
                        )
                    },
                    modifier = Modifier,
                    navigationIcon = {
                        Row (horizontalArrangement = Arrangement.spacedBy(4.dp)){
                            Box(
                                modifier = Modifier.wrapContentSize(Alignment.TopStart)
                            ) {
                                IconButton(onClick = { mainMenu = !mainMenu }) {
                                    Icon(
                                        Icons.Filled.MoreVert,
                                        contentDescription = stringResource(R.string.overflowmenu),
                                        Modifier.size(20.dp)
                                    )
                                }
                                DropdownMenu(expanded = mainMenu,
                                    onDismissRequest = {mainMenu = !mainMenu }
                                ) {
                                    DropdownMenuItem(onClick = {
                                        coroutineScope.launch { navController.navigate(overflowMenu[0].route)  }
                                    }) {
                                        Text(
                                            text = overflowMenu[0].name,
                                            textAlign = TextAlign.Center,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 15.sp,
                                            style = TextStyle.Default
                                        )

                                    }
                                    DropdownMenuItem(onClick = { navController.navigate(overflowMenu[1].route) }) {
                                        Text(
                                            text = overflowMenu[1].name,
                                            textAlign = TextAlign.Center,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 15.sp,
                                            style = TextStyle.Default
                                        )

                                    }
                                    DropdownMenuItem(onClick = { navController.navigate(overflowMenu[2].route) }) {
                                        Text(
                                            text = overflowMenu[2].name,
                                            textAlign = TextAlign.Center,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 15.sp,
                                            style = TextStyle.Default
                                        )

                                    }
                                    DropdownMenuItem(onClick = { navController.navigate(overflowMenu[3].route) }) {
                                        Text(
                                            text = overflowMenu[3].name,
                                            textAlign = TextAlign.Center,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 15.sp,
                                            style = TextStyle.Default
                                        )
                                    }
                                    DropdownMenuItem(onClick = { navController.navigate(overflowMenu[4].route) }) {
                                        Text(
                                            text = overflowMenu[4].name,
                                            textAlign = TextAlign.Center,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 15.sp,
                                            style = TextStyle.Default
                                        )

                                    }
                                    DropdownMenuItem(onClick = { navController.navigate(overflowMenu[5].route) }) {
                                        Text(
                                            text = overflowMenu[5].name,
                                            textAlign = TextAlign.Center,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 15.sp,
                                            style = TextStyle.Default
                                        )

                                    }
                                    DropdownMenuItem(onClick = { navController.navigate(overflowMenu[6].route) }) {
                                        Text(
                                            text = overflowMenu[6].name,
                                            textAlign = TextAlign.Center,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 15.sp,
                                            style = TextStyle.Default
                                        )

                                    }

                                    DropdownMenuItem(onClick = { navController.navigate(overflowMenu[7].route) }) {
                                        Text(
                                            text = overflowMenu[7].name,
                                            textAlign = TextAlign.Center,
                                            fontFamily = FontFamily.Monospace,
                                            fontSize = 15.sp,
                                            style = TextStyle.Default
                                        )

                                    }
                                }


                            }
                            Image(
                                painter = painterResource(id = R.drawable.tutor),
                                contentDescription = stringResource(R.string.profile_pic),
                                Modifier
                                    .border(width = 2.dp, color = White, shape = CircleShape)
                                    .size(50.dp)
                            )
                        }
                    },
                    actions =
                    {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = null,
                    )
                        Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        Icons.Filled.Share,
                        contentDescription = stringResource(R.string.shareoptions)
                    )
                        Spacer(modifier = Modifier.width(4.dp))

                        IconButton(onClick = {navController.navigate(Screen.Settings.route)}) {
                            Icon(
                            Icons.Filled.Settings,
                            contentDescription = stringResource(R.string.settings))
                        }
                        Spacer(modifier = Modifier.width(4.dp))

                    },

                    colors = TopAppBarDefaults.largeTopAppBarColors(),

                )
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.height(50.dp),
                    containerColor = Gray, contentColor = White,
                    tonalElevation = 3.dp
                ) {

                    IconButton(onClick = { navController.navigate(Screen.Profile.route) }) {
                        Icon(Icons.Filled.Person, contentDescription = null)
                    }

                    Spacer(modifier = Modifier.width(90.dp))


                    IconButton(onClick = { navController.navigate(Screen.Login.route) }) {
                        Icon(Icons.Filled.Home, contentDescription = null)
                    }

                    Spacer(modifier = Modifier.width(90.dp))

                    IconButton(onClick = { /*TODO*/ }) {
                        BadgedBox(badge = { Text(text = "$num", color = White) }) {
                            Icon(Icons.Filled.AccountBox, contentDescription = null)
                        }
                    }
                }


            },
            floatingActionButton = {
                FloatingActionButton(onClick = {num++ }) {
                    Icon(Icons.Filled.Add,contentDescription = null, tint = Color.Blue)
                }
            },
        floatingActionButtonPosition = FabPosition.End,

        ){
            Main(navController = rememberNavController())
        }
    }

    }


@Preview
@Composable
fun PreviewDashboard(){
    AppDashboard(navController = rememberNavController())
}


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
private  fun Main(navController: NavHostController){
    val selectedUser = remember { mutableStateOf<UserDataInfo?>(null) }
    val selectedCase = remember { mutableStateOf<UseCases?>(null) }
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(top = 80.dp, start = 7.dp, end = 10.dp)
        ) {
            LazyRow {
                items(useCase) { use ->
                    OutlinedButton(onClick = {},
                        modifier =  Modifier
                            .width(100.dp)
                            .height(35.dp)
                            .clickable(enabled = true, role = Role.Button, onClick = {navController.navigate(Screen.User.route)})
                        ,
                        interactionSource = MutableInteractionSource(),
                        contentPadding = PaddingValues(3.dp)
                    ) {
                        Text(
                            text = use.name,
                            fontFamily = FontFamily.Monospace,
                            fontStyle = FontStyle.Normal,
                            fontSize = 15.sp
                        )
                    }
                }

            }
            Spacer(modifier = Modifier.height(5.dp))
            Row {
                Card(
                    onClick = { /*To DO*/ },
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .width(IntrinsicSize.Max)
                ) {
                    OutlinedButton(onClick = {/**/ }) {
                        ClickableText(text = AnnotatedString("Bottom Sheet"),
                            onClick = { navController.navigate(Screen.Profile.route)}, modifier = Modifier.padding(5.dp))

                    }
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
Row{
UserInfo()
}
            Spacer(modifier = Modifier.height(5.dp))


        }

}


//

@Composable
private  fun UserInfo(){
    LazyColumn(modifier = Modifier
        .padding(2.dp)
        .clickable(onClickLabel = "Clicked") { }, content = {
        items(sampleData) { user->
            if (user == sampleData.last()){
                ItemCard(user)
                Spacer(modifier = Modifier.padding(bottom = 20.dp))
            }
            else
            {
                ItemCard(user)
            }
        }
    }
    )}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(user:UserDataInfo){
    var showPro by remember { mutableStateOf(false) }

            ElevatedCard(onClick = {
                showPro = !showPro
            }, modifier = Modifier
                .fillMaxWidth()
                .height(intrinsicSize = IntrinsicSize.Max)
                .padding(start = 20.dp, end = 20.dp)
                ,
                colors = CardDefaults.cardColors( White, Gray,Red),
                content = {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(top = 18.dp, bottom = 12.dp)
                            .fillMaxWidth()
                    ) {
                        Image(
                            painterResource(id = user.image),
                            contentDescription = null,
                            Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(7.dp))
                                .border(border = BorderStroke(2.dp, White), shape = CircleShape)
                        )
                        Text(text = user.name, textAlign = TextAlign.Center,
                            fontSize = 15.sp, fontWeight = FontWeight.Bold,
                            textDecoration = TextDecoration.combine(
                                listOf(TextDecoration.Underline)
                            )
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = stringResource(user.description), textAlign = TextAlign.Center, fontSize = 15.sp)

                    }
                        if (showPro) {
                            LaunchedEffect(showPro) {
                                if (showPro) {
                                    delay( 10 * 1000L) // Delay for 10 minutes (10 minutes * 60 seconds * 1000 milliseconds)
                                    showPro = false // Hide the CircularProgressIndicator after the delay
                                }
                            }
                            CircularProgressIndicator(
                                modifier = Modifier.width(50.dp),
                                color = Gray,
                                strokeWidth = 4.dp
                            )
                        }
                }
                }
            )
    Spacer(modifier = Modifier.height(3.dp))

}
