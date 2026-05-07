package navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
sealed interface AppRoutes : NavKey {

    @Serializable
    data object HomeScreen : AppRoutes

    @Serializable
    data object ListaNombres : AppRoutes

    @Serializable
    data object Sensor : AppRoutes

}
