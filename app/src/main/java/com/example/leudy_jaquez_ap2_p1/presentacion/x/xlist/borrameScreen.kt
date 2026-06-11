package com.example.leudy_jaquez_ap2_p1.presentacion.x.xlist


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.leudy_jaquez_ap2_p1.domain.borrame.model.amonestacion


@Composable
fun borrameListScreen(
    viewModel: borrameViewModel= hiltViewModel(),
    onAddBorrame: () -> Unit,
    onNavigateToEdit:(Int)->Unit,

){
    val state by viewModel.state.collectAsStateWithLifecycle()

    BorrameListBody(
        state = state,
        onEvent =  viewModel::onEvent,
        onAddBorrame= onAddBorrame

    )

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BorrameListBody(
    state: amonestacionState,
    onEvent: (amonestacionEvent) -> Unit,
    onAddBorrame: () -> Unit,

    ) {
    val snackbarHostState = remember { SnackbarHostState() }
    var menuExpanded by remember { mutableStateOf(false) }

    Scaffold(
        snackbarHost={SnackbarHost(snackbarHostState)},
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Amonestacion") },

            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    onAddBorrame() },
                modifier = Modifier.testTag("fab_add")
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar Amonestacion"
                )
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(padding)
                .padding(8.dp)
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .testTag("loading")
                )
            } else {

                if (state.listaAmonestacion.isEmpty()) {
                    Text(
                        text = "No hay Amonestaciones",
                        modifier = Modifier
                            .align(Alignment.Center),
                        style = MaterialTheme.typography.bodyLarge
                    )
                } else {
                    AnimatedVisibility(
                        visible = state.listaAmonestacion.isNotEmpty(),
                        enter = fadeIn() + expandVertically(),
                        exit = fadeOut() + shrinkVertically()
                    ) {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize(),
                            contentPadding = PaddingValues(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(
                                items = state.listaAmonestacion,
                                key = { it.amonestacionId }
                            ) { borrame ->
                                borrameItem(
                                    amonestacion = borrame,
                                    onDelete = {
                                        onEvent(amonestacionEvent.delete(borrame.amonestacionId))
                                    },
                                    onEditar = {
                                        onEvent(amonestacionEvent.edit(borrame.amonestacionId))
                                    },


                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun borrameItem(
    amonestacion: amonestacion,
    onDelete: () -> Unit,
    onEditar: ()-> Unit,

) {
    ElevatedCard(
        modifier = Modifier.fillMaxWidth(),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = amonestacion.nombres,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = amonestacion.razon,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = amonestacion.monto.toString(),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            IconButton(onClick = onEditar) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar amonestacion")
            }
            IconButton(
                onClick = onDelete,
                modifier = Modifier.testTag("btn_delete_${amonestacion.amonestacionId}")
            ) {
                Icon(
                    imageVector = Icons.Default.Delete, contentDescription = "Eliminar amonestacion"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BorrameListBodyPreview() {
    BorrameListBody(
        state = amonestacionState(),
        onEvent = {},
        onAddBorrame = {},

    )


}
