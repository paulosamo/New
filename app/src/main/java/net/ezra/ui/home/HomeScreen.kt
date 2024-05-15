//package net.ezra.ui.home
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.ClickableText
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Refresh
//import androidx.compose.material3.Button
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedButton
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBar
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.rememberNavController
//import net.ezra.navigation.ROUTE_ABOUT
//import net.ezra.navigation.ROUTE_HOME
//import net.ezra.navigation.ROUTE_MIT
//import net.ezra.navigation.ROUTE_SERVICES
//import net.ezra.navigation.ROUTE_CONTACT
//import net.ezra.navigation.ROUTE_EVENING
//import net.ezra.navigation.ROUTE_PRODUCTS
//import net.ezra.navigation.ROUTE_SHOP
//
//import net.ezra.R
//import net.ezra.navigation.ROUTE_ADD_STUDENTS
//import net.ezra.navigation.ROUTE_BOOKING
//import net.ezra.navigation.ROUTE_HOM
//import net.ezra.navigation.ROUTE_LOGIN
//import net.ezra.navigation.ROUTE_WOUND
//import okhttp3.internal.wait
//import java.util.Vector
//
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun HomeScreen(navController: NavHostController) {
//Box(modifier = Modifier
//    .fillMaxSize()
//    .fillMaxWidth()
//    .background(Color.Black)
//    .padding(5.dp),
//
//) {
//    Image(painter = painterResource(id = R.drawable.img_5), contentDescription = "")
//
//    Scaffold(
//        bottomBar = { BottomBar()},
////        content ={
//////                 Box(modifier = Modifier.fillMaxSize().fillMaxWidth().background(color = Color.Blue).padding(50.dp))
////        },
//
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "Go back")
//                },
//                navigationIcon = {
//                    IconButton(onClick = {}) {
//                        Icon(Icons.Filled.ArrowBack, "backIcon")
//                    }
//                },
////                backgroundColor = MaterialTheme.colors.primary,
////                contentColor = Color.White,
////                elevation = 10.dp
//            )
//
//        }, content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(16.dp)
//            ) {
//                Card (modifier = Modifier.clickable { navController.navigate(ROUTE_HOM){popUpTo(ROUTE_EVENING){inclusive=true} }}){
//                    IconButton(onClick = {  }) {
//
//                    }
//
//                }
//
//                Text(
//                    text = "Welcome to Wound Care",
//                    modifier = Modifier
//                        .padding(bottom = 16.dp),
//                    color = Color.Magenta
//                )
//
//                Image(
//                    painter = painterResource(id = R.drawable.img),
//                    contentDescription = "Wound Care Image",
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(200.dp),
//                    contentScale = ContentScale.FillWidth
//                )
//
//                Text(
//                    text = "Wound care involves the assessment, treatment, and management of wounds to promote healing and prevent complications." +
//                            "It encompasses a range of techniques and interventions, including cleaning, dressing, and protecting the wound site. " +
//                            "Proper wound care is essential for preventing infection, reducing pain, and facilitating the healing process.,",
//                    modifier = Modifier
//                        .padding(vertical = 16.dp),
//                    color = Color.Black
//                )
//
//                Card {
//                    Column {
//                        Text(
//                            modifier = Modifier
//
//                                .clickable {
//                                    navController.navigate(ROUTE_BOOKING) {
//                                        popUpTo(ROUTE_HOME) { inclusive = true }
//                                    }
//                                },
//                            text = "BOOK AN APPOINTMENT",
//                            textAlign = TextAlign.Center,
//                            color = MaterialTheme.colorScheme.onSurface
//
//
//                        )
//                        Text(
//                            modifier = Modifier
//
//                                .clickable {
//                                    navController.navigate(ROUTE_MIT) {
//                                        popUpTo(ROUTE_HOME) { inclusive = true }
//                                    }
//                                },
//                            text = "LOG_IN",
//                            textAlign = TextAlign.Center,
//                            color = MaterialTheme.colorScheme.onSurface
//
//
//                        )
//
//                        Text(
//                            modifier = Modifier
//
//                                .clickable {
//                                    navController.navigate(ROUTE_WOUND) {
//                                        popUpTo(ROUTE_HOME) { inclusive = true }
//                                    }
//                                },
//                            text = "wound details",
//                            textAlign = TextAlign.Center,
//                            color = MaterialTheme.colorScheme.onSurface
//
//
//                        )
//                        Text(
//                            modifier = Modifier
//
//                                .clickable {
//                                    navController.navigate(ROUTE_PRODUCTS) {
//                                        popUpTo(ROUTE_HOME) { inclusive = true }
//                                    }
//                                },
//                            text = "WOUND CLEANING STEPS",
//                            textAlign = TextAlign.Center,
//                            color = MaterialTheme.colorScheme.onSurface
//
//
//                        )
//
//
//
//                    }
//                    Card {
//                        Text(
//                            modifier = Modifier
//
//                                .clickable {
//                                    navController.navigate(ROUTE_SERVICES) {
//                                        popUpTo(ROUTE_HOME) { inclusive = true }
//                                    }
//                                },
//                            text = "services we offer",
//                            textAlign = TextAlign.Center,
//                            color = MaterialTheme.colorScheme.onSurface
//
//
//                        )
//                    }
//                }
//
//            }
//
//
//        })
//}
//
//
//}
//@Composable
//fun BottomBar() {
//    val selectedIndex = remember { mutableStateOf(0) }
//    BottomNavigation(elevation = 10.dp) {
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Home,""
//
//            )
//        },
//            label = { Text(text = "Home") }, selected = (selectedIndex.value == 0), onClick = {
//                selectedIndex.value = 0
//            })
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Refresh,"")
//        },
//            label = { Text(text = "Refresh") }, selected = (selectedIndex.value == 1), onClick = {
//                selectedIndex.value = 1
//            })
//        BottomNavigationItem(icon = {
//            Icon(imageVector = Icons.Default.Person, "")
//        },
//            label = { Text(text = "Profile") }, selected = (selectedIndex.value == 2), onClick = {
//                selectedIndex.value = 2
//            })
//    }
//}
//
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewLight() {
//    HomeScreen(rememberNavController())
//}
//

package net.ezra.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.ezra.R
import net.ezra.navigation.ROUTE_BOOKING
import net.ezra.navigation.ROUTE_EVENING
import net.ezra.navigation.ROUTE_HOM
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_MIT
import net.ezra.navigation.ROUTE_PATIENT
import net.ezra.navigation.ROUTE_PRODUCTS
import net.ezra.navigation.ROUTE_SERVICES
import net.ezra.navigation.ROUTE_STUDENT

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    val selectedIndex = remember { mutableStateOf(0) }

    Box(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()
        .background(Color.Black)
        .padding(5.dp)
    ) {
        Image(painter = painterResource(id = R.drawable.img_5), contentDescription = "")

        Scaffold(
            bottomBar = { BottomBar(selectedIndex = selectedIndex, navController = navController) },
            topBar = { TopBar(navController = navController) },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Card(modifier = Modifier.clickable {
                        navController.navigate(ROUTE_HOM) {
                            popUpTo(ROUTE_EVENING) { inclusive = true }
                        }
                    }) {
                        // Placeholder for card content
                    }

                    // Other content
                }
            }
        )

    }
Card(
    modifier = Modifier.fillMaxWidth()
) {
    androidx.compose.material3.Text(
        text = "Welcome to Wound Care",
        modifier = Modifier
            .padding(bottom = 16.dp),
        color = Color.Magenta
    )

    Image(
        painter = painterResource(id = R.drawable.img),
        contentDescription = "Wound Care Image",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        contentScale = ContentScale.FillWidth
    )

    androidx.compose.material3.Text(
        text = "Wound care involves the assessment, treatment, and management of wounds to promote healing and prevent complications." +
                "It encompasses a range of techniques and interventions, including cleaning, dressing, and protecting the wound site. " +
                "Proper wound care is essential for preventing infection, reducing pain, and facilitating the healing process.,",
        modifier = Modifier
            .padding(vertical = 16.dp),
        color = Color.Black
    )
    Card {
        androidx.compose.material3.Text(
            modifier = Modifier
                .clickable {
                    navController.navigate(ROUTE_STUDENT) {
                        popUpTo(ROUTE_HOME) { inclusive = true }
                    }
                },
            text = "add patient",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )


    }

    Card {
        androidx.compose.material3.Text(
            modifier = Modifier
                .clickable {
                    navController.navigate(ROUTE_SERVICES) {
                        popUpTo(ROUTE_HOME) { inclusive = true }
                    }
                },
            text = "go services",
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )

    }
}

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavHostController) {
    TopAppBar(
        title = { Text(text = "Go back") },
        navigationIcon = {
            IconButton(onClick = { navController.navigateUp() }) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        }
    )
}

@Composable
fun BottomBar(selectedIndex: MutableState<Int>, navController: NavHostController) {
    BottomNavigation(elevation = 10.dp) {
        val items = listOf(
            Pair(Icons.Default.Home, "Go book online"),
            Pair(Icons.Default.Refresh, "Go tp product content"),
            Pair(Icons.Default.Person, "Profile")
        )
        items.forEachIndexed { index, (icon, label) ->
            BottomNavigationItem(
                icon = { Icon(imageVector = icon, contentDescription = null) },
                label = { Text(text = label) },
                selected = (selectedIndex.value == index),
                onClick = {
                    selectedIndex.value = index // Assign the new value to selectedIndex
                    // Handle bottom navigation item click here
                    when (index) {
                        0 -> navController.navigate(ROUTE_BOOKING)
                        1 -> navController.navigate(ROUTE_PRODUCTS)
                        2 -> navController.navigate(ROUTE_MIT)
                    }
                }
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewLight() {
    HomeScreen(rememberNavController())
}

