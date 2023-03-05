package com.research.comperio.screens

import io.github.sceneview.ar.node.PlacementMode

data class Model(
    val fileLocation: String,
    val scaleUnits: Float? = null,
    val placementMode: PlacementMode = PlacementMode.BEST_AVAILABLE,
    val applyPoseRotation: Boolean = true
)
