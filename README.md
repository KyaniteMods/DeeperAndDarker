<p align="center"><img src="https://github.com/KyaniteMods/DeeperAndDarker/blob/master/common/src/main/resources/banner.png" alt="banner" width="1024"></p>

---
A Minecraft 1.19 mod which features more blocks, items, armors, and hidden mysteries to complement the Deep Dark update. Such implementations include new sculk-related blocks, Warden armor and tools, the Otherside dimension, and secrets waiting to be discovered by you!

If you happen to find any bugs or inconsistencies in Deeper and Darker, be sure to report them here!

# Contributions
[![Crowdin](https://badges.crowdin.net/deeper-and-darker/localized.svg)](https://crowdin.com/project/deeper-and-darker)

If you would like to help translate Deeper and Darker, head over to our [Crowdin](https://crowdin.com/project/deeper-and-darker) page. If there is a language not on the page which you would like to add translations for, start a discussion on Crowdin or join our [Discord](https://discord.gg/GDNRd5yvxa)! We'd love to make our mod even more accessible.

We accept pull requests; however, the majority of development is done internally by the Kyanite Mods team.

# API

If you want to add Deeper and Darker as a library, you can add it by finding the latest `deeper_darker_version` on the [maven repo](https://maven.mineblock11.dev/#/releases/com/kyanite) or on [CurseForge](https://curseforge.com/minecraft/mc-mods/deeperdarker).

![](https://maven.mineblock11.dev/api/badge/latest/releases/com/kyanite/deeperdarker-fabric?color=00898c&name=Fabric&prefix=v)
![](https://maven.mineblock11.dev/api/badge/latest/releases/com/kyanite/deeperdarker-forge?color=00898c&name=Forge&prefix=v)

```groovy
repositories {
    maven "https://maven.mineblock11.dev/releases"
}

dependencies {
    // Fabric
    // DO NOT "include" DEEPER AND DARKER, IT WILL NOT WORK.
    implementation "com.kyanite:deeperdarker-fabric:${deeper_darker_version}"
    
    // Forge
    // DO NOT Jar-Jar DEEPER AND DARKER, IT WILL NOT WORK.
    runtimeOnly fg.deobf("com.kyanite:deeperdarker-forge:${deeper_darker_version}")
    compileOnly fg.deobf("com.kyanite:deeperdarker-forge:${deeper_darker_version}")
}
```

# Building From Source

If you want to build Deeper And Darker from source, clone this repo and run the following:

```
gradlew build
```

Build files are located in each sub-project's `build/libs` folder:

- `fabric/build/libs`
- `forge/build/libs`
