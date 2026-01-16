# AGENT.md

This document provides context and instructions for AI agents working on this project.

## Project Background
This project is a fork of the original CyanogenMod / LineageOS File Manager, which was "frozen" for over 10 years. It has been recently revived and modified to support modern requirements and specific integration features for the **BSLauncher** ecosystem.

## Key Modifications
- **Modern SDK targeting**: Updated to target Android SDK 33.
- **BSLauncher Integration**: Added support for mode cycling and deep integration with the BSLauncher application.
- **Intent Features**: Enhanced intent handling, including automatic home directory setting when navigating to specific folders via `resource/folder` intents.
- **Legacy Storage Support**: Maintained compatibility with legacy storage modes where necessary.

## Development Guidelines
- Always refer to `INTENTS.md` for information on supported URI schemes and intent extras.
- Use `CHANGELOG.md` to track new features and version bumps.
- Maintain compatibility with both legacy (AOSP-like) environments and modern Android versions (up to SDK 33).
