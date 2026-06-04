package com.example.leudy_jaquez_ap2_p1.navegacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.leudy_jaquez_ap2_p1.presentacion.x.xEdit.borrameEditScreen
import com.example.leudy_jaquez_ap2_p1.presentacion.x.xlist.borrameScreen

@Composable
fun BorrameNavHost(
    navController: NavController = rememberNavController(),
    modifier: Modifier= Modifier
    ){
    NavHost(
        navController= navController,
        startDestination = screen.borrameList


    ){
        composable<screen.borrameList>{
            borrameScreen(
                onAddBorrame ={
                    navController.navigate(screen.borrameForm(id=0))
                },
                onNavigateToEdit ={
                    id->navController.navigate(screen.borrameForm(id))
                },


            )
        }
        composable<screen.borrameForm> { backStackEntry ->

            borrameEditScreen(

                onBack = {
                    navController.navigateUp()
                }
            )
        }

    }
}