package seniordeveloper.peter.skylinearonepoolservice.userFlows

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylinearonepoolservice.R
import seniordeveloper.peter.skylinearonepoolservice.models.Screen
import seniordeveloper.peter.skylinearonepoolservice.data_Sets.DataList

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDashboard(navController:NavHostController) {
    var mainMenu by remember { mutableStateOf(false) }
    var num by remember { mutableStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Scaffold(
            topBar = {
                TopAppBar (
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
                            IconButton(onClick = { mainMenu = !mainMenu }) {
                                Icon(
                                    Icons.Filled.MoreVert,
                                    contentDescription = stringResource(R.string.overflowmenu),
                                    Modifier.size(20.dp)
                                )
                            }
                            Image(
                                painter = painterResource(id = R.drawable.logg),
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

                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(LightGray)
                )
            },
            bottomBar = {
                BottomAppBar(
                    modifier = Modifier.height(60.dp),
                    containerColor = LightGray, contentColor = White,
                    tonalElevation = 3.dp
                ) {
                    Box {
                        Column {
                            IconButton(onClick = { navController.navigate(Screen.Profile.route) }) {
                                Icon(Icons.Filled.Person, contentDescription = null)
                            }
                            Text(text = "People",modifier = Modifier.padding(top = 1.dp))
                        }
                    }
                    Spacer(modifier = Modifier.width(90.dp))
                    Box{
                        Column{
                            IconButton(onClick = {navController.navigate("loginPage")}) {
                                Icon(Icons.Filled.Home, contentDescription = null)
                            }
                            Text(text = "Home",modifier = Modifier.padding(top = 1.dp))
                        }
                    }

                    Spacer(modifier = Modifier.width(90.dp))
                    Box{
                        Column {
                            IconButton(onClick = { /*TODO*/ }) {
                                BadgedBox(badge = { Text(text = "$num", color = Red)}) {
                                    Icon(Icons.Filled.AccountBox,contentDescription = null)
                                }
                            }
                            Text(text = "Accounts",modifier = Modifier.padding(top = 1.dp))
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private  fun Main(navController: NavHostController){
    var txt by remember{mutableStateOf("")}
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(top = 80.dp, start =  7.dp, end = 10.dp)) {


        OutlinedTextField(
            value = txt,
            onValueChange = { txt = it },
            modifier = Modifier
                .height(50.dp)
                .width(330.dp)
                .offset(3.dp),
            shape = RoundedCornerShape(18.dp),
            keyboardOptions = KeyboardOptions(keyboardType =KeyboardType.Text,autoCorrect = true),
            keyboardActions = KeyboardActions.Default,
//            supportingText = { Text(text = stringResource(R.string.enter_id_to_search)) },
//            label = { Text(text = stringResource(R.string.search_here)) },
            placeholder = { Text(text = stringResource(R.string.enter_id_to_search), textAlign = TextAlign.Justify)},
            trailingIcon = {
                IconButton(onClick = {
                    Toast.makeText(context,"Under Maintenance",Toast.LENGTH_SHORT).show()
                }){
                    Icon(
                    Icons.Filled.Search,
                    contentDescription = stringResource(R.string.search_icon),
                    tint = Color.Blue,
                    modifier = Modifier.size(28.dp)
                )
            }
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
//        Row(horizontalArrangement = Arrangement.spacedBy(3.dp)) {
//            ElevatedCard(onClick = { /*TODO*/ }, modifier = Modifier
//                .width(170.dp)
//                .height(170.dp)
//                .align(CenterVertically),
//                colors = CardDefaults.cardColors(LightGray, White, Gray,Red)
//            ) {
//                Column(verticalArrangement = Arrangement.Center) {
//                    Text(text = "Welcome", textAlign = TextAlign.Center, fontSize = 15.sp)
//                }
//            }
//            ElevatedCard(onClick = { /*TODO*/ }, modifier = Modifier
//                .width(170.dp)
//                .height(170.dp)
//                .align(CenterVertically),
//                colors = CardDefaults.cardColors(LightGray, White, Gray,Red)
//
//                ) {
//                Column(verticalArrangement = Arrangement.Center){
//                    Text(text = "Karibu", textAlign = TextAlign.Center, fontSize = 15.sp)
//                }
//            }
//
//        }
        LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
            val dataList = DataList()
            val strings = dataList.mutableStringList
            items(strings.size){item ->
                ElevatedCard(onClick = { /*TODO*/ }, modifier = Modifier
                    .width(170.dp)
                    .height(170.dp),
                    colors = CardDefaults.cardColors(LightGray, White, Gray,Red)

                ) {
                    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                        Text(text = "\n\n\n\n\t\t\t\t\t $item ${strings[item]}", textAlign = TextAlign.Center, fontSize = 15.sp)
                    }
                }

            }
        }, verticalArrangement = Arrangement.spacedBy(3.dp), horizontalArrangement = Arrangement.spacedBy(3.dp))
    }
}