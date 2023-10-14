package com.example.samespacetask.ui.screen

sealed class AppScreens(val route : String){
    data object ForYou:AppScreens("for_you")
    data object TopTrack:AppScreens("top_track")
}



