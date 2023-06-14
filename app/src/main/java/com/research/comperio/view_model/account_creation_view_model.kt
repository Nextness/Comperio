package com.research.comperio.view_model

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Suppress("PrivatePropertyName", "FunctionName", "ClassName")
class account_creation_view_model() : ViewModel() {

    val account_creation_page_count: Int = 5

    /* TODO: Make the all update methods a single method which accepts value and the field to updated to. */
    private val _user_first_name: MutableStateFlow<TextFieldValue> =
        MutableStateFlow(TextFieldValue(""))
    val user_first_name: StateFlow<TextFieldValue> = _user_first_name.asStateFlow()
    fun update_user_first_name(first_name: TextFieldValue) {
        _user_first_name.value = first_name
    }

    private val _user_last_name: MutableStateFlow<TextFieldValue> =
        MutableStateFlow(TextFieldValue(""))
    val user_last_name: StateFlow<TextFieldValue> = _user_last_name.asStateFlow()
    fun update_user_last_name(last_name: TextFieldValue) {
        _user_last_name.value = last_name
    }

    private val _user_born_date_day: MutableStateFlow<Int?> = MutableStateFlow(null)
    val user_born_date_day: StateFlow<Int?> = _user_born_date_day.asStateFlow()
    fun update_user_born_date_day(born_date_day: Int?) {
        _user_born_date_day.value = born_date_day
    }

    private val _user_born_date_month: MutableStateFlow<Int?> = MutableStateFlow(null)
    val user_born_date_month: StateFlow<Int?> = _user_born_date_month.asStateFlow()
    fun update_user_born_date_month(born_date_month: Int?) {
        _user_born_date_month.value = born_date_month
    }

    private val _user_born_date_year: MutableStateFlow<Int?> = MutableStateFlow(null)
    val user_born_date_year: StateFlow<Int?> = _user_born_date_year.asStateFlow()
    fun update_user_born_date_year(born_date_year: Int?) {
        _user_born_date_year.value = born_date_year
    }

    private val _user_gender: MutableStateFlow<String> = MutableStateFlow("")
    val user_gender: StateFlow<String> = _user_gender.asStateFlow()
    fun update_user_gender(gender: String) {
        _user_gender.value = gender
    }

    private val _user_email: MutableStateFlow<TextFieldValue> = MutableStateFlow(TextFieldValue())
    val user_email: StateFlow<TextFieldValue> = _user_email.asStateFlow()
    fun update_user_email(email: TextFieldValue) {
        _user_email.value = email
    }

    private val _user_password: MutableStateFlow<TextFieldValue> = MutableStateFlow(TextFieldValue())
    val user_password: StateFlow<TextFieldValue> = _user_password.asStateFlow()
    fun update_user_password(password: TextFieldValue) {
        _user_password.value = password
    }

    private val _user_password_validation: MutableStateFlow<TextFieldValue> = MutableStateFlow(TextFieldValue())
    val user_password_validation: StateFlow<TextFieldValue> = _user_password_validation.asStateFlow()
    fun update_user_password_validation(password_validation: TextFieldValue) {
        _user_password_validation.value = password_validation
    }
}
