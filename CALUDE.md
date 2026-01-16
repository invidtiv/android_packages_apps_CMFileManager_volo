# CALUDE.md

This document serves as a guide for AI assistants (specifically Claude) working on the File Manager project.

## Project Context
The **LineageOS File Manager (Volo Fork)** is an updated version of a legacy file manager that remained unchanged for over a decade. The current maintainers have unfrozen the project to implement mission-critical features for modern Android devices and auxiliary launchers.

## Architecture & Integration
- **Package Name**: `com.cyanogenmod.filemanager` (subject to change in specific builds).
- **Core Strategy**: Enhance the existing stable platform with new intent-based controls.
- **Key Files**:
    - `AndroidManifest.xml`: Watch for intent-filter updates.
    - `src/com/cyanogenmod/filemanager/activities/NavigationActivity.java`: Core navigation logic.
    - `INTENTS.md`: Source of truth for external command interfaces.

## Modification History
Refer to the `README.md` and `CHANGELOG.md` for details on the "unfreezing" process and the transition from a 10-year freeze to active development.
