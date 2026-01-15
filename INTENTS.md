# CMFileManager Intents Documentation

This document describes the Intent Actions supported by the CMFileManager application.

## 1. Open a Folder
To open a specific directory in the file manager.

**Action:** `android.intent.action.VIEW`

**Supported Schemes:** `file://`, `folder://`, `directory://`

**MIME Type:** `resource/folder`

**Data URI:** `file:///absolute/path/to/directory`

**Example (ADB):**
```bash
# Open using file scheme
adb shell am start -a android.intent.action.VIEW -d "file:///sdcard/Download" -n com.cyanogenmod.filemanager.dev/com.cyanogenmod.filemanager.activities.NavigationActivity

# Open using folder scheme
adb shell am start -a android.intent.action.VIEW -d "folder:///sdcard/Download" -n com.cyanogenmod.filemanager.dev/com.cyanogenmod.filemanager.activities.NavigationActivity
```

**Alternative (using Extras):**
*   **Extra Key:** `extra_navigate_to` (String)
    *   **Value:** `/absolute/path/to/directory`
*   **Extra Key:** `extra_add_to_history` (Boolean)
    *   **Default:** `true`
    *   **Description:** Whether to add this navigation to the history list.

---

## 2. Set Home Directory
To change the default "Home" directory of the application via intent. This will persist in the application settings.

**Action:** `${applicationId}.ACTION_SET_HOME`
*(e.g., `com.cyanogenmod.filemanager.ACTION_SET_HOME` or `com.cyanogenmod.filemanager.dev.ACTION_SET_HOME` for debug build)*

**Supported Schemes:** `file://`, `folder://`, `directory://`

**Data URI:** `file:///absolute/path/to/new/home`

**Example (ADB):**
```bash
adb shell am start -a com.cyanogenmod.filemanager.dev.ACTION_SET_HOME -d "file:///sdcard/Music" -n com.cyanogenmod.filemanager.dev/com.cyanogenmod.filemanager.activities.NavigationActivity
```

**Alternative (using Extra):**
*   **Extra Key:** `extra_navigate_to` (String)
    *   **Value:** `/absolute/path/to/new/home`

---

## 3. Pick a File
To select a file and return its URI to the calling application.

**Action:** `android.intent.action.GET_CONTENT` or `android.intent.action.PICK`

**MIME Type:** `*/*` (or specific mime type)

**Category:** `android.intent.category.OPENABLE`

**Example (ADB):**
```bash
adb shell am start -a android.intent.action.GET_CONTENT -t "*/*" -n com.cyanogenmod.filemanager.dev/com.cyanogenmod.filemanager.activities.PickerActivity
```

---

## 4. Pick a Folder
To select a directory and return its path to the calling application.

**Action:** `com.android.fileexplorer.action.DIR_SEL`

**Example (ADB):**
```bash
adb shell am start -a com.android.fileexplorer.action.DIR_SEL -n com.cyanogenmod.filemanager.dev/com.cyanogenmod.filemanager.activities.PickerActivity
```

**Return Extra:**
*   `def_file_manager_result_dir` (String): The absolute path of the selected folder.

---

## 5. Search
To initiate a search within a directory.

**Action:** `android.intent.action.SEARCH`

**Extras:**
*   **Extra Key:** `query` (String)
    *   **Value:** The search term.
*   **Extra Key:** `app_data` (Bundle)
    *   **Content:** Can contain application-specific data.

---

## 6. Other Internal Actions
*   `${applicationId}.ACTION_START_INDEX`: Starts indexing service.
*   `${applicationId}.ACTION_START_CLEANUP`: Starts cache cleanup service.

