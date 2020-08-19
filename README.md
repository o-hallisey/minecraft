# minecraft
Minecraft modding

# Setup

1. Install [Gradle 4.9](https://gradle.org/releases/)
    1. Unzip to some local folder (navigate into the bin folder and copy the folder path for use in a later step)
1. Install [OpenJDK 14](https://jdk.java.net/14/)
    1. Unzip to some local folder (navigate into the bin folder and copy the folder path for use in a later step)
1. Add the `(path)\bin` where you unzipped the above to your PATH environment variable
 
# Build

1. Open a terminal (command prompt/power shell)
1. Navigate to the `forge-1.16.2-mod-dev` folder in this repo
1. Run `gradle build`
1. The resulting jar is created in `forge-1.16.2-mod-dev\build\libs`

## Build and Create Installer

### Additional Requirements
1. Install [NSIS](https://nsis.sourceforge.io/Main_Page)

### Build Everything (jar and installer)

1. Open a terminal (command prompt/power shell)
1. Run `BuildAndCreateInstaller.bat`
1. The installer will be built in the `installer` folder and moved to the root (where the batch is)

# Installer

See the Readme in the `installer` folder