@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.samespacetask.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.samespacetask.ui.model.BottomNavigationItemDetail
import com.example.samespacetask.ui.theme.colorBlack
import com.example.samespacetask.ui.theme.colorWhite
import com.example.samespacetask.ui.theme.colorWhite87
import com.example.samespacetask.ui.theme.textStyleBold

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(modifier: Modifier) {
    val navController = rememberNavController()

    //initializing the default selected item
    var navigationSelectedItem by remember {
        mutableStateOf(0)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(modifier = modifier, bottomBar = {
        TabRow(selectedTabIndex = navigationSelectedItem) {
            getBottomNavigationItemList().forEachIndexed { index, item ->
                Tab(
                    selected = index == navigationSelectedItem,
                    onClick = {
                        navigationSelectedItem = index
                        navController.navigate(item.appScreens.route){
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    text = {
                        Text(
                            item.title,
                        )
                    })
            }
        }
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppScreens.ForYou.route,
            modifier = Modifier.padding(paddingValues = innerPadding)
        ) {
            composable(AppScreens.ForYou.route) {
                ForYouScreen(modifier)
            }
            composable(AppScreens.TopTrack.route) {
                TopTrackScreen(modifier)
            }
        }
    }
}


fun getBottomNavigationItemList(): ArrayList<BottomNavigationItemDetail> {
    return arrayListOf(
        BottomNavigationItemDetail(title = "For You", appScreens = AppScreens.ForYou),
        BottomNavigationItemDetail(title = "Top Tracks", appScreens = AppScreens.TopTrack)
    )
}

