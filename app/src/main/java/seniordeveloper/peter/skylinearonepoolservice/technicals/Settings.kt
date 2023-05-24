package seniordeveloper.peter.skylinearonepoolservice.technicals

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylinearonepoolservice.models.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(navController: NavHostController) {
    val colors = Color(0xFF1976D2)
    Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(16.dp)

    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("App Settings") },
            navigationIcon = {
                IconButton(onClick = { navController.navigate(Screen.Main.route) }) {
                    Icon(Icons.Filled.ArrowBack, null,
                        modifier = Modifier.size(20.dp),
                        tint = Color.Black
                    )
                }
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Unspecified)
        )

        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 10.dp)) {
            val context = LocalContext.current
            Spacer(modifier = Modifier.height(20.dp))

            SettingsCard("General", Icons.Outlined.Build) {Toast.makeText(
                context,"Coming Up soon.🎼🎶🎙!",Toast.LENGTH_LONG).show()} // General
            SettingsCard("Sounds", Icons.Filled.Notifications){Toast.makeText(
                context, "Coming Up soon.🎼🎶🎙!",Toast.LENGTH_LONG).show()}
            SettingsCard("App Language", Icons.Filled.Search){ Toast.makeText(
                context, "Coming Up soon.🎼🎶🎙!",Toast.LENGTH_LONG).show()} // App Language
            SettingsCard("Backup", Icons.Outlined.Send){Toast.makeText(
                context, "Coming Up soon.🎼🎶🎙!",Toast.LENGTH_LONG).show() } // Backup
            SettingsCard("Privacy Center", Icons.Outlined.Lock){ Toast.makeText(
                context, "Coming Up soon.🎼🎶🎙!",Toast.LENGTH_LONG).show()}// Privacy Center
            SettingsCard("About Developer", Icons.Outlined.Info){navController.navigate(Screen.Profile.route) } // Privacy Center
            SettingsCard("Change Password", Icons.Outlined.Lock){navController.navigate(Screen.Reset.route) } // Privacy Center
            SettingsCard("Log Out", Icons.Outlined.ExitToApp){navController.navigate(Screen.Login.route) } // Privacy Center

        }

    }
}

@Composable
fun SettingsCard(title: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .padding(top = 10.dp)
            .clickable(onClick = onClick) // Make the row clickable
    ) {
        Image(
            imageVector = icon,
            contentDescription = title,
            modifier = Modifier.size(25.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            title,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.offset(5.dp, 5.dp)
        )
    }

    Spacer(modifier = Modifier.height(7.dp))
}

@Preview(showBackground = true)
@Composable
fun SettingsPreview() {
    SettingsPage(navController = rememberNavController())
}

//Row {
//    Image(
//        painter = painterResource(R.drawable.backup),
//        contentDescription = "Backup"
//    )
//    Spacer(modifier = Modifier.width(20.dp))
//    ClickableText(
//        text = AnnotatedString("Backup"),
//        onClick = {}
//    )
//}