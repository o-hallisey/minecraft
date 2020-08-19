; minecraft_mod.nsi
;
; Creates an installer/uninstaller for the minecraft jar specified in the defines section
;
; Generate from command line: 
; "%ProgramFiles(x86)%\NSIS\makensis" minecraft_mod.nsi
;
;--------------------------------

;--- Defines
; The jar file we embed
!define MODJAR "bnegames-mod-1.0.jar"
!define MODJAR_PATH "..\forge-1.16.2-mod-dev\build\libs\"
!define REGISTRY_UNINSTALL_NAME "MinecraftBNEMod"
!define UNINSTALL_EXE_NAME "bne-mod-uninstall.exe"

; The name of the installer
Name "Minecraft BNE Mod"

; The file to write
OutFile "MinecraftBNEModInstaller.exe"

; Request application privileges for Windows Vista
RequestExecutionLevel highest

; Build Unicode installer
Unicode True

; The default installation directory
InstallDir $APPDATA\.minecraft\mods


;--------------------------------

; Pages

Page directory
Page instfiles

;--------------------------------

; The stuff to install
Section "Install" ;No components page, name is not important

  ; Set output path to the installation directory.
  SetOutPath $INSTDIR
  
  ; Put file there
  File ${MODJAR_PATH}${MODJAR}
  
  ; Uninstall issues
  ; https://stackoverflow.com/questions/32077917/nsis-installer-not-writing-registry-entries
  ; Software\WOW6432Node\Microsoft\Windows\CurrentVersion\Uninstall -- may write here
  
  ; write uninstall strings
  SetRegView 64
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${REGISTRY_UNINSTALL_NAME}" "DisplayName" "Minecraft BNE Mod (remove only)"
  WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${REGISTRY_UNINSTALL_NAME}" "UninstallString" '"$INSTDIR\${UNINSTALL_EXE_NAME}"'
  ; write the uninstaller
  WriteUninstaller "${UNINSTALL_EXE_NAME}"
  
SectionEnd ; end the section

; Uninstaller

UninstallText "This will remove the jar(s) installed by the Minecraft BNE Mod"

Section "Uninstall"

  Delete "$INSTDIR\${MODJAR}"
  SetRegView 64
  DeleteRegKey HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\${REGISTRY_UNINSTALL_NAME}"

SectionEnd
