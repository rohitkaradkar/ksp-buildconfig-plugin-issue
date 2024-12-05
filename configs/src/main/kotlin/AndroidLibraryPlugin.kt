import com.android.build.api.dsl.LibraryExtension
import com.sample.configs.configureFlavors
import com.sample.configs.configureKotlinAndroid
import com.sample.configs.getVersionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("DEPRECATION")
class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = getVersionCatalog()
            with(pluginManager) {
                apply(libs.plugins.android.library.get().pluginId)
            }

            configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 34
                configureFlavors(this)
            }
        }
    }
}

