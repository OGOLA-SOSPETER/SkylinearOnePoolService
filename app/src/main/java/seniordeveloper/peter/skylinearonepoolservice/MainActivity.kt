package seniordeveloper.peter.skylinearonepoolservice

import android.content.ContentValues
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import seniordeveloper.peter.skylinearonepoolservice.ui.theme.SkylinearOnePoolServiceTheme
import seniordeveloper.peter.skylinearonepoolservice.userFlows.AppDashboard
import seniordeveloper.peter.skylinearonepoolservice.userFlows.AppNavigation
import seniordeveloper.peter.skylinearonepoolservice.userFlows.UserLoginPage

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkylinearOnePoolServiceTheme {
                navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(navController = navController)
//                    UserLoginPage(navController = rememberNavController())
//                    AppDashboard(navController = rememberNavController())
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(ContentValues.TAG, getString(R.string.onstart_called))
    }

    override fun onResume() {
        super.onResume()
        Log.d(ContentValues.TAG, getString(R.string.onresume_called))
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(ContentValues.TAG, getString(R.string.onrestart_called))
    }

    override fun onPause() {
        super.onPause()
        Log.d(ContentValues.TAG, getString(R.string.onpause_called))
    }

    override fun onStop() {
        super.onStop()
        Log.d(ContentValues.TAG, getString(R.string.onstop_called))
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ContentValues.TAG, getString(R.string.ondestroy_called))
    }
}


@RequiresApi(Build.VERSION_CODES.M)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SkylinearOnePoolServiceTheme {
        UserLoginPage(navController = rememberNavController())
    }
}