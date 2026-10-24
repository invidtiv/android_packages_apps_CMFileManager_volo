param(
    [string]$Serial = 'emulator-5556',
    [string]$Package = 'com.babysharks.filemanager.dev',
    [string]$Directory = '/storage/emulated/0/TeamFiles/BS8'
)

$ErrorActionPreference = 'Stop'
$files = & adb -s $Serial shell ls $Directory
if ($LASTEXITCODE -ne 0 -or -not ($files -match '\.TiBkp$')) {
    throw "Fixture directory must contain existing .TiBkp files: $Directory"
}
& adb -s $Serial shell am start -n "$Package/com.cyanogenmod.filemanager.activities.NavigationActivity" --es extra_navigate_to $Directory
if ($LASTEXITCODE -ne 0) { throw 'Could not open file manager' }

# Directory loading is asynchronous; wait for a visible backup row.
for ($attempt = 0; $attempt -lt 5; $attempt++) {
    & adb -s $Serial shell uiautomator dump /data/local/tmp/filemanager-listing.xml | Out-Null
    $hierarchy = (& adb -s $Serial shell cat /data/local/tmp/filemanager-listing.xml) -join "`n"
    if ($hierarchy -match 'text="[^"]+\.TiBkp"') {
        Write-Output 'PASS: existing .TiBkp files appear in the file manager'
        exit 0
    }
}
throw 'FAIL: .TiBkp files exist on disk but are absent from the file manager UI'
