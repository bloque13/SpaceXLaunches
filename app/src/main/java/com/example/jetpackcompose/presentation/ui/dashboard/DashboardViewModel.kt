package com.example.jetpackcompose.presentation.ui.dashboard

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel
@Inject
constructor(
) : ViewModel() {

    fun reload() {
      //  sendEvent(AccountListEvent.LoadEvent)
    }

}