@echo off
echo Generate bitstream from an XML document and its schema . . .

if "%FLAVOR_HOME%" == "" goto noflavorhome

set _FLAVOR_BIN=%FLAVOR_HOME%\bin
set _IN_FILENAME=maptest2.xml
set _OUT_FILENAME=maptest2.bs

%_FLAVOR_BIN%\bitgen -ofile=%_OUT_FILENAME% -schema=y -full=y %_IN_FILENAME%

goto done

:noflavorhome
echo No FLAVOR_HOME environment variable set
goto done

:done
if not "%1" == "batch" pause
