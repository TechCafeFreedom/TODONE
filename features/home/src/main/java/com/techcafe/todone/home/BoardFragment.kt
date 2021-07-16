package com.techcafe.todone.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.techcafe.todone.home.model.SampleModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardFragment : Fragment() {
    private val sampleTodos = buildList {
        for (i in 0..20) {
            add(SampleModel(title = "TODO$i", description = "TODO$i の説明"))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    LazyColumn {
                        items(sampleTodos) {
                            Spacer(modifier = Modifier.height(16.dp))
                            Box(modifier = Modifier.padding(horizontal = 16.dp)) {
                                TodoListItem(sampleTodo = it)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TodoListItem(sampleTodo: SampleModel) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    Toast.makeText(context, sampleTodo.title, Toast.LENGTH_SHORT).show()
                }
                .background(color = Color.LightGray)
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {
            Box(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(4.dp))
                    .background(color = Color.Gray)
                    .padding(8.dp)
            ) {
                Icon(painter = painterResource(R.drawable.ic_dashboard), contentDescription = null)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(sampleTodo.title)
                Text(sampleTodo.description)
            }
        }
    }
}

