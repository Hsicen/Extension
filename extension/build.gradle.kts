plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.github.dcendents.android-maven")
}

android {
    compileSdk = DepVersion.compileSdk

    defaultConfig {
        minSdk = DepVersion.minSdk
        targetSdk = DepVersion.targetSdk
        versionCode = DepVersion.versionCode
        versionName = DepVersion.versionName
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(Deps.fileMap))
    implementation(Deps.kotlinStb)

    implementation(Deps.appCompat)
    implementation(Deps.constrainLayout)
    implementation(Deps.material)

    implementation(Deps.coroutines)
    implementation(Deps.coreKtx)
    implementation(Deps.lifecycleLiveDataKtx)

    implementation(Deps.logger)
}
