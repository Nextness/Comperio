package com.research.comperio.view_model

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.ar.node.ArNode
import io.github.sceneview.math.Position
import io.github.sceneview.model.ModelInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Suppress("PrivatePropertyName", "FunctionName", "ClassName")
class init_3d_model_view_model() : ViewModel() {

    private val _file_location: MutableStateFlow<String> = MutableStateFlow("")
    val file_location: StateFlow<String> = _file_location.asStateFlow()

    private val _ar_nodes: MutableStateFlow<SnapshotStateList<ArNode>> =
        MutableStateFlow(SnapshotStateList())
    val ar_nodes: StateFlow<SnapshotStateList<ArNode>> = _ar_nodes.asStateFlow()

    private val _model_3d_node: MutableStateFlow<ArModelNode> = MutableStateFlow(ArModelNode())
    val model_3d_node: StateFlow<ArModelNode> = _model_3d_node.asStateFlow()

    private val _model_scale: MutableStateFlow<Float?> = MutableStateFlow(0.5f)
    val model_scale: StateFlow<Float?> = _model_scale.asStateFlow()

    private val _x: MutableStateFlow<Float> = MutableStateFlow(0f)
    val x: StateFlow<Float> = _x.asStateFlow()

    private val _y: MutableStateFlow<Float> = MutableStateFlow(0f)
    val y: StateFlow<Float> = _y.asStateFlow()
    fun update_y(y: Float) {
        _y.value = y
    }

    private val _z: MutableStateFlow<Float> = MutableStateFlow(0f)
    val z: StateFlow<Float> = _z.asStateFlow()


    fun load_3d_model(
        glb_file_location: String = _file_location.value,
        auto_animate: Boolean = true,
        scale_to_units: Float? = _model_scale.value,
        center_origin: Position? = Position(x = _x.value, y = _y.value, z = _z.value),
        on_error: ((error: Exception) -> Unit)? = null,
        on_loaded: ((model_instance: ModelInstance) -> Unit)? = null
    ) {
        _model_3d_node.value.loadModelGlbAsync(
            glbFileLocation = glb_file_location,
            autoAnimate = auto_animate,
            scaleToUnits = scale_to_units,
            centerOrigin = center_origin,
            onError = on_error,
            onLoaded = on_loaded
        )
    }

    fun show_3d_model() {
        _ar_nodes.value.add(
            _model_3d_node.value
        )
    }

    fun set_3d_model_location(model_location: String) {
        _file_location.value = model_location
    }
}