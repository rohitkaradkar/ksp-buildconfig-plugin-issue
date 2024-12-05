import com.sample.configs.getVersionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * Plugin to configure gradle module with Hilt dependencies.
 */
class AndroidHiltPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        with(project) {

            val libs = getVersionCatalog()
            with(pluginManager) {
                apply(libs.plugins.ksp.get().pluginId)
                apply(libs.plugins.dagger.hilt.get().pluginId)
            }

            dependencies {
                add("implementation", libs.hilt.core)
                add("implementation", libs.hilt.android)
                add("ksp", libs.hilt.compiler)
            }
        }
    }
}
