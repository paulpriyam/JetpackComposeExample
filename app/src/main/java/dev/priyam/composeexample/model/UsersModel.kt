package dev.priyam.composeexample.model

data class UsersModel(
    val description: String
)

fun dummyData(): List<UsersModel> {
    return listOf(
        UsersModel("this is the first item of recycclerView"),
        UsersModel("This is the second item of recyclerView"),
        UsersModel("This is the third item of recyclerView"),
        UsersModel("This is the fourth item of recyclerView"),
        UsersModel("This is the fifth item of recyclerView"),
        UsersModel("This is the sixth item of recyclerView"),
        UsersModel("This is the seventh item of recyclerView"),
        UsersModel("This is the eighth item of recyclerView"))
}

