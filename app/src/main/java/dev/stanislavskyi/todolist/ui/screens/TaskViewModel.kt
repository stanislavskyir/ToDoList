package dev.stanislavskyi.todolist.ui.screens


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.stanislavskyi.todolist.data.repository.TaskDatabaseRepositoryImpl
import dev.stanislavskyi.todolist.domain.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repositoryImpl: TaskDatabaseRepositoryImpl
) : ViewModel() {

    private val _taskList = MutableStateFlow<List<Task>>(emptyList())
    val taskList: StateFlow<List<Task>> = _taskList

    init {
        viewModelScope.launch {
            _taskList.value = repositoryImpl.getAll()
        }
    }

    fun addTask(task: Task) {
        viewModelScope.launch {
            repositoryImpl.insert(task)
            _taskList.value = repositoryImpl.getAll()
        }
    }


}