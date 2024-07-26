package com.mario.notesapp.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mario.notesapp.AddingNoteScreen
import com.mario.notesapp.EditingNoteScreen
import com.mario.notesapp.HomeScreen
import com.mario.notesapp.routes.Route.ADD_NOTE
import com.mario.notesapp.routes.Route.EDIT_NOTE
import com.mario.notesapp.routes.Route.HOME

object Route {
    const val HOME = "home"
    const val ADD_NOTE = "add_note"
    const val EDIT_NOTE = "edit_note"
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(route = HOME) { HomeScreen(navController = navController) }
        composable(route = ADD_NOTE) { AddingNoteScreen(navController = navController) }
        //According to the docs: You cannot pass complex data using parcelable
        //https://developer.android.com/guide/navigation/use-graph/pass-data
        composable(
            route = "$EDIT_NOTE/{id}/{title}/{details}",
            arguments = listOf(
                navArgument("id") { type = NavType.IntType},
                navArgument("details") { type = NavType.StringType},
                navArgument("title") { type = NavType.StringType}
            )
        ) {
            val id = it.arguments?.getInt("id")!!
            val details = it.arguments?.getString("details")!!
            val title = it.arguments?.getString("title")!!
            EditingNoteScreen(id, title, details, navController = navController)
        }

    }

}