//package seniordeveloper.peter.skylinearonepoolservice.technicals
//
//import android.annotation.SuppressLint
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Info
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.collectAsState
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.Color.Companion.Blue
//import androidx.compose.ui.graphics.ColorFilter
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.SpanStyle
//import androidx.compose.ui.text.buildAnnotatedString
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.text.withStyle
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import kotlinx.coroutines.launch
//import seniordeveloper.peter.skylinearonepoolservice.R
//import seniordeveloper.peter.skylinearonepoolservice.data_Sets.DataList
//import seniordeveloper.peter.skylinearonepoolservice.viewModels.SignUpViewModel
//
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnrememberedMutableState")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SignUpUser(viewModel: SignUpViewModel = hiltViewModel(),navController:NavHostController) {
//
//    val context = LocalContext.current
//    val email = remember { mutableStateOf("") }
//    val password = remember { mutableStateOf("") }
//    val confirmPassword = remember { mutableStateOf(TextFieldValue()) }
//    var showDialog by remember{ mutableStateOf(false) }
//
//    val scope = rememberCoroutineScope()
//    val state = viewModel.signUpState.collectAsState(initial = true)
//
//
//    val nameErrorState = remember { mutableStateOf(false) }
//    val emailErrorState = remember { mutableStateOf(false) }
//    val passwordErrorState = remember { mutableStateOf(false) }
//    val confirmPasswordErrorState = remember { mutableStateOf(false) }
//    val scrollState = rememberScrollState()
//
////    val authViewModel: AuthViewModel = viewModel()
//    val username by mutableStateOf("")
//    val userpassword by mutableStateOf("")
//
//    val dataList = DataList()
//
//
//    Scaffold(
//        modifier = Modifier,
//        topBar = {
//            TopAppBar( title = { Text(text = "Registration") },
//                navigationIcon = {
//                    IconButton(onClick = {
////                        navController.navigate("mainPage")
//                    }) {
//                        Icon(Icons.Default.ArrowBack, contentDescription = "back to home")
//                    }
//                },
//                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(Blue,Color.Green,Color.White,Color.White)
//
//
//            )
//        }
//    ) {
//
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 5.dp)
//                .verticalScroll(scrollState),
//            verticalArrangement = Arrangement.Center,
//        ) {
//
//            Text(text = buildAnnotatedString {
//                withStyle(style = SpanStyle(color = Blue)) {
//                    append("R")
//                }
//                withStyle(style = SpanStyle(color = Color.Black)) {
//                    append("egistration")
//                }
//            }, fontSize = 30.sp)
//            Spacer(Modifier.size(16.dp))
//
//            OutlinedTextField(
//                value = email.value,
//                onValueChange = {
//                    if (emailErrorState.value) {
//                        emailErrorState.value = false
//                    }
//                    email.value = it
//                },
//
//                modifier = Modifier.fillMaxWidth(),
//                isError = emailErrorState.value,
//                label = {
//                    Text(text = "Email*")
//                },
//            )
//            if (emailErrorState.value) {
//                Text(text = "Required", color = Color.Red)
//            }
//            Spacer(modifier = Modifier.size(16.dp))
//            }
//
//            Spacer(Modifier.size(16.dp))
//            val passwordVisibility = remember { mutableStateOf(true) }
//            OutlinedTextField(
//                value = password.value,
//                onValueChange = {
//                    if (passwordErrorState.value) {
//                        passwordErrorState.value = false
//                    }
//                    password.value = it
//                },
//                modifier = Modifier.fillMaxWidth(),
//                label = {
//                    Text(text = "Password*")
//                },
//                isError = passwordErrorState.value,
//                trailingIcon = {
//                    IconButton(onClick = {
//                        passwordVisibility.value = !passwordVisibility.value
//                    }) {
//                        if (passwordVisibility.value)
//                            Image(
//                                painter = painterResource(id = R.drawable.visibility_off),
//                                contentDescription = "visibility off",
//                                Modifier.size(20.dp),
//                                colorFilter = ColorFilter.tint(Color.Blue)
//                            )
//                        else
//                            Image(
//                                painter = painterResource(id = R.drawable.visibility_on),
//                                contentDescription = "visibility",
//                                Modifier.size(20.dp),
//                                colorFilter = ColorFilter.tint(Color.Blue)
//
//
//                            )
//
//                    }
//                },
//                visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
//            )
//            if (passwordErrorState.value) {
//                Text(text = "Required", color = Color.Red)
//            }
//
//            Spacer(Modifier.size(16.dp))
//            val cPasswordVisibility = remember { mutableStateOf(true) }
//            OutlinedTextField(
//                value = confirmPassword.value,
//                onValueChange = {
//                    if (confirmPasswordErrorState.value) {
//                        confirmPasswordErrorState.value = false
//                    }
//                    confirmPassword.value = it
//                },
//                modifier = Modifier.fillMaxWidth(),
//                isError = confirmPasswordErrorState.value,
//                label = {
//                    Text(text = "Confirm Password*")
//                },
//                trailingIcon = {
//                    IconButton(onClick = {
//                        cPasswordVisibility.value = !cPasswordVisibility.value
//                    }) {
//                        if (cPasswordVisibility.value)
//                            Image(
//                                painter = painterResource(id = R.drawable.visibility_off),
//                                contentDescription = "visibility off",
//                                Modifier.size(20.dp),
//                                colorFilter = ColorFilter.tint(Color.Blue)
//
//
//                            )
//                        else
//                            Image(
//                                painter = painterResource(id = R.drawable.visibility_on),
//                                contentDescription = "visibility",
//                                Modifier.size(20.dp),
//                                colorFilter = ColorFilter.tint(Color.Blue)
//
//
//                            )
//
//                    }
//                },
//                visualTransformation = if (cPasswordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None
//            )
//            if (confirmPasswordErrorState.value) {
//                val msg = if (confirmPassword.value.text.isEmpty()) {
//                    "Required"
//                } else if (confirmPassword.value.text != password.value) {
//                    "Password not matching"
//                } else {
//                    ""
//                }
//                Text(text = msg, color = Color.Red)
//            }
//            Spacer(Modifier.size(16.dp))
//            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//                OutlinedButton(
//                    onClick = {
//                        when {
//
//                            email.value.isEmpty() -> {
//                                emailErrorState.value = true
//                            }
//
//                            password.value.isEmpty() -> {
//                                passwordErrorState.value = true
//                            }
//
//                            confirmPassword.value.text.isEmpty() -> {
//                                confirmPasswordErrorState.value = true
//                            }
//
//                            confirmPassword.value.text != password.value -> {
//                                confirmPasswordErrorState.value = true
//                            }
//
//                            else -> {
//                                scope.launch {
//                                    viewModel.registerUser(email.value,password.value)
//                                }
//                                showDialog = !showDialog
//
//                            }
//                        }
//                    },
//                    content = {
//                        Text(text = "Register", color = Blue)
//                    },
//                    modifier = Modifier.width(200.dp)
//                )
//            }
//            Spacer(Modifier.size(16.dp))
//            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
//                OutlinedButton(onClick = {
////                    navController.navigate("loginPage") {
////                        popUpTo(navController.graph.startDestinationId)
////                        launchSingleTop = true
////                    }
//                },Modifier.width(200.dp)) {
//                    Text(text = "Login", color = Blue)
//                }
//            }
//        }
//        if (showDialog){
//            AlertDialog(
//                onDismissRequest = { showDialog = false },
//                confirmButton = {
//                    OutlinedButton(onClick = {
//                        dataList.mutableLoginData[username] = userpassword
//                        showDialog = false
//                        Toast.makeText(
//                            context,
//                            "Registered successfully",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        dataList.mutableLoginData[username] = userpassword
////                        authViewModel.register(username, user_password)
////                        navController.navigate(Screen.Login.route)
//                    }) {
//                        Text(text = stringResource(R.string.ok))}
//                },
//                icon = { Icons.Filled.Info},
//                title = { Text(text = "Registration Success.")},
//                text ={ Text(text = " ${email.value }  Registered successfully")}
//            )
//        }
//    }
//
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewSignUpUser() {
//    val viewModel: SignUpViewModel = hiltViewModel()
//    val navsController = rememberNavController()
//    SignUpUser(viewModel = viewModel, navsController)
//}
