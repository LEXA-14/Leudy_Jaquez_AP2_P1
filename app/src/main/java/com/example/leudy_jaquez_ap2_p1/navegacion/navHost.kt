package com.example.leudy_jaquez_ap2_p1.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.leudy_jaquez_ap2_p1.presentacion.x.xEdit.borrameEditScreen
import com.example.leudy_jaquez_ap2_p1.presentacion.x.xlist.borrameListScreen

@Composable
fun BorrameNavHost(
    navController: NavHostController = rememberNavController()

    ){
    NavHost(
        navController= navController,
        startDestination = screen.borrameList
    ){
        composable<screen.borrameList>{
            borrameListScreen(

                onAddBorrame ={
                    navController.navigate(screen.borrameForm(id=0))
                },
                onNavigateToEdit ={ id ->
                    navController.navigate(screen.borrameForm(id))
                },


            )
        }
        composable<screen.borrameForm> { backStackEntry ->

            borrameEditScreen(

                onBack = {
                    navController.popBackStack()
                }
            )
        }

    }
}