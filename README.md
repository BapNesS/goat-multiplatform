# Goat Multiplatform

Sample app for Android Makers by droidcon 2024 talk (x@enthuan and @bapness)

## How to use it

In `OmgApplication.kt`, you can switch between Android data module to KMP data module.

The dependency injection will do the job under the hood.

Of course, `domain` layer should be in KMP so that `sharedData` can access to it.

```mermaid
flowchart LR
    androidApp>fa:fa-mobile :androidApp] --> androidData
    androidApp --> sharedData
    androidData --> domain
    sharedData --> domain[[:shared:domain]]
    
    style androidApp fill:#33d781,stroke:#333,stroke-width:1px
    style androidData fill:#b3daca,stroke:#333,stroke-width:1px
    style sharedData fill:#bfaafb,stroke:#333,stroke-width:1px
    style domain fill:#bfaafb,stroke:#333,stroke-width:1px
```

## Endpoints

2 endpoints are avaiable through GitHub Pages.