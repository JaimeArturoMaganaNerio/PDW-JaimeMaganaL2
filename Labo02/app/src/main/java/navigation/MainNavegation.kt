package navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import screen.HomeScreen
import screen.LightSensor
import screen.UIlISTA

@Composable
fun MainNavegation() {
    val backStack = rememberNavBackStack(AppRoutes.HomeScreen)

    NavDisplay(
        backStack = backStack,
        onBack = {
            if (backStack.size > 1) {
                backStack.removeLastOrNull()
            }
        },
        entryProvider = entryProvider {
            entry<AppRoutes.HomeScreen> {
                HomeScreen(
                    onNavigateToLista = { backStack.add(AppRoutes.ListaNombres) },
                    onNavigateToSensor = { backStack.add(AppRoutes.Sensor) }
                )
            }
            
            entry<AppRoutes.ListaNombres> {
                UIlISTA(modifier = Modifier)
            }
            
            entry<AppRoutes.Sensor> {
                LightSensor()
            }
        }
    )
}
