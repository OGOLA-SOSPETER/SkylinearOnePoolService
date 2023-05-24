package seniordeveloper.peter.skylinearonepoolservice.userFlows

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylinearonepoolservice.R
import seniordeveloper.peter.skylinearonepoolservice.models.Screen


@RequiresApi(Build.VERSION_CODES.M)
@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserLoginPage(navController:NavHostController) {
    var userName by remember{ mutableStateOf("") }
    var password by  remember{ mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var showDialog by remember{mutableStateOf(false)}
    var logErrorDialog by remember{mutableStateOf(false)}
    var passLog by remember{mutableStateOf(false)}




    Column(modifier = Modifier.padding(top = 30.dp, start = 30.dp, end = 30.dp),
    verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(15.dp))
        Image(painter = painterResource(R.drawable.log),
            contentDescription = stringResource(R.string.login_image),
            Modifier.size(200.dp)

        )

        Text(
            text = stringResource(R.string.logtext),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(3.dp)
                .offset(3.dp, 10.dp)
            )

Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            placeholder = { Text(text = stringResource(R.string.username))},
            keyboardActions = KeyboardActions(
                onDone = { /* Handle "Done" action */ }
            ),
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it},
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(
                onDone = { /* Handle "Done" action */ }
            ),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        placeholder = { Text(text = stringResource(R.string.password))},
        trailingIcon = {
            val description = if (passwordVisible) stringResource(R.string.hide_password) else stringResource(
                            R.string.show_password)

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    if (passwordVisible)
                        Image(
                            painter = painterResource(id = R.drawable.visibility_on),
                            modifier = Modifier.size(20.dp),
                            contentDescription = description
                        )
                    else
                        Image(
                            painter = painterResource(id = R.drawable.visibility_off),
                            modifier = Modifier.size(20.dp),
                            contentDescription = description
                        )
                }
            }
        )
        Spacer(modifier = Modifier.height(15.dp))

//        Button(onClick = {showDialog = true},modifier = Modifier.width(150.dp)){
        Row{
        OutlinedButton(onClick = {

            if (userName != "" &&  password.length <=8)
            {
                val enteredPassword = password

                val passwordFromData = "1234"

                if (passwordFromData == enteredPassword) {
                    passLog = !passLog
                    navController.navigate(Screen.Main.route)
                }
                else{
                    logErrorDialog = !logErrorDialog
                }
            }

            else
            {
                showDialog = !showDialog
            }
            },modifier = Modifier.width(125.dp)) {

            Text(
                text = stringResource(R.string.login),
                fontFamily = FontFamily.Monospace,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                color = Color.Black

            )
        }
            OutlinedButton(onClick = { navController.navigate(Screen.Registration.route) }
                ,modifier = Modifier.width(125.dp))
            {
                Text(
                    text = stringResource(R.string.register),
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    color = Color.Black
                )
            }
    }
//        , colors = ButtonDefaults.elevatedButtonColors(White)
        if(showDialog){
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        OutlinedButton(onClick = {showDialog = false}) {
                            Text(text = stringResource(R.string.ok))}
                    },
                    icon = { Icons.Filled.Info},
                    title = { Text(text = "Invalid Credentials!") },
                    text = { Text(text = "Kindly Fill in the Correct Credentials.") }
                )
            }
        if(passLog){
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    OutlinedButton(onClick = {showDialog = false}) {
                        Text(text = stringResource(R.string.ok))}
                },
                icon = { Icons.Filled.Info},
                title = { Text(text = "Login Success!") },
                text = { Text(text = "User Logged in Successsfully.") }
            )
        }



        if(logErrorDialog){
            AlertDialog(
                onDismissRequest = { showDialog = false },
                confirmButton = {
                    OutlinedButton(onClick = {logErrorDialog = false}) {
                        Text(text = stringResource(R.string.ok))}
                },
                icon = { Icons.Filled.Info},
                title = { Text(text = "Invalid Credentials!") },
                text = { Text(text = "Invalid Username or Password.") }
            )
        }
//        if (showDialog) {
//            AlertDialog(
//                onDismissRequest = { showDialog = false },
//                confirmButton = {
//                    OutlinedButton(onClick = {navController.navigate("mainPage")}) {
//                        Text(text = stringResource(R.string.login))}
//                    },
//                modifier = Modifier.width(400.dp).height(180.dp),
//                dismissButton = {
//                    OutlinedButton(onClick = {showDialog = false}) {
//                        Text(text = stringResource(R.string.cancel))}
//                },
//                icon = { Icons.Filled.Info},
//                title = { Text(text = "Confirm Login") },
//                text = { Text(text = "Proceed to Main Page?") }
//            )
//        }

        OutlinedButton(
            modifier = Modifier.width(250.dp), onClick = {/*TODO*/}) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.googlelogo),
                    contentDescription = stringResource(R.string.googlelogo),
                    modifier = Modifier.size(25.dp)
                )
                Text(
                    stringResource(R.string.google_account_login),
                    Modifier.offset(5.dp, 2.dp),
                    color = Color.DarkGray
                )
            }
        }

        OutlinedButton(modifier = Modifier.width(250.dp), onClick = { navController.navigate(Screen.SignUp.route)}) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.email),
                    contentDescription = stringResource(R.string.email_logo),
                    modifier = Modifier.size(25.dp)
                )
                Text(
                    stringResource(R.string.email_account_login),
                    Modifier.offset(5.dp, 2.dp),
                    color = Color.DarkGray
                )
            }
        }

        OutlinedButton(modifier = Modifier.width(250.dp), onClick = { navController.navigate(Screen.Main.route) }) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.phone),
                    contentDescription = stringResource(R.string.phone_login),
                    modifier = Modifier.size(25.dp)
                )
                Text(
                    stringResource(R.string.login_with_phone),
                    Modifier.offset(5.dp, 2.dp),
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LogPreview(){
    UserLoginPage(navController = rememberNavController())
}