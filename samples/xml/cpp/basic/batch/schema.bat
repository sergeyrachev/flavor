@echo off
echo Generate an XML schema for a given Flavor description . . .

if "%FLAVOR_HOME%" == "" goto noflavorhome

set _FLAVOR_BIN=%FLAVOR_HOME%\bin
set _IN_FILENAME=%FLAVOR_HOME%\samples\fl\basic.fl
set _OUT_FILENAME=basic.xsd

%_FLAVOR_BIN%\flavorc -gx -ox %_OUT_FILENAME% %_IN_FILENAME%

goto done

:noflavorhome
echo No FLAVOR_HOME environment variable set
goto done

:done
if not "%1" == "batch" pause
