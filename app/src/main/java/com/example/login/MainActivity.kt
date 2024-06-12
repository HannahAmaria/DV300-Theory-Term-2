package com.example.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.login.ui.theme.LoginTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val passwordVisible by remember {
        mutableStateOf(false)
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090011)),
    ){
        Box(
            modifier = Modifier
                .height(160.dp)
                .background(Color.Red),
            contentAlignment = Alignment.Center
        ){
            Image(painter = painterResource(id = R.drawable.space),
                contentDescription = "Background Image",
                modifier = Modifier
                    .height(160.dp)
                    .width(604.dp),
                contentScale = ContentScale.FillHeight
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp)
        ){
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
               Image(
                   painter = painterResource(id = R.drawable.rocket),
                   contentDescription = "Rocket",
                   modifier = Modifier
                       .size(100.dp)
               )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight(),
                contentAlignment = Alignment.TopCenter
            ){
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
                ){
                    Text(
                        text = "LOGIN",
                        color = Color.White,
                        fontFamily = BebasNeueFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 56.sp,
                        letterSpacing = 4.sp,
                        style = MaterialTheme.typography.headlineMedium
                        )
                    Text(
                        text = "Explore the Galaxy",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(top = 4.dp, bottom = 20.dp)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                    ) {
                        Text(
                            text = "Your email",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = {
                            Text(text = "eg. martin@space.com")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        singleLine = true,
                        shape = RoundedCornerShape(30.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White
                        )

                    )
                    Spacer(
                        modifier = Modifier
                            .height(30.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                    ) {
                        Text(
                            text = "Your password",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }

                    OutlinedTextField(
                        value = password,
                        onValueChange = {password = it},
                        label = {
                            Text(text = "***********")
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp),
                        singleLine = true,
                        shape = RoundedCornerShape(30.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White
                        )
                    )

                    Spacer(modifier = Modifier.height(0.dp))

                    Row (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Row (
                            verticalAlignment = Alignment.CenterVertically
                        ){

                            Checkbox(checked = false,
                                onCheckedChange = {},
                                colors = CheckboxDefaults
                                    .colors(
                                        checkmarkColor = Color.White
                                    )
                            )

                            Text(
                                text = "Remember Me",
                                color = Color.White,
                                fontSize = 12.sp
                            )

                        }

                        ClickableText(
                            text = AnnotatedString("Forgot Password?"),
                            onClick = {},
                            style = TextStyle(
                                color = Color(0xFFF2994A),
                                fontSize = 12.sp,
                                fontWeight = FontWeight(700)
                            )
                        )

                        }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .width(300.dp)
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7920C2))
                    ) {
                        Text(
                            text = "Login",
                            color = Color.White
                        )
                        
                    }
                    Spacer(modifier = Modifier.height(80.dp))
                    Row {
                        Text(
                            text = "Already have an account? ",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                        ClickableText(
                            text = AnnotatedString("Sign Up"),
                            onClick = {},
                            style = TextStyle(
                                color = Color(0xFFF2994A),
                                fontWeight = FontWeight(700)
                            )
                        )

                            
                        }
                    }
                    }
                }
            }
        }


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginTheme {
        LoginScreen()
    }
}