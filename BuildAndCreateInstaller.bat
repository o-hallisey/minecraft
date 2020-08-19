@echo off
SET ROOT=%CD%

cd forge-1.16.2-mod-dev
call gradle build
if "%ERRORLEVEL%" == "0" goto :createinstall
goto :fail

:createinstall
cd ..\installer
call buildInstaller.bat
if NOT "%ERRORLEVEL%" == "0" goto :fail
REM NOTE: Just move every exe...
move *.exe %ROOT%

:done
cd %ROOT%
goto :EOF

:fail
cd %ROOT%
ECHO There was an error. Stopping build.
