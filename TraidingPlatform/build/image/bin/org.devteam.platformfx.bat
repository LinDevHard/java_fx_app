@echo off
set DIR="%~dp0"
set JAVA_EXEC="%DIR:"=%\java"
pushd %DIR% & %JAVA_EXEC%  -m org.devteam.platformfx/org.devteam.MainApp  %* & popd
