# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## 2.3.0
### Changed 
- Updated to latest changes of Hunspell (commit 871416ae3534 on 27-05-23)

## 2.2.0
### Changed
- provide classloader to NativeLibrary.getInstance

## 2.1.1
### Fixed 
- Resource path for macOS arm binary

## 2.1.0
### Changed
- Include generated JNA bindings instead of generating them for every build

## 2.0.0
### Breaking Changes
- Replaced BridJ with JNA
- `suggest` returns an array of string instead of a `List`
### Added
- Binaries for macOS on ARM
### Changed
- Updated to Hunspell 1.7.1

## 1.1.0
### Added
- macOS 64bit Build
