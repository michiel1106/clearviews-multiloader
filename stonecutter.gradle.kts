plugins {
    id("dev.kikugie.stonecutter")
    id("co.uzzu.dotenv.gradle") version "4.0.0"
    alias(libs.plugins.publishing)
}

stonecutter active "26.1.2-fabric" /* [SC] DO NOT EDIT */

stonecutter parameters {
    swaps["mod_version"] = "\"${property("mod.version")}\";"
    swaps["minecraft"] = "\"${node.metadata.version}\";"
    constants["release"] = property("mod.id") != "template"

    replacements {
        // For 1.21.11+: ResourceLocation → Identifier
        string(current.parsed >= "1.21.11") {
            replace("ResourceLocation", "Identifier")
        }
        // For 26.1+: official mappings instead of named
        string(current.parsed >= "26.1") {
            replace("classTweaker v1 named", "classTweaker v1 official")
        }
    }
}

tasks.named("publishMods") {
    group = "build"
}