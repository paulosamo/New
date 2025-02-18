//package net.ezra.ui.auth
//
//import android.content.res.Configuration.UI_MODE_NIGHT_NO
//import android.content.res.Configuration.UI_MODE_NIGHT_YES
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.input.ImeAction
//import androidx.compose.ui.text.input.KeyboardCapitalization
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.constraintlayout.compose.ConstraintLayout
//import androidx.constraintlayout.compose.Dimension
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import net.ezra.R
//import net.ezra.navigation.ROUTE_LOGIN
//import net.ezra.navigation.ROUTE_SIGNUP
//import net.ezra.ui.theme.AppTheme
//import net.ezra.ui.theme.spacing
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginScreen(navController: NavController) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    ConstraintLayout(
//        modifier = Modifier.fillMaxSize()
//    ) {
//
//        val (refHeader, refEmail, refPassword, refButtonLogin, refTextSignup) = createRefs()
//        val spacing = MaterialTheme.spacing
//
//        Box(
//            modifier = Modifier
//                .constrainAs(refHeader) {
//                    top.linkTo(parent.top, spacing.extraLarge)
//                    start.linkTo(parent.start)
//                    end.linkTo(parent.end)
//                    width = Dimension.fillToConstraints
//                }
//                .wrapContentSize()
//        ) {
////            AuthHeader()
//
//            Image(painter = painterResource(id = R.drawable.img_5), contentDescription = "")
//        }
//
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
//
//            },
//            modifier = Modifier.constrainAs(refButtonLogin) {
//                top.linkTo(refPassword.bottom, spacing.large)
//                start.linkTo(parent.start, spacing.extraLarge)
//                end.linkTo(parent.end, spacing.extraLarge)
//                width = Dimension.fillToConstraints
//            }
//        ) {
//            Text(text = stringResource(id = R.string.login), style = MaterialTheme.typography.titleMedium)
//        }
//
//
//        Text(
//            modifier = Modifier
//                .constrainAs(refTextSignup) {
//                    top.linkTo(refButtonLogin.bottom, spacing.medium)
//                    start.linkTo(parent.start, spacing.extraLarge)
//                    end.linkTo(parent.end, spacing.extraLarge)
//                }
//                .clickable {
//                    navController.navigate(ROUTE_SIGNUP) {
//                        popUpTo(ROUTE_LOGIN) { inclusive = true }
//                    }
//                },
//            text = stringResource(id = R.string.dont_have_account),
//            style = MaterialTheme.typography.bodyLarge,
//            textAlign = TextAlign.Center,
//            color = MaterialTheme.colorScheme.onSurface
//        )
//
//    }
//}
//
//@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
//@Composable
//fun LoginScreenPreviewLight() {
//    LoginScreen(rememberNavController())
//}
//
//
import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import net.ezra.R
import net.ezra.navigation.ROUTE_HOME
import net.ezra.navigation.ROUTE_LOGIN
import net.ezra.navigation.ROUTE_SIGNUP
import net.ezra.ui.theme.spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {

        val (refHeader, refEmail, refPassword, refButtonLogin, refTextSignup) = createRefs()
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
            value = email,
            onValueChange = { email = it },
            label = { Text(text = stringResource(id = R.string.email)) },
            modifier = Modifier.constrainAs(refEmail) {
                top.linkTo(refHeader.bottom, spacing.extraLarge)
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
            onValueChange = { password = it },
            label = { Text(text = stringResource(id = R.string.password)) },
            modifier = Modifier.constrainAs(refPassword) {
                top.linkTo(refEmail.bottom, spacing.medium)
                start.linkTo(parent.start, spacing.large)
                end.linkTo(parent.end, spacing.large)
                width = Dimension.fillToConstraints
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            )
        )

        Button(
            onClick = {
                // Call login function
                login(email, password) {
                    // On successful login, navigate to home screen
                    navController.navigate(ROUTE_HOME) {
                        // Pop up to the login screen to avoid going back to it after login
                        popUpTo(ROUTE_SIGNUP) { inclusive = true }
                    }
                }
            },
            modifier = Modifier.constrainAs(refButtonLogin) {
                top.linkTo(refPassword.bottom, spacing.large)
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
                    navController.navigate(ROUTE_SIGNUP) {
                        popUpTo(ROUTE_LOGIN) { inclusive = true }
                    }
                },
            text = stringResource(id = R.string.dont_have_account),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

private fun login(email: String, password: String, onSuccess: () -> Unit) {
    // Authenticate user with Firebase Auth
    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
        .addOnSuccessListener {
            // On successful login, save user-related data to Firestore
            saveUserRelatedDataToFirestore(email)
            onSuccess()
        }
        .addOnFailureListener { exception ->
            // Handle login failure
        }
}

private fun saveUserRelatedDataToFirestore(email: String) {
    val db = FirebaseFirestore.getInstance()
    val userData = hashMapOf(
        "lastLoginTime" to System.currentTimeMillis()
        // Add more user-related data as needed
    )

    // Save user-related data to Firestore under 'users' collection with document ID as user's email
    db.collection("users")
        .document(email)
        .set(userData)
        .addOnSuccessListener {
            // On success
        }
        .addOnFailureListener { e ->
            // Handle error
        }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}
