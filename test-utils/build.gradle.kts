
plugins {
    id("org.kodein.mpp")
}

kodein {
    kotlin {

        common.main.dependencies {
            api("org.jetbrains.kotlin:kotlin-test-common")
            api("org.jetbrains.kotlin:kotlin-test-annotations-common")
        }

        add(kodeinTargets.jvm) {
            main.dependencies {
                api("org.jetbrains.kotlin:kotlin-test")
                api("org.jetbrains.kotlin:kotlin-test-junit")
                api("junit:junit:4.12")
            }
        }

        add(kodeinTargets.js) {
            main.dependencies {
                api("org.jetbrains.kotlin:kotlin-test-js")
                api("org.jetbrains.kotlin:kotlin-stdlib-js")
            }
        }

        add(kodeinTargets.native.all)

    }
}
