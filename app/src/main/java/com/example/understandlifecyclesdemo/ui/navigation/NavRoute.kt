package com.example.understandlifecyclesdemo.ui.navigation

sealed class NavRoute(val path: String) {

    object First: NavRoute("first")

    object Second: NavRoute("second")
}


