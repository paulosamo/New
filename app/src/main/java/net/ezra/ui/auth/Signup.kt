////package net.ezra.ui.auth
////
////import android.content.res.Configuration.UI_MODE_NIGHT_NO
////import android.content.res.Configuration.UI_MODE_NIGHT_YES
////import androidx.compose.foundation.Image
////import androidx.compose.foundation.clickable
////import androidx.compose.foundation.layout.Box
////import androidx.compose.foundation.layout.Spacer
////import androidx.compose.foundation.layout.fillMaxSize
////import androidx.compose.foundation.layout.fillMaxWidth
////import androidx.compose.foundation.layout.height
////import androidx.compose.foundation.layout.wrapContentSize
////import androidx.compose.foundation.text.KeyboardOptions
////import androidx.compose.material3.*
////import androidx.compose.runtime.*
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.res.painterResource
////import androidx.compose.ui.res.stringResource
////import androidx.compose.ui.text.input.ImeAction
////import androidx.compose.ui.text.input.KeyboardCapitalization
////import androidx.compose.ui.text.input.KeyboardType
////import androidx.compose.ui.text.input.PasswordVisualTransformation
////import androidx.compose.ui.text.style.TextAlign
////import androidx.compose.ui.tooling.preview.Preview
////import androidx.constraintlayout.compose.ConstraintLayout
////import androidx.constraintlayout.compose.Dimension
////import androidx.navigation.NavHostController
////import androidx.navigation.compose.rememberNavController
////import com.google.firebase.auth.FirebaseAuth
////import com.google.firebase.firestore.FirebaseFirestore
////import net.ezra.R
////import net.ezra.navigation.ROUTE_BOOKING
////import net.ezra.navigation.ROUTE_HOME
////import net.ezra.navigation.ROUTE_LOGIN
////import net.ezra.navigation.ROUTE_SIGNUP
////import net.ezra.ui.theme.AppTheme
////import net.ezra.ui.theme.spacing
////
////@OptIn(ExperimentalMaterial3Api::class)
////@Composable
////fun SignupScreen(navController: NavHostController) {
////    var name by remember { mutableStateOf("") }
////    var email by remember { mutableStateOf("") }
////    var password by remember { mutableStateOf("") }
////
////    ConstraintLayout(
////        modifier = Modifier.fillMaxSize()
////    ) {
////        val (refHeader, refName, refEmail, refPassword, refButtonSignup, refTextSignup) = createRefs()
////        val spacing = MaterialTheme.spacing
////
////        Box(
////            modifier = Modifier
////                .constrainAs(refHeader) {
////                    top.linkTo(parent.top, spacing.extraLarge)
////                    start.linkTo(parent.start)
////                    end.linkTo(parent.end)
////                    width = Dimension.fillToConstraints
////
////                }
////                .wrapContentSize()
////        ) {
//////            AuthHeader()
////
////            Image(painter = painterResource(id = R.drawable.img_5), contentDescription = "")
////
////
////
////
////
////        }
////
////
////        TextField(
////            value = name,
////            onValueChange = {
////                name = it
////            },
////            label = {
////                Text(text = stringResource(id = R.string.name))
////            },
////            modifier = Modifier.constrainAs(refName) {
////                top.linkTo(refHeader.bottom, spacing.extraLarge)
////                start.linkTo(parent.start, spacing.large)
////                end.linkTo(parent.end, spacing.large)
////                width = Dimension.fillToConstraints
////            },
////            keyboardOptions = KeyboardOptions(
////                capitalization = KeyboardCapitalization.None,
////                autoCorrect = false,
////                keyboardType = KeyboardType.Email,
////                imeAction = ImeAction.Next
////            )
////        )
////
////        TextField(
////            value = email,
////            onValueChange = {
////                email = it
////            },
////            label = {
////                Text(text = stringResource(id = R.string.email))
////            },
////            modifier = Modifier.constrainAs(refEmail) {
////                top.linkTo(refName.bottom, spacing.medium)
////                start.linkTo(parent.start, spacing.large)
////                end.linkTo(parent.end, spacing.large)
////                width = Dimension.fillToConstraints
////            },
////            keyboardOptions = KeyboardOptions(
////                capitalization = KeyboardCapitalization.None,
////                autoCorrect = false,
////                keyboardType = KeyboardType.Email,
////                imeAction = ImeAction.Next
////            )
////        )
////
////        TextField(
////            value = password,
////            onValueChange = {
////                password = it
////            },
////            label = {
////                Text(text = stringResource(id = R.string.password))
////            },
////            modifier = Modifier.constrainAs(refPassword) {
////                top.linkTo(refEmail.bottom, spacing.medium)
////                start.linkTo(parent.start, spacing.large)
////                end.linkTo(parent.end, spacing.large)
////                width = Dimension.fillToConstraints
////            },
////            visualTransformation = PasswordVisualTransformation(),
////            keyboardOptions = KeyboardOptions(
////                capitalization = KeyboardCapitalization.None,
////                autoCorrect = false,
////                keyboardType = KeyboardType.Password,
////                imeAction = ImeAction.Done
////            )
////        )
////
////        Button(
////            onClick = {
////
////                navController.navigate(ROUTE_HOME) {
////                    popUpTo(ROUTE_SIGNUP) { inclusive = true }
////                }
////
////            },
////            modifier = Modifier.constrainAs(refButtonSignup) {
////                top.linkTo(refPassword.bottom, spacing.large)
////                start.linkTo(parent.start, spacing.extraLarge)
////                end.linkTo(parent.end, spacing.extraLarge)
////                width = Dimension.fillToConstraints
////            }
////        ) {
////            Text(text = stringResource(id = R.string.signup), style = MaterialTheme.typography.titleMedium)
////        }
////
////
////        Text(
////            modifier = Modifier
////                .constrainAs(refTextSignup) {
////                    top.linkTo(refButtonSignup.bottom, spacing.medium)
////                    start.linkTo(parent.start, spacing.extraLarge)
////                    end.linkTo(parent.end, spacing.extraLarge)
////                }
////                .clickable {
////                    navController.navigate(ROUTE_LOGIN) {
////                        popUpTo(ROUTE_SIGNUP) { inclusive = true }
////                    }
////                },
////            text = stringResource(id = R.string.already_have_account),
////            style = MaterialTheme.typography.bodyLarge,
////            textAlign = TextAlign.Center,
////            color = MaterialTheme.colorScheme.onSurface
////        )
////
////    }
////}
////private fun signup(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
////    FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
////        .addOnCompleteListener { task ->
////            if (task.isSuccessful) {
////                val signInMethods = task.result?.signInMethods ?: emptyList()
////                if (signInMethods.isNotEmpty()) {
////                    onError("Email is already registered")
////                } else {
////                    // Email is not registered, proceed with sign-up
////                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
////                        .addOnCompleteListener { signUpTask ->
////                            if (signUpTask.isSuccessful) {
////                                onSuccess()
////                            } else {
////                                onError(signUpTask.exception?.message ?: "Sign-up failed")
////                            }
////                        }
////                }
////            } else {
////                onError(task.exception?.message ?: "Failed to check email availability")
////            }
////
////        }
////
////
////}
////private fun saveUserToFirestore(email: String, name: String, onSuccess: () -> Unit) {
////    val db = FirebaseFirestore.getInstance()
////    val user = hashMapOf(
////        "email" to email,
////        "name" to name
////    )
////
////    db.collection("users")
////        .add(user)
////        .addOnSuccessListener { documentReference ->
////            onSuccess()
////        }
////        .addOnFailureListener { e ->
////            // Handle error
////        }
////}
////
////
////
////
////@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
////@Composable
////fun SignupScreenPreviewLight() {
////    SignupScreen(rememberNavController())
////
////}
////
//
//
package net.ezra.ui.auth

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import net.ezra.R
import net.ezra.navigation.ROUTE_BOOKING
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SIGNUP
import net.ezra.ui.theme.AppTheme
import net.ezra.ui.theme.spacing

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SignupScreen(navController: NavHostController) {
//    var name by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    ConstraintLayout(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        val (refHeader, refName, refEmail, refPassword, refButtonSignup, refTextSignup) = createRefs()
//        val spacing = MaterialTheme.spacing
//
//        Box(
//            modifier = Modifier
//                .constrainAs(refHeader) {
//                    top.linkTo(parent.top, spacing.extraLarge)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    width = Dimension.fillToConstraints
//
//                }
//                .wrapContentSize()
//        ) {
////            AuthHeader()
//
//            Image(painter = painterResource(id = R.drawable.img_5), contentDescription = "")
//
//
//        }
//
//
//        TextField(
//            value = name,
//            onValueChange = {
//                name = it
//            },
//            label = {
//                Text(text = stringResource(id = R.string.name))
//            },
//            modifier = Modifier.constrainAs(refName) {
//                top.linkTo(refHeader.bottom, spacing.extraLarge)
//                start.linkTo(parent.start, spacing.large)
//                end.linkTo(parent.end, spacing.large)
//                width = Dimension.fillToConstraints
//            },
//            keyboardOptions = KeyboardOptions(
//                capitalization = KeyboardCapitalization.None,
//                autoCorrect = false,
//                keyboardType = KeyboardType.Email,
//                imeAction = ImeAction.Next
//            )
//        )
//
//        TextField(
//            value = email,
//            onValueChange = {
//                email = it
//            },
//            label = {
//                Text(text = stringResource(id = R.string.email))
//            },
//            modifier = Modifier.constrainAs(refEmail) {
//                top.linkTo(refName.bottom, spacing.medium)
//                start.linkTo(parent.start, spacing.large)
//                end.linkTo(parent.end, spacing.large)
//                width = Dimension.fillToConstraints
//            },
//            keyboardOptions = KeyboardOptions(
//                capitalization = KeyboardCapitalization.None,
//                autoCorrect = false,
//                keyboardType = KeyboardType.Email,
//                imeAction = ImeAction.Next
//            )
//        )
//
//        TextField(
//            value = password,
//            onValueChange = {
//                password = it
//            },
//            label = {
//                Text(text = stringResource(id = R.string.password))
//            },
//            modifier = Modifier.constrainAs(refPassword) {
//                top.linkTo(refEmail.bottom, spacing.medium)
//                start.linkTo(parent.start, spacing.large)
//                end.linkTo(parent.end, spacing.large)
//                width = Dimension.fillToConstraints
//            },
//            visualTransformation = PasswordVisualTransformation(),
//            keyboardOptions = KeyboardOptions(
//                capitalization = KeyboardCapitalization.None,
//                autoCorrect = false,
//                keyboardType = KeyboardType.Password,
//                imeAction = ImeAction.Done
//            )
//        )
//
//        Button(
//            onClick = {
//                signup(
//                    email = email,
//                    password = password,
//                    onSuccess = {
//                        saveUserToFirestore(email, name) {
//                            navController.navigate(ROUTE_HOME) {
//                                popUpTo(ROUTE_SIGNUP) { inclusive = true }
//                            }
//                        }
//                    },
//                    onError = { errorMessage ->
//                        // Handle error
//                    }
//                )
//            },
//            modifier = Modifier.constrainAs(refButtonSignup) {
//                top.linkTo(refPassword.bottom, spacing.large)
//                start.linkTo(parent.start, spacing.extraLarge)
//                end.linkTo(parent.end, spacing.extraLarge)
//                width = Dimension.fillToConstraints
//            }
//        ) {
//            Text(text = stringResource(id = R.string.signup), style = MaterialTheme.typography.titleMedium)
//        }
//
//
//        Text(
//            modifier = Modifier
//                .constrainAs(refTextSignup) {
//                    top.linkTo(refButtonSignup.bottom, spacing.medium)
//                    start.linkTo(parent.start, spacing.extraLarge)
//                    end.linkTo(parent.end, spacing.extraLarge)
//                }
//                .clickable {
//                    navController.navigate(ROUTE_LOGIN) {
//                        popUpTo(ROUTE_SIGNUP) { inclusive = true }
//                    }
//                },
//            text = stringResource(id = R.string.already_have_account),
//            style = MaterialTheme.typography.bodyLarge,
//            textAlign = TextAlign.Center,
//            color = MaterialTheme.colorScheme.onSurface
//        )
//
//    }
//}
//
//private fun signup(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
//    FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
//        .addOnCompleteListener { task ->
//            if (task.isSuccessful) {
//                val signInMethods = task.result?.signInMethods ?: emptyList()
//                if (signInMethods.isNotEmpty()) {
//                    onError("Email is already registered")
//                } else {
//                    // Email is not registered, proceed with sign-up
//                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
//                        .addOnCompleteListener { signUpTask ->
//                            if (signUpTask.isSuccessful) {
//                                onSuccess()
//                            } else {
//                                onError(signUpTask.exception?.message ?: "Sign-up failed")
//                            }
//                        }
//                }
//            } else {
//                onError(task.exception?.message ?: "Failed to check email availability")
//            }
//
//        }
//}
//
//private fun saveUserToFirestore(email: String, name: String, onSuccess: () -> Unit) {
//    val db = FirebaseFirestore.getInstance()
//    val user = hashMapOf(
//        "email" to email,
//        "name" to name
//    )
//
//    db.collection("users")
//        .add(user)
//        .addOnSuccessListener { documentReference ->
//            onSuccess()
//        }
//        .addOnFailureListener { e ->
//            // Handle error
//        }
//}
//
//@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
//@Composable
//fun SignupScreenPreviewLight() {
//    SignupScreen(rememberNavController())
//}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (refHeader, refName, refEmail, refPassword, refButtonSignup, refButtonLogin, refTextSignup) = createRefs()
        val spacing = MaterialTheme.spacing

        Box(
            modifier = Modifier
                .constrainAs(refHeader) {
                    top.linkTo(parent.top, spacing.extraLarge)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    width = Dimension.fillToConstraints

                }
                .wrapContentSize()
        ) {
            Image(painter = painterResource(id = R.drawable.img_5), contentDescription = "")
        }

        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            label = {
                Text(text = stringResource(id = R.string.name))
            },
            modifier = Modifier.constrainAs(refName) {
                top.linkTo(refHeader.bottom, spacing.extraLarge)
                start.linkTo(parent.start, spacing.large)
                end.linkTo(parent.end, spacing.large)
                width = Dimension.fillToConstraints
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = stringResource(id = R.string.email))
            },
            modifier = Modifier.constrainAs(refEmail) {
                top.linkTo(refName.bottom, spacing.medium)
                start.linkTo(parent.start, spacing.large)
                end.linkTo(parent.end, spacing.large)
                width = Dimension.fillToConstraints
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = stringResource(id = R.string.password))
            },
            modifier = Modifier.constrainAs(refPassword) {
                top.linkTo(refEmail.bottom, spacing.medium)
                start.linkTo(parent.start, spacing.large)
                end.linkTo(parent.end, spacing.large)
                width = Dimension.fillToConstraints
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )

        Button(
            onClick = {
                signup(
                    email = email,
                    password = password,
                    name = name,
                    onSuccess = {
                        navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_SIGNUP) { inclusive = true }
                        }
                    },
                    onError = { errorMessage ->
                        // Handle error
                    }
                )
            },
            modifier = Modifier.constrainAs(refButtonSignup) {
                top.linkTo(refPassword.bottom, spacing.large)
                start.linkTo(parent.start, spacing.extraLarge)
                end.linkTo(parent.end, spacing.extraLarge)
                width = Dimension.fillToConstraints
            }
        ) {
            Text(text = stringResource(id = R.string.signup), style = MaterialTheme.typography.titleMedium)
        }

        Button(
            onClick = {
                login(
                    email = email,
                    password = password,
                    onSuccess = {
                        navController.navigate(ROUTE_HOME) {
                            popUpTo(ROUTE_LOGIN) { inclusive = true }
                        }
                    },
                    onError = { errorMessage ->
                        // Handle error
                    }
                )
            },
            modifier = Modifier.constrainAs(refButtonLogin) {
                top.linkTo(refButtonSignup.bottom, spacing.medium)
                start.linkTo(parent.start, spacing.extraLarge)
                end.linkTo(parent.end, spacing.extraLarge)
                width = Dimension.fillToConstraints
            }
        ) {
            Text(text = stringResource(id = R.string.login), style = MaterialTheme.typography.titleMedium)
        }

        Text(
            modifier = Modifier
                .constrainAs(refTextSignup) {
                    top.linkTo(refButtonLogin.bottom, spacing.medium)
                    start.linkTo(parent.start, spacing.extraLarge)
                    end.linkTo(parent.end, spacing.extraLarge)
                }
                .clickable {
                    navController.navigate(ROUTE_LOGIN) {
                        popUpTo(ROUTE_SIGNUP) { inclusive = true }
                    }
                },
            text = stringResource(id = R.string.already_have_account),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

private fun signup(email: String, password: String, name: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
    FirebaseAuth.getInstance().fetchSignInMethodsForEmail(email)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val signInMethods = task.result?.signInMethods ?: emptyList()
                if (signInMethods.isNotEmpty()) {
                    onError("Email is already registered")
                } else {
                    // Email is not registered, proceed with sign-up
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { signUpTask ->
                            if (signUpTask.isSuccessful) {
                                saveUserToFirestore(email, name) {
                                    onSuccess()
                                }
                            } else {
                                onError(signUpTask.exception?.message ?: "Sign-up failed")
                            }
                        }
                }
            } else {
                onError(task.exception?.message ?: "Failed to check email availability")
            }

        }
}

private fun login(email: String, password: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                onSuccess()
            } else {
                onError(task.exception?.message ?: "Login failed")
            }
        }
}

private fun saveUserToFirestore(email: String, name: String, onSuccess: () -> Unit) {
    val db = FirebaseFirestore.getInstance()
    val user = hashMapOf(
        "email" to email,
        "name" to name
    )

    db.collection("users")
        .add(user)
        .addOnSuccessListener { documentReference ->
            onSuccess()
        }
        .addOnFailureListener { e ->
            // Handle error
        }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun AuthScreenPreviewLight() {
    AuthScreen(rememberNavController())
}
