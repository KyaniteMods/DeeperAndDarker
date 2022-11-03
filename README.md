<p align="center"><img src="https://github.com/KyaniteMods/DeeperAndDarker/blob/master/common/src/main/resources/banner.png" alt="banner" width="1024"></p>

---
A Minecraft 1.19 mod which features more blocks, items, armors, and hidden mysteries to complement the Deep Dark update. Such implementations include new sculk-related blocks, Warden armor and tools, the Otherside dimension, and secrets waiting to be discovered by you!

Deeper and Darker is in beta production currently; therefore, there will be bugs and crashes, so be sure to report them as an issue here!

# Contributions

[![Crowdin](https://badges.crowdin.net/deeper-and-darker/localized.svg)](https://crowdin.com/project/deeper-and-darker)

If you would like to help translate Deeper and Darker, head over to our [Crowdin](https://crowdin.com/project/deeper-and-darker) page. If there is a language not on the page which you would like to add translations for, start a discussion on Crowdin or join our [Discord](https://discord.gg/GDNRd5yvxa)! We'd love to make our mod even more accessible.

We accept pull requests, however, most development is internally done by the Kyanite Mods team.

# API

If you need Deeper And Darker as a library, eg: to create mixin-based compatability classes, or to access classes in Deeper And Darker, you can add it to your projects like so:

You can find the latest `deeper_darker_version` [on the maven repo.](https://maven.mineblock11.dev/releases)

```groovy
repositories {
    maven "https://maven.mineblock11.dev/releases"
}

dependencies {
    // Fabric
    implementation include("com.kyanite:deeperdarker-fabric:${deeper_darker_version}")
}
```

# Building From Source

If you want to build Deeper And Darker from source, clone this repo and run the following:

```shell
gradlew build
```

Build files are located in each sub-project's `build/libs` folder:

- `fabric/build/libs`
- `forge/build/libs`

